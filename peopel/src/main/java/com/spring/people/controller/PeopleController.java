package com.spring.people.controller;

import com.spring.people.entity.People;
import com.spring.people.model.Vehicle;
import com.spring.people.service.PeopleService;
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
@RequestMapping("/people")
public class PeopleController {

	@Autowired
	private PeopleService peopleService;

	@GetMapping("/{name}")
	public People get(@PathVariable("name") String name) {
		return peopleService.get(name);
	}

	@PostMapping("/create")
	public ResponseEntity<People> create(@RequestBody People people) {
		People peopleCreated = peopleService.create(people);
		return new ResponseEntity<>(peopleCreated, HttpStatus.CREATED);
	}

	@GetMapping("/all")
	public List<People> getAll() {
		return peopleService.getAll();
	}

	@GetMapping("/vehicles-of-people/{peopleID}")
	public ResponseEntity<List<Vehicle>> getVehicles(@PathVariable("peopleID") String peopleID) {
		List<Vehicle> vehicles = peopleService.getVehicles(peopleID);
		return ResponseEntity.ok(vehicles);
	}

}