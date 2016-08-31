package com.mahi.free.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.mahi.free.model.AddProduct;
import com.mahi.free.model.User;
import com.mahi.free.service.AddProductService;
import com.mahi.free.service.UserService;

@Controller
public class AdminController {
	
	@Autowired
	UserService userService;
	@Autowired
	AddProductService addproductService;

	@RequestMapping("/ViewUser")
	public ModelAndView viewpage() throws JsonGenerationException, JsonMappingException, IOException{
		List<User> list=userService.viewUser();
		ObjectMapper mapper=new ObjectMapper();
		String listJSON=mapper.writeValueAsString(list);
		System.out.println(listJSON);
		return new ModelAndView("viewuser","listofuser",listJSON);
	}
	@RequestMapping("/addProduct")
	public ModelAndView additem(){
		AddProduct addproduct=new AddProduct();
		return new ModelAndView("addproduct","product",addproduct);
	}
	@RequestMapping("/item")
	public ModelAndView register(@Valid@ModelAttribute("product") AddProduct addproduct,BindingResult bindingresult,
			@RequestParam("file")MultipartFile file) throws IllegalStateException, IOException{
		System.out.println("the product should be added");
		addproductService.Addproduct(addproduct);
		MultipartFile itemImage=addproduct.getFile();
		System.out.println("image:"+addproduct.getFile());
		Path path=Paths.get("F://Roja//Free//src//main//webapp//resources//images//"+addproduct.getPid()+".jpg");
		System.out.println("path is "+path);

        if (itemImage != null && !itemImage.isEmpty()) {
        	itemImage.transferTo(new File(path.toString()));
			return new ModelAndView("addproduct");
        }
		System.out.println("i am in register");
		addproductService.Addproduct(addproduct);
		return new ModelAndView("addproduct");
		
	}
	@RequestMapping("/viewAllProducts")
	public ModelAndView viewproduct() throws JsonGenerationException, JsonMappingException, IOException{
		List<AddProduct> list=addproductService.viewAddProduct();
		ObjectMapper mapper=new ObjectMapper();
		String listJSON=mapper.writeValueAsString(list);
		System.out.println(listJSON);
		return new ModelAndView("viewproducts","listofallproducts",listJSON);
		
		
	}
	@RequestMapping("/deleteItem")
	public String deleteitem(@RequestParam("pid") int pid)
	{
		addproductService.deleteproduct(pid);
		return "redirect:/viewAllProducts";
}
	@RequestMapping("/editProduct")
	public ModelAndView editProduct(@RequestParam("id") int pid)
	{
		System.out.println("id"+pid);
		AddProduct addProduct=addproductService.getProductById(pid);
		System.out.println("ïtem name"+addProduct.getPname());
		return new ModelAndView("editProduct","editproduct",addProduct);
}
	@RequestMapping("/updatemyProduct")
	public String updateprod(@RequestParam("pid") String pid,@RequestParam("pname") String pname,
			@RequestParam("pdes") String pdes,@RequestParam("category") String category,@RequestParam("price")String price)
		{
		
			int id=Integer.parseInt(pid);
			AddProduct addProduct=addproductService.getProductById(id);
			addProduct.setPname(pname);
			addProduct.setPdes(pdes);
			addProduct.setCategory(category);
			addProduct.setPrice(Float.parseFloat(price));
			addproductService.updateProduct(addProduct);
			
			
		
		return "redirect:/viewAllProducts";
}
	@RequestMapping("/Home")
	public ModelAndView homepage(){
		System.out.println("welcome home");
				return new ModelAndView("Home");
	}
}
