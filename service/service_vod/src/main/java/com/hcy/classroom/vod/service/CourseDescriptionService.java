package com.hcy.classroom.vod.service;

import com.hcy.classroom.model.vod.CourseDescription;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 课程简介 服务类
 * </p>
 *
 * @author hcy
 * @since 2022-12-19
 */
public interface CourseDescriptionService extends IService<CourseDescription> {

    CourseDescription getByCourseId(Long id);
}
