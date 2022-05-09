package com.spring.vehicle.controller;

import com.spring.vehicle.entity.Vehicle;
import com.spring.vehicle.service.VehicleService;
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
@RequestMapping("/vehicle")
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;

	@GetMapping("/v-name/{brand}")
	public Vehicle get(@PathVariable("brand") String brand) {
		return vehicleService.get(brand);
	}

	@GetMapping("/{id}")
	public Vehicle getByID(@PathVariable("id") String id) {
		return vehicleService.getByID(id);
	}

	@PostMapping("/create")
	public ResponseEntity<Vehicle> create(@RequestBody Vehicle vehicle) {
		Vehicle vehicleCreated = vehicleService.create(vehicle);
		return new ResponseEntity<>(vehicleCreated, HttpStatus.CREATED);
	}

	@GetMapping("/all")
	public List<Vehicle> getAll() {
		return vehicleService.getAll();
	}

}