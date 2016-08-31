package com.mahi.free.service;

import java.util.List;

import com.mahi.free.model.AddProduct;

public interface CategoryService {
	List<AddProduct> getProductByCAtegory(String category);

}
