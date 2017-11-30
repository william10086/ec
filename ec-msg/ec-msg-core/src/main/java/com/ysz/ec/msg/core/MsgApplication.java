package com.ysz.ec.msg.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * <B>描述：</B><br/> <B>作者：</B> carl.yu <br/> <B>时间：</B> 2017/11/30 <br/> <B>版本：</B><br/>
 */
@SpringBootApplication
@EnableDiscoveryClient
public class MsgApplication {

  public static void main(String[] args) {
    SpringApplication.run(MsgApplication.class, args);
  }
}
