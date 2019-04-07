package com.lhf.sportMeeting.service;

import com.github.pagehelper.PageInfo;
import com.lhf.sportMeeting.domain.entity.Log;

public interface LogService {
    void save(Log log);

    PageInfo<Log> list(Integer pageNo, Integer pageSize);
}
