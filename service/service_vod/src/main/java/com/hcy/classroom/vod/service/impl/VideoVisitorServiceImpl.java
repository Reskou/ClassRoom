package com.hcy.classroom.vod.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hcy.classroom.model.vod.VideoVisitor;
import com.hcy.classroom.vo.vod.VideoVisitorCountVo;
import com.hcy.classroom.vod.mapper.VideoVisitorMapper;
import com.hcy.classroom.vod.service.VideoVisitorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author 韩传勇
 * @version 1.0
 */
@Service
public class VideoVisitorServiceImpl extends ServiceImpl<VideoVisitorMapper, VideoVisitor> implements VideoVisitorService {


    //课程统计的接口
    @Override
    public Map<String, Object> findCount(Long courseId, String startDate, String endDate) {
        //调用mapper的方法
        List<VideoVisitorCountVo> videoVisitorVoList =
                baseMapper.findCount(courseId,startDate,endDate);
        //创建map集合
        Map<String, Object> map = new HashMap<>();
        //创建两个list集合，一个代表所有日期，一个代表日期对应数量
        //封装数据  代表所有日期
        List<Date> dateList =
                videoVisitorVoList.stream().map(VideoVisitorCountVo::getJoinTime).
                        collect(Collectors.toList());
        //代表日期对应数量
        List<Integer> countList = videoVisitorVoList.stream().map(VideoVisitorCountVo::getUserCount)
                .collect(Collectors.toList());
        //放到map集合
        map.put("xData", dateList);
        map.put("yData", countList);
        return map;
    }
}
