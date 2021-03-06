package me.palazzomichi.telegram.telejam.objects.inline.results;

import com.google.gson.annotations.SerializedName;
import me.palazzomichi.telegram.telejam.objects.inline.inputmessagecontents.InputMessageContent;
import me.palazzomichi.telegram.telejam.objects.replymarkups.InlineKeyboardMarkup;

import java.util.Objects;
import java.util.Optional;
import java.util.OptionalInt;

/**
 * Represents a link to an article or web page.
 *
 * @author Michi Palazzo
 */
public class InlineQueryResultArticle extends InlineQueryResult {

  static final String TITLE_FIELD = "title";
  static final String INPUT_MESSAGE_CONTENT_FIELD = "input_message_content";
  static final String REPLY_MARKUP_FIELD = "reply_markup";
  static final String URL_FIELD = "url";
  static final String HIDE_URL_FIELD = "hide_url";
  static final String DESCRIPTION_FIELD = "description";
  static final String THUMB_URL_FIELD = "thumb_url";
  static final String THUMB_WIDTH_FIELD = "thumb_width";
  static final String THUMB_HEIGHT_FIELD = "thumb_height";

  @SerializedName(TYPE_FIELD)
  static final String TYPE = "article";

  /**
   * Title of the result.
   */
  @SerializedName(TITLE_FIELD)
  private String title;

  /**
   * Content of the message to be sent.
   */
  @SerializedName(INPUT_MESSAGE_CONTENT_FIELD)
  private InputMessageContent inputMessageContent;

  /**
   * Inline keyboard attached to the message.
   */
  @SerializedName(REPLY_MARKUP_FIELD)
  private InlineKeyboardMarkup replyMarkup;

  /**
   * URL of the result.
   */
  @SerializedName(URL_FIELD)
  private String url;

  /**
   * Pass <code>true</code>, if you don't want the URL to be shown in the message.
   */
  @SerializedName(HIDE_URL_FIELD)
  private Boolean hideUrl;

  /**
   * Short description of the result.
   */
  @SerializedName(DESCRIPTION_FIELD)
  private String description;

  /**
   * Url of the thumbnail for the result.
   */
  @SerializedName(THUMB_URL_FIELD)
  private String thumbUrlField;

  /**
   * Thumbnail width.
   */
  @SerializedName(THUMB_WIDTH_FIELD)
  private Integer thumbWidth;

  /**
   * Thumbnail height.
   */
  @SerializedName(THUMB_HEIGHT_FIELD)
  private Integer thumbHeight;


  public InlineQueryResultArticle(String id,
                                  String title,
                                  InputMessageContent inputMessageContent,
                                  InlineKeyboardMarkup replyMarkup,
                                  String url, Boolean hideUrl,
                                  String description,
                                  String thumbUrlField,
                                  Integer thumbWidth,
                                  Integer thumbHeight) {
    super(id);
    this.title = Objects.requireNonNull(title);
    this.inputMessageContent = Objects.requireNonNull(inputMessageContent);
    this.replyMarkup = replyMarkup;
    this.url = url;
    this.hideUrl = hideUrl;
    this.description = description;
    this.thumbUrlField = thumbUrlField;
    this.thumbWidth = thumbWidth;
    this.thumbHeight = thumbHeight;
  }

  public InlineQueryResultArticle(String id,
                                  String title,
                                  InputMessageContent inputMessageContent,
                                  InlineKeyboardMarkup replyMarkup,
                                  String description) {
    this(id, title, inputMessageContent, replyMarkup, null, null, description,null, null, null);
  }

  public InlineQueryResultArticle(String id, String title, InlineKeyboardMarkup replyMarkup, String description) {
    this(id, title, null, replyMarkup, description);
  }


  /**
   * Getter for property {@link #title}.
   *
   * @return value for property {@link #title}
   */
  public String getTitle() {
    return title;
  }

  /**
   * Setter for property {@link #title}.
   *
   * @param title value for property {@link #title}
   */
  public void setTitle(String title) {
    this.title = Objects.requireNonNull(title);
  }

  /**
   * Getter for property {@link #inputMessageContent}.
   *
   * @return optional value for property {@link #inputMessageContent}
   */
  public Optional<InputMessageContent> getInputMessageContent() {
    return Optional.ofNullable(inputMessageContent);
  }

  /**
   * Setter for property {@link #inputMessageContent}.
   *
   * @param inputMessageContent value for property {@link #inputMessageContent}
   */
  public void setInputMessageContent(InputMessageContent inputMessageContent) {
    this.inputMessageContent = Objects.requireNonNull(inputMessageContent);
  }

  /**
   * Getter for property {@link #replyMarkup}.
   *
   * @return optional value for property {@link #replyMarkup}
   */
  public Optional<InlineKeyboardMarkup> getReplyMarkup() {
    return Optional.ofNullable(replyMarkup);
  }

  /**
   * Setter for property {@link #replyMarkup}.
   *
   * @param replyMarkup value for property {@link #replyMarkup}
   */
  public void setReplyMarkup(InlineKeyboardMarkup replyMarkup) {
    this.replyMarkup = replyMarkup;
  }

  /**
   * Getter for property {@link #url}.
   *
   * @return optional value for property {@link #url}
   */
  public Optional<String> getUrl() {
    return Optional.ofNullable(url);
  }

  /**
   * Setter for property {@link #url}.
   *
   * @param url value for property {@link #url}
   */
  public void setUrl(String url) {
    this.url = url;
  }

  /**
   * Getter for property {@link #hideUrl}.
   *
   * @return value for property {@link #hideUrl}
   */
  public Boolean getHideUrl() {
    return hideUrl;
  }

  /**
   * Setter for property {@link #hideUrl}.
   *
   * @param hideUrl value for property {@link #hideUrl}
   */
  public void setHideUrl(Boolean hideUrl) {
    this.hideUrl = hideUrl;
  }

  /**
   * Getter for property {@link #description}.
   *
   * @return optional value for property {@link #description}
   */
  public Optional<String> getDescription() {
    return Optional.ofNullable(description);
  }

  /**
   * Setter for property {@link #description}.
   *
   * @param description value for property {@link #description}
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * Getter for property {@link #thumbUrlField}.
   *
   * @return optional value for property {@link #thumbUrlField}
   */
  public Optional<String> getThumbUrlField() {
    return Optional.ofNullable(thumbUrlField);
  }

  /**
   * Setter for property {@link #thumbUrlField}.
   *
   * @param thumbUrlField value for property {@link #thumbUrlField}
   */
  public void setThumbUrlField(String thumbUrlField) {
    this.thumbUrlField = thumbUrlField;
  }

  /**
   * Getter for property {@link #thumbWidth}.
   *
   * @return optional value for property {@link #thumbWidth}
   */
  public OptionalInt getThumbWidth() {
    return thumbWidth == null ? OptionalInt.empty() : OptionalInt.of(thumbWidth);
  }

  /**
   * Setter for property {@link #thumbWidth}.
   *
   * @param thumbWidth value for property {@link #thumbWidth}
   */
  public void setThumbWidth(Integer thumbWidth) {
    this.thumbWidth = thumbWidth;
  }

  /**
   * Getter for property {@link #thumbHeight}.
   *
   * @return optional value for property {@link #thumbHeight}
   */
  public OptionalInt getThumbHeight() {
    return thumbHeight == null ? OptionalInt.empty() : OptionalInt.of(thumbHeight);
  }

  /**
   * Setter for property {@link #thumbHeight}.
   *
   * @param thumbHeight value for property {@link #thumbHeight}
   */
  public void setThumbHeight(Integer thumbHeight) {
    this.thumbHeight = thumbHeight;
  }

}
