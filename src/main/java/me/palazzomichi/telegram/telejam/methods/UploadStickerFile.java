package me.palazzomichi.telegram.telejam.methods;

import com.google.gson.JsonElement;
import me.palazzomichi.telegram.telejam.objects.File;
import me.palazzomichi.telegram.telejam.objects.User;
import org.apache.http.HttpEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Use this method to upload a .png file with a sticker for later
 * use in createNewStickerSet and addStickerToSet methods (can be used multiple times).
 * Returns the uploaded File on success.
 *
 * @author Michi Palazzo
 */
public class UploadStickerFile implements TelegramMethod<File> {

  public static final String NAME = "uploadStickerFile";

  static final String USER_ID_FIELD = "user_id";
  static final String STICKER_FIELD = "png_sticker";

  /**
   * User identifier of sticker file owner.
   */
  private Long userId;

  /**
   * Png image with the sticker, must be up to 512 kilobytes in size,
   * dimensions must not exceed 512px, and either width or height must be exactly 512px.
   */
  private InputStream sticker;


  public UploadStickerFile user(long userId) {
    this.userId = userId;
    return this;
  }

  public UploadStickerFile user(User user) {
    this.userId = user.getId();
    return this;
  }

  public UploadStickerFile sticker(InputStream sticker) {
    this.sticker = sticker;
    return this;
  }
  
  public UploadStickerFile sticker(String sticker) throws FileNotFoundException {
    this.sticker = new FileInputStream(sticker);
    return this;
  }

  public UploadStickerFile sticker(java.io.File sticker) throws FileNotFoundException {
    this.sticker = new FileInputStream(sticker);
    return this;
  }

  public UploadStickerFile sticker(Path sticker) throws IOException {
    this.sticker = Files.newInputStream(sticker);
    return this;
  }

  @Override
  public String getName() {
    return NAME;
  }

  @Override
  public Class<? extends File> getReturnType(JsonElement response) {
    return File.class;
  }

  @Override
  public HttpEntity getHttpEntity() {

    MultipartEntityBuilder builder = MultipartEntityBuilder.create();

    if (userId != null)
      builder.addTextBody(USER_ID_FIELD, userId.toString());

    if (sticker != null)
      builder.addBinaryBody(STICKER_FIELD, sticker);

    return builder.build();
  }

}
