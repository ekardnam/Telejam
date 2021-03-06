package me.palazzomichi.telegram.telejam.objects.inputmedia;

import com.google.gson.*;

import java.lang.reflect.Type;

/**
 * JSON adapter for class {@link InputMedia}.
 *
 * @author Michi Palazzo
 */
public class InputMediaAdapter implements JsonDeserializer<InputMedia>, JsonSerializer<InputMedia> {
  
  public static final InputMediaAdapter INSTANCE = new InputMediaAdapter();
  
  private InputMediaAdapter() {
  }
  
  @Override
  public InputMedia deserialize(JsonElement src, Type typeOfT, JsonDeserializationContext context)
      throws JsonParseException {
    JsonObject object = src.getAsJsonObject();
    switch (object.getAsJsonPrimitive(InputMedia.TYPE_FIELD).getAsString()) {
      case InputMediaPhoto.TYPE:
        return context.deserialize(src, InputMediaPhoto.class);
      case InputMediaVideo.TYPE:
        return context.deserialize(src, InputMediaVideo.class);
      default:
        String media = object.getAsJsonPrimitive(InputMedia.MEDIA_FIELD).getAsString();
        String caption = object.getAsJsonPrimitive(InputMedia.CAPTION_FIELD).getAsString();
        return new InputMedia(media, caption) {};
    }
  }
  
  @Override
  public JsonElement serialize(InputMedia inputMedia, Type typeOfT, JsonSerializationContext context) {
    return context.serialize(inputMedia, inputMedia.getClass());
  }
  
}
