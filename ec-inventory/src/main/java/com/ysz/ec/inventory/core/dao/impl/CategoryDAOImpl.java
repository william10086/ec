package com.ysz.ec.inventory.core.dao.impl;

import com.ysz.ec.common.mybatis.dao.MyBatisDAO;
import com.ysz.ec.inventory.core.dao.CategoryDAO;
import com.ysz.ec.inventory.core.entity.Category;

import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * <B>描述：</B><br/> <B>作者：</B> carl.yu <br/> <B>时间：</B> 2017/11/26 <br/> <B>版本：</B><br/>
 */
@Repository
public class CategoryDAOImpl implements CategoryDAO {

  @Resource
  private MyBatisDAO myBatisDAO;

  private static String buildMapId(String methodName) {
    return "com.ysz.ec.inventory.core.dao.CategoryDAO." + methodName;
  }

  @Override
  public int addCategory(Category category) {
    return myBatisDAO.insert(buildMapId("addCategory"), category);
  }
}
