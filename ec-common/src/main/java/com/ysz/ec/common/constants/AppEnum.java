package com.ysz.ec.common.constants;

import lombok.Getter;

/**
 * <B>描述：</B><br/> <B>作者：</B> carl.yu <br/> <B>时间：</B> 2017/11/15 <br/> <B>版本：</B><br/>
 */
public enum AppEnum {
  USER("EC-USER"),
  ORDER("EC-ORDER");
  public String value;

  AppEnum(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
