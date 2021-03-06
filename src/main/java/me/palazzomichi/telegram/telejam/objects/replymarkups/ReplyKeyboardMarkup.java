package me.palazzomichi.telegram.telejam.objects.replymarkups;

import com.google.gson.annotations.SerializedName;
import me.palazzomichi.telegram.telejam.objects.replymarkups.keyboardbuttons.KeyboardButton;

import java.util.Objects;

/**
 * This object represents a custom keyboard with reply options.
 *
 * @author Michi Palazzo
 */
public class ReplyKeyboardMarkup implements ReplyMarkup {

  static final String KEYBOARD_FIELD = "keyboard";
  static final String RESIZE_KEYBOARD_FIELD = "resize_keyboard";
  static final String ONE_TIME_KEYBOARD_FIELD = "one_time_keyboard";
  static final String SELECTIVE_FIELD = "selective";

  /**
   * Array of button rows, each represented by an
   * Array of {@link KeyboardButton} objects.
   */
  @SerializedName(KEYBOARD_FIELD)
  private KeyboardButton[][] keyboard;

  /**
   * Optional.
   * Requests clients to resize the keyboard vertically for
   * optimal fit (e.g., make the keyboard smaller if there are just two
   * rows of inlinekeyboardbuttons). Defaults to false, in which case the custom
   * keyboard is always of the same height as the app's standard keyboard.
   */
  @SerializedName(RESIZE_KEYBOARD_FIELD)
  private Boolean resizeKeyboard;

  /**
   * Optional.
   * Requests clients to hide the keyboard as soon as it's been used.
   * The keyboard will still be available, but clients will
   * automatically display the usual letter-keyboard in the
   * chat – the user can press a special button in the input
   * field to see the custom keyboard again.
   * Defaults to false.
   */
  @SerializedName(ONE_TIME_KEYBOARD_FIELD)
  private Boolean oneTimeKeyboard;

  /**
   * Optional.
   * Use this parameter if you want to show the keyboard to
   * specific users only.
   * Targets:
   * 1) users that are @mentioned in the text of the Message object;
   * 2) if the bot's message is a reply (has reply_to_message_id), sender of the original message.
   */
  @SerializedName(SELECTIVE_FIELD)
  private Boolean selective;


  /**
   * Constructs a ReplyKeyboardMarkup.
   *
   * @param keyboard        array of button rows
   * @param resizeKeyboard  if true resize vertically the keyboard
   * @param oneTimeKeyboard if true requests clients to hide the
   *                        keyboard as soon as it's been used
   * @param selective       set to <code>true</code> if you want to
   *                        show the keyboard to specific users only
   */
  public ReplyKeyboardMarkup(KeyboardButton[][] keyboard,
                             Boolean resizeKeyboard,
                             Boolean oneTimeKeyboard,
                             Boolean selective) {
    this.keyboard = Objects.requireNonNull(keyboard);
    this.resizeKeyboard = resizeKeyboard;
    this.oneTimeKeyboard = oneTimeKeyboard;
    this.selective = selective;
  }

  /**
   * Constructs a ReplyKeyboardMarkup.
   *
   * @param keyboard array of button rows
   */
  public ReplyKeyboardMarkup(KeyboardButton[][] keyboard) {
    this.keyboard = keyboard;
  }

  /**
   * Constructs a ReplyKeyboardMarkup.
   *
   * @param keyboard array of button rows
   */
  public ReplyKeyboardMarkup(String[][] keyboard) {
    int rows = keyboard.length;

    KeyboardButton[][] keyboardButtons = new KeyboardButton[rows][];
    for (int i = 0; i < rows; i++) {
      int buttons = keyboard[i].length;
      keyboardButtons[i] = new KeyboardButton[buttons];
      for (int j = 0; j < buttons; j++) {
        keyboardButtons[i][j] = new KeyboardButton(keyboard[i][j]);
      }
    }
    this.keyboard = keyboardButtons;
  }


  /**
   * Getter for property {@link #keyboard}.
   *
   * @return value for property {@link #keyboard}
   */
  public KeyboardButton[][] getKeyboard() {
    return keyboard;
  }

  /**
   * Setter for property {@link #keyboard}.
   *
   * @param keyboard value for property {@link #keyboard}
   */
  public void setKeyboard(KeyboardButton[][] keyboard) {
    this.keyboard = Objects.requireNonNull(keyboard);
  }

  /**
   * Getter for property {@link #resizeKeyboard}.
   *
   * @return value for property {@link #resizeKeyboard}
   */
  public boolean resizeKeyboard() {
    return resizeKeyboard == null ? false : resizeKeyboard;
  }

  /**
   * Setter for property {@link #resizeKeyboard}.
   *
   * @param resizeKeyboard value for property {@link #resizeKeyboard}
   */
  public void setResizeKeyboard(Boolean resizeKeyboard) {
    this.resizeKeyboard = resizeKeyboard;
  }

  /**
   * Getter for property {@link #oneTimeKeyboard}.
   *
   * @return value for property {@link #oneTimeKeyboard}
   */
  public boolean isOneTimeKeyboard() {
    return oneTimeKeyboard == null ? false : oneTimeKeyboard;
  }

  /**
   * Setter for property {@link #oneTimeKeyboard}.
   *
   * @param oneTimeKeyboard value for property {@link #oneTimeKeyboard}
   */
  public void setOneTimeKeyboard(Boolean oneTimeKeyboard) {
    this.oneTimeKeyboard = oneTimeKeyboard;
  }

  /**
   * Getter for property {@link #selective}.
   *
   * @return value for property {@link #selective}
   */
  public boolean isSelective() {
    return selective == null ? false : selective;
  }

  /**
   * Setter for property {@link #selective}.
   *
   * @param selective value for property {@link #selective}
   */
  public void setSelective(Boolean selective) {
    this.selective = selective;
  }

}
