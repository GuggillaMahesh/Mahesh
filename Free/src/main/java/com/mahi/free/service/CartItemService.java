package com.mahi.free.service;

import java.util.List;

import com.mahi.free.model.CartProduct;

public interface CartItemService {
	void addCartProduct(CartProduct cartProduct);
	List<CartProduct> viewCartProducts(int cartid);

}
