package com.ranck.study.enums;

public enum ResultEnum {
    UNKOWN_ERROR(-1, "未知错误"),
    SUCCESS(0, "成功"),
    PRESCHOOL(100, "你是学前儿童"),
    SCHOOL_STUDENT(101, "你是在校学生"),

    ;


    private Integer code;
    private String message;


    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
