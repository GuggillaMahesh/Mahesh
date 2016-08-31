package com.mahi.free.dao;

import java.util.List;

import com.mahi.free.model.AddProduct;

public interface CategoryDao {
	List<AddProduct> getProductByCAtegory(String category);

}
