package com.example.interview;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tag;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Listener {

  private final MeterRegistry meterRegistry;

  @Autowired
  private KafkaTemplate<Integer, String> kafkaTemplate;

  public Listener(MeterRegistry meterRegistry) {
    this.meterRegistry = meterRegistry;
  }

  @KafkaListener(topics = "customer", groupId = "groupA")
  public void zoneAListener(@Payload String customer) {
    log.info("Group A Receive message: {}", customer);

    try {
      kafkaTemplate.send("zoneA", customer).get();
      meterRegistry.counter("throughput", Arrays.asList(Tag.of("zone","A"))).increment();
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
    }
  }

  @KafkaListener(topics = "customer", groupId = "groupB")
  public void zoneBListener(@Payload String customer) {
    log.info("Group B Receive message: {}", customer);

    try {
      kafkaTemplate.send("zoneB", customer).get();
      meterRegistry.counter("throughput", Arrays.asList(Tag.of("zone","B"))).increment();
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
    }
  }

  @KafkaListener(topics = "customer", groupId = "groupC")
  public void zoneCListener(@Payload String customer) {
    log.info("Group C Receive message: {}", customer);

    try {
      kafkaTemplate.send("zoneC", customer).get();
      meterRegistry.counter("throughput", Arrays.asList(Tag.of("zone","C"))).increment();
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
    }
  }

  @KafkaListener(topics = "customer", groupId = "groupD")
  public void zoneDListener(@Payload String customer) {
    log.info("Group D Receive message: {}", customer);

    try {

      Thread.sleep(1000);

      kafkaTemplate.send("zoneD", customer).get();
      meterRegistry.counter("throughput", Arrays.asList(Tag.of("zone","D"))).increment();
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
    }
  }




}

