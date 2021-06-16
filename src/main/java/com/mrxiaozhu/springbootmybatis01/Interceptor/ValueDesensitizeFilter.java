package com.mrxiaozhu.springbootmybatis01.Interceptor;

import com.alibaba.fastjson.serializer.ValueFilter;
import com.mrxiaozhu.springbootmybatis01.common.SensitiveTypeEnum;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;


public class ValueDesensitizeFilter implements ValueFilter {
    public static final ValueDesensitizeFilter instance = new ValueDesensitizeFilter();

    @Override
    public Object process(Object object, String name, Object value) {
        if (null == value || !(value instanceof String) || ((String) value).length() == 0) {
            return value;
        }
        try {
            Field field = object.getClass().getDeclaredField(name);
            Desensitization desensitization;
            if (String.class != field.getType() || (desensitization = field.getAnnotation(Desensitization.class)) == null) {
                return value;
            }
            String valueStr = (String) value;
            SensitiveTypeEnum type = desensitization.type();
            switch (type) {
                case encrypt:
                    return encryptNumber(valueStr);
                case desensitization:
                    return modifyNumber(valueStr);
                default:
            }
        } catch (NoSuchFieldException e) {
            return value;
        }
        return value;
    }

    public static String modifyNumber(String num) {
        if (StringUtils.isEmpty(num)) {
            return "";
        }
        return StringUtils.left(num, 3).concat(StringUtils.removeStart(StringUtils.leftPad(StringUtils.right(num, 4), StringUtils.length(num), "*"), "***"));
    }

    public static String encryptNumber(String num) {
        if (StringUtils.isEmpty(num)) {
            return "";
        }
        return StringUtils.left(num, 3).concat(StringUtils.removeStart(StringUtils.leftPad(StringUtils.right(num, 4), StringUtils.length(num), "*"), "***"));
    }
}