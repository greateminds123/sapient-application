package com.dell.springboot.model.service;

import java.util.List;

import com.dell.springboot.model.Product;

public interface ProductServices {
	
	Product findById(Long id);
	Product findByName(String type);
	void saveProduct(Product product);
	
	void deleteProductById(Long id);
	void deleteAllProducts();
	
	List<Product> findAllProducts();
	void updateProduct(Product product);
	boolean isProductExist(Product product);
	

}
