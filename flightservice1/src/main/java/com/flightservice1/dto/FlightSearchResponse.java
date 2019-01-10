package com.flightservice1.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
public class FlightSearchResponse implements Serializable{
  
  @JsonProperty(value="id")
  String id;
  
  @JsonProperty(value="departure")
  String departure;
  
  @JsonProperty(value="arrival")
  String arrival;
  
  @JsonProperty(value="departureDate")
  LocalDate departureDate;
  
  @JsonProperty(value="departureTime")
  LocalTime departureTime;
  
  @JsonProperty(value="arrivalDate")
  LocalDate arrivalDate;
  
  @JsonProperty(value="arrivalTime")
  LocalTime arrivalTime;
}
