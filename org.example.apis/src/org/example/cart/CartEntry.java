package org.example.cart;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Entry in a cart (item and price).
 */
@ProviderType
public interface CartEntry {

	/**
	 * Stock keeping unit (the ID of the item)
	 */
	String getSku();

	/**
	 * The price at which the item is sold
	 */
	long getSoldPrice();

	/**
	 * Remove entry from the cart
	 */
	void remove();

}