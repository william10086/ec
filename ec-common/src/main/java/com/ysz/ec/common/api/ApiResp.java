package com.ysz.ec.common.api;

import com.ysz.ec.common.constants.ApiRespStatusEnum;

import lombok.Data;

import java.io.Serializable;

/**
 * <B>描述：</B><br/> <B>作者：</B> carl.yu <br/> <B>时间：</B> 2017/11/29 <br/> <B>版本：</B><br/>
 */
@Data
public class ApiResp<T> implements Serializable {
  private String errorMsg;
  private Integer status;
  private T data;


  public static <T> ApiResp fail(String errorMsg, Object... param) {
    ApiResp<T> resp = new ApiResp<>();
    resp.setErrorMsg(String.format(errorMsg, param));
    resp.setStatus(ApiRespStatusEnum.FAIL.getVal());
    return resp;
  }

  public static <T> ApiResp ok(T data) {
    ApiResp<T> resp = new ApiResp<>();
    resp.setData(data);
    resp.setStatus(ApiRespStatusEnum.OK.getVal());
    return resp;
  }


}
