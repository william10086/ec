package com.ysz.ec.common.exception;

/**
 * <B>描述：</B><br/> <B>作者：</B> carl.yu <br/> <B>时间：</B> 2017/11/20 <br/> <B>版本：</B><br/>
 */
public class DaoException extends RuntimeException {
  public DaoException() {
    super();
  }

  public DaoException(String message) {
    super(message);
  }

  public DaoException(String message, Throwable cause) {
    super(message, cause);
  }

  public DaoException(Throwable cause) {
    super(cause);
  }
}
