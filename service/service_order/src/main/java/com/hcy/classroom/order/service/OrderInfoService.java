package com.hcy.classroom.order.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hcy.classroom.model.order.OrderInfo;
import com.hcy.classroom.vo.order.OrderInfoQueryVo;

import java.util.Map;

/**
 * @author 韩传勇
 * @version 1.0
 */
public interface OrderInfoService extends IService<OrderInfo> {
    //订单列表
    Map<String,Object> findPageOrderInfo(Page<OrderInfo> pageParam, OrderInfoQueryVo orderInfoQueryVo);
}