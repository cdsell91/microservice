package com.spring.people.service;

import com.spring.people.entity.People;
import com.spring.people.model.Vehicle;
import com.spring.people.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class PeopleService {

	private static final String vehicleService = "http://localhost:8083/vehicle/";

	@Autowired
	private PeopleRepository peopleRepository;

	@Autowired
	RestTemplate restTemplate;

	public People get(String name) {
		return peopleRepository.findPeopleByName(name);
	}

	public People create(People people) {
		return peopleRepository.save(people);
	}

	public List<People> getAll() {
		return peopleRepository.findAll();
	}

	public List<Vehicle> getVehicles(String peopleID) {
		People people = this.getPeopleByID(peopleID);
		List<String> vIDs = people.getVehicleIDList();
		List<Vehicle> vehicles = new ArrayList<>();
		for (String id : vIDs) {
			Vehicle vehicle = restTemplate.getForObject(vehicleService + id, Vehicle.class);
			if (vehicle != null) {
				vehicles.add(vehicle);
			}
		}
		return vehicles;
	}

	public People getPeopleByID(String peopleID) {
		return peopleRepository.findById(peopleID).orElse(null);
	}
}