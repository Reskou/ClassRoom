package com.hcy.classroom.front.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hcy.classroom.dto.UserDto;
import com.hcy.classroom.dto.UserRegisterDto;
import com.hcy.classroom.model.user.UserInfo;

/**
 * @author 韩传勇
 * @version 1.0
 */
public interface UserInfoService extends IService<UserInfo> {
    boolean login(UserDto dto);

    boolean register(UserRegisterDto dto);
}
