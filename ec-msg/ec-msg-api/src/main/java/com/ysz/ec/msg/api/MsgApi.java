package com.ysz.ec.msg.api;

import com.ysz.ec.msg.api.dto.PrepareConfirmMsgReq;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <B>描述：</B><br/> <B>作者：</B> carl.yu <br/> <B>时间：</B> 2017/11/29 <br/> <B>版本：</B><br/>
 */
@RestController
@RequestMapping("/api/msg")
public interface MsgApi {

  /**
   * 预发送确认消息
   */
  @RequestMapping(value = "/prepare", method = RequestMethod.POST)
  int prepareConfirmMsg(@RequestBody PrepareConfirmMsgReq req);
}
