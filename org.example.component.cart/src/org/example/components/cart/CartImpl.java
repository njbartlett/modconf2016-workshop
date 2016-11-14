package org.example.components.cart;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.example.cart.Cart;
import org.example.cart.CartEntry;

public class CartImpl implements Cart {
	
	private final LinkedList<CartEntry> entries = new LinkedList<>();
	
	public CartImpl() throws Exception {
		// Sample data...
		addEntry("EffectiveOSGi", 100);
		addEntry("OSGi in Practice", 50);
		addEntry("Die OSGi Service Platform", 65);
	}

	@Override
	public String getUserId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CartEntry> listEntries() throws Exception {
		return Collections.unmodifiableList(entries);
	}

	@Override
	public CartEntry addEntry(String sku, long price) throws Exception {
		CartEntryImpl entry = new CartEntryImpl(this, sku, price);
		entries.add(entry);
		return entry;
	}

	void remove(CartEntryImpl entry) {
		entries.remove(entry);
	}

}
