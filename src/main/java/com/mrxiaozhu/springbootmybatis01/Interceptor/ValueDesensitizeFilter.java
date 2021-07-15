package com.mrxiaozhu.springbootmybatis01.Interceptor;

import com.alibaba.fastjson.serializer.ValueFilter;
import com.mrxiaozhu.springbootmybatis01.common.SensitiveTypeEnum;
import com.mrxiaozhu.springbootmybatis01.util.AESEncryptDecryptUtils;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


public class ValueDesensitizeFilter implements ValueFilter {
    public static final ValueDesensitizeFilter instance = new ValueDesensitizeFilter();

    @Override
    public Object process(Object object, String name, Object value) {
        if (isNotString(value) && isNotList(value)) {
            return value;
        }
        //
        try {
            Field field = object.getClass().getDeclaredField(name);
            Desensitization desensitization = field.getAnnotation(Desensitization.class);
            if (desensitization == null) {
                return value;
            }
            SensitiveTypeEnum type = desensitization.type();
            switch (type) {
                case encrypt:
                    return AESEncryptDecryptUtils.encrypt((String)value, null);
                case desensitization:
                    return modifyNumber((String)value);
                case desensitization_list:
                    return "";
                default:
            }
        } catch (NoSuchFieldException e) {
            return value;
        }
        return value;
    }

    private static boolean isNotString(Object value) {
        return null == value || !(value instanceof String) || ((String) value).length() == 0;
    }

    private static boolean isNotList(Object value) {
        return null == value || !(value instanceof List) || ((List) value).size() == 0;
    }

    public static String modifyNumber(String num) {
        if (StringUtils.isEmpty(num)) {
            return "";
        }
        return StringUtils.left(num, 3).concat(StringUtils.removeStart(StringUtils.leftPad(StringUtils.right(num, 4), StringUtils.length(num), "*"), "***"));
    }

    public static String modifyNumbers(String num) {
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

    public static void main(String[] args) {
//        System.out.println(new ArrayList<>() instanceof List);

        String str = "接听人员(Petugas penjawab):GIETA NATALIA PERMATASARI KAISSANAN/,085853575300,接听状态(Status):关机turn off";

        int place1 = str.indexOf("/");
        int place2 = str.indexOf(",");

        System.out.println(modifyNumber(str.substring(place1 + 1, place2)));

        System.out.println(str.replace(str.substring(place1 + 1, place2), modifyNumber(str.substring(place1 + 1, place2))));
    }
}