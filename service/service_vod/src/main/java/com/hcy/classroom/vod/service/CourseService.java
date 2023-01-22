package com.hcy.classroom.vod.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hcy.classroom.model.vod.Course;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hcy.classroom.vo.vod.CourseFormVo;
import com.hcy.classroom.vo.vod.CoursePublishVo;
import com.hcy.classroom.vo.vod.CourseQueryVo;

import java.util.Map;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author hcy
 * @since 2022-12-19
 */
public interface CourseService extends IService<Course> {
    //课程列表
    Map<String,Object> findPage(Page<Course> pageParam, CourseQueryVo courseQueryVo);

    public Long saveCourseInfo(CourseFormVo courseFormVo);

    //根据id获取课程信息
    CourseFormVo getCourseFormVoById(Long id);

    //根据id修改课程信息
    void updateCourseById(CourseFormVo courseFormVo);

    //根据id获取课程发布信息
    CoursePublishVo getCoursePublishVo(Long id);

    //根据id发布课程
    boolean publishCourseById(Long id);

    void removeCourseById(Long id);
}