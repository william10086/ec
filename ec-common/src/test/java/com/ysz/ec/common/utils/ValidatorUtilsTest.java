package com.ysz.ec.common.utils;

import org.hibernate.validator.constraints.NotEmpty;
import org.junit.Ignore;
import org.junit.Test;

/**
 * <B>描述：</B><br/> <B>作者：</B> carl.yu <br/> <B>时间：</B> 2017/11/29 <br/> <B>版本：</B><br/>
 */
@Ignore
public class ValidatorUtilsTest {


  static class Pojo {
    @NotEmpty(message = "name 不能为空")
    private String name;


  }

  @Test
  public void testValidateNotNull() throws Exception {
    Pojo pojo = new Pojo();
    try {
      ValidatorUtils.validateThrow(pojo);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}