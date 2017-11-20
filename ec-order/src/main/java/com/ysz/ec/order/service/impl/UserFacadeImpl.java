package com.ysz.ec.order.service.impl;

import com.ysz.ec.common.constants.AppEnum;
import com.ysz.ec.order.service.UserFacade;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * <B>描述：</B><br/>
 * <B>作者：</B> carl.yu <br/>
 * <B>时间：</B> 2017/11/15 <br/>
 * <B>版本：</B><br/>
 */
@Service
public class UserFacadeImpl implements UserFacade {

  @Resource
  private RestTemplate restTemplate;

  @Override
  public String hello() {
    String url = String.format("http://%s/user/hello", AppEnum.USER.getValue());
    String result = restTemplate.getForObject(url, String.class);
    return result;
  }
}
