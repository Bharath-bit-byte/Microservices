package com.tech.client;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.tech.model.CitizenModel;

// Add the 'url' attribute mapping to the property we created
@FeignClient(name = "citizen-service", url = "${citizen.service.url}")
public interface CitizenFeignClient {

    @GetMapping("/citizen/VCid/{id}")
    List<CitizenModel> getCitizensByVaccinationCenterId(@PathVariable("id") Integer id);
}