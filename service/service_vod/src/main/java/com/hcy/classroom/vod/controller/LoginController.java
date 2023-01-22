package com.hcy.classroom.vod.controller;

import com.hcy.classroom.result.ApiResponse;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 韩传勇
 * @version 1.0
 */
@RestController
@RequestMapping("/admin/vod/user")
@CrossOrigin
public class LoginController {
    /**
     * 登录
     * @return
     */
    @PostMapping("login")
    public ApiResponse login() {
        Map<String, Object> map = new HashMap<>();
        map.put("token","admin");
        return ApiResponse.ofSuccess(map);
    }
    /**
     * 获取用户信息
     * @return
     */
    @GetMapping("info")
    public ApiResponse info() {
        Map<String, Object> map = new HashMap<>();
        map.put("roles","[admin]");
        map.put("name","admin");
        map.put("avatar","https://oss.aliyuncs.com/aliyun_id_photo_bucket/default_handsome.jpg");
        return ApiResponse.ofSuccess(map);
    }
    /**
     * 退出
     * @return
     */
    @PostMapping("logout")
    public ApiResponse logout(){
        return ApiResponse.ofSuccess();
    }
}