package me.palazzomichi.telegram.telejam;

import me.palazzomichi.telegram.telejam.objects.ResponseParameters;
import me.palazzomichi.telegram.telejam.objects.Result;
import me.palazzomichi.telegram.telejam.objects.TelegramObject;

import java.io.IOException;
import java.util.Optional;

/**
 * Exception thrown when a method invocation of
 * the Telegram API returns an error.
 *
 * @author Michi Palazzo
 */
public class TelegramException extends IOException implements TelegramObject {

  /**
   * Int representation of the error.
   */
  private int errorCode;

  /**
   * Object that help to automatically handle the error.
   */
  private ResponseParameters responseParameters;


  public TelegramException(int errorCode, String description, ResponseParameters responseParameters) {
    super(description);
    this.errorCode = errorCode;
    this.responseParameters = responseParameters;
  }

  public TelegramException(int errorCode, String description) {
    this(errorCode, description, null);
  }


  @Override
  public String toJson() {
    return new Result<>(this).toJson();
  }

  /**
   * Getter for property {@link #errorCode}.
   *
   * @return value for property {@link #errorCode}
   */
  public int getErrorCode() {
    return errorCode;
  }

  /**
   * Getter for property {@link #responseParameters}.
   *
   * @return optional value for property {@link #responseParameters}
   */
  public Optional<ResponseParameters> getResponseParameters() {
    return Optional.ofNullable(responseParameters);
  }

}
