package com.hcy.classroom.vod.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hcy.classroom.model.vod.Video;

import java.io.InputStream;

/**
 * @author 韩传勇
 * @version 1.0
 */
public interface VodService {
    String uploadVideo(InputStream inputStream, String originalFilename);

    void removeVideo(String videoSourceId);
}
