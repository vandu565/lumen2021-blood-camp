package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Camp;
import com.example.demo.services.DonationCampService;

@RestController
@RequestMapping(path = "/api/v1/camps")
public class DonationCampController {

	@Autowired
	private DonationCampService service;
	
	
	@PostMapping
	public ResponseEntity<Camp> add(@RequestBody Camp entity) {
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.newCamp(entity));
	}
	
	@GetMapping(path = "/location/{location}")
	public List<Camp> findByLocation(@PathVariable("location") String location){
		return this.service.findByLocation(location);
	}
	
	@GetMapping
	public List<Camp> findAll(){
		return this.service.findAllCamps();
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<String> removeCamp(@PathVariable("id") int id) {
		int count = this.service.removeCamp(id);
		return count==1?ResponseEntity.ok().body(count+" rows deleted"):
				ResponseEntity.status(HttpStatus.NOT_FOUND).body("Record not found");
	}
	
}
