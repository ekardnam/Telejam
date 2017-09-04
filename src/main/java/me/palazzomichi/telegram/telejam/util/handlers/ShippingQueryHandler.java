package me.palazzomichi.telegram.telejam.util.handlers;

import me.palazzomichi.telegram.telejam.objects.payments.ShippingQuery;
import me.palazzomichi.telegram.telejam.objects.updates.ShippingQueryUpdate;
import me.palazzomichi.telegram.telejam.objects.updates.Update;

/**
 * Represents an operation that accepts a shipping query and returns no
 * result. Used usually to handle updates received from a bot.
 *
 * @author Michi Palazzo
 */
public interface ShippingQueryHandler extends UpdateHandler {

  /**
   * Performs this operation on the given shipping query.
   *
   * @param shippingQuery the shipping query
   */
  void accept(ShippingQuery shippingQuery);

  @Override
  default void accept(Update update) {
    if (update instanceof ShippingQueryUpdate) {
      ShippingQuery shippingQuery = ((ShippingQueryUpdate) update).getShippingQuery();
      accept(shippingQuery);
    }
  }

}
