package com.tech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tech.model.RequiredResponse;
import com.tech.model.VaccinationCenter;
import com.tech.service.VaccinationCenterService;

@RestController
@RequestMapping("/vaccinationCenter")
public class VaccinationCenterController {

    @Autowired
    private VaccinationCenterService centerService;

    @GetMapping("/get/{id}") 
    public ResponseEntity<RequiredResponse> getRequiredData(@PathVariable Integer id) {
        RequiredResponse requiredResponse = centerService.getRequiredData(id);
        return new ResponseEntity<>(requiredResponse, HttpStatus.OK);
    }
    
    @PostMapping("/add")
    public ResponseEntity<VaccinationCenter> addCenter(@RequestBody VaccinationCenter newCenter) {
        VaccinationCenter center = centerService.addCenter(newCenter);
        return new ResponseEntity<>(center, HttpStatus.OK);
    }
}