package com.ysz.ec.common.constants;

/**
 * <B>描述：</B><br/> <B>作者：</B> carl.yu <br/> <B>时间：</B> 2017/11/29 <br/> <B>版本：</B><br/>
 */
public enum ApiRespStatusEnum {
  OK(1, "ok"), FAIL(-1, "fail");
  private int val;
  private String desc;

  ApiRespStatusEnum(int val, String desc) {
    this.val = val;
    this.desc = desc;
  }

  public void setVal(int val) {
    this.val = val;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  public int getVal() {
    return val;
  }

  public String getDesc() {
    return desc;
  }
}
