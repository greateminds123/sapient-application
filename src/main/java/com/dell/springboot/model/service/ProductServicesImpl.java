package com.dell.springboot.model.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dell.springboot.model.Product;
import com.dell.springboot.repositories.ProductRepository;


@Service("productService")
@Transactional
public class ProductServicesImpl implements ProductServices {

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Product findById(Long id) {
		// TODO Auto-generated method stub
		return productRepository.findOne(id);
	}

	@Override
	public Product findByName(String type) {
		// TODO Auto-generated method stub
		return productRepository.findByType(type);
	}

	@Override
	public void saveProduct(Product product) {
		// TODO Auto-generated method stub
		productRepository.save(product);
	}
	@Override
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		saveProduct(product);
	}
	@Override
	public void deleteProductById(Long id) {
		// TODO Auto-generated method stub
		productRepository.delete(id);
	}
	

	@Override
	public void deleteAllProducts() {
		// TODO Auto-generated method stub
		productRepository.deleteAll();
	}

	@Override
	public List<Product> findAllProducts() {
		// TODO Auto-generated method stub
		return  productRepository.findAll();
	}

	@Override
	public boolean isProductExist(Product product) {
		// TODO Auto-generated method stub
		return findByName(product.getType())!=null;
	}

	
}
