package com.hcy.classroom.vod.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hcy.classroom.model.vod.Teacher;
import com.hcy.classroom.vod.mapper.TeacherMapper;
import com.hcy.classroom.vod.service.TeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author hcy
 * @since 2022-12-12
 */
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {

    @Resource
    private TeacherMapper teacherMapper;


}
