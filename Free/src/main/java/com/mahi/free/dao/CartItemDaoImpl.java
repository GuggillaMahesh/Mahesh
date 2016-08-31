package com.mahi.free.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mahi.free.model.CartProduct;
@Repository
public class CartItemDaoImpl implements CartItemDao{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void addCartProduct(CartProduct cartProduct) {
		Session session=sessionFactory.getCurrentSession();
		System.out.println("session="+session);
		Transaction transaction=session.beginTransaction();
		session.save(cartProduct);
		System.out.println("transcation="+transaction);
		transaction.commit();
		
		
	}

}
