package com.springweb.restdemo;

public class Product {
	
	// to keep track of id of next element
	private static Long nextProductId = 1l;
	
	private Long productId;
	private String productName;
	private double productPrice; // price can be a decimal
	
	/* constructor */
	public Product(){
		this.productId = nextProductId++;
	}
	
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	
}
