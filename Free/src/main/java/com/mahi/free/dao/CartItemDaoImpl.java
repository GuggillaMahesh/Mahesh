package com.mahi.free.dao;

import java.util.List;

import org.hibernate.Query;
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

	@Override
	public List<CartProduct> viewCartProducts(int cartid) {
		Session session=sessionFactory.getCurrentSession();
		Transaction transaction=session.beginTransaction();
		Query query= session.createQuery("from cartProduct where cartid="+cartid);
		List<CartProduct> list=query.list();
		return list;
	}

	@Override
	public void deleteCartProductById(int id) {
		// TODO Auto-generated method stub
		
	}

}
