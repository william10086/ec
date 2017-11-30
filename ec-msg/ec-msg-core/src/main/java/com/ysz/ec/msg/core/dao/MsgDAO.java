package com.ysz.ec.msg.core.dao;

import com.ysz.ec.msg.core.entity.Msg; /**
 * <B>描述：</B><br/> <B>作者：</B> carl.yu <br/> <B>时间：</B> 2017/11/29 <br/> <B>版本：</B><br/>
 */
public interface MsgDAO {
  void insert(Msg msg);

  Msg loadByMsgId(String msgId);

  int updateStatus(Long id, int code);
}
