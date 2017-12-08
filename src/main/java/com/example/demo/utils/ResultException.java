package com.example.demo.utils;

public class ResultException extends  RuntimeException {
    private Integer code;

    public ResultException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }
}
