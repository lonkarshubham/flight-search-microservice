package com.flightservice1.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.flightservice1.model.FlightSearch;

@Service
public class FlightDetailsService {

  @Autowired
  private RestTemplate restTemplate;
  
  @Value("${service.url}")
  String serviceUrl;

  public List<FlightSearch> getFlightDetails() {
    ResponseEntity<List<FlightSearch>> responseEntity = restTemplate.
        exchange(serviceUrl, HttpMethod.GET, null,
            new ParameterizedTypeReference<List<FlightSearch>>(){});
    return responseEntity.getBody();
  }
}
