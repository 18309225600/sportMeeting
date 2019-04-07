package com.lhf.sportMeeting.service.impl;

import com.github.pagehelper.PageInfo;
import com.lhf.sportMeeting.domain.entity.Sport;
import com.lhf.sportMeeting.repository.dao.SportDao;
import com.lhf.sportMeeting.service.SportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SportServiceImpl implements SportService {

    @Autowired
    private SportDao sportDao;

    @Override
    public PageInfo<Sport> pages(Integer pageNo, Integer pageSize) {
        return sportDao.pages(pageNo,pageSize);
    }
}
