package com.ysz.ec.inventory.core.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <B>描述：</B><br/> <B>作者：</B> carl.yu <br/> <B>时间：</B> 2017/11/15 <br/> <B>版本：</B><br/>
 */
@Data
@Builder
@AllArgsConstructor
public class Inventory implements Serializable {

  private Long id;
  // spuId
  private Long spuId;
  // 供应商
  private Long supplierId;
  // 商品名称
  private String name;
  // 商品描述
  private String description;
  // 商品数量
  private Integer count;
  // 市场价格
  private BigDecimal marketPrice;
  // 销售价格
  private BigDecimal salePrice;
  // 上架时间
  private Date onSaleTime;
  // 下架时间
  private Date offSaleTime;
  // 商品图片链接
  private String pic;
  // 商品状态
  private Integer status;

  private Date gmtUpdate;
  private Date gmtCreate;

  public Inventory() {
  }
}
