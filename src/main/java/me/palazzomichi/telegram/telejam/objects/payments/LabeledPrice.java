package me.palazzomichi.telegram.telejam.objects.payments;

import com.google.gson.annotations.SerializedName;
import me.palazzomichi.telegram.telejam.objects.TelegramObject;

import java.util.Objects;

/**
 * This object represents a portion of the price for goods or services.
 *
 * @author Michi Palazzo
 */
public class LabeledPrice implements TelegramObject {

  static final String LABEL_FIELD = "label";
  static final String AMOUNT_FIELD = "amount";

  /**
   * Portion label.
   */
  @SerializedName(LABEL_FIELD)
  private String label;

  /**
   * Price of the product in the smallest units of the currency (integer, not float/double).
   * For example, for a price of US$ 1.45 pass amount = 145.
   * See {@link Currency#getExponent()}, it shows the number of digits
   * past the decimal point for each currency (2 for the majority of currencies).
   */
  @SerializedName(AMOUNT_FIELD)
  private int amount;


  /**
   * Constructs a LabeledPrice.
   *
   * @param label  the portion label
   * @param amount price of the product in the smallest units of the currency (integer, not float/double).
   *               For example, for a price of US$ 1.45 pass amount = 145.
   *               See {@link Currency#getExponent()}, it shows the number of digits
   *               past the decimal point for each currency (2 for the majority of currencies).
   */
  public LabeledPrice(String label, int amount) {
    this.label = Objects.requireNonNull(label);
    this.amount = amount;
  }


  /**
   * Getter for property {@link #label}.
   *
   * @return value for property {@link #label}
   */
  public String getLabel() {
    return label;
  }

  /**
   * Getter for property {@link #amount}.
   *
   * @return value for property {@link #amount}
   */
  public int getAmount() {
    return amount;
  }

}
