package com.searchservice.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.searchservice.dto.FlightSearchResponse;

@Service
public class FlightDetailsService {

  @Autowired
  private RestTemplate restTemplate;

  public List<FlightSearchResponse> getFlightDetails() {
    ResponseEntity<List<FlightSearchResponse>> businessFlightEntity = restTemplate.
        exchange("http://localhost:9094/business", HttpMethod.GET, null,
            new ParameterizedTypeReference<List<FlightSearchResponse>>(){});
    List<FlightSearchResponse> businessFlight = businessFlightEntity.getBody();
    
    ResponseEntity<List<FlightSearchResponse>> cheapFlightEntity = restTemplate.
        exchange("http://localhost:9093/cheap", HttpMethod.GET, null,
            new ParameterizedTypeReference<List<FlightSearchResponse>>(){});
    List<FlightSearchResponse> cheapFlight = cheapFlightEntity.getBody();
    
    List<FlightSearchResponse> flightList = new ArrayList<>();
    flightList.addAll(businessFlight);
    flightList.addAll(cheapFlight);
    
    return flightList;
  }
}
