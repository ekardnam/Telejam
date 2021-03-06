package me.palazzomichi.telegram.telejam.objects.messages;

import me.palazzomichi.telegram.telejam.objects.User;
import me.palazzomichi.telegram.telejam.objects.chats.Chat;

import java.util.Objects;

/**
 * Class representing a forwarded message.
 *
 * @param <T> the type of the forwarded message
 * @author Michi Palazzo
 */
public class Forward<T extends Message & Forwardable> extends Message {
  
  static final String FORWARD_MESSAGE_SENDER_FIELD = "forward_from";
  static final String FORWARD_MESSAGE_CHAT_FIELD = "forward_from_chat";
  static final String FORWARD_MESSAGE_ID_FIELD = "forward_from_message_id";
  static final String FORWARD_MESSAGE_DATE_FIELD = "forward_date";
  static final String FORWARD_SIGNATURE_FIELD = "forward_signature";
  
  /**
   * The forwarded message.
   */
  private T forwardedMessage;
  
  
  public Forward(long id,
                 User sender,
                 long date,
                 Chat chat,
                 String authorSignature,
                 T forwardedMessage) {
    super(id, sender, date, chat, null, null, authorSignature);
    this.forwardedMessage = Objects.requireNonNull(forwardedMessage);
  }
  
  
  /**
   * Getter for property {@link #forwardedMessage}.
   *
   * @return value for property {@link #forwardedMessage}
   */
  public T getForwardedMessage() {
    return forwardedMessage;
  }
  
}
