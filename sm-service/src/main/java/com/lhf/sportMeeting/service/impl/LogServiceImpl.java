package com.lhf.sportMeeting.service.impl;

import com.lhf.deviceMS.domain.entity.Log;
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
}
