package com.mrxiaozhu.springbootmybatis01.common;

public enum SensitiveTypeEnum {
    desensitization,
    encrypt;

    public static SensitiveTypeEnum valueCode(String value){
        for (SensitiveTypeEnum sensitiveTypeEnum : values()) {
            if (sensitiveTypeEnum.name().toLowerCase().equals(value.toLowerCase())) {
                return sensitiveTypeEnum;
            }
        }
        return null;
    }
}
