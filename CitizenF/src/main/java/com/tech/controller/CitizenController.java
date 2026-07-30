package com.tech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tech.model.CitizenModel;
import com.tech.repo.CitizenRepo;

@RestController
@RequestMapping("/citizen")
public class CitizenController {
	
	@Autowired
	private CitizenRepo repo;

	@GetMapping("/test")
	public ResponseEntity<String> test()
	{
		return new ResponseEntity<>("Hello",HttpStatus.OK);
	}
	@PostMapping("/add")
	public ResponseEntity<CitizenModel> addCitizen(@RequestBody CitizenModel newCitizen)
	{
		CitizenModel citizen=repo.save(newCitizen);
		return new ResponseEntity<>(citizen,HttpStatus.OK);
	}
	
	@GetMapping("/VCid/{id}")
	public ResponseEntity<List<CitizenModel>> getById(@PathVariable Integer id)
	{
		List<CitizenModel> listCitizen=repo.findByVaccinationCenterId(id);
		return new ResponseEntity<>(listCitizen,HttpStatus.OK);
	} 
	
}
