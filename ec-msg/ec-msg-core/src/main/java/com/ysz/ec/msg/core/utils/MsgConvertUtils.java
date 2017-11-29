package com.ysz.ec.msg.core.utils;

import com.google.common.base.Preconditions;
import com.ysz.ec.msg.api.contants.MsgStatusEnum;
import com.ysz.ec.msg.api.dto.PrepareConfirmMsgReq;
import com.ysz.ec.msg.core.entity.Msg;

import org.springframework.beans.BeanUtils;

/**
 * <B>描述：</B><br/> <B>作者：</B> carl.yu <br/> <B>时间：</B> 2017/11/29 <br/> <B>版本：</B><br/>
 */
public class MsgConvertUtils {

  public static Msg toMsgFromPrepareConfirmMsgReq(PrepareConfirmMsgReq src) {
    Preconditions.checkNotNull(src);
    Msg dest = new Msg();
    BeanUtils.copyProperties(src, dest);
    dest.setMsgStatus(MsgStatusEnum.PREPARE.getCode());
    return dest;
  }
}
