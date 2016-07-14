package com.anson.study.spring.dao;

import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.anson.study.spring.dto.Product;
import com.anson.study.spring.service.ProductService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
	{
		"file:src/main/webapp/WEB-INF/config/root-context.xml",
		"file:src/main/webapp/WEB-INF/config/servlet/servlet-context.xml"
	}
)
public class IProductDaoTest {
	
    @Autowired
	private IProductDao productdao;
    @Autowired
    private ProductService productService;
    @Autowired
    private RedisTemplate<String,Product> redisTemplate;

	
	@Test
	public void testGetAllProduct() {
		List<Product> productlist = productdao.getAllProduct();
		
		System.out.println(productlist.isEmpty());
	}

	@Test
	public void testGetProductById() {
		Product product = productdao.getProductById(12);
		System.out.println(product.getProductName());
	}

	@Test
	public void testInsertProduct() {
		
		for (int i = 0; i < 10; i++) {
			Product product = new Product();
			product.setProductName("小米"+i);
			product.setIntroduce("小米"+i+"商品详细介绍");
			product.setPrice(new BigDecimal(999.0));
			
			if (i == 5) {
				int x = i / 0;
			}
			productdao.insertProduct(product);
		}
		
		
	}

	@Test
	public void testUpdateProductById() {
		fail("尚未实现");
	}
	
	@Test
	public void testInsertProduct2Redis() {
		
		// 先从MySQL中获得所有的商品
		List<Product> productList = productdao.getAllProduct();
		
		ValueOperations<String, Product> valueOper = redisTemplate.opsForValue();
		
		for(Product product : productList) {
			System.out.println("从MySQL中取得的结果：" + ReflectionToStringBuilder.reflectionToString(product));
			
			String key = product.getId()+"";
			Product cachedProduct = valueOper.get(key);
			if (cachedProduct == null) {
				valueOper.set(key, product);
			} else {
				System.out.println("从Redis中取得的结果：" + ReflectionToStringBuilder.reflectionToString(cachedProduct));
				
				// 删除Redis中缓存的对象
				valueOper.getOperations().delete(key);
			}
			
		}
	}
	
	@Test
	public void testMultiTransaction() throws SQLException {
		
		List<Product> productList = new ArrayList<Product>();
		
		for (int i = 0; i < 10; i++) {
			Product product = new Product();
			product.setProductName("小米"+i);
			product.setIntroduce("小米"+i+"商品详细介绍");
			product.setPrice(new BigDecimal(999.0));
			productList.add(product);
		}
		
		productService.insertMultiProducts(productList);
	}

}
