package com.ysz.ec.common.ext.kafka;

/**
 * <B>描述：</B><br/> <B>作者：</B> carl.yu <br/> <B>时间：</B> 2017/11/30 <br/> <B>版本：</B><br/>
 */
public enum KafkaAckEnum {
  ALL("all"),
  ONE("1"),
  ZERO("0");
  private String val;

  KafkaAckEnum(String val) {
    this.val = val;
  }

  public String getVal() {
    return val;
  }
}
