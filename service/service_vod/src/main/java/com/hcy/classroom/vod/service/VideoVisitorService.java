package com.hcy.classroom.vod.service;

import java.util.Map;

/**
 * @author 韩传勇
 * @version 1.0
 */
public interface VideoVisitorService {
    Map<String, Object> findCount(Long courseId, String startDate, String endDate);
}
