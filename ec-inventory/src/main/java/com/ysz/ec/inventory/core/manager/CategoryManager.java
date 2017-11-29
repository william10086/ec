package com.ysz.ec.inventory.core.manager;

import com.ysz.ec.inventory.core.entity.Category;

/**
 * <B>描述：</B><br/> <B>作者：</B> carl.yu <br/> <B>时间：</B> 2017/11/26 <br/> <B>版本：</B><br/>
 */
public interface CategoryManager {

  /**
   * 生成根节点分类
   */
  void addCategory(Category category);

  /**
   * 在pid节点下创建子分类
   *
   * @param category 要增加的新分类
   * @param pid      父节点分类
   */
  void addCategory(Category category, Long pid);
}
