package com.hcy.classroom.vod.service;

import com.hcy.classroom.model.vod.Video;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 课程视频 服务类
 * </p>
 *
 * @author hcy
 * @since 2022-12-19
 */
public interface VideoService extends IService<Video> {

    void removeVideoByCourseId(Long id);

    void removeVideoById(Long id);
}
