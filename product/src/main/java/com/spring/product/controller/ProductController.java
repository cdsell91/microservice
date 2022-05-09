package com.spring.product.controller;

import com.spring.product.entity.Product;
import com.spring.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

	@Autowired
	ProductService productService;

	@GetMapping("/{name}")
	public Product get(@PathVariable("name") String name) {
		return productService.get(name);
	}

	@PostMapping("/create")
	public ResponseEntity<Product> create(@RequestBody Product product) {
		Product productCreated = productService.create(product);
		return new ResponseEntity<>(productCreated, HttpStatus.CREATED);
	}

	@GetMapping("/all")
	public List<Product> getAll() {
		return productService.getAll();
	}
}
