package com.ysz.ec.msg.core.dao.impl;

import com.ysz.ec.common.mybatis.dao.MyBatisDAO;
import com.ysz.ec.msg.core.dao.MsgDAO;
import com.ysz.ec.msg.core.entity.Msg;

import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

import java.util.HashMap;
import java.util.Map;

/**
 * <B>描述：</B><br/> <B>作者：</B> carl.yu <br/> <B>时间：</B> 2017/11/29 <br/> <B>版本：</B><br/>
 */
@Repository
public class MsgDAOImpl implements MsgDAO {

  private static final String NAMESPACE = "com.ysz.ec.msg.core.dao.MsgDAO.";

  @Resource
  private MyBatisDAO myBatisDAO;

  @Override
  public void insert(Msg msg) {
    myBatisDAO.insert(NAMESPACE + "MsgDAO", msg);
  }

  @Override
  public Msg loadByMsgId(String msgId) {
    return myBatisDAO.selectOne(NAMESPACE + "loadByMsgId", msgId);
  }

  @Override
  public int updateStatus(Long id, int status) {
    Map<String, Object> param = new HashMap<>(2);
    param.put("id", id);
    param.put("status", status);
    return myBatisDAO.update(NAMESPACE + "updateStatus", param);
  }
}
