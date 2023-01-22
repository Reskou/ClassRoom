package com.hcy.classroom.vod.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hcy.classroom.model.vod.Chapter;
import com.hcy.classroom.vo.vod.ChapterVo;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author hcy
 * @since 2022-12-19
 */
public interface ChapterService extends IService<Chapter> {

    //章节小结列表
    List<ChapterVo> getNestedTreeList(Long courseId);

    void removeChapterByCourseId(Long id);
}
