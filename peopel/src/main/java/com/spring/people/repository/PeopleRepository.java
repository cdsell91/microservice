package com.spring.people.repository;

import com.spring.people.entity.People;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleRepository extends MongoRepository<People, String> {

	@Query("{name: '?0'}")
	People findPeopleByName(String name);
}