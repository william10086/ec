package com.ysz.ec.msg.api.exception;

import com.ysz.ec.common.exception.BizException;
import com.ysz.ec.msg.api.contants.MsgBizExceptionEnum;

/**
 * <B>描述：</B><br/> <B>作者：</B> carl.yu <br/> <B>时间：</B> 2017/11/29 <br/> <B>版本：</B><br/>
 */
public class MsgBizException extends BizException {

  public MsgBizException(MsgBizExceptionEnum exceptionEnum, String msg, Throwable e) {
    super(exceptionEnum.getCode(), exceptionEnum.getDesc() + msg, e);
  }

  public MsgBizException(MsgBizExceptionEnum exceptionEnum, Throwable e) {
    this(exceptionEnum, "", e);
  }

  public MsgBizException(MsgBizExceptionEnum exceptionEnum) {
    super(exceptionEnum.getCode(), "");
  }

  public MsgBizException(MsgBizExceptionEnum exceptionEnum, String msg) {
    super(exceptionEnum.getCode(), exceptionEnum.getDesc() + msg);
  }

}
