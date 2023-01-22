package com.hcy.classroom.vod.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hcy.classroom.model.vod.VideoVisitor;
import com.hcy.classroom.vo.vod.VideoVisitorCountVo;

import java.util.List;

/**
 * @author 韩传勇
 * @version 1.0
 */
public interface VideoVisitorMapper extends BaseMapper<VideoVisitor> {
    List<VideoVisitorCountVo> findCount(Long courseId, String startDate, String endDate);

}
