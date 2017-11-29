package com.ysz.ec.msg.core.web;

import com.ysz.ec.common.api.AbstractApi;
import com.ysz.ec.msg.api.MsgApi;
import com.ysz.ec.msg.api.dto.PrepareConfirmMsgReq;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <B>描述：</B><br/> <B>作者：</B> carl.yu <br/> <B>时间：</B> 2017/11/29 <br/> <B>版本：</B><br/>
 */
@RestController
@RequestMapping("/api/msg")
@Slf4j
public class MsgApiImpl extends AbstractApi implements MsgApi {

  @RequestMapping(value = "/prepare", method = RequestMethod.POST)
  @Override
  public int prepareConfirmMsg(@RequestBody PrepareConfirmMsgReq req) {

    return 0;
  }
}
