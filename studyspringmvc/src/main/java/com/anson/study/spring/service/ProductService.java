package com.anson.study.spring.service;

import java.util.List;

import com.anson.study.spring.dto.Product;

public interface ProductService {
	
	public void insertMultiProducts(List<Product> productList);

}
