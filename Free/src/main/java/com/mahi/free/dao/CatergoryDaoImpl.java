package com.mahi.free.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mahi.free.model.AddProduct;
@Repository
public class CatergoryDaoImpl implements CategoryDao{
@Autowired
SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<AddProduct> getProductByCAtegory(String category) {
		System.out.println("im here");
	Session session=sessionFactory.getCurrentSession();
	Transaction transction=session.beginTransaction();
	List<AddProduct> list= session.createCriteria(AddProduct.class)
			.add(Restrictions.like("category",category)).list();
	
	
		return list;
	}

}
