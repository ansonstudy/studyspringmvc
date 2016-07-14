package com.anson.study.spring.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anson.study.spring.dao.IProductDao;
import com.anson.study.spring.dto.Product;
import com.anson.study.spring.service.ProductService;


@Service("productService")
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private IProductDao productdao;

	@Override
	//@Transactional
	public void insertMultiProducts(List<Product> productList) {
		for (Product product : productList) {
			productdao.insertProduct(product);
			
		}
		int i = 1 / 0;
	}

}
