package com.hcy.classroom.exception;

import com.hcy.classroom.result.ApiResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 韩传勇
 * @version 1.0
 */
@ControllerAdvice
public class GlobalExceptionHandler {

//    全局异常处理
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ApiResponse error(Exception e){
        e.printStackTrace();
        return ApiResponse.ofFailed().message("执行全局异常处理");
    }

    //    全局异常处理
    @ResponseBody
    @ExceptionHandler(ClassRoomException.class)
    public ApiResponse classroomError( ClassRoomException e ){
        e.printStackTrace();
        return ApiResponse.ofFailed().message(e.getMessage());
    }

}
