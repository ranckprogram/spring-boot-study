package com.ranck.study.handle;

import com.ranck.study.controller.StudentController;
import com.ranck.study.domain.Result;
import com.ranck.study.exception.UserException;
import com.ranck.study.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
public class ExceptionHandle {
    private static Logger logger = LoggerFactory.getLogger(StudentController.class);

    @ExceptionHandler(value = UserException.class)
    @ResponseBody
    public Result handle(UserException e) {
        if (e instanceof UserException) {
            return ResultUtil.error(e.getCode(), e.getMessage());
        } else {
            logger.error("【系统异常】={}", e);
            return ResultUtil.error(-1, "系统错误");
        }
    }
}
