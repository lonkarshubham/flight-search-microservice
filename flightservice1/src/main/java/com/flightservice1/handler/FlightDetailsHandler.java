package com.flightservice1.handler;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.flightservice1.dto.FlightSearchResponse;
import com.flightservice1.model.FlightSearch;
import com.flightservice1.service.FlightDetailsService;

@Service
public class FlightDetailsHandler {
  
  @Autowired
  private FlightDetailsService flightDetails;
  
  public List<FlightSearchResponse> getFlightDetails() {
    return convertResponse(flightDetails.getFlightDetails());
  }
  
  private List<FlightSearchResponse> convertResponse(final List<FlightSearch> list) {
    List<FlightSearchResponse> result = new ArrayList<>();
    for(FlightSearch flight: list) {
      FlightSearchResponse response = new FlightSearchResponse();
      response.setId(String.valueOf(flight.getId()));
      response.setDeparture(flight.getDeparture());
      response.setArrival(flight.getArrival());
      response.setDepartureDate(getLocalDate(flight.getDepartureTime()));
      response.setDepartureTime(getLocalTime(flight.getDepartureTime()));
      response.setArrivalDate(getLocalDate(flight.getArrivalTime()));
      response.setArrivalTime(getLocalTime(flight.getArrivalTime()));
      result.add(response);
    }
    return result;
  }
  
  private LocalDate getLocalDate(final Long value) {
    return Instant.ofEpochMilli(value).atZone(ZoneId.systemDefault()).toLocalDate();
  }
  
  private LocalTime getLocalTime(final Long value) {
    LocalTime time = Instant.ofEpochMilli(value).atZone(ZoneId.systemDefault()).toLocalTime();
    return LocalTime.of(time.getHour(), time.getMinute());
  }
}
