package org.example.cart;

import org.osgi.annotation.versioning.ProviderType;

@ProviderType
public interface CartManager {

	/**
	 * Get the current Cart for the specified user ID, or create a
	 * new Cart for that user if one does not already exist.
	 */
	Cart getCart(String userId) throws Exception;

}