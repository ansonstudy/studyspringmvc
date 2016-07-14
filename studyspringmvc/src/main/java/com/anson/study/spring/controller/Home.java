/**
 * 
 */
package com.anson.study.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author yonghua
 *
 */
@Controller
public class Home {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String goHome(Model model) {
		return "/product/input_product";
	}

	@RequestMapping("/home")
	public String sayHello() {
		return "home";
	}
}
