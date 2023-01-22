package com.hcy.classroom.vod.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.hcy.classroom.model.vod.Subject;
import com.hcy.classroom.vo.vod.SubjectEeVo;
import com.hcy.classroom.vod.mapper.SubjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author 韩传勇
 * @version 1.0
 */
@Component
public class SubjectListener extends AnalysisEventListener<SubjectEeVo> {
    @Resource
    private SubjectMapper dictMapper;

    //一行一行读取
    @Override
    public void invoke(SubjectEeVo subjectEeVo, AnalysisContext analysisContext) {
        //调用方法添加数据库
        Subject subject = new Subject();
        BeanUtils.copyProperties(subjectEeVo,subject);
        dictMapper.insert(subject);
    }
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
    }
}