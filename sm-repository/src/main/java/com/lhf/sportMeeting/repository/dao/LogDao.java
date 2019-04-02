package com.lhf.sportMeeting.repository.dao;

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
}
