package com.ysz.ec.usr.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <B>描述：</B><br/> <B>作者：</B> carl.yu <br/> <B>时间：</B> 2017/11/28 <br/> <B>版本：</B><br/>
 */
@Data
@Builder
@AllArgsConstructor
public class TestWithParamReq implements Serializable {

  public TestWithParamReq() {
  }

  private Integer age;
  private String name;
  private Date date;

}
