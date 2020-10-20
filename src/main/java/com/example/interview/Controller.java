package com.example.interview;

import com.example.interview.dto.Customer;
import com.example.interview.dto.Throughput;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

  private KafkaMessageService kafkaMessageService;

  public Controller(KafkaMessageService kafkaMessageService) {
    this.kafkaMessageService = kafkaMessageService;
  }

  @PostMapping
  public void sendMessage(@RequestBody Customer customer) {
    kafkaMessageService.send(customer);
  }

  @GetMapping
  public Throughput getThroughout() {
    return null;
  }
}
