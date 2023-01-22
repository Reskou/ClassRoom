package com.hcy.classroom.vod.controller;


import com.hcy.classroom.model.vod.Video;
import com.hcy.classroom.result.ApiResponse;
import com.hcy.classroom.vod.service.VideoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 课程视频 前端控制器
 * </p>
 *
 * @author hcy
 * @since 2022-12-19
 */
@Api(tags = "课程小结（课时）")
@RestController
@RequestMapping(value="/admin/vod/video")
@CrossOrigin
public class VideoController {

    @Resource
    private VideoService videoService;

    @ApiOperation(value = "获取")
    @GetMapping("get/{id}")
    public ApiResponse get(@PathVariable Long id) {
        Video video = videoService.getById(id);
        return ApiResponse.ofSuccess(video);
    }

    @ApiOperation(value = "新增")
    @PostMapping("save")
    public ApiResponse save(@RequestBody Video video) {
        videoService.save(video);
        return ApiResponse.ofSuccess(null);
    }

    @ApiOperation(value = "修改")
    @PutMapping("update")
    public ApiResponse updateById(@RequestBody Video video) {
        videoService.updateById(video);
        return ApiResponse.ofSuccess(null);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("remove/{id}")
    public ApiResponse remove(@PathVariable Long id) {
        videoService.removeById(id);
        return ApiResponse.ofSuccess(null);
    }
}