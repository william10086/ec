package com.ysz.ec.common.api;

import com.ysz.ec.common.exception.ValidateException;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <B>描述：</B><br/> <B>作者：</B> carl.yu <br/> <B>时间：</B> 2017/11/29 <br/> <B>版本：</B><br/>
 */
@Slf4j
public abstract class AbstractApi {

  @ResponseBody
  @ExceptionHandler(ValidateException.class)
  public ApiResp<?> handleValidateException(ValidateException e) {
    return ApiResp.fail(e.getMessage());
  }
}
