package com.spring.vehicle.service;

import com.spring.vehicle.entity.Vehicle;
import com.spring.vehicle.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

	@Autowired
	private VehicleRepository vehicleRepository;

	public Vehicle get(String brand) {
		return vehicleRepository.findVehicleByBrand(brand);
	}

	public Vehicle getByID(String id) {
		return vehicleRepository.findById(id).orElse(null);
	}

	public Vehicle create(Vehicle vehicle) {
		return vehicleRepository.save(vehicle);
	}

	public List<Vehicle> getAll() {
		return vehicleRepository.findAll();
	}
}