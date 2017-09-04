package me.palazzomichi.telegram.telejam.objects.chats;

import com.google.gson.*;

import java.lang.reflect.Type;

/**
 * JSON Adapter for class {@link Chat}.
 *
 * @author Michi Palazzo
 */
public class ChatAdapter implements JsonDeserializer<Chat>, JsonSerializer<Chat> {

  public static final ChatAdapter INSTANCE = new ChatAdapter();

  private ChatAdapter() {
  }

  @Override
  public Chat deserialize(JsonElement src, Type type, JsonDeserializationContext context)
      throws JsonParseException {
    String chatType = src.getAsJsonObject().getAsJsonPrimitive(Chat.TYPE_FIELD).getAsString();
    switch (chatType) {
      case PrivateChat.TYPE:
        return context.deserialize(src, PrivateChat.class);
      case Group.TYPE:
        return context.deserialize(src, Group.class);
      case SuperGroup.TYPE:
        return context.deserialize(src, SuperGroup.class);
      case Channel.TYPE:
        return context.deserialize(src, Channel.class);
      default:
        throw new JsonParseException("Unknown object: " + src);
    }
  }

  @Override
  public JsonElement serialize(Chat chat, Type type, JsonSerializationContext context) {
    return context.serialize(chat, chat.getClass());
  }

}
