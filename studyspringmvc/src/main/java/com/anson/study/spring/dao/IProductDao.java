package com.anson.study.spring.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.anson.study.spring.dto.Product;


public interface IProductDao {
	
	/**
	 * 获取所有商品
	 * @return 
	 */
	List<Product> getAllProduct();
	
	/**
	 * 获取指定商品ID的商品明细
	 * @param id 商品ID
	 * @return
	 */
	Product getProductById(Integer id);
	
	/**
	 * 添加新商品
	 * @param product
	 * @return 插入的结果行数
	 */
	int insertProduct(Product product);
	
	/**
	 * 更新商品明细
	 * @param id
	 * @param product
	 * @return 更新的行数
	 */
	int updateProductById(Long id, Product product);
}
