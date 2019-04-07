package com.lhf.sportMeeting.service.impl;

import com.github.pagehelper.PageInfo;
import com.lhf.sportMeeting.domain.entity.Log;
import com.lhf.sportMeeting.repository.dao.LogDao;
import com.lhf.sportMeeting.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogDao logDao;

    @Override
    public void save(Log log) {
        logDao.merge(log);
    }

    @Override
    public PageInfo<Log> list(Integer pageNo, Integer pageSize) {
        return logDao.list(pageNo,pageSize);
    }
}
