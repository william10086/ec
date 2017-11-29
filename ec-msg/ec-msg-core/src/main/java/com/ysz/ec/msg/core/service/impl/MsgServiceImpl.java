package com.ysz.ec.msg.core.service.impl;

import com.ysz.ec.common.exception.DaoException;
import com.ysz.ec.msg.api.contants.MsgBizExceptionEnum;
import com.ysz.ec.msg.api.dto.PrepareConfirmMsgReq;
import com.ysz.ec.msg.api.exception.MsgBizException;
import com.ysz.ec.msg.core.dao.MsgDAO;
import com.ysz.ec.msg.core.entity.Msg;
import com.ysz.ec.msg.core.service.MsgService;
import com.ysz.ec.msg.core.utils.MsgConvertUtils;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <B>描述：</B><br/> <B>作者：</B> carl.yu <br/> <B>时间：</B> 2017/11/29 <br/> <B>版本：</B><br/>
 */
@Service
public class MsgServiceImpl implements MsgService {

  @Resource
  private MsgDAO msgDAO;

  @Override
  public void prepare(PrepareConfirmMsgReq req) {
    try {
      msgDAO.insert(MsgConvertUtils.toMsgFromPrepareConfirmMsgReq(req));
    } catch (DaoException e) {
      throw new MsgBizException(e);
    }
  }

  @Override
  public void confirmAndSend(String msgId) {
    Msg msg = msgDAO.loadByMsgId(msgId);
    if (msg == null) {
      throw new MsgBizException(MsgBizExceptionEnum.MSG_IS_NULL);
    }
  }


}
