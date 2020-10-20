package com.example.interview.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Throughput {

  private Integer zoneA;

  private Integer zoneB;

  private Integer zoneC;

  private Integer zoneD;
}
