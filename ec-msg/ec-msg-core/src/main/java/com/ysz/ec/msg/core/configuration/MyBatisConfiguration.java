package com.ysz.ec.msg.core.configuration;

import com.ysz.ec.common.mybatis.dao.MyBatisDAO;
import com.ysz.ec.common.utils.MyBatisUtils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * <B>描述：</B><br/> <B>作者：</B> carl.yu <br/> <B>时间：</B> 2017/11/20 <br/> <B>版本：</B><br/>
 */
@Configuration
@Profile("!test")
public class MyBatisConfiguration {

  @Resource
  private DataSource dataSource;

  @Bean
  public MyBatisDAO myBatisDAO() throws Exception {
    MyBatisDAO myBatisDAO = new MyBatisDAO();
    myBatisDAO.setSqlSessionFactory(
        MyBatisUtils.createSqlSessionFactory(dataSource,
            "com.ysz.ec.msg.core.entity",
            "classpath:mybatis/mapper/*/*.xml"));
    return myBatisDAO;
  }

  @Bean
  public TransactionTemplate transactionTpl() {
    return createTransactionTemplate(dataSource);
  }


  /**
   * 创建 spring 事务管理器
   *
   * @param dataSource 数据源
   */
  private static TransactionTemplate createTransactionTemplate(DataSource dataSource) {
    DataSourceTransactionManager dsm = new DataSourceTransactionManager(dataSource);
    return new TransactionTemplate(dsm);
  }
}
