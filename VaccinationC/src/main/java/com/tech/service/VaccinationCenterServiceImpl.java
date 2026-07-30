package com.tech.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

import com.tech.client.CitizenFeignClient;
import com.tech.model.CitizenModel;
import com.tech.model.RequiredResponse;
import com.tech.model.VaccinationCenter;
import com.tech.repo.VaccinationCenterRepo;

@Service
public class VaccinationCenterServiceImpl implements VaccinationCenterService {

    @Autowired
    private VaccinationCenterRepo centerRepo;

    @Autowired
    private CitizenFeignClient citizenFeignClient;

    @Override
    public VaccinationCenter addCenter(VaccinationCenter newCenter) {
        
        return centerRepo.save(newCenter);
    }

    @Override
    @CircuitBreaker(name = "citizenService", fallbackMethod = "handleCitizenServiceDowntime")
    public RequiredResponse getRequiredData(int id) {
        RequiredResponse response = new RequiredResponse();
        
        VaccinationCenter center = centerRepo.findById(id).orElse(null);
        response.setCenter(center);
        
        List<CitizenModel> citizens = citizenFeignClient.getCitizensByVaccinationCenterId(id);
        response.setCitizens(citizens);
        
        return response;
    }

    public RequiredResponse handleCitizenServiceDowntime(int id, Exception exception) {
        RequiredResponse response = new RequiredResponse();
        
        VaccinationCenter center = centerRepo.findById(id).orElse(null);
        response.setCenter(center);
        
        response.setCitizens(List.of()); 

        String errorMessage = "Citizen Service is down! Circuit breaker triggered. Error: " + exception.getMessage();
        response.setStatusMessage(errorMessage); 

        System.out.println(errorMessage);
        
        return response;
    }
}