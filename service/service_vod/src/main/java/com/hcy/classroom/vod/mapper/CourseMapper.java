package com.hcy.classroom.vod.mapper;

import com.hcy.classroom.model.vod.Course;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hcy.classroom.vo.vod.CoursePublishVo;

/**
 * <p>
 * 课程 Mapper 接口
 * </p>
 *
 * @author hcy
 * @since 2022-12-19
 */
public interface CourseMapper extends BaseMapper<Course> {

    //根据id获取课程发布信息
    CoursePublishVo selectCoursePublishVoById(Long id);
}
