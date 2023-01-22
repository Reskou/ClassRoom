package com.hcy.classroom.front.controller;

import com.hcy.classroom.dto.UserDto;
import com.hcy.classroom.dto.UserRegisterDto;
import com.hcy.classroom.front.service.UserInfoService;
import com.hcy.classroom.model.user.UserInfo;
import com.hcy.classroom.result.ApiResponse;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author 韩传勇
 * @version 1.0
 */
@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Resource
    private UserInfoService userInfoService;

    @PostMapping("/login")
    public ApiResponse Login(@RequestBody UserDto dto){

        return ApiResponse.ofSuccess(userInfoService.login(dto));

    }


    @PostMapping("/register")
    public ApiResponse Register(@RequestBody UserRegisterDto dto){

        System.out.println("获取到的数据为: " + dto  );

        return ApiResponse.ofSuccess(userInfoService.register(dto));

    }

}
