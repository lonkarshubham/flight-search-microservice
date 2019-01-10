package com.searchservice.handler;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.searchservice.dto.FlightSearchResponse;
import com.searchservice.model.FlightSearch;
import com.searchservice.service.FlightDetailsService;

@Service
public class FlightDetailsHandler {
  
  @Autowired
  private FlightDetailsService flightDetails;
  
  public List<FlightSearchResponse> getFlightDetails(final String type, final String searchText) {
    List<FlightSearchResponse> list = getAll();
//    try {
//      Field[] fields =  FlightSearchResponse.class.getDeclaredFields();
//      String field = FlightSearchResponse.class.getField("departure").getName();
//      System.out.println("fields: "+ field);
//      return list;
//    } catch (NoSuchFieldException e) {
//      // TODO Auto-generated catch block
//      e.printStackTrace();
//    } catch (SecurityException e) {
//      // TODO Auto-generated catch block
//      e.printStackTrace();
//    }
    return list;
  }
  
  private List<FlightSearchResponse> getAll() {
    return flightDetails.getFlightDetails();
  }
}
