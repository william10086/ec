package com.ysz.ec.msg.core.service.impl;

import com.ysz.ec.common.ext.kafka.KafkaProducerBean;
import com.ysz.ec.msg.api.contants.MsgBizExceptionEnum;
import com.ysz.ec.msg.api.contants.MsgStatusEnum;
import com.ysz.ec.msg.api.dto.PrepareConfirmMsgReq;
import com.ysz.ec.msg.api.exception.MsgBizException;
import com.ysz.ec.msg.core.dao.MsgDAO;
import com.ysz.ec.msg.core.entity.Msg;
import com.ysz.ec.msg.core.service.MsgService;
import com.ysz.ec.msg.core.service.MsgServiceConstants;
import com.ysz.ec.msg.core.utils.MsgConvertUtils;

import lombok.extern.slf4j.Slf4j;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * <B>描述：</B><br/> <B>作者：</B> carl.yu <br/> <B>时间：</B> 2017/11/29 <br/> <B>版本：</B><br/>
 */
@Service
@Slf4j
public class MsgServiceImpl implements MsgService {

  @Resource
  private MsgDAO msgDAO;

  @Resource
  private KafkaProducerBean msgProducer;

  /**
   * 预发送消息，消息状态为 INIT
   */
  @Override
  public void prepare(PrepareConfirmMsgReq req) {
    msgDAO.insert(MsgConvertUtils.toMsgFromPrepareConfirmMsgReq(req));
  }

  /**
   * <pre>
   *   方法说明：
   *    (1) 修改消息为 SENDING状态
   *    (2) 直接发送消息
   * </pre>
   */
  @Override
  public void confirmAndSend(String msgId) {
    Msg msg = msgDAO.loadByMsgId(msgId);
    if (msg == null) {
      throw new MsgBizException(MsgBizExceptionEnum.MSG_IS_NULL);
    }
    if (msgDAO.updateStatus(msg.getId(), MsgStatusEnum.SENDING.getCode()) != 1) {
      throw new MsgBizException(MsgBizExceptionEnum.CONFIRM_MSG_FAIL, msg.toString());
    }
    sendMsg(msg);
  }

  @Override
  public void sendDirectly(String topic, String tag, String value) {
    sendMsg(topic, tag, value);
  }

  /**
   * 直接发送消息给 mq
   *
   * @param msg 消息对象
   * @throws MsgBizException 如果发送失败，抛出异常
   */
  private void sendMsg(Msg msg) throws MsgBizException {
    sendMsg(msg.getTopic(), msg.getTag(), msg.getMsgContent());
  }

  private void sendMsg(String topic, String tag, String value) throws MsgBizException {
    Future<RecordMetadata> metadataFuture = msgProducer.sendAsString(topic, tag, value);
    try {
      metadataFuture.get(MsgServiceConstants.SEND_TIMEOUT_MS, TimeUnit.MILLISECONDS);
    } catch (Exception e) {
      throw new MsgBizException(
          MsgBizExceptionEnum.KAFKA_SEND_FAIL,
          String.format("[topic:%s,tag:%s,value:%s]", topic, tag, value), e);
    }
  }


}
