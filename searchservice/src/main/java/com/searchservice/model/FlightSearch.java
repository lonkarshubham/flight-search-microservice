package com.searchservice.model;

import java.io.Serializable;
import java.time.LocalDateTime;
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
  
  @JsonProperty(value = "uuid")
  String id;
  
  @JsonProperty(value = "flight")
  String flight;
  
  @JsonProperty(value = "departure")
  LocalDateTime departure;
  
  @JsonProperty(value = "arrival")
  LocalDateTime arrival;
}
