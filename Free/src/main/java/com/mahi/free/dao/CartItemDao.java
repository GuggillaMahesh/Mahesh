package com.mahi.free.dao;

import java.util.List;

import com.mahi.free.model.CartProduct;

public interface CartItemDao {
	void addCartProduct(CartProduct cartProduct);
	List<CartProduct> viewCartProducts(int cartid);
	void deleteCartProductById(int id);


}
