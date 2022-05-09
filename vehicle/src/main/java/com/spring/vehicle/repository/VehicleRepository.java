package com.spring.vehicle.repository;

import com.spring.vehicle.entity.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository  extends MongoRepository<Vehicle, String> {

	@Query("{brand: '?0'}")
	Vehicle findVehicleByBrand(String brand);

}