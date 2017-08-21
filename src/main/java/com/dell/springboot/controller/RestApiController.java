package com.dell.springboot.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.dell.springboot.model.Product;
import com.dell.springboot.model.service.ProductServices;
import com.dell.springboot.utill.CustomErrorType;

@RestController
@RequestMapping("/api")
public class RestApiController {
	public static final Logger logger=LoggerFactory.getLogger(RestApiController.class);

	@Autowired
	ProductServices productServices;
	
	//Retrive all product
	@RequestMapping(value="/product/", method= RequestMethod.GET)
	public ResponseEntity<List<Product>> listAllProduct(){
	List<Product> products=	productServices.findAllProducts();
	if(products.isEmpty()){
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
		return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
		
	}
	//creating product
	
	@RequestMapping(value ="/product/",method =RequestMethod.POST)
	ResponseEntity<?> createProduct(@RequestBody Product product, UriComponentsBuilder uriComponentsBuilder){
	logger.info("Creating Product: {}", product);
		
	/*if(productServices.isProductExist(product)){
			logger.error("Unamble to create product product already exists",product.getType()); 
	    return new ResponseEntity(new CustomErrorType("Unable to create product. A product is "+ product.getType()+"already exits"),HttpStatus.CONFLICT);
	}*/
	productServices.saveProduct(product);
	HttpHeaders headers=new HttpHeaders();
	headers.setLocation(uriComponentsBuilder.path("/api/product/{id}").buildAndExpand(product.getId()).toUri());
	return new ResponseEntity<String>(headers,HttpStatus.CREATED);
		
	}
	
	//delete All product
	
	public ResponseEntity<Product>  deleteAllProducts(){
	  
		logger.info("Deleting All Products");
		
		productServices.deleteAllProducts();
		
		return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
		
	    }
	
	
	
	
}