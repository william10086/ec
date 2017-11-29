package com.ysz.ec.inventory.core.manager.impl;

import com.ysz.ec.inventory.core.dao.CategoryDAO;
import com.ysz.ec.inventory.core.entity.Category;
import com.ysz.ec.inventory.core.manager.CategoryManager;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <B>描述：</B><br/> <B>作者：</B> carl.yu <br/> <B>时间：</B> 2017/11/26 <br/> <B>版本：</B><br/>
 */
@Service
public class CategoryManagerImpl implements CategoryManager {

  @Resource
  private CategoryDAO categoryDAO;

  @Override
  public void addCategory(Category category) {
    categoryDAO.addCategory(category);
  }

  @Override
  public void addCategory(Category category, Long pid) {
  }
}
