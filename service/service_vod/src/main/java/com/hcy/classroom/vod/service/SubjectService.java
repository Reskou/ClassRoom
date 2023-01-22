package com.hcy.classroom.vod.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hcy.classroom.model.vod.Subject;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author 韩传勇
 * @version 1.0
 */
public interface SubjectService extends IService<Subject> {

    //查询下一层课程分类
    List<Subject> findChildSubject(Long id);


    /**
     * 导出
     * @param response
     */
    void exportData(HttpServletResponse response);

    public void importData(MultipartFile file);

}
