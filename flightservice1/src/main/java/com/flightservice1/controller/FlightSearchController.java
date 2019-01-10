package com.flightservice1.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.flightservice1.dto.FlightSearchResponse;
import com.flightservice1.handler.FlightDetailsHandler;

@RestController
@RequestMapping("cheap")
public class FlightSearchController {
  
  @Autowired
  private FlightDetailsHandler flightDetails;
  
  @GetMapping
  public ResponseEntity<List<FlightSearchResponse>> getFlightDetails() {
    return new ResponseEntity<>(flightDetails.getFlightDetails(),HttpStatus.OK);
  }
  
  
}
