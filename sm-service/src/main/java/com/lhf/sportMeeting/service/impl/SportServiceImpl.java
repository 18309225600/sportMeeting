package com.lhf.sportMeeting.service.impl;

import com.github.pagehelper.PageInfo;
import com.lhf.sportMeeting.domain.entity.Sport;
import com.lhf.sportMeeting.domain.entity.SportItem;
import com.lhf.sportMeeting.domain.entity.SportItemJoin;
import com.lhf.sportMeeting.repository.dao.SportDao;
import com.lhf.sportMeeting.service.SportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SportServiceImpl implements SportService {

    @Autowired
    private SportDao sportDao;

    @Override
    public PageInfo<Sport> pages(Integer pageNo, Integer pageSize) {
        return sportDao.pages(pageNo,pageSize);
    }

    @Override
    public PageInfo<SportItem> itemList(Long sportId, Integer pageNo, Integer pageSize) {
        return sportDao.itemList(sportId,pageNo,pageSize);
    }

    @Override
    public PageInfo<SportItemJoin> joinList(Long sportId,Long itemId, Integer pageNo, Integer pageSize) {
        return sportDao.joinList(sportId,itemId,pageNo,pageSize);
    }

    @Override
    public Sport querySportById(Long sportId) {
        return sportDao.querySportById(sportId);
    }

    @Override
    public List<SportItem> querySportItems(Long sportId) {
        return sportDao.querySportItemBySportId(sportId);
    }
}
