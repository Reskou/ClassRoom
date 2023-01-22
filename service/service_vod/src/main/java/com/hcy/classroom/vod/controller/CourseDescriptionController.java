package com.hcy.classroom.vod.controller;


import com.hcy.classroom.result.ApiResponse;
import com.hcy.classroom.vo.vod.CourseFormVo;
import com.hcy.classroom.vod.service.CourseService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 课程简介 前端控制器
 * </p>
 *
 * @author hcy
 * @since 2022-12-19
 */
@RestController
@RequestMapping("/vod/course-description")
public class CourseDescriptionController {

    @Resource
    private CourseService courseService;

    //添加课程基本信息
    @ApiOperation(value = "新增")
    @PostMapping("save")
    public ApiResponse save(@RequestBody CourseFormVo courseFormVo) {
        Long courseId = courseService.saveCourseInfo(courseFormVo);
        return ApiResponse.ofSuccess(courseId);
    }

}

