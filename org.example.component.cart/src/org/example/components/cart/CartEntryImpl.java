package org.example.components.cart;

import org.example.cart.CartEntry;

public class CartEntryImpl implements CartEntry {
	
	private final CartImpl cart;
	private final String sku;
	private final long soldPrice;

	CartEntryImpl(CartImpl cart, String sku, long soldPrice) {
		this.cart = cart;
		this.sku = sku;
		this.soldPrice = soldPrice;
	}

	@Override
	public String getSku() {
		return sku;
	}

	@Override
	public long getSoldPrice() {
		return soldPrice;
	}

	@Override
	public void remove() {
		cart.remove(this);
	}

}
