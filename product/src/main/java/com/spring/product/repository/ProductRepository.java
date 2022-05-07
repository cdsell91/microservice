package com.spring.product.repository;

import com.spring.product.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ProductRepository extends MongoRepository<Product, String> {

	@Query("{name: '?0'}")
	Product findProductByName(String name);

}
