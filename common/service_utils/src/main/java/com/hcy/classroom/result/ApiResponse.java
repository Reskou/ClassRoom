package com.hcy.classroom.result;

import lombok.Data;

import javax.xml.transform.Result;

/**
 * @author 韩传勇
 * @version 1.0
 */
@Data
public class ApiResponse<T> {

    //状态码
    private Integer code;

    //返回状态成功
    private String message;


    //返回数据
    private T data;

    public  ApiResponse(){

    }


//    成功没有数据
    public static<T> ApiResponse<T> ofSuccess(){

        ApiResponse<T> apiResponse = new ApiResponse<>();
        apiResponse.setCode(200);
        apiResponse.setMessage("成功");
        return apiResponse;


    }

//    成功有数据
    public static<T> ApiResponse<T> ofSuccess(T data){

        ApiResponse<T> apiResponse = new ApiResponse<>();
        apiResponse.setCode(200);
        apiResponse.setMessage("成功");

        if(data != null){
            apiResponse.setData(data);
        }

        return apiResponse;


    }


//   成功没有数据
    public static<T> ApiResponse<T> ofFailed(){

        ApiResponse<T> apiResponse = new ApiResponse<>();
        apiResponse.setCode(201);
        apiResponse.setMessage("失败");
        return apiResponse;


    }

//    成功有数据
    public static<T> ApiResponse<T> ofFailed(T data){

        ApiResponse<T> apiResponse = new ApiResponse<>();
        apiResponse.setCode(201);
        apiResponse.setMessage("失败");

        if(data != null){
            apiResponse.setData(data);
        }

        return apiResponse;


    }


    public ApiResponse<T> message(String msg){
        this.setMessage(msg);
        return this;
    }

    public ApiResponse<T> code(Integer code){
        this.setCode(code);
        return this;
    }


    public ApiResponse<T> data(T value){
        this.setData(value);
        return this;
    }


}
