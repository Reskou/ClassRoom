package com.hcy.classroom.vod.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hcy.classroom.model.vod.CourseDescription;
import com.hcy.classroom.vod.mapper.CourseDescriptionMapper;
import com.hcy.classroom.vod.service.CourseDescriptionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 课程简介 服务实现类
 * </p>
 *
 * @author hcy
 * @since 2022-12-19
 */
@Service
public class CourseDescriptionServiceImpl extends ServiceImpl<CourseDescriptionMapper, CourseDescription> implements CourseDescriptionService {


    @Resource
    private CourseDescriptionMapper courseDescriptionMapper;

    @Override
    public CourseDescription getByCourseId(Long id) {

        return courseDescriptionMapper.selectByCourseId(id);
    }
}
