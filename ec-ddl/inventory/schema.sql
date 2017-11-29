# 商品表
DROP TABLE IF EXISTS ec_inventory;
CREATE TABLE ec_inventory (
  id            BIGINT PRIMARY KEY AUTO_INCREMENT,
  spu_id        BIGINT,
  supplier_id   BIGINT,
  name          VARCHAR(255) COMMENT '商品名称',
  description   VARCHAR(255) COMMENT '商品描述',
  count         INT(11) COMMENT '商品数量',
  market_price  DECIMAL COMMENT '市场价格',
  sale_price    DECIMAL COMMENT '销售价格',
  on_sale_time  TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '上架时间',
  off_sale_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '下架时间',
  pic           VARCHAR(255) COMMENT '商品图片',
  status        INTEGER COMMENT '商品状态',
  gmt_update    TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '创建时间',
  gmt_create    TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '修改时间'
);

CREATE TABLE `category` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `name` varchar(15) NOT NULL DEFAULT '' COMMENT '类目名称',
  `value` varchar(128) NOT NULL DEFAULT '' COMMENT '类目对应值',
  `status` tinyint(11) NOT NULL DEFAULT '1' COMMENT '状态, 0不可用, 1可用',
  `parent_category_id` int(11) NOT NULL DEFAULT '0' COMMENT '父类目id',
  `display_order` int(11) NOT NULL DEFAULT '0' COMMENT '排序',
  `gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最近修改时间',
  `background_img` varchar(128) NOT NULL DEFAULT '' COMMENT '背景图',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=97 DEFAULT CHARSET=utf8 COMMENT='类目表'


CREATE TABLE `spu` (
  `id`           INT(11) UNSIGNED NOT NULL AUTO_INCREMENT
  COMMENT '自增id',
  `name`         VARCHAR(128)     NOT NULL DEFAULT ''
  COMMENT 'spu 名称',
  `main_pic`     VARCHAR(255)     NOT NULL DEFAULT ''
  COMMENT 'spu 主图',
  `pvs`          VARCHAR(2047)    NOT NULL DEFAULT ''
  COMMENT 'spu 属性, 对应属性名和属性值的键值对',
  `operator_id`  INT(11)          NOT NULL DEFAULT '0'
  COMMENT '操作人userid',
  `category_id`  INT(11)          NOT NULL DEFAULT '0'
  COMMENT '类目id',
  `brand_id`     INT(11)          NOT NULL DEFAULT '0'
  COMMENT 'spu 品牌id',
  `extend`       TEXT             NOT NULL
  COMMENT '扩展字段, 以json保存',
  `sold_count`   INT(11)          NOT NULL DEFAULT '0'
  COMMENT '销售总量',
  `wanted_count` INT(11)          NOT NULL DEFAULT '0'
  COMMENT '''想要''总量',
  `status`       TINYINT(11)      NOT NULL DEFAULT '0'
  COMMENT '状态, 0可用, 1不可用',
  `gmt_create`   TIMESTAMP        NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '创建时间',
  `gmt_update`   TIMESTAMP        NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
  COMMENT '最近修改时间',
  `tags`         TEXT COMMENT '标签信息',
  `enlist_count` INT(11)          NOT NULL DEFAULT '1'
  COMMENT '显示inventory个数',
  PRIMARY KEY (`id`),
  UNIQUE KEY `indx_name` (`name`),
  KEY `indx_categoryid` (`category_id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 105727
  DEFAULT CHARSET = utf8
  COMMENT ='spu 表'