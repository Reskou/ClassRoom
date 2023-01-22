package com.hcy.classroom.vod.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hcy.classroom.model.vod.Course;
import com.hcy.classroom.result.ApiResponse;
import com.hcy.classroom.vo.vod.CourseFormVo;
import com.hcy.classroom.vo.vod.CoursePublishVo;
import com.hcy.classroom.vo.vod.CourseQueryVo;
import com.hcy.classroom.vod.service.CourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author hcy
 * @since 2022-12-19
 */
@Api(tags = "课程管理接口")
@RestController
@RequestMapping(value="/admin/vod/course")
@CrossOrigin
@Slf4j
public class CourseController {

    @Resource
    private CourseService courseService;


    //添加课程基本信息
    @ApiOperation(value = "新增")
    @PostMapping("save")
    public ApiResponse save(@RequestBody CourseFormVo courseFormVo) {
        Long courseId = courseService.saveCourseInfo(courseFormVo);
        return ApiResponse.ofSuccess(courseId);
    }

    @ApiOperation(value = "获取分页列表")
    @GetMapping("{page}/{limit}")
    public ApiResponse index(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,
            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit,
            @ApiParam(name = "courseVo", value = "查询对象", required = false)
                    CourseQueryVo courseQueryVo) {
        Page<Course> pageParam = new Page<>(page, limit);
        Map<String,Object> map = courseService.findPage(pageParam, courseQueryVo);
        return ApiResponse.ofSuccess(map);
    }


    @ApiOperation(value = "获取")
    @GetMapping("get/{id}")
    public ApiResponse get(@PathVariable Long id) {
        CourseFormVo course = courseService.getCourseFormVoById(id);
        return ApiResponse.ofSuccess(course);
    }

    @ApiOperation(value = "修改")
    @PutMapping("update")
    public ApiResponse updateById(@RequestBody CourseFormVo courseFormVo) {

        courseService.updateCourseById(courseFormVo);
        return ApiResponse.ofSuccess();
    }


    @ApiOperation("根据id获取课程发布信息")
    @GetMapping("getCoursePublishVo/{id}")
    public ApiResponse getCoursePublishVoById(
            @ApiParam(value = "课程ID", required = true)
            @PathVariable Long id){

        CoursePublishVo coursePublishVo = courseService.getCoursePublishVo(id);
        return ApiResponse.ofSuccess(coursePublishVo);
    }

    @ApiOperation("根据id发布课程")
    @PutMapping("publishCourseById/{id}")
    public ApiResponse publishCourseById(
            @ApiParam(value = "课程ID", required = true)
            @PathVariable Long id){

        boolean result = courseService.publishCourseById(id);
        return ApiResponse.ofSuccess();
    }


    @ApiOperation(value = "删除课程")
    @DeleteMapping("remove/{id}")
    public ApiResponse remove(@PathVariable Long id) {
        courseService.removeCourseById(id);
        return ApiResponse.ofSuccess();
    }


}
