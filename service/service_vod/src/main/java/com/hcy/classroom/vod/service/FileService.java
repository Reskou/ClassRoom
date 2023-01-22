package com.hcy.classroom.vod.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author 韩传勇
 * @version 1.0
 */
public interface FileService {
    String upload(MultipartFile file);
}
