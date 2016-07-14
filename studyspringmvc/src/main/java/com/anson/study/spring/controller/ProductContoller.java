package com.anson.study.spring.controller;

import javax.validation.Valid;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.anson.study.spring.dao.IProductDao;
import com.anson.study.spring.dto.Product;

@Controller
@RequestMapping("/product")
public class ProductContoller {
	
    @Autowired
	private IProductDao productdao;
	
	
	@RequestMapping("/new")
	public String showCreateProductForm() {
		
		//model.addAttribute("productForm", new Product());
		
		return "/product/input_product";
	}

	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String saveNewProduct(@Valid Product product, /*Errors errors*/BindingResult result, Model model) {
		
		System.out.println(ReflectionToStringBuilder.toString(product));
		
		/*
		 * 要使用Spring的表单验证功能，必须配置<mvc:annotation-driven/> 
		 */
		if (result.hasErrors()) {
			model.addAttribute("errors", result.getAllErrors());
			model.addAttribute("productForm", product);
			return "/product/input_product";
		}
		
		// TODO 保存商品
		// TODO 跳轉到商品List頁面
		return "/product/lists";
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String showProductList(Model model) {
		
		model.addAttribute("product_list", productdao.getAllProduct());
		
		
		return "/product/lists";
	}
}
