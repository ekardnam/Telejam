package me.palazzomichi.telegram.telejam.objects.replymarkups.inlinekeyboardbuttons;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * This object represents one button of an inline keyboard.
 *
 * @author Michi Palazzo
 */
public class SwitchInlineQueryInlineKeyboardButton extends InlineKeyboardButton {

  static final String SWITCH_INLINE_QUERY_FIELD = "switch_inline_query";

  /**
   * Pressing the button will prompt the user to select one of their chats,
   * open that chat and insert the bot‘s username and the specified inline
   * query in the input field. Can be empty, in which case just the
   * bot’s username will be inserted.
   */
  @SerializedName(SWITCH_INLINE_QUERY_FIELD)
  private String query;


  /**
   * Constructs a SwitchInlineQueryInlineKeyboardButton.
   *
   * @param text  label text on the button
   * @param query inline query to send
   */
  public SwitchInlineQueryInlineKeyboardButton(String text, String query) {
    super(text);
    this.query = Objects.requireNonNull(query);
  }


  /**
   * Getter for property {@link #query}.
   *
   * @return value for property {@link #query}
   */
  public String getSwitchInlineQuery() {
    return query;
  }

  /**
   * Setter for property {@link #query}.
   *
   * @param query value for property {@link #query}
   */
  public void setSwitchInlineQuery(String query) {
    this.query = Objects.requireNonNull(query);
  }

}
