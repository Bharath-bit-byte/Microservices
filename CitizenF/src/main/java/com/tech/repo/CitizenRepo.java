package com.tech.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tech.model.CitizenModel;

public interface CitizenRepo extends JpaRepository<CitizenModel, Integer> {

	public List<CitizenModel> findByVaccinationCenterId(Integer id);
}