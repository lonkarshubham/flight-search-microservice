package com.flightservice2.handler;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.flightservice2.dto.FlightSearchResponse;
import com.flightservice2.model.FlightSearch;
import com.flightservice2.service.FlightDetailsService;

@Service
public class FlightDetailsHandler {
  
  @Autowired
  private FlightDetailsService flightDetails;
  
  public List<FlightSearchResponse> getFlightDetails() {
    return convertResponse(flightDetails.getFlightDetails());
  }
  
  private List<FlightSearchResponse> convertResponse(final List<FlightSearch> list) {
    List<FlightSearchResponse> result = new ArrayList<>();
    for(FlightSearch item: list) {
      FlightSearchResponse response = new FlightSearchResponse();
      response.setId(String.valueOf(item.getId()));
      List<String> parts = Pattern.compile("->").splitAsStream(item.getFlight()).collect(Collectors.toList());
      response.setDeparture(parts.get(0));
      response.setArrival(parts.get(0));
      response.setDepartureDate(LocalDate.of(item.getDeparture().getYear(), item.getDeparture().getMonth(), item.getDeparture().getDayOfMonth()));
      response.setDepartureTime(LocalTime.of(item.getDeparture().getHour(), item.getDeparture().getMinute()));
      response.setArrivalDate(LocalDate.of(item.getArrival().getYear(), item.getArrival().getMonth(), item.getArrival().getDayOfMonth()));
      response.setArrivalTime(LocalTime.of(item.getArrival().getHour(), item.getArrival().getMinute()));
      result.add(response);
    }
    return result;
  }
}
