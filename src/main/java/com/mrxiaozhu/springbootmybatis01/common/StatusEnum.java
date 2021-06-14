package com.mrxiaozhu.springbootmybatis01.common;

public enum StatusEnum {
    phone,
    idNumber;

    public static StatusEnum valueCode(String value){
        for (StatusEnum statusEnum : values()) {
            if (statusEnum.name().toLowerCase().equals(value.toLowerCase())) {
                return statusEnum;
            }
        }
        return null;
    }
}
