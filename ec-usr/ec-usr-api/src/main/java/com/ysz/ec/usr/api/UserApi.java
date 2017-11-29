package com.ysz.ec.usr.api;

import com.ysz.ec.usr.api.dto.TestWithParamReq;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <B>描述：</B><br/> <B>作者：</B> carl.yu <br/> <B>时间：</B> 2017/11/28 <br/> <B>版本：</B><br/>
 */
public interface UserApi {

  @RequestMapping(method = RequestMethod.GET, value = "/test")
  @ResponseBody
  String test();

  @RequestMapping(method = RequestMethod.POST, value = "/test_with_param")
  @ResponseBody
  String testWithParam(@RequestBody TestWithParamReq req);
}
