package com.tal.util;

import com.tal.exception.ParamException;
import org.apache.commons.collections.MapUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.*;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

//功能：校验参数是否合格，分两种情况，一种是参数为一组，另一种为参数为多组即list，所以分别写两个，再写一个调度
public class BeanValidator {
    private static ValidatorFactory validatorFactory= Validation.buildDefaultValidatorFactory();
    public static <T> Map<String,String> validate(T t,Class... groups){
      Validator validator= validatorFactory.getValidator();
//      得到校验结果集
      Set validateResulet=validator.validate(t,groups);
//      遍历校验的set结果集
        if (validateResulet.isEmpty()){
//            如果想new一个新的map、list、set但是以后不会再添加元素，或者仅仅是需要一个空的用来跑例子，使用这样，不分配内存
            return Collections.emptyMap();
        }
        else {
            LinkedHashMap errors=new LinkedHashMap();
            Iterator iterator=validateResulet.iterator();
            while (iterator.hasNext()){
                ConstraintViolation violation=(ConstraintViolation) iterator.next();
                errors.put(violation.getPropertyPath().toString(),violation.getMessage());
            }
            return errors;
        }

    }

    public static Map<String, String> validateList(Collection<?> collection) {
        //先对列表进行校验，此类有校验每个语句等是不是有问题的方法，在这里我们使用是不是空方法
        Preconditions.checkNotNull(collection);
        Iterator iterator = collection.iterator();
        Map errors;

        do {
            if (!iterator.hasNext()) {
                return Collections.emptyMap();
            }
            Object object = iterator.next();
            errors = validate(object, new Class[0]);
        } while (errors.isEmpty());

        return errors;
    }

    public static Map<String, String> validateObject(Object first, Object... objects) {
        if (objects != null && objects.length > 0) {
            return validateList(Lists.asList(first, objects));
        } else {
            return validate(first, new Class[0]);
        }
    }

    public static void check(Object param) throws ParamException {
        Map<String, String> map = BeanValidator.validateObject(param);
        if (MapUtils.isNotEmpty(map)) {
            throw new ParamException(map.toString());
        }
    }


}
