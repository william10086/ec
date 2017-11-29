package com.ysz.ec.common.utils;

import com.ysz.ec.common.exception.ValidateException;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.util.Set;

/**
 * <B>描述：</B><br/> <B>作者：</B> carl.yu <br/> <B>时间：</B> 2017/11/29 <br/> <B>版本：</B><br/>
 */
public class ValidatorUtils {

  private static Validator validator;

  static {
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    validator = factory.getValidator();
  }


  /**
   * 检测实体bean对象, 如果不满足 annotation规范，抛出 {@link ValidateException}
   */
  public static <T> void validateThrow(T t) throws ValidateException {
    Set<ConstraintViolation<T>> violationSet = validator.validate(t);
    if (violationSet != null && violationSet.size() > 0) {
      ConstraintViolation<T> violation = violationSet.iterator().next();
      throw new ValidateException(violation.getMessage());
    }
  }
}
