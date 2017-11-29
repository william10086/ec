package com.ysz.ec.msg.core.web;

import com.ysz.ec.common.api.AbstractApi;
import com.ysz.ec.common.api.ApiResp;
import com.ysz.ec.common.utils.ValidatorUtils;
import com.ysz.ec.msg.api.MsgApi;
import com.ysz.ec.msg.api.dto.PrepareConfirmMsgReq;
import com.ysz.ec.msg.core.service.MsgService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <B>描述：</B><br/> <B>作者：</B> carl.yu <br/> <B>时间：</B> 2017/11/29 <br/> <B>版本：</B><br/>
 */
@RestController
@RequestMapping("/api/msg")
@Slf4j
public class MsgApiImpl extends AbstractApi implements MsgApi {

  @Resource
  private MsgService msgService;

  @RequestMapping(value = "/prepare", method = RequestMethod.POST)
  @Override
  public ApiResp<Boolean> prepareConfirmMsg(@RequestBody PrepareConfirmMsgReq req) {
    ValidatorUtils.validateThrow(req);
    msgService.prepare(req);
    return ApiResp.ok(Boolean.TRUE);
  }

  @RequestMapping(value = "/confirm", method = RequestMethod.POST)
  @Override
  public ApiResp<Boolean> confirmAndSendMsg(@RequestParam(value = "msgId") String msgId) {
    msgService.confirmAndSend(msgId);
    return null;
  }
}
