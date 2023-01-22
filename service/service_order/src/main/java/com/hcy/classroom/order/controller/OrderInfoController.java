package com.hcy.classroom.order.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hcy.classroom.model.order.OrderInfo;
import com.hcy.classroom.order.service.OrderInfoService;
import com.hcy.classroom.result.ApiResponse;
import com.hcy.classroom.vo.order.OrderInfoQueryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author 韩传勇
 * @version 1.0
 */
@Api(tags = "订单管理")
@RestController
@RequestMapping(value="/admin/order/orderInfo")
public class OrderInfoController {

    @Resource
    private OrderInfoService orderInfoService;

    @ApiOperation(value = "获取分页列表")
    @GetMapping("{page}/{limit}")
    public ApiResponse index(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,
            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit,
            @ApiParam(name = "orderInfoVo", value = "查询对象", required = false)
                    OrderInfoQueryVo orderInfoQueryVo) {
        Page<OrderInfo> pageParam = new Page<>(page, limit);
        Map<String,Object> map = orderInfoService.findPageOrderInfo(pageParam, orderInfoQueryVo);
        return ApiResponse.ofSuccess(map);
    }
}