package com.tech.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

public class RequiredResponse {
    
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private VaccinationCenter center;
    private List<CitizenModel> citizens;
    private String statusMessage;
    
    public RequiredResponse() {
        super();
    }

    public RequiredResponse(VaccinationCenter center, List<CitizenModel> citizens, String statusMessage) {
        super();
        this.center = center;
        this.citizens = citizens;
        this.statusMessage=statusMessage;
    }
    

    public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public VaccinationCenter getCenter() {
        return center;
    }

    public void setCenter(VaccinationCenter center) {
        this.center = center;
    }

    public List<CitizenModel> getCitizens() {
        return citizens;
    }

    public void setCitizens(List<CitizenModel> citizens) {
        this.citizens = citizens;
    }

    @Override
    public String toString() {
        return "RequiredResponse [center=" + center + "]";
    }
}