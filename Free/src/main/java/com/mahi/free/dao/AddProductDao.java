package com.mahi.free.dao;

import java.util.List;

import com.mahi.free.model.AddProduct;

public interface AddProductDao {
	 void Addproduct(AddProduct addProduct);
	 List<AddProduct> viewAddProduct();
	 public boolean deleteproduct(int pid);
	 AddProduct getProductById(int id);
	 void updateProduct(AddProduct addProduct);

}
