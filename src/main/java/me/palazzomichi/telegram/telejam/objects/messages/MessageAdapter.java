package me.palazzomichi.telegram.telejam.objects.messages;

import com.google.gson.*;
import me.palazzomichi.telegram.telejam.objects.User;
import me.palazzomichi.telegram.telejam.objects.chats.Chat;

import java.lang.reflect.Type;

/**
 * JSON Adapter for class {@link Message}.
 *
 * @author Michi Palazzo
 */
public class MessageAdapter implements JsonDeserializer<Message>, JsonSerializer<Message> {

  public static final MessageAdapter INSTANCE = new MessageAdapter();

  private MessageAdapter() {
  }

  @Override
  public Message deserialize(JsonElement src, Type type, JsonDeserializationContext context) throws JsonParseException {
    JsonObject object = src.getAsJsonObject();
    if (object.has(Forward.FORWARD_MESSAGE_ID_FIELD)) {
      return context.deserialize(src, Forward.class);
    } else if (object.has(TextMessage.TEXT_FIELD)) {
      return context.deserialize(src, TextMessage.class);
    } else if (object.has(AudioMessage.AUDIO_FIELD)) {
      return context.deserialize(src, AudioMessage.class);
    } else if (object.has(DocumentMessage.DOCUMENT_FIELD)) {
      return context.deserialize(src, DocumentMessage.class);
    } else if (object.has(GameMessage.GAME_FIELD)) {
      return context.deserialize(src, GameMessage.class);
    } else if (object.has(PhotoMessage.PHOTO_FIELD)) {
      return context.deserialize(src, PhotoMessage.class);
    } else if (object.has(StickerMessage.STICKER_FIELD)) {
      return context.deserialize(src, StickerMessage.class);
    } else if (object.has(VideoMessage.VIDEO_FIELD)) {
      return context.deserialize(src, VideoMessage.class);
    } else if (object.has(VoiceMessage.VOICE_FIELD)) {
      return context.deserialize(src, VoiceMessage.class);
    } else if (object.has(VideoNoteMessage.VIDEO_NOTE_FIELD)) {
      return context.deserialize(src, VideoMessage.class);
    } else if (object.has(NewChatMembersMessage.NEW_CHAT_MEMBERS_FIELD)) {
      return context.deserialize(src, NewChatMembersMessage.class);
    } else if (object.has(ContactMessage.CONTACT_FIELD)) {
      return context.deserialize(src, ContactMessage.class);
    } else if (object.has(LocationMessage.LOCATION_FIELD)) {
      return context.deserialize(src, LocationMessage.class);
    } else if (object.has(VenueMessage.VENUE_FIELD)) {
      return context.deserialize(src, VenueMessage.class);
    } else if (object.has(NewChatMemberMessage.NEW_CHAT_MEMBER_FIELD)) {
      return context.deserialize(src, NewChatMemberMessage.class);
    } else if (object.has(LeftChatMemberMessage.LEFT_CHAT_MEMBER_FIELD)) {
      return context.deserialize(src, LeftChatMemberMessage.class);
    } else if (object.has(NewChatTitleMessage.NEW_CHAT_TITLE_FIELD)) {
      return context.deserialize(src, NewChatTitleMessage.class);
    } else if (object.has(NewChatPhotoMessage.NEW_CHAT_PHOTO_FIELD)) {
      return context.deserialize(src, NewChatPhotoMessage.class);
    } else if (object.has(DeleteChatPhotoMessage.DELETE_CHAT_PHOTO_FIELD)) {
      return context.deserialize(src, DeleteChatPhotoMessage.class);
    } else if (object.has(ChatCreatedMessage.GROUP_CHAT_CREATED_FIELD) ||
        object.has(ChatCreatedMessage.SUPERGROUP_CHAT_CREATED_FIELD) ||
        object.has(ChatCreatedMessage.CHANNEL_CHAT_CREATED_FIELD)) {
      return context.deserialize(src, ChatCreatedMessage.class);
    } else if (object.has(MigrateFromChatIdMessage.MIGRATE_FROM_CHAT_ID_FIELD)) {
      return context.deserialize(src, MigrateFromChatIdMessage.class);
    } else if (object.has(MigrateToChatIdMessage.MIGRATE_TO_CHAT_ID_FIELD)) {
      return context.deserialize(src, MigrateToChatIdMessage.class);
    } else if (object.has(MessagePinnedMessage.PINNED_MESSAGE_FIELD)) {
      return context.deserialize(src, MessagePinnedMessage.class);
    } else if (object.has(InvoiceMessage.INVOICE_FIELD)) {
      return context.deserialize(src, InvoiceMessage.class);
    } else if (object.has(SuccessfulPaymentMessage.SUCCESSFUL_PAYMENT_FIELD)) {
      return context.deserialize(src, SuccessfulPaymentMessage.class);
    }
    long id = object.getAsJsonPrimitive(Message.ID_FIELD).getAsLong();
    User sender = context.deserialize(object.get(Message.SENDER_FIELD), User.class);
    long date = object.getAsJsonPrimitive(Message.DATE_FIELD).getAsLong();
    Chat chat = context.deserialize(object.get(Message.CHAT_FIELD), Chat.class);
    Message replyToMessage = object.has(Message.REPLY_TO_MESSAGE_FIELD) ?
        context.deserialize(object.get(Message.REPLY_TO_MESSAGE_FIELD), Message.class) :
        null;
    Long editDate = object.has(Message.EDIT_DATE_FIELD) ?
        object.getAsJsonPrimitive(Message.EDIT_DATE_FIELD).getAsLong() :
        null;
    String authorSignature = object.has(Message.AUTHOR_SIGNATURE_FIELD) ?
        object.getAsJsonPrimitive(Message.AUTHOR_SIGNATURE_FIELD).getAsString() :
        null;
    return new Message(id, sender, date, chat, replyToMessage, editDate, authorSignature) {}; // unknown message
  }

  @Override
  public JsonElement serialize(Message message, Type type, JsonSerializationContext context) {
    return context.serialize(message, message.getClass());
  }

}
