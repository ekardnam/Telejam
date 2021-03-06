package me.palazzomichi.telegram.telejam.objects.payments;

import com.google.gson.annotations.SerializedName;
import me.palazzomichi.telegram.telejam.objects.TelegramObject;

import java.util.Optional;

/**
 * This object represents information about an order.
 *
 * @author Michi Palazzo
 */
public class OrderInfo implements TelegramObject {

  static final String NAME_FIELD = "name";
  static final String PHONE_NUMBER_FIELD = "phone_number";
  static final String EMAIL_FIELD = "email";
  static final String SHIPPING_ADDRESS_FIELD = "shipping_address";

  /**
   * User name.
   */
  @SerializedName(NAME_FIELD)
  private String name;

  /**
   * User's phone number.
   */
  @SerializedName(PHONE_NUMBER_FIELD)
  private String phoneNumber;

  /**
   * User email.
   */
  @SerializedName(EMAIL_FIELD)
  private String email;

  /**
   * User shipping address.
   */
  @SerializedName(SHIPPING_ADDRESS_FIELD)
  private ShippingAddress shippingAddress;


  public OrderInfo(String name, String phoneNumber, String email, ShippingAddress shippingAddress) {
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.email = email;
    this.shippingAddress = shippingAddress;
  }


  /**
   * Getter for property {@link #name}.
   *
   * @return optional value for property {@link #name}
   */
  public Optional<String> getName() {
    return Optional.ofNullable(name);
  }

  /**
   * Getter for property {@link #phoneNumber}.
   *
   * @return optional value for property {@link #phoneNumber}
   */
  public Optional<String> getPhoneNumber() {
    return Optional.ofNullable(phoneNumber);
  }

  /**
   * Getter for property {@link #email}.
   *
   * @return optional value for property {@link #email}
   */
  public Optional<String> getEmail() {
    return Optional.ofNullable(email);
  }

  /**
   * Getter for property {@link #shippingAddress}.
   *
   * @return optional value for property {@link #shippingAddress}
   */
  public Optional<ShippingAddress> getShippingAddress() {
    return Optional.ofNullable(shippingAddress);
  }

}
