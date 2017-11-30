package com.ysz.ec.msg.api.contants;

/**
 * <B>描述：</B>消息状态枚举<br/> <B>作者：</B> carl.yu <br/> <B>时间：</B> 2017/11/29 <br/> <B>版本：</B><br/>
 */
public enum MsgStatusEnum {
  PREPARE(0, "消息初始化"),
  SENDING(1,"消息发送中"),
  DEAD(-1, "死亡队列");
  
  private int code;
  private String desc;

  MsgStatusEnum(int code, String desc) {
    this.code = code;
    this.desc = desc;
  }

  public int getCode() {
    return code;
  }

  public String getDesc() {
    return desc;
  }
}
