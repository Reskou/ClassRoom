package com.hcy.classroom.vod.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hcy.classroom.model.vod.Teacher;
import com.hcy.classroom.result.ApiResponse;
import com.hcy.classroom.vo.vod.TeacherQueryVo;
import com.hcy.classroom.vod.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author hcy
 * @since 2022-12-12
 */
@Api(tags = "讲师管理接口")
@RestController
@RequestMapping("/vod/teacher")
@CrossOrigin
public class TeacherController {

    @Resource
    private TeacherService teacherService;


    @ApiOperation("查询所有讲师")
    @GetMapping("findAll")
    public ApiResponse<List<Teacher>> getAllTeacher(){

        return ApiResponse.ofSuccess(teacherService.list());

    }

    @ApiOperation("逻辑删除讲师")
    @DeleteMapping("/remove/{id}")
    public ApiResponse removeById(@PathVariable String id){

        boolean ifSuccess = teacherService.removeById(id);


        if(ifSuccess){
            return ApiResponse.ofSuccess();
        }

        return ApiResponse.ofFailed();
    }

    //条件查询分页列表
    @ApiOperation(value = "获取分页列表")
    @PostMapping("{page}/{limit}")
    public ApiResponse page(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,
            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit,
            @ApiParam(name = "teacherVo", value = "查询对象", required = false)
            @RequestBody(required = false) TeacherQueryVo teacherQueryVo) {
        //创建page对象，传递当前页和每页记录数
        Page<Teacher> pageParam = new Page<>(page, limit);
        //获取条件值
        String name = teacherQueryVo.getName();//讲师名称
        Integer level = teacherQueryVo.getLevel();//讲师级别
        String joinDateBegin = teacherQueryVo.getJoinDateBegin();//开始时间
        String joinDateEnd = teacherQueryVo.getJoinDateEnd();//结束时间
        //封装条件
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        if(!StringUtils.isEmpty(name)) {
            wrapper.like("name",name);
        }
        if(!StringUtils.isEmpty(level)) {
            wrapper.eq("level",level);
        }
        if(!StringUtils.isEmpty(joinDateBegin)) {
            wrapper.ge("join_date",joinDateBegin);
        }
        if(!StringUtils.isEmpty(joinDateEnd)) {
            wrapper.le("join_date",joinDateEnd);
        }
        //调用方法得到分页查询结果
        IPage<Teacher> pageModel = teacherService.page(pageParam, wrapper);
        return ApiResponse.ofSuccess(pageModel);
    }


    @ApiOperation("添加讲师")
    @PostMapping("/saveTeacher")
    public  ApiResponse saveTeacher(@RequestBody Teacher teacher){

        boolean isSave = teacherService.save(teacher);


        if(isSave){
            return ApiResponse.ofSuccess();
        }

        return ApiResponse.ofFailed();
    }

    @ApiOperation("修改讲师")
    @PostMapping("/editTeacher")
    public  ApiResponse editTeacher(@RequestBody Teacher teacher){

        boolean isUpdate = teacherService.updateById(teacher);

        if(isUpdate){
            return ApiResponse.ofSuccess();
        }

        return ApiResponse.ofFailed();
    }

    @ApiOperation("批量删除讲师")
    @DeleteMapping("removeBatch")
    public ApiResponse removeBatch(@RequestBody List<Long> ids){


        boolean isRemove = teacherService.removeByIds(ids);

        if(isRemove){
            return ApiResponse.ofSuccess();
        }

        return ApiResponse.ofFailed();

    }

    @ApiOperation("根据id获取教师")
    @GetMapping("/get/{id}")
    public  ApiResponse getTeacherById(@PathVariable Long id){

        Teacher teacher = teacherService.getById(id);

        if(teacher != null){
            return ApiResponse.ofSuccess(teacher);
        }

        return ApiResponse.ofFailed();
    }




}

