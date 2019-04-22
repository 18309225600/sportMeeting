package com.lhf.sportMeeting.service.impl;

import com.github.pagehelper.PageInfo;
import com.lhf.sportMeeting.common.std.enums.WebErrCode;
import com.lhf.sportMeeting.common.utils.SessionUtils;
import com.lhf.sportMeeting.common.utils.TimeUtils;
import com.lhf.sportMeeting.domain.entity.Sport;
import com.lhf.sportMeeting.domain.entity.SportItem;
import com.lhf.sportMeeting.domain.entity.SportItemJoin;
import com.lhf.sportMeeting.domain.entity.User;
import com.lhf.sportMeeting.repository.dao.SportDao;
import com.lhf.sportMeeting.repository.dao.UserDao;
import com.lhf.sportMeeting.service.SportService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class SportServiceImpl implements SportService {

    @Autowired
    private SportDao sportDao;

    @Autowired
    private UserDao userDao;

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

    @Override
    public List<Sport> allSport() {
        return sportDao.allSport();
    }

    @Override
    public String join(Long sportId, Long sportItemId) {
        Sport sport = sportDao.querySportById(sportId);
        if (!(sport!=null&&sport.getSportItems()!=null&&sport.getSportItems().contains(Objects.toString(sportItemId,"0")))){
            return WebErrCode.SM_ACTIVITY_NOT_EXIST.getMsg();
        }

        if (sport.getEndAt().before(TimeUtils.currentTime())){
            return WebErrCode.SM_ACTIVITY_TIME_OVER.getMsg();
        }

        SportItemJoin joined = sportDao.queryJoinByUserAndSportAndItem(SessionUtils.getUserId(),sportId,sportItemId);
        if (joined!=null){
            return WebErrCode.SM_ACTIVITY_ONCE_ONLY.getMsg();
        }

        SportItem sportItem = sportDao.querySportItemById(sportItemId);
        List<SportItemJoin> sportItemJoins = sportDao.queryJoin(sportId,sportItemId);
        if (sportItemJoins.size()>=sportItem.getItemMaxUserNum()){
            return WebErrCode.SM_ACTIVITY_USER_MAX_FULL.getMsg();
        }

        SportItemJoin join = new SportItemJoin();
        join.setUserId(SessionUtils.getUserId());
        join.setUserName(SessionUtils.getUsername());
        join.setSportId(sportId);
        join.setSportName(sport.getName());
        join.setItemId(sportItemId);
        join.setItemName(sportItem.getItemName());
        sportDao.merge(join);
        return WebErrCode.SM_SYS_OP_SUCC.getMsg();
    }

    @Override
    public List<SportItemJoin> querySportItemJoins(Long sportId, Long sportItemId) {
        return sportDao.queryJoin(sportId,sportItemId);
    }

    @Override
    public String score(Long sportId, Long sportItemId, Long userId,Integer score,String realScore) {
        String msg = WebErrCode.SM_SYS_OP_SUCC.getMsg();
        SportItemJoin join = sportDao.queryJoinByUserAndSportAndItem(userId, sportId, sportItemId);
        if (join==null){
            return WebErrCode.SM_ACTIVITY_USER_NOT_JOIN.getMsg();
        }

        if (join.getScore()!=null||StringUtils.isNotBlank(join.getRealScore())){
            return WebErrCode.SM_ACTIVITY_SCORE_WRITE_ONECE_ONLY.getMsg();
        }

        User user = userDao.queryUserById(userId);

        SportItem item = sportDao.querySportItemById(sportItemId);
        if (item.getRecord()==null||item.getRecord()<score){
            item.setRecord(score);
            item.setRealRecord(realScore);
            item.setRecordAt(TimeUtils.currentTime());
            item.setRecordName(user.getUsername());
            item.setRecordSportId(sportId);
            item.setRecordSportName(join.getSportName());
            sportDao.merge(item);
            msg = WebErrCode.SM_RECORED_REFRESH.getMsg();
        }

        join.setScore(score);
        join.setRealScore(realScore);
        sportDao.merge(join);

        return msg;
    }
}
