package com.springweb.restdemo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController // declares the class as REST controller
@RequestMapping("/products") // http://localhost:8080/products
public class ProductController {
	
	// creating an array list to store the product objects returned by the API
	private List<Product> listOfProducts = new ArrayList<>();
	
	/* GET */
	@GetMapping("/welcome") // http://localhost:8080/products/hello
	public String sayWelcome() {
		return "Welcome User";
	}
	
	
	@GetMapping("/mywebpage")
	@ResponseBody // optional annotation
	public String returnHtml() {
		return ""
				+ "<!DOCTYPE html> "
				+ "<html>" 
				+ 	"<head> "
				+ 		"<title> Springboot Webpage </title>"
				+ 	"</head>"
				+ 	"<body>"
				+ 		"<h1 style=\"background-color:powderblue;\" > Springboot </h1>"
				+ 		"<p style=\"background-color:tomato;\" >My first paragraph.</p>"
				+ 	"</body>"
				+ "</html>";
	}
	
	
	@GetMapping("/default")
	public Product returnDefaultProduct() {
		Product defaultProduct = new Product();
		defaultProduct.setProductName("Default Product");
		defaultProduct.setProductPrice(60.67);
		return defaultProduct;
	}
	
	/* if URL end-point not mentioned explicitly
	 * then the parent class's URL end-point will be considered */
	@GetMapping
	public List<Product> getAllProducts(){
		return listOfProducts;
	}

	/* GET specific product */
	@GetMapping("/{productId}")
	public Product getProductById(@PathVariable Long productId){
		return listOfProducts.stream().
		filter( p -> p.getProductId().equals(productId)).
		findFirst().orElse(null);
	}

	/* POST i.e. Create */
	@PostMapping
	public Product postProduct(@RequestBody Product product) { 
		listOfProducts.add(product);
		return product;
	}

	/* PUT i.e. full Update */
	@PutMapping("/{id}") // {id} goes to argument marked with @PathVariable
	public Product updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct){
		Product existingProduct = getProductById(id);
		if(existingProduct != null){
			existingProduct.setProductName(updatedProduct.getProductName());
			existingProduct.setProductPrice(updatedProduct.getProductPrice());
		}
		return existingProduct ;
	}

	/* PATCH i.e. selective update */
	@PatchMapping("/{id}")
	public Product editProduct(@PathVariable Long id, @RequestBody Product updatedProduct){
		
		Product existingProduct = getProductById(id);
		
		if(!updatedProduct.getProductName().equals(null)){
			existingProduct.setProductName(updatedProduct.getProductName());
		}
		if(updatedProduct.getProductPrice() != 0 ){
			existingProduct.setProductPrice(updatedProduct.getProductPrice());
		}
		return existingProduct;
	}

	/* DELETE */
	@DeleteMapping("/{id}")
	public void removeProduct(@PathVariable Long id){
		listOfProducts.removeIf(product -> product.getProductId().equals(id));
	}
	
}
