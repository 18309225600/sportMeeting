package com.lhf.sportMeeting.repository.dao;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lhf.sportMeeting.common.utils.TimeUtils;
import com.lhf.sportMeeting.domain.entity.Log;
import com.lhf.sportMeeting.repository.mapper.LogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Objects;

@Repository
public class LogDao {

    @Autowired
    private LogMapper logMapper;


    public void merge(Log log) {
        Objects.requireNonNull(log);
        if (log.getId()==null){
            log.setCreatedAt(TimeUtils.currentTime());
            logMapper.insertSelective(log);
        }else{
            logMapper.updateByPrimaryKeySelective(log);
        }
    }

    public PageInfo<Log> list(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        return new PageInfo<>(logMapper.selectAll());
    }
}
