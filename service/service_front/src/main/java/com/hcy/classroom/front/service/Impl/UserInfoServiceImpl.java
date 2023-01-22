package com.hcy.classroom.front.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hcy.classroom.dto.UserDto;
import com.hcy.classroom.dto.UserRegisterDto;
import com.hcy.classroom.enums.ServiceStatus;
import com.hcy.classroom.exception.ClassRoomException;
import com.hcy.classroom.front.mapper.UserInfoMapper;
import com.hcy.classroom.front.service.UserInfoService;
import com.hcy.classroom.model.user.UserInfo;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 韩传勇
 * @version 1.0
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {


    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public boolean login(UserDto dto) {
        System.out.println("数据为: " + dto);
        QueryWrapper<UserInfo> userInfoQueryWrapper = new QueryWrapper<>();
        userInfoQueryWrapper.eq("name",dto.getName());
        UserInfo user = baseMapper.selectOne(userInfoQueryWrapper);
        if(user == null) {
            throw new ClassRoomException(ServiceStatus.UserNotFound);
        }

        if(!user.getPassword().equals(dto.getPassword())){

            throw new ClassRoomException(ServiceStatus.UserPasswordNotMatch);

        }

        return true;
    }

    @Override
    public boolean register(UserRegisterDto dto) {

        if(isExist(dto)){
            UserInfo userInfo = new UserInfo();
            userInfo.setName(dto.getName());
            userInfo.setPassword(dto.getPassword());
            userInfo.setPhone(dto.getTelephone());
            userInfoMapper.insert(userInfo);
            return true;
        }else {
            throw new ClassRoomException(ServiceStatus.UserExist);
        }

    }

    public boolean isExist(UserRegisterDto dto){

        QueryWrapper<UserInfo> userInfoQueryWrapper = new QueryWrapper<>();
        userInfoQueryWrapper.eq("name",dto.getName());
        UserInfo user = userInfoMapper.selectOne(userInfoQueryWrapper);
        if(ObjectUtils.isEmpty(user)){
            return true;
        }

        return false;

    }

}
