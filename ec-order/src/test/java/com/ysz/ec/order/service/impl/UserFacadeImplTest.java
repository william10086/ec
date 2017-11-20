package com.ysz.ec.order.service.impl;

import com.ysz.ec.order.OrderApplication;
import com.ysz.ec.order.service.UserFacade;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * <B>描述：</B><br/>
 * <B>作者：</B> carl.yu <br/>
 * <B>时间：</B> 2017/11/15 <br/>
 * <B>版本：</B><br/>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(
    classes = OrderApplication.class
)
public class UserFacadeImplTest {

  @Resource
  private UserFacade userFacade;

  @Test
  public void hello() throws Exception {
    String hello = userFacade.hello();
    System.err.println(hello);
  }

}