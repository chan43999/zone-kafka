package com.example.interview.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Customer {

  private String name;

  private String id;

  private String telephoneNumber;

  @JsonProperty("customer_score")
  private Integer customerScore;

  @JsonProperty("customer_zone")
  private String customerZone;
}
