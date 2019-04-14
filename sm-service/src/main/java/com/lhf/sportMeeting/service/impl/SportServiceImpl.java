package com.lhf.sportMeeting.service.impl;

import com.github.pagehelper.PageInfo;
import com.lhf.sportMeeting.common.std.enums.WebErrCode;
import com.lhf.sportMeeting.common.utils.TimeUtils;
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

    @Override
    public List<SportItem> allSportItems() {
        return sportDao.allSportItems();
    }

    @Override
    public void saveSport(Sport sport) {
        sportDao.merge(sport);
    }

    @Override
    public String delSport(Long sportId) {
        Sport sport = sportDao.querySportById(sportId);
        if (sport==null){
            return WebErrCode.SM_SYS_OPTION_NOT_EXSIT.getMsg();
        }

        Sport del = new Sport();
        del.setId(sportId);
        del.setDeletedAt(TimeUtils.currentTime());
        sportDao.merge(del);
        return WebErrCode.SM_SYS_OP_SUCC.getMsg();
    }

    @Override
    public SportItem querySportItem(Long itemId) {
        return sportDao.querySportItemById(itemId);
    }

    @Override
    public String delSportItem(Long itemId) {
        SportItem sportItem = sportDao.querySportItemById(itemId);
        if (sportItem==null){
            return WebErrCode.SM_SYS_OPTION_NOT_EXSIT.getMsg();
        }

        SportItem del = new SportItem();
        del.setId(itemId);
        del.setDeletedAt(TimeUtils.currentTime());
        sportDao.merge(del);
        return WebErrCode.SM_SYS_OP_SUCC.getMsg();
    }

    @Override
    public String saveItem(SportItem item) {
        if (item.getId()!=null){
            SportItem sportItem = sportDao.querySportItemById(item.getId());
            if (sportItem==null){
                return WebErrCode.SM_SYS_OPTION_NOT_EXSIT.getMsg();
            }
        }

        sportDao.merge(item);
        return WebErrCode.SM_SYS_OP_SUCC.getMsg();
    }
}
