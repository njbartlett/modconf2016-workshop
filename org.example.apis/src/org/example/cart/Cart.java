package org.example.cart;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Cart for a specific user.
 */
@ProviderType
public interface Cart {

	/**
	 * Get the ID of the user with whom this cart is associated.
	 */
	String getUserId();

	/**
	 * Get the list of entries (item + price) in this cart.
	 * 
	 * @return An immutable list of cart entries.
	 */
	List<CartEntry> listEntries() throws Exception;

	/**
	 * Add a new item to the cart
	 * @param sku Stock keeping unit
	 * @param price Sale price of the item
	 * @return The newly created entry
	 */
	CartEntry addEntry(String sku, long price) throws Exception;

}