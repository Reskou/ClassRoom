package com.hcy.classroom.vod.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hcy.classroom.model.vod.CourseDescription;

/**
 * <p>
 * 课程简介 Mapper 接口
 * </p>
 *
 * @author hcy
 * @since 2022-12-19
 */
public interface CourseDescriptionMapper extends BaseMapper<CourseDescription> {

    CourseDescription selectByCourseId(Long id);
}
