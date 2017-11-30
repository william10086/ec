package com.ysz.ec.msg.api;

import com.ysz.ec.common.api.ApiResp;
import com.ysz.ec.msg.api.dto.PrepareConfirmMsgReq;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
  ApiResp<Boolean> prepareConfirmMsg(@RequestBody PrepareConfirmMsgReq req);

  /**
   * 确认消息，并发送根据Id发送消息给消息中间件
   * @param msgId
   * @return
   */
  @RequestMapping(value = "/confirm", method = RequestMethod.POST)
  ApiResp<Boolean> confirmAndSendMsg(@RequestParam(value = "msgId") String msgId);


  //未完成方法:
  // (1) 消息进入死亡队列
  // (2) 保存且直接发送消息
  // (3) 直接发送消息
  // (4) 按照 topic resend Msg
  // (5) 按照 msgId resend Msg
  // (6) ...
}
