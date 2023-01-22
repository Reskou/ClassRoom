package com.hcy.classroom.vod.controller;

import com.hcy.classroom.result.ApiResponse;
import com.hcy.classroom.vod.service.VideoService;
import com.hcy.classroom.vod.service.VideoVisitorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author 韩传勇
 * @version 1.0
 */
@Api(value = "VideoVisitor管理", tags = "VideoVisitor管理")
@RestController
@RequestMapping(value="/admin/vod/videoVisitor")
@CrossOrigin
public class VideoVisitorController {


    @Resource
    private VideoService videoService;

    @Resource
    private VideoVisitorService videoVisitorService;

    @ApiOperation("显示统计数据")
    @GetMapping("findCount/{courseId}/{startDate}/{endDate}")
    public ApiResponse showChart(
            @ApiParam("开始时间") @PathVariable Long courseId,
            @ApiParam("开始时间") @PathVariable String startDate,
            @ApiParam("结束时间") @PathVariable String endDate){

        Map<String, Object> map = videoVisitorService.findCount(courseId, startDate, endDate);
        return ApiResponse.ofSuccess(map);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("remove/{id}")
    public ApiResponse remove(@PathVariable Long id) {
        videoService.removeVideoById(id);
        return ApiResponse.ofSuccess();
    }
}