package com.hcy.classroom.vod.controller;


import com.hcy.classroom.model.vod.Chapter;
import com.hcy.classroom.result.ApiResponse;
import com.hcy.classroom.vo.vod.ChapterVo;
import com.hcy.classroom.vod.service.ChapterService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author hcy
 * @since 2022-12-19
 */
@RestController
@RequestMapping(value="/admin/vod/chapter")
@CrossOrigin
public class ChapterController {

    @Resource
    private ChapterService chapterService;

    //获取章节小结列表
    @ApiOperation("嵌套章节数据列表")
    @GetMapping("getNestedTreeList/{courseId}")
    public ApiResponse getNestedTreeList(
            @ApiParam(value = "课程ID", required = true)
            @PathVariable Long courseId){

        List<ChapterVo> chapterVoList = chapterService.getNestedTreeList(courseId);
        return ApiResponse.ofSuccess(chapterVoList);
    }

    //2 添加章节
    @PostMapping("save")
    public ApiResponse save(@RequestBody Chapter chapter) {
        chapterService.save(chapter);
        return ApiResponse.ofSuccess(null);
    }

    //3 修改-根据id查询
    @GetMapping("get/{id}")
    public ApiResponse get(@PathVariable Long id) {
        Chapter chapter = chapterService.getById(id);
        return ApiResponse.ofSuccess(chapter);
    }

    //4 修改-最终实现
    @PostMapping("update")
    public ApiResponse update(@RequestBody Chapter chapter) {
        chapterService.updateById(chapter);
        return ApiResponse.ofSuccess(null);
    }

    //5 删除章节
    @DeleteMapping("remove/{id}")
    public ApiResponse remove(@PathVariable Long id) {
        chapterService.removeById(id);
        return ApiResponse.ofSuccess(null);
    }
}
