package com.tech.service;

import com.tech.model.RequiredResponse;
import com.tech.model.VaccinationCenter;

public interface VaccinationCenterService {
    
    public VaccinationCenter addCenter(VaccinationCenter newCenter);
    
    public RequiredResponse getRequiredData(int id);
    
}