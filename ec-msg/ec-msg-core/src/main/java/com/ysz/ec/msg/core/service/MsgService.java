package com.ysz.ec.msg.core.service;

import com.ysz.ec.msg.api.dto.PrepareConfirmMsgReq;

/**
 * <B>描述：</B><br/> <B>作者：</B> carl.yu <br/> <B>时间：</B> 2017/11/29 <br/> <B>版本：</B><br/>
 */
public interface MsgService {
  void prepare(PrepareConfirmMsgReq req);

  void confirmAndSend(String msgId);

  void sendDirectly(String topic, String key, String value);


}
