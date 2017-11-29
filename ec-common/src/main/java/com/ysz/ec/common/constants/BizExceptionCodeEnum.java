package com.ysz.ec.common.constants;

/**
 * <B>描述：</B><br/> <B>作者：</B> carl.yu <br/> <B>时间：</B> 2017/11/29 <br/> <B>版本：</B><br/>
 */
public enum BizExceptionCodeEnum {
  DB_CODE(100000, "db error");
  private Integer val;
  private String desc;

  BizExceptionCodeEnum(Integer val, String desc) {
    this.val = val;
    this.desc = desc;
  }

  public Integer getVal() {
    return val;
  }

  public void setVal(Integer val) {
    this.val = val;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }
}
