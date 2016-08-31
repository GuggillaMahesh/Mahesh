package com.mahi.free.dao;

import java.util.List;

import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mahi.free.model.AddProduct;

@Repository
public class AddProductDaoImpl implements AddProductDao{

	@Autowired
	SessionFactory sessionFactory;
	public void Addproduct(AddProduct addProduct) {
		Session session=sessionFactory.getCurrentSession();
		Transaction transaction=session.beginTransaction();
		session.save(addProduct);
		transaction.commit();
		
	}
	
	public List<AddProduct> viewAddProduct() {
		Session session=sessionFactory.getCurrentSession();
		Transaction transaction=session.beginTransaction();
		List<AddProduct> list=session.createCriteria(AddProduct.class).list();
		return list;
	}

	@Override
	public boolean deleteproduct(int pid) {
		System.out.println("product has been deleted="+pid);
		Session session=sessionFactory.getCurrentSession();
		Transaction transaction=session.beginTransaction();
		Query query=session.createQuery("delete from AddProduct where pid=:status");
		query.setInteger("status", pid);
		int rowsDeleted=query.executeUpdate();
		transaction.commit();
		System.out.println("Rows deleted:"+rowsDeleted);
		if(rowsDeleted!=1)
			return true;
		else
		return false;
	}

	@Override
	public AddProduct getProductById(int id) {
		Session session=sessionFactory.getCurrentSession();
		Transaction transaction=session.beginTransaction();
		AddProduct addProduct=session.load(AddProduct.class,new Integer(id));
		return addProduct;
	}

	@Override
	public void updateProduct(AddProduct addProduct) {
	
		Session session=sessionFactory.getCurrentSession();
		Transaction transaction=session.beginTransaction();
		session.update(addProduct);
		transaction.commit();
		System.out.println("edit has done");
	}

}
