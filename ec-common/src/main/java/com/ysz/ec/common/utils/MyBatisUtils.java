package com.ysz.ec.common.utils;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * <B>描述：</B><br/> <B>作者：</B> carl.yu <br/> <B>时间：</B> 2017/11/30 <br/> <B>版本：</B><br/>
 */
public class MyBatisUtils {
  /**
   * 创建 mybatis 的 template
   *
   * @param datasource     数据源
   * @param aliasPackage   entity别名源路径
   * @param mapperResource mapper路径
   */
  public static SqlSessionFactory createSqlSessionFactory(
      DataSource datasource,
      String aliasPackage,
      String mapperResource)
      throws Exception {
    SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
    sessionFactory.setDataSource(datasource);
    sessionFactory.setTypeAliasesPackage(aliasPackage);
    PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
    org.springframework.core.io.Resource[] resources = resolver.getResources(mapperResource);
    sessionFactory.setMapperLocations(resources);
    return sessionFactory.getObject();
  }
}
