package com.dell.springboot.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	//delete product
	@RequestMapping(value="/product/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<?> deleteProduct(@PathVariable("id") long id){
		
		logger.info("fetching & deleteing product with id {}",id);
		Product  product=productServices.findById(id);
		if(product==null){
			logger.error("unable to delete wjth user id{ } not found",id);
			 return new ResponseEntity(new CustomErrorType("Unable to delete. Product with id " + id + " not found."),
	                    HttpStatus.NOT_FOUND);
		}
		 productServices.deleteProductById(id);
	        return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
		
	}
	
	  // ------------------- Update a Product ------------------------------------------------
	 
    @RequestMapping(value = "/product/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateProduct(@PathVariable("id") long id, @RequestBody Product product) {
        logger.info("Updating Product with id {}", id);
 
        Product currentProduct = productServices.findById(id);
 
        if (currentProduct == null) {
            logger.error("Unable to update. Product with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Unable to upate. Product with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
 
        currentProduct.setType(product.getType());
        currentProduct.setBrand(product.getBrand());
        currentProduct.setColor(product.getColor());
        currentProduct.setPrice(product.getPrice());
productServices.updateProduct(currentProduct);
        
        return new ResponseEntity<Product>(currentProduct, HttpStatus.OK);
    }
	
    
    @RequestMapping(value="/product/{id}",method=RequestMethod.GET)
    public ResponseEntity<?> getproduct(@PathVariable("id") long id){
    	 logger.info("Fetching Product with id {}", id);
         Product product = productServices.findById(id);
         if (product == null) {
             logger.error("product with id {} not found.", id);
             return new ResponseEntity(new CustomErrorType("product with id " + id 
                     + " not found"), HttpStatus.NOT_FOUND);
         }
         return new ResponseEntity<Product>(product, HttpStatus.OK);
    }
	
}