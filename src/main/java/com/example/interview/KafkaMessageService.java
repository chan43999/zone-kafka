package com.example.interview;

import com.example.interview.dto.Customer;
import java.util.concurrent.ExecutionException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaMessageService {

  @Autowired
  private KafkaTemplate<Integer, Customer> kafkaTemplate;

  public void send(Customer customer) {

    try {
      log.info("sending kafka message");
      kafkaTemplate.send("customer", customer).get();
    } catch (InterruptedException | ExecutionException e) {
      log.error("publish fail");
      e.printStackTrace();
    }
  }
}
