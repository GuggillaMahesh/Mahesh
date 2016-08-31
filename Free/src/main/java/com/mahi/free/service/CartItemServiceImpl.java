package com.mahi.free.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mahi.free.dao.CartItemDao;
import com.mahi.free.model.CartProduct;
@Service
public class CartItemServiceImpl implements CartItemService{
	@Autowired
    CartItemDao cartItemDao;

	@Override
	public void addCartProduct(CartProduct cartProduct) {
		cartItemDao.addCartProduct(cartProduct);
		
		
	}

}
