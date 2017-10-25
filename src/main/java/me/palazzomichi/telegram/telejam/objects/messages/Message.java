package me.palazzomichi.telegram.telejam.objects.messages;

import com.google.gson.annotations.SerializedName;
import me.palazzomichi.telegram.telejam.objects.TelegramObject;
import me.palazzomichi.telegram.telejam.objects.User;
import me.palazzomichi.telegram.telejam.objects.chats.Chat;

import java.util.Objects;
import java.util.Optional;
import java.util.OptionalLong;

/**
 * This object represents a message.
 *
 * @author Michi Palazzo
 */
public abstract class Message implements TelegramObject {

  static final String ID_FIELD = "message_id";
  static final String SENDER_FIELD = "from";
  static final String DATE_FIELD = "date";
  static final String CHAT_FIELD = "chat";
  static final String REPLY_TO_MESSAGE_FIELD = "reply_to_message";
  static final String EDIT_DATE_FIELD = "edit_date";
  static final String AUTHOR_SIGNATURE_FIELD = "author_signature";

  /**
   * Unique message identifier inside this chat.
   */
  @SerializedName(ID_FIELD)
  private long id;

  /**
   * Sender, can be empty for messages sent to channels.
   */
  @SerializedName(SENDER_FIELD)
  private User sender;

  /**
   * Date the message was sent in Unix time.
   */
  @SerializedName(DATE_FIELD)
  private long date;

  /**
   * Conversation the message belongs to.
   */
  @SerializedName(CHAT_FIELD)
  private Chat chat;

  /**
   * For replies, the original message.
   * <p>Note that the Message object in this field
   * will not contain further replyToMessage
   * even if it itself is a reply.</p>
   */
  @SerializedName(REPLY_TO_MESSAGE_FIELD)
  private Message replyToMessage;

  /**
   * Date the message was last edited in Unix time.
   */
  @SerializedName(EDIT_DATE_FIELD)
  private Long editDate;

  /**
   * Signature of the post author for messages in channels.
   */
  @SerializedName(AUTHOR_SIGNATURE_FIELD)
  private String authorSignature;
  
  
  public Message(long id,
                 User sender,
                 long date,
                 Chat chat,
                 Message replyToMessage,
                 Long editDate,
                 String authorSignature) {
    this.id = id;
    this.sender = sender;
    this.date = date;
    this.chat = Objects.requireNonNull(chat);
    this.replyToMessage = replyToMessage;
    this.editDate = editDate;
    this.authorSignature = authorSignature;
  }
  

  /**
   * Getter for property {@link #id}.
   *
   * @return value for property {@link #id}
   */
  public long getId() {
    return id;
  }

  /**
   * Getter for property {@link #sender}.
   *
   * @return value for property {@link #sender}
   */
  public User getSender() {
    return sender;
  }

  /**
   * Getter for property {@link #date}.
   *
   * @return value for property {@link #date}
   */
  public long getDate() {
    return date;
  }

  /**
   * Getter for property {@link #chat}.
   *
   * @return value for property {@link #chat}
   */
  public Chat getChat() {
    return chat;
  }

  /**
   * Getter for property {@link #replyToMessage}.
   *
   * @return optional value for property {@link #replyToMessage}
   */
  public Optional<Message> getReplyToMessage() {
    return Optional.ofNullable(replyToMessage);
  }

  /**
   * Getter for property {@link #editDate}.
   *
   * @return optional value for property {@link #editDate}
   */
  public OptionalLong getEditDate() {
    return editDate == null ? OptionalLong.empty() : OptionalLong.of(editDate);
  }

  /**
   * Getter for property {@link #authorSignature}.
   *
   * @return optional value for property {@link #authorSignature}
   */
  public Optional<String> getAuthorSignature() {
    return Optional.ofNullable(authorSignature);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    
    if (!(obj instanceof Message)) {
      return false;
    }
    
    Message message = (Message) obj;
    return id == message.getId() && chat.equals(message.getChat());
  }
  
  @Override
  public int hashCode() {
    return 31 * chat.hashCode() + Long.hashCode(id);
  }

}
