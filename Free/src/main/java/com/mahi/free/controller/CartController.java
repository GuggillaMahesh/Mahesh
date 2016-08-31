package com.mahi.free.controller;

import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mahi.free.model.AddProduct;
import com.mahi.free.model.Cart;
import com.mahi.free.model.CartProduct;
import com.mahi.free.model.User;
import com.mahi.free.service.AddProductService;
import com.mahi.free.service.CartItemService;
import com.mahi.free.service.UserService;

@Controller
public class CartController {
	@Autowired
	AddProductService addProductService;
	@Autowired
	CartItemService cartItemService;
	@Autowired
	UserService userService;
	@RequestMapping("/myCartMap")
	public String addToCart(@RequestParam("id")String id){
		String loggedInUserName=SecurityContextHolder.getContext().getAuthentication().getName();
		User user=userService.getUserByName(loggedInUserName);
		Cart cart=user.getCart();
		AddProduct addProduct = addProductService.getProductById(Integer.parseInt(id));
		CartProduct cartProduct = new CartProduct();
		cartProduct.setAddProduct(addProduct);
		cartProduct.setQuantity(1);
		cartProduct.setTotalprice(addProduct.getPrice());
		cartItemService.addCartProduct(cartProduct);
		System.out.println("product is added to cart");
		return "redirect:/UserLog";
		
	}
	@RequestMapping("/mycart")
	public ModelAndView cart(){
		String activeUsername=SecurityContextHolder.getContext().getAuthentication().getName();
		User activeUser=userService.getUserByName(activeUsername);
		Cart cart=activeUser.getCart();
		int cartid=cart.getCartid();
		List<CartProduct> list=cartItemService.viewCartProducts(cartid);
		ObjectMapper mapper=new ObjectMapper();
		String listJSON=mapper.writeValueAsString(list);
		double grandTotal=
		return list;
	}

}
