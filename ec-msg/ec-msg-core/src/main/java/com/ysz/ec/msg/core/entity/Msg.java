package com.ysz.ec.msg.core.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <B>描述：</B><br/> <B>作者：</B> carl.yu <br/> <B>时间：</B> 2017/11/29 <br/> <B>版本：</B><br/>
 */
@Data
@AllArgsConstructor
@Builder
public class Msg implements Serializable {
  public Msg() {
  }

  private Long id;
  //消息id
  private String msgId;

  //消息内容类型
  private Integer msgContentType;
  //消息内容
  private String msgContent;
  //消息主题
  private String topic;
  //消息标签
  private String tag;
  private String consumeQueue;
  //消息发送次数
  private Integer msgSendTimes;
  //消息状态
  private Integer msgStatus;
  private Date gmtCreate;
  private Date gmtUpdate;
}
