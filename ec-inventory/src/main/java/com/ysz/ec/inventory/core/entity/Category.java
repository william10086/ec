package com.ysz.ec.inventory.core.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <B>描述：</B><br/> <B>作者：</B> carl.yu <br/> <B>时间：</B> 2017/11/26 <br/> <B>版本：</B><br/>
 */
@Data
@Builder
@AllArgsConstructor
public class Category implements Serializable {

  public Category() {
  }

  private Integer id;
  private Integer categoryName;
  private Integer leftId;
  private Integer rightId;
  private Integer display;
  private Date gmtCreate;
  private Date gmtUpdate;
  private String categoryPicUrl;
  private Integer status;
}
