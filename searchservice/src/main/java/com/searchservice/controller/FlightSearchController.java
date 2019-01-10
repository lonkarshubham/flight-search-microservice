package com.searchservice.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.searchservice.dto.FlightSearchResponse;
import com.searchservice.handler.FlightDetailsHandler;

@RestController
@RequestMapping("search")
public class FlightSearchController {
  
  @Autowired
  private FlightDetailsHandler flightDetails;
  
  @GetMapping
  public PageImpl<FlightSearchResponse> getFlightDetails(
      @RequestParam(value = "type", required = false, defaultValue = "All") final String type,
      @RequestParam(value = "searchText", required = false) final String searchText,
      Pageable pageable) {
    List<FlightSearchResponse> list = flightDetails.getFlightDetails(type, searchText);
    int start =  (int) PageRequest.of(1, 5).getOffset();
    int end = (start + PageRequest.of(1, 5).getPageSize()) > list.size() ? list.size() : (start + PageRequest.of(1, 5).getPageSize());
    return new PageImpl<FlightSearchResponse>(list.subList(start, end), PageRequest.of(1, 5), list.size());
    //return new ResponseEntity<>(flightDetails.getFlightDetails(type, searchText),HttpStatus.OK);
  }
}
