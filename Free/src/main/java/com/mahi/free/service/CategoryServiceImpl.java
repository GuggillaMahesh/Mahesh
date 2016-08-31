package com.mahi.free.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mahi.free.dao.CategoryDao;
import com.mahi.free.model.AddProduct;
@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	CategoryDao categoryDao;

	@Override
	public List<AddProduct> getProductByCAtegory(String category) {
		List<AddProduct> list=categoryDao.getProductByCAtegory(category);
		return list;
	}

}
