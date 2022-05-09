package com.spring.product.service;

import com.spring.product.entity.Product;
import com.spring.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	public Product get(String name) {
		return productRepository.findProductByName(name);
	}

	public Product create(Product product) {
		return productRepository.save(product);
	}

	public List<Product> getAll() {
		return productRepository.findAll();
	}

}
