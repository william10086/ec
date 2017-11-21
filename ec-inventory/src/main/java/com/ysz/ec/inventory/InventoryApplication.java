package com.ysz.ec.inventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <B>描述：</B><br/> <B>作者：</B> carl.yu <br/> <B>时间：</B> 2017/11/15 <br/> <B>版本：</B><br/>
 */
@SpringBootApplication
@RestController
public class InventoryApplication {

  public static void main(String[] args) {
    SpringApplication.run(InventoryApplication.class, args);
  }

  @RequestMapping("/inventory/hello")
  public String hello() {
    return "hello inventory";
  }
}
