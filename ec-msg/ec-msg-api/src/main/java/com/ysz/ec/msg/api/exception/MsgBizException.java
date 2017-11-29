package com.ysz.ec.msg.api.exception;

import com.ysz.ec.common.exception.BizException;
import com.ysz.ec.msg.api.contants.MsgBizExceptionEnum;

/**
 * <B>描述：</B><br/> <B>作者：</B> carl.yu <br/> <B>时间：</B> 2017/11/29 <br/> <B>版本：</B><br/>
 */
public class MsgBizException extends BizException {


  public MsgBizException(MsgBizExceptionEnum exceptionEnum) {
    super(exceptionEnum.getCode(), exceptionEnum.getDesc());
  }

  public MsgBizException(Throwable e) {
    super(e);
  }
}
