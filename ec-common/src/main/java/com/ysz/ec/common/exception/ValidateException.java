package com.ysz.ec.common.exception;

/**
 * <B>描述：</B><br/> <B>作者：</B> carl.yu <br/> <B>时间：</B> 2017/11/29 <br/> <B>版本：</B><br/>
 */
public class ValidateException extends RuntimeException {
  public ValidateException() {
    super();
  }

  public ValidateException(String format, Object... param) {
    super(String.format(format, param));
  }
}
