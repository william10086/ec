package com.ysz.ec.msg.api.contants;

import lombok.Getter;

/**
 * <B>描述：</B><br/> <B>作者：</B> carl.yu <br/> <B>时间：</B> 2017/11/29 <br/> <B>版本：</B><br/>
 */
@Getter
public enum MsgBizExceptionEnum {
  MSG_IS_NULL(8001, "消息不能为空"),
  KAFKA_SEND_FAIL(8002, "kafka发送失败"),
  CONFIRM_MSG_FAIL(8003, "消息确认失败");

  private Integer code;
  private String desc;


  MsgBizExceptionEnum(Integer code, String desc) {
    this.code = code;
    this.desc = desc;
  }
}
