package com.example.interview;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tags;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MetricConfiguration {

  @Bean
  MeterRegistryCustomizer<MeterRegistry> zoneACounter() {

    return registry -> {
      registry.counter("count");
    };

  }
}
