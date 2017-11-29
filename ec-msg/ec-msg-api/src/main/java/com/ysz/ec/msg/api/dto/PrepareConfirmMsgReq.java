package com.ysz.ec.msg.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

import java.io.Serializable;

/**
 * <B>描述：</B><br/> <B>作者：</B> carl.yu <br/> <B>时间：</B> 2017/11/29 <br/> <B>版本：</B><br/>
 */
@Data
@AllArgsConstructor
@Builder
public class PrepareConfirmMsgReq implements Serializable {
  public PrepareConfirmMsgReq() {
  }

  /***
   * 消息逻辑Id
   */
  @NotNull(message = "消息Id不能为空")
  @Length(message = "消息Id长度<55", max = 55)
  private String msgId;

  /**
   * 消息内容类型
   */
  private Integer msgContentType;
  /**
   * 消息内容
   */
  @NotNull(message = "消息内容不能为空")
  private String msgContent;

  /**
   * 消息主题
   */
  @NotEmpty(message = "消息主题不能为空")
  private String topic;

  /**
   * 消息标签
   */
  @NotEmpty(message = "消息tag不能为空")
  private String tag;
  
}
