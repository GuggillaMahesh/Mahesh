package com.mahi.free.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class CartProduct {
	@Id@GeneratedValue
	private int cartproductid;
	private int quantity;
	 @OneToOne
	    @JoinColumn(name="pid")
	 private AddProduct addProduct;
	 private double totalprice;
	@ManyToOne
	@JoinColumn(name="cartid")
	private Cart cart;
		
	public int getCartproductid() {
		return cartproductid;
	}
	public void setCartproductid(int cartproductid) {
		this.cartproductid = cartproductid;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public AddProduct getAddProduct() {
		return addProduct;
	}
	public void setAddProduct(AddProduct addProduct) {
		this.addProduct = addProduct;
	}
	public double getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	}



