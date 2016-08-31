package com.mahi.free.service;

import java.util.List;

import com.mahi.free.model.AddProduct;

public interface AddProductService {
	 void Addproduct(AddProduct addProduct);
	 List<AddProduct> viewAddProduct();
	 public boolean deleteproduct(int pid);
	 AddProduct getProductById(int id);
	 void updateProduct(AddProduct addProduct);




}
