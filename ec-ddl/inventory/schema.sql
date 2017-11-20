# 商品表
DROP TABLE IF EXISTS ec_inventory;
CREATE TABLE ec_inventory (
  id           BIGINT PRIMARY KEY AUTO_INCREMENT,
  spu_id       BIGINT,
  supplier_id  BIGINT,
  name         VARCHAR(255) COMMENT '商品名称',
  description  VARCHAR(255) COMMENT '商品描述',
  count        INT(11) COMMENT '商品数量',
  market_price DECIMAL COMMENT '市场价格',
  sale_price   DECIMAL COMMENT '销售价格',
  onsale_time  TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '上架时间',
  offsale_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '下架时间',
  pic          VARCHAR(255) COMMENT '商品图片',
  status       INTEGER COMMENT '商品状态',
  gmt_update   TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '创建时间',
  gmt_create   TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '修改时间'
);
