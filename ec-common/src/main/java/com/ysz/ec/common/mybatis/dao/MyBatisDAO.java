package com.ysz.ec.common.mybatis.dao;


import com.ysz.ec.common.exception.DaoException;

import lombok.extern.slf4j.Slf4j;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.helpers.MessageFormatter;

/**
 * <B>描述：</B><br/> <B>作者：</B> carl.yu <br/> <B>时间：</B> 2017/11/20 <br/> <B>版本：</B><br/>
 */
@Slf4j
public class MyBatisDAO extends SqlSessionDaoSupport {

  public MyBatisDAO() {
  }


  public int insert(final String sqlMapId, final Object param) {
    try {
      return (Integer) execute(sqlSession -> sqlSession.insert(sqlMapId, param));
    } catch (Exception e) {
      log.error(MessageFormatter.arrayFormat("failed to execute sql:{},param:{}",
          new Object[]{sqlMapId, param}).getMessage(), e);
      throw wrap(e);
    }
  }

  public int update(final String sqlMapId, final Object param) {
    try {
      return (Integer) execute(sqlSession -> sqlSession.update(sqlMapId, param));
    } catch (Exception e) {
      log.error(MessageFormatter.arrayFormat("failed to execute sql:{},param:{}",
          new Object[]{sqlMapId, param}).getMessage(), e);
      throw wrap(e);
    }
  }

  public <E> E selectOne(final String sqlMapId, final Object param) {
    try {
      Object result = execute(sqlSession -> sqlSession.selectOne(sqlMapId, param));
      return (E) result;
    } catch (Exception e) {
      log.error(MessageFormatter.arrayFormat("failed to execute sql:{},param:{}",
          new Object[]{sqlMapId, param}).getMessage(), e);
      throw wrap(e);
    }

  }

  /**
   * 执行 MyBatis的回调
   */
  private Object execute(final SqlSessionCallback callback) {
    return callback.doInSession(getSqlSession());
  }

  private DaoException wrap(Exception e) {
    if (e instanceof DaoException) {
      return (DaoException) e;
    } else {
      return new DaoException(e);
    }
  }


  public interface SqlSessionCallback {
    /**
     * 在回调中调用 mybatis 的 session，返回结果
     */
    Object doInSession(SqlSession session);
  }

}
