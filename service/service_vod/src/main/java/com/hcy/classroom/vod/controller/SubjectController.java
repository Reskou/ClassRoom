package com.hcy.classroom.vod.controller;

import com.hcy.classroom.model.vod.Subject;
import com.hcy.classroom.result.ApiResponse;
import com.hcy.classroom.vod.service.SubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author 韩传勇
 * @version 1.0
 */
@Api(tags = "课程分类管理")
@RestController
@RequestMapping(value="/admin/vod/subject")
@CrossOrigin
public class SubjectController {

    @Resource
    private SubjectService subjectService;

    //查询下一层课程分类
    //根据parent_id
    @ApiOperation("查询下一层的课程分类")
    @GetMapping("getChildSubject/{id}")
    public ApiResponse getChildSubject(@PathVariable Long id) {
        List<Subject> list = subjectService.findChildSubject(id);
        return ApiResponse.ofSuccess(list);
    }

    @ApiOperation(value="导出")
    @GetMapping(value = "/exportData")
    public void exportData(HttpServletResponse response) {
        subjectService.exportData(response);
    }


    @ApiOperation(value = "导入")
    @PostMapping("importData")
    public ApiResponse importData(MultipartFile file) {
        subjectService.importData(file);
        return ApiResponse.ofSuccess();
    }

}