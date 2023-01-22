package com.hcy.classroom.vod.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hcy.classroom.model.vod.Chapter;
import com.hcy.classroom.model.vod.Video;
import com.hcy.classroom.vo.vod.ChapterVo;
import com.hcy.classroom.vo.vod.VideoVo;
import com.hcy.classroom.vod.mapper.ChapterMapper;
import com.hcy.classroom.vod.service.ChapterService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hcy.classroom.vod.service.VideoService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author hcy
 * @since 2022-12-19
 */
@Service
public class ChapterServiceImpl extends ServiceImpl<ChapterMapper, Chapter> implements ChapterService {


    @Resource
    private VideoService videoService;

    //章节小结列表封装
    @Override
    public List<ChapterVo> getNestedTreeList(Long courseId) {
        List<ChapterVo> chapterVoList = new ArrayList<>();

        //获取章信息
        LambdaQueryWrapper<Chapter> queryWrapperChapter = new LambdaQueryWrapper<>();
        queryWrapperChapter.eq(Chapter::getCourseId, courseId);
        queryWrapperChapter.orderByAsc(Chapter::getSort, Chapter::getId);
        List<Chapter> chapterList = baseMapper.selectList(queryWrapperChapter);

        //获取课时信息
        LambdaQueryWrapper<Video> queryWrapperVideo = new LambdaQueryWrapper<>();
        queryWrapperVideo.eq(Video::getCourseId, courseId);
        queryWrapperVideo.orderByAsc(Video::getSort, Video::getId);
        List<Video> videoList = videoService.list(queryWrapperVideo);

        //填充列表数据：Chapter列表
        for (int i = 0; i < chapterList.size(); i++) {
            Chapter chapter = chapterList.get(i);

            //创建ChapterVo对象
            ChapterVo chapterVo = new ChapterVo();
            BeanUtils.copyProperties(chapter, chapterVo);
            chapterVoList.add(chapterVo);

            //填充列表数据：Video列表
            List<VideoVo> videoVoList = new ArrayList<>();
            for (int j = 0; j < videoList.size(); j++) {
                Video video = videoList.get(j);
                if (chapter.getId().equals(video.getChapterId())) {

                    VideoVo videoVo = new VideoVo();
                    BeanUtils.copyProperties(video, videoVo);
                    videoVoList.add(videoVo);
                }
            }
            chapterVo.setChildren(videoVoList);
        }
        return chapterVoList;
    }


    //根据课程id删除章节
    @Override
    public void removeChapterByCourseId(Long id) {
        QueryWrapper<Chapter> wrapper = new QueryWrapper<>();
        wrapper.eq("course_id",id);
        baseMapper.delete(wrapper);
    }


}
