package com.ysz.ec.order.web.controller;

import com.ysz.ec.order.service.UserFacade;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <B>描述：</B><br/>
 * <B>作者：</B> carl.yu <br/>
 * <B>时间：</B> 2017/11/15 <br/>
 * <B>版本：</B><br/>
 */
@RestController
@RequestMapping("order/test")
public class OrderTestController {

  @Resource
  private UserFacade userFacade;

  @RequestMapping("/hello")
  public String hello() {
    return userFacade.hello();
  }
}
