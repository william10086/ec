package com.ysz.ec.inventory.core.dao.impl;

import com.ysz.ec.common.mybatis.dao.MyBatisDAO;
import com.ysz.ec.inventory.core.dao.InventoryDAO;
import com.ysz.ec.inventory.core.entity.Inventory;

import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * <B>描述：</B><br/> <B>作者：</B> carl.yu <br/> <B>时间：</B> 2017/11/15 <br/> <B>版本：</B><br/>
 */
@Repository
public class InventoryDAOImpl implements InventoryDAO {

  @Resource
  private MyBatisDAO myBatisDAO;

  private static String buildSqlMapId(String methodName) {
    return "com.ysz.ec.inventory.core.dao.InventoryDAO." + methodName;
  }

  @Override
  public int addInventory(Inventory inventory) {
    return myBatisDAO.insert(buildSqlMapId("addInventory"), inventory);
  }

}
