package com.mario.rpc.http.error;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BarConsumerService {

  private RestTemplate restTemplate;

  public BarConsumerService(RestTemplateBuilder restTemplateBuilder) {
    RestTemplate restTemplate = restTemplateBuilder
        .errorHandler(new RestTemplateResponseErrorHandler()).build();
  }

  public Bar fetchBarById(String barId) {
    return restTemplate.getForObject("/bars/4242", Bar.class);
  }
}
