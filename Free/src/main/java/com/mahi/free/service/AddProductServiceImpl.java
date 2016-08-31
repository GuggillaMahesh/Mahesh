package com.mahi.free.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mahi.free.dao.AddProductDao;
import com.mahi.free.model.AddProduct;
@Service
public class AddProductServiceImpl implements AddProductService{
	@Autowired
	AddProductDao addproductDao;

	@Override
	public void Addproduct(AddProduct addProduct) {
		System.out.println("i am in servive now");
		 addproductDao.Addproduct(addProduct);
	}

	@Override
	public List<AddProduct> viewAddProduct() {
		List<AddProduct> list=addproductDao.viewAddProduct();
		return addproductDao.viewAddProduct();
	}

	@Override
	public boolean deleteproduct(int pid) {
		
		return addproductDao.deleteproduct(pid);
	}

	@Override
	public AddProduct getProductById(int id) {
	return addproductDao.getProductById(id);
		
	}

	@Override
	public void updateProduct(AddProduct addProduct) {
		addproductDao.updateProduct(addProduct);
		
	}

	

	
}
