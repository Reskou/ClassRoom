package com.hcy.classroom.vod.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hcy.classroom.model.vod.Course;
import com.hcy.classroom.model.vod.CourseDescription;
import com.hcy.classroom.model.vod.Subject;
import com.hcy.classroom.model.vod.Teacher;
import com.hcy.classroom.vo.vod.CourseFormVo;
import com.hcy.classroom.vo.vod.CoursePublishVo;
import com.hcy.classroom.vo.vod.CourseQueryVo;
import com.hcy.classroom.vod.mapper.CourseMapper;
import com.hcy.classroom.vod.service.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author hcy
 * @since 2022-12-19
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {

    @Resource
    private CourseMapper courseMapper;

    @Resource
    private TeacherService teacherService;

    @Resource
    private SubjectService subjectService;

    @Resource
    private VideoService videoService;

    @Resource
    private ChapterService chapterService;

    @Resource
    private CourseDescriptionService descriptionService;

    //课程列表
    @Override
    public Map<String,Object> findPage(Page<Course> pageParam, CourseQueryVo courseQueryVo) {
        //获取条件值
        String title = courseQueryVo.getTitle();//名称
        Long subjectId = courseQueryVo.getSubjectId();//二级分类
        Long subjectParentId = courseQueryVo.getSubjectParentId();//一级分类
        Long teacherId = courseQueryVo.getTeacherId();//讲师
        //封装条件
        QueryWrapper<Course> wrapper = new QueryWrapper<>();
        if(!StringUtils.isEmpty(title)) {
            wrapper.like("title",title);
        }
        if(!StringUtils.isEmpty(subjectId)) {
            wrapper.eq("subject_id",subjectId);
        }
        if(!StringUtils.isEmpty(subjectParentId)) {
            wrapper.eq("subject_parent_id",subjectParentId);
        }
        if(!StringUtils.isEmpty(teacherId)) {
            wrapper.eq("teacher_id",teacherId);
        }
        //调用方法查询
        Page<Course> pages = baseMapper.selectPage(pageParam, wrapper);
        long totalCount = pages.getTotal();//总记录数
        long totalPage = pages.getPages();//总页数
        long currentPage = pages.getCurrent();//当前页
        long size = pages.getSize();//每页记录数
        //每页数据集合
        List<Course> records = pages.getRecords();
        //遍历封装讲师和分类名称
        records.stream().forEach(item -> {
            this.getTeacherOrSubjectName(item);
        });
        //封装返回数据
        Map<String,Object> map = new HashMap<>();
        map.put("totalCount",totalCount);
        map.put("totalPage",totalPage);
        map.put("records",records);
        return map;
    }

    //获取讲师和分类名称
    private Course getTeacherOrSubjectName(Course course) {
        //查询讲师名称
        Teacher teacher = teacherService.getById(course.getTeacherId());
        if(teacher != null) {
            course.getParam().put("teacherName",teacher.getName());
        }
        //查询分类名称
        Subject subjectOne = subjectService.getById(course.getSubjectParentId());
        if(subjectOne != null) {
            course.getParam().put("subjectParentTitle",subjectOne.getTitle());
        }
        Subject subjectTwo = subjectService.getById(course.getSubjectId());
        if(subjectTwo != null) {
            course.getParam().put("subjectTitle",subjectTwo.getTitle());
        }
        return course;
    }


    //实现方法
//添加课程基本信息
    @Override
    public Long saveCourseInfo(CourseFormVo courseFormVo) {
        //保存课程基本信息
        Course course = new Course();
        BeanUtils.copyProperties(courseFormVo, course);
        baseMapper.insert(course);

        //保存课程详情信息
        CourseDescription courseDescription = new CourseDescription();
        courseDescription.setDescription(courseFormVo.getDescription() != null? courseFormVo.getDescription():"");
        courseDescription.setCourseId(course.getId());
        descriptionService.save(courseDescription);

        //返回课程id
        return course.getId();
    }

    //根据id获取课程信息
    @Override
    public CourseFormVo getCourseFormVoById(Long id) {
        //从course表中取数据
        Course course = baseMapper.selectById(id);
        if(course == null){
            return null;
        }
        //从course_description表中取数据
        CourseDescription courseDescription = descriptionService.getById(id);
        //创建courseInfoForm对象
        CourseFormVo courseFormVo = new CourseFormVo();
        BeanUtils.copyProperties(course, courseFormVo);
        if(courseDescription != null){
            courseFormVo.setDescription(courseDescription.getDescription());
        }
        return courseFormVo;
    }

    //根据id修改课程信息
    @Override
    public void updateCourseById(CourseFormVo courseFormVo) {
        //修改课程基本信息
        Course course = new Course();
        BeanUtils.copyProperties(courseFormVo, course);
        baseMapper.updateById(course);
        //修改课程详情信息
        CourseDescription courseDescription = descriptionService.getByCourseId(course.getId());
        System.out.println("获取的数据为; " + courseDescription);

        if(courseFormVo.getDescription() != null){
            courseDescription.setDescription(courseFormVo.getDescription());
        }
        courseDescription.setCourseId(course.getId());
        descriptionService.updateById(courseDescription);
    }


    //根据id获取课程发布信息
    @Override
    public CoursePublishVo getCoursePublishVo(Long id) {
        CoursePublishVo coursePublishVo = courseMapper.selectCoursePublishVoById(id);
        System.out.println("获取的数据为: " + coursePublishVo);
        return courseMapper.selectCoursePublishVoById(id);
    }

    //根据id发布课程
    @Override
    public boolean publishCourseById(Long id) {
        Course course = new Course();
        course.setId(id);
        course.setPublishTime(new Date());
        course.setStatus(1);
        return this.updateById(course);
    }

    //删除课程
    @Override
    public void removeCourseById(Long id) {
        //根据课程id删除小节
        videoService.removeVideoByCourseId(id);
        //根据课程id删除章节
        chapterService.removeChapterByCourseId(id);
        //根据课程id删除描述
        descriptionService.removeById(id);
        //根据课程id删除课程
        baseMapper.deleteById(id);
    }


}