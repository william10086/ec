package com.ysz.ec.common.exception;

import com.ysz.ec.common.constants.BizExceptionCodeEnum;

import lombok.Getter;

/**
 * <B>描述：</B><br/> <B>作者：</B> carl.yu <br/> <B>时间：</B> 2017/11/29 <br/> <B>版本：</B><br/>
 */
public class BizException extends RuntimeException {
  @Getter
  protected String msg;
  @Getter
  protected Integer code;

  public BizException(int code, String msgFormat, Object... args) {
    super(String.format(msgFormat, args));
    this.code = code;
    this.msg = String.format(msgFormat, args);
  }

  public BizException() {
    super();
  }

  public BizException(int code, String message, Throwable cause) {
    super(message, cause);
    this.code = code;
  }


  public BizException(Throwable cause) {
    super(cause);
    if (cause instanceof DaoException) {
      this.code = BizExceptionCodeEnum.DB_CODE.getVal();
    }
  }
}
