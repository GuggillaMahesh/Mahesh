package com.mahi.free.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class User {
	@Id@GeneratedValue
	private int id;
	@NotEmpty(message="please enter user name")
	private String name;
	@NotEmpty(message="please enter user password")
	private String password;
	@NotEmpty(message="please enter user email")
	private String email;
	@NotEmpty(message="please enter user mobile")
	private String mobile;
	private Boolean enbaled;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cartid")
	private Cart cart;

	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public Boolean getEnbaled() {
		return enbaled;
	}
	public void setEnbaled(Boolean enbaled) {
		this.enbaled = enbaled;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
}
