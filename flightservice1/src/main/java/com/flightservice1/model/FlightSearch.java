package com.flightservice1.model;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FlightSearch implements Serializable {
  
  @JsonProperty(value = "id")
  Long id;
  
  @JsonProperty(value = "departure")
  String departure;
  
  @JsonProperty(value = "arrival")
  String arrival;
  
  @JsonProperty(value = "departureTime")
  Long departureTime;
  
  @JsonProperty(value = "arrivalTime")
  Long arrivalTime;
  
}
