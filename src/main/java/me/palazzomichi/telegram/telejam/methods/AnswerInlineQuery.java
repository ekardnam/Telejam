package me.palazzomichi.telegram.telejam.methods;

import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import me.palazzomichi.telegram.telejam.objects.inline.InlineQuery;
import me.palazzomichi.telegram.telejam.objects.inline.results.InlineQueryResult;

/**
 * Use this method to send answers to an inline query. On success, True is returned.
 * No more than 50 results per query are allowed.
 *
 * @author Michi Palazzo
 */
public class AnswerInlineQuery extends JsonTelegramMethod<Boolean> {

  public static final String NAME = "answerInlineQuery";

  static final String INLINE_QUERY_ID_FIELD = "inline_query_id";
  static final String RESULTS_FIELD = "results";
  static final String CACHE_TIME_FIELD = "cache_time";
  static final String IS_PERSONAL_FIELD = "is_personal";
  static final String NEXT_OFFSET_FIELD = "next_offset";
  static final String SWITCH_PM_TEXT_FIELD = "switch_pm_text";
  static final String SWITCH_PM_PARAMETER_FIELD = "switch_pm_parameter";

  /**
   * Unique identifier for the answered query.
   */
  @SerializedName(INLINE_QUERY_ID_FIELD)
  private String inlineQueryId;

  /**
   * An array of results for the inline query.
   */
  @SerializedName(RESULTS_FIELD)
  private InlineQueryResult[] results;

  /**
   * The maximum amount of time in seconds that the result of
   * the inline query may be cached on the server. Defaults to 300.
   */
  @SerializedName(CACHE_TIME_FIELD)
  private Integer cacheTime;

  /**
   * Pass True, if results may be cached on the server side only for the user that sent the query.
   * By default, results may be returned to any user who sends the same query.
   */
  @SerializedName(IS_PERSONAL_FIELD)
  private Boolean isPersonal;

  /**
   * Pass the offset that a client should send in the next query with
   * the same text to receive more results. Pass an empty string if
   * there are no more results or if you don‘t support pagination.
   * Offset length can’t exceed 64 bytes.
   */
  @SerializedName(NEXT_OFFSET_FIELD)
  private String nextOffset;

  /**
   * If passed, clients will display a button with specified text that
   * switches the user to a private chat with the bot and sends the bot
   * a start message with the parameter switch_pm_parameter.
   */
  @SerializedName(SWITCH_PM_TEXT_FIELD)
  private String switchPmText;

  /**
   * Deep-linking parameter for the /start message sent to the bot when
   * user presses the switch button.
   * 1-64 characters, only A-Z, a-z, 0-9, _ and - are allowed.
   */
  @SerializedName(SWITCH_PM_PARAMETER_FIELD)
  private String switchPmParameter;


  public AnswerInlineQuery inlineQuery(String inlineQueryId) {
    this.inlineQueryId = inlineQueryId;
    return this;
  }

  public AnswerInlineQuery inlineQuery(InlineQuery inlineQuery) {
    this.inlineQueryId = inlineQuery.getId();
    return this;
  }

  public AnswerInlineQuery results(InlineQueryResult... results) {
    this.results = results;
    return this;
  }

  public AnswerInlineQuery cacheTime(Integer cacheTime) {
    this.cacheTime = cacheTime;
    isPersonal = cacheTime <= 0;
    return this;
  }

  public AnswerInlineQuery isPersonal(Boolean personal) {
    isPersonal = personal;
    return this;
  }

  public AnswerInlineQuery isPersonal() {
    isPersonal = true;
    return this;
  }

  public AnswerInlineQuery nextOffset(String nextOffset) {
    this.nextOffset = nextOffset;
    return this;
  }

  public AnswerInlineQuery switchPmText(String switchPmText) {
    this.switchPmText = switchPmText;
    return this;
  }

  public AnswerInlineQuery switchPmParameter(String switchPmParameter) {
    this.switchPmParameter = switchPmParameter;
    return this;
  }

  @Override
  public String getName() {
    return NAME;
  }

  @Override
  public Class<? extends Boolean> getReturnType(JsonElement response) {
    return Boolean.class;
  }

}
