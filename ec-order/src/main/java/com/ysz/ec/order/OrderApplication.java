package com.ysz.ec.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * <B>描述：</B><br/>
 * <B>作者：</B> carl.yu <br/>
 * <B>时间：</B> 2017/11/15 <br/>
 * <B>版本：</B><br/>
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderApplication {

  @Bean
  @LoadBalanced
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

  public static void main(String[] args) {
    SpringApplication.run(OrderApplication.class, args);
  }
}
