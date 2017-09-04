package me.palazzomichi.telegram.telejam.methods;

import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import me.palazzomichi.telegram.telejam.objects.chats.Chat;
import me.palazzomichi.telegram.telejam.objects.messages.Message;
import me.palazzomichi.telegram.telejam.objects.replymarkups.InlineKeyboardMarkup;
import me.palazzomichi.telegram.telejam.util.text.Text;

import java.io.Serializable;

/**
 * Use this method to edit captions of messages sent by the bot or via the bot (for inline bots).
 * On success, if edited message is sent by the bot, the edited Message is returned,
 * otherwise True is returned.
 *
 * @author Michi Palazzo
 */
public class EditMessageCaption extends JsonTelegramMethod<Serializable> {

  public static final String NAME = "editMessageCaption";

  static final String CHAT_ID_FIELD = "chat_id";
  static final String MESSAGE_ID_FIELD = "message_id";
  static final String INLINE_MESSAGE_ID_FIELD = "inline_message_id";
  static final String CAPTION_FIELD = "caption";
  static final String INLINE_KEYBOARD_FIELD = "reply_markup";

  /**
   * Required if {@link #inlineMessageId} is not specified.
   * Unique identifier for the target chat or username
   * of the target channel (in the format @channelusername).
   */
  @SerializedName(CHAT_ID_FIELD)
  private String chatId; // String or long

  /**
   * Required if {@link #inlineMessageId} is not specified.
   * Identifier of the sent message.
   */
  @SerializedName(MESSAGE_ID_FIELD)
  private Long messageId;

  /**
   * Required if {@link #chatId} and {@link #messageId} are not specified.
   * Identifier of the inline message.
   */
  @SerializedName(INLINE_MESSAGE_ID_FIELD)
  private String inlineMessageId;

  /**
   * A JSON-serialized object for an inline keyboard.
   */
  @SerializedName(INLINE_KEYBOARD_FIELD)
  private InlineKeyboardMarkup inlineKeyboard;

  /**
   * New caption of the message.
   */
  @SerializedName(CAPTION_FIELD)
  private String caption;


  public EditMessageCaption chat(String chatId) {
    this.chatId = chatId;
    this.inlineMessageId = null;
    return this;
  }

  public EditMessageCaption chat(long chatId) {
    this.chatId = Long.toString(chatId);
    this.inlineMessageId = null;
    return this;
  }

  public EditMessageCaption chat(Chat chat) {
    this.chatId = Long.toString(chat.getId());
    this.inlineMessageId = null;
    return this;
  }

  public EditMessageCaption message(Long messageId) {
    this.messageId = messageId;
    this.inlineMessageId = null;
    return this;
  }

  public EditMessageCaption message(Message message) {
    this.chatId = Long.toString(message.getChat().getId());
    this.messageId = message.getId();
    this.inlineMessageId = null;
    return this;
  }

  public EditMessageCaption inlineMessage(String inlineMessageId) {
    this.inlineMessageId = inlineMessageId;
    this.chatId = null;
    this.messageId = null;
    return this;
  }

  public EditMessageCaption inlineKeyboard(InlineKeyboardMarkup inlineKeyboard) {
    this.inlineKeyboard = inlineKeyboard;
    return this;
  }

  public EditMessageCaption caption(Text caption) {
    this.caption = caption.toString();
    return this;
  }

  public EditMessageCaption caption(String caption) {
    this.caption = caption;
    return this;
  }

  @Override
  public String getName() {
    return NAME;
  }

  @Override
  public Class<? extends Serializable> getReturnType(JsonElement response) {
    if (response == null) {
      return Serializable.class;
    }
    return response.isJsonPrimitive() ? Boolean.class : Message.class;
  }

}
