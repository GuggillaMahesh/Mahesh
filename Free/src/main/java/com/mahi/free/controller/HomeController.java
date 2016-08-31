package com.mahi.free.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.SystemPropertyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mahi.free.model.AddProduct;
import com.mahi.free.model.User;
import com.mahi.free.service.AddProductService;
import com.mahi.free.service.CategoryService;
import com.mahi.free.service.UserService;



@Controller
public class HomeController {
	
	@Autowired
	UserService userService;
	@Autowired
	AddProductService addproductService;
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping("/")
	public ModelAndView homepage(){
		System.out.println("welcome to home page");
				return new ModelAndView("Home");
	}

	
	@RequestMapping("/home")
public ModelAndView homepag(){
	
			return new ModelAndView("Home");
}
	@RequestMapping("/about")
	public ModelAndView aboutpagepage(){
				return new ModelAndView("about");
	}
	@RequestMapping("/contact")
	public ModelAndView contactpage(){
						return new ModelAndView("contact");
	}
	
	//a soon as client click the signup button the request mapping is done her
	@RequestMapping("/signIn")
	public ModelAndView signin(){
		System.out.println("welcome to signin page");
		return new ModelAndView("signin");
	}
	@RequestMapping("/signUp")
	public ModelAndView signup(){
		User user=new User();
		System.out.println("welcome to signup");
		return new ModelAndView("signup","userobj",user);
	}
	@RequestMapping("/login")
	public String loginMethod()
	{
		return "login";
	}

	@RequestMapping("/logout")
	public String logout(HttpServletRequest request)
	{
		request.getSession().invalidate();
		System.out.println("logout page called");

		return "logout";
		
	}
	@RequestMapping("/UserLog")
	public ModelAndView userCheck(Principal principal) throws JsonGenerationException, JsonMappingException, IOException{
		System.out.println("User Name:"+principal.getName());
		List<AddProduct> list=addproductService.viewAddProduct();
		ObjectMapper mapper=new ObjectMapper();
		String listJSON=mapper.writeValueAsString(list);
		System.out.println(listJSON);
		return new ModelAndView("UserHome","listofallproducts",listJSON);
		}
	@RequestMapping("/viewproduct")
	public ModelAndView viewpro(@RequestParam("id")String pid){
		AddProduct addProduct=addproductService.getProductById(Integer.parseInt(pid));
		return new ModelAndView("singleproduct","singlepro",addProduct);
	}
	@RequestMapping("/AdminLog")
	public ModelAndView adminCheck(Principal principal){
		System.out.println("Admin Name:"+principal.getName());
		return new ModelAndView("AdminHome");
	}
	@RequestMapping("/register")
	public ModelAndView register(@Valid@ModelAttribute("userobj") User user,BindingResult bindingresult){
		if(bindingresult.hasErrors()){
			return new ModelAndView("signup");
		}
		System.out.println("UserName:"+user.getName());
		System.out.println("PassWord:"+user.getPassword());
		System.out.println("i am in register");
		userService.addUser(user);
		return new ModelAndView("signup");
		
	}
	@RequestMapping("/ViewCategorytype")
	public ModelAndView descategory(@RequestParam("category") String category) throws JsonGenerationException, JsonMappingException, IOException
	{
		List<AddProduct> list=categoryService.getProductByCAtegory(category);
		ObjectMapper mapper=new ObjectMapper();
		String listJSON=mapper.writeValueAsString(list);
		return new ModelAndView("Categorypage","Catkey",listJSON);
	}
	
}
