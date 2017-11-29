package com.ysz.ec.usr.core.impl;

import com.ysz.ec.usr.api.UserApi;
import com.ysz.ec.usr.api.dto.TestWithParamReq;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <B>描述：</B><br/> <B>作者：</B> carl.yu <br/> <B>时间：</B> 2017/11/28 <br/> <B>版本：</B><br/>
 */
@Controller
public class UserApiImpl implements UserApi {

  @RequestMapping(method = RequestMethod.GET, value = "/test")
  @ResponseBody
  @Override
  public String test() {
    return "user";
  }

  @RequestMapping(method = RequestMethod.POST, value = "/test_with_param")
  @ResponseBody
  @Override
  public String testWithParam(@RequestBody TestWithParamReq req) {
    System.err.println(req);
    return "ok";
  }
}
