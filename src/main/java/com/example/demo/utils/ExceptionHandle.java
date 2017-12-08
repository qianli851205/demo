package com.example.demo.utils;

import com.example.demo.entity.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
@ControllerAdvice
public class ExceptionHandle {
    private final static Logger logger= LoggerFactory.getLogger(ExceptionHandle.class);
    @ExceptionHandler(value=Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if(e instanceof  ResultException){
            ResultException resultException=(ResultException)e;
            return ResultUtil.error(resultException.getCode(),resultException.getMessage());
        }else{
            logger.error("【系统异常】{}",e);
            return ResultUtil.error(ResultEnum.UNKONW_ERROR.getCode(),ResultEnum.UNKONW_ERROR.getMsg());
        }
    }
}
