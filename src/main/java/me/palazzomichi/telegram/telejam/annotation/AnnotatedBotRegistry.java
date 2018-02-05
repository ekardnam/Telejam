package me.palazzomichi.telegram.telejam.annotation;

import me.palazzomichi.telegram.telejam.Bot;
import me.palazzomichi.telegram.telejam.BotThread;
import me.palazzomichi.telegram.telejam.objects.messages.TextMessage;
import me.palazzomichi.telegram.telejam.objects.updates.Update;
import me.palazzomichi.telegram.telejam.util.handlers.CommandExecutor;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Stream;

public class AnnotatedBotRegistry {

    private AnnotatedBotRegistry() {}

    public static void registerBot(Object obj) throws IOException {
        Class clazz = obj.getClass();
        TelegramBot bot = (TelegramBot) clazz.getAnnotation(TelegramBot.class);
        if (bot == null) throw new AnnotatedBotException("Given class is not annotated with @TelegramBot");
        Bot telejamBot = new Bot(bot.token());
        BotThread thread = new BotThread(telejamBot);
        Stream<Method> updateHooks = Arrays.stream(clazz.getMethods()).filter(method -> method.getAnnotation(UpdateHook.class) != null);
        Stream<Method> commandHooks = Arrays.stream(clazz.getMethods()).filter(method -> method.getAnnotation(CommandHook.class) != null);
        Stream<Method> errorHooks = Arrays.stream(clazz.getMethods()).filter(method -> method.getAnnotation(ErrorHook.class) != null);
        updateHooks.forEach(method -> {
            if (method.getParameterCount() != 1 && method.getParameterTypes()[0].equals(Update.class)) throw new AnnotatedBotException("Update hook has wrong arguments, must have a single argument of type Update");
            thread.getUpdateHandlers().add(update -> {
                try {
                    method.invoke(obj, update);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            });
        });
        commandHooks.forEach(method -> {
            if (method.getParameterCount() != 3 && method.getParameterTypes()[0] != String.class && method.getParameterTypes()[1] != String[].class && method.getParameterTypes()[2] != TextMessage.class){
                throw new AnnotatedBotException("Command hook must have three paramenter, String command, String[] args, TextMessage message");
            }
            CommandHook ch = (CommandHook) method.getAnnotation(CommandHook.class);
            thread.getUpdateHandlers().add(new CommandExecutor(telejamBot, ch.command()) {
                @Override
                public void execute(String command, String[] args, TextMessage message) throws Throwable {
                    try {
                        method.invoke(obj, command, args, message);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            });
        });
        errorHooks.forEach(method -> {
            if (method.getParameterCount() != 1 && method.getParameterTypes()[0].isAssignableFrom(Throwable.class)) {
                throw new AnnotatedBotException("Error hook must have one parameter the is A Throwable object");
            }
            thread.getErrorHandlers().add(throwable -> {
                try {
                    method.invoke(telejamBot, throwable);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            });
        });
    }

}
