package com.lhf.sportMeeting.repository.dao;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lhf.sportMeeting.common.utils.TimeUtils;
import com.lhf.sportMeeting.domain.entity.Sport;
import com.lhf.sportMeeting.domain.entity.SportItem;
import com.lhf.sportMeeting.domain.entity.SportItemJoin;
import com.lhf.sportMeeting.repository.mapper.SportItemJoinMapper;
import com.lhf.sportMeeting.repository.mapper.SportItemMapper;
import com.lhf.sportMeeting.repository.mapper.SportMapper;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import java.util.*;

@Repository
public class SportDao {

    @Autowired
    private SportMapper sportMapper;

    @Autowired
    private SportItemMapper sportItemMapper;

    @Autowired
    private SportItemJoinMapper sportItemJoinMapper;

    public PageInfo<Sport> pages(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        Weekend<Sport> weekend = new Weekend<>(Sport.class);
        weekend.setOrderByClause("created_at desc");
        weekend.weekendCriteria().andIsNull(Sport::getDeletedAt);
        return new PageInfo<>(sportMapper.selectByExample(weekend));
    }

    public PageInfo<SportItem> itemList(Long sportId, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        Weekend<SportItem> weekend = new Weekend<>(SportItem.class);
        weekend.setOrderByClause("created_at desc,id desc");
        WeekendCriteria<SportItem, Object> criteria = weekend.weekendCriteria();
        criteria.andIsNull(SportItem::getDeletedAt);
        if (sportId!=null){
            Sport sport = querySportById(sportId);
            String sportItems = sport.getSportItems();
            if (StringUtils.isNotBlank(sportItems)){
                String[] itemIdArr = sportItems.split(",");
                List<Long> itemIds = new ArrayList<>();

                for (String itemId:itemIdArr){
                    itemIds.add(Long.valueOf(itemId));
                }

                if (CollectionUtils.isNotEmpty(itemIds)){
                    criteria.andIn(SportItem::getId,itemIds);
                }
            }
        }
        return new PageInfo<>(sportItemMapper.selectByExample(weekend));
    }

    public Sport querySportById(Long sportId) {
        return sportMapper.selectByPrimaryKey(sportId);
    }

    public PageInfo<SportItemJoin> joinList(Long sportId,Long itemId, Integer pageNo, Integer pageSize) {
        if (sportId==null||itemId==null){
            return new PageInfo<>(Collections.emptyList());
        }

        PageHelper.startPage(pageNo,pageSize);

        Weekend<SportItemJoin> weekend = new Weekend<>(SportItemJoin.class);
        weekend.weekendCriteria().andIsNull(SportItemJoin::getDeletedAt).andEqualTo(SportItemJoin::getSportId,sportId).andEqualTo(SportItemJoin::getItemId,itemId);
        return new PageInfo<>(sportItemJoinMapper.selectByExample(weekend));
    }

    public List<SportItem> querySportItemBySportId(Long sportId) {
        Weekend<SportItem> weekend = new Weekend<>(SportItem.class);
        WeekendCriteria<SportItem, Object> criteria = weekend.weekendCriteria();
        criteria.andIsNull(SportItem::getDeletedAt);
        if (sportId!=null){
            Sport sport = querySportById(sportId);
            String sportItems = sport.getSportItems();
            if (StringUtils.isNotBlank(sportItems)){
                String[] itemIdArr = sportItems.split(",");
                List<Long> itemIds = new ArrayList<>();

                for (String itemId:itemIdArr){
                    itemIds.add(Long.valueOf(itemId));
                }

                if (CollectionUtils.isNotEmpty(itemIds)){
                    criteria.andIn(SportItem::getId,itemIds);
                }
            }
        }
        return sportItemMapper.selectByExample(weekend);
    }

    public List<SportItem> allSportItems() {
        Weekend<SportItem> weekend = new Weekend<>(SportItem.class);
        weekend.weekendCriteria().andIsNull(SportItem::getDeletedAt);
        return sportItemMapper.selectByExample(weekend);
    }

    public void merge(Sport sport) {
        if (sport.getId()==null){
            sport.setCreatedAt(TimeUtils.currentTime());
            sportMapper.insertSelective(sport);
        }else{
            sportMapper.updateByPrimaryKeySelective(sport);
        }
    }

    public SportItem querySportItemById(Long itemId) {
        Objects.requireNonNull(itemId);
        SportItem sportItem = sportItemMapper.selectByPrimaryKey(itemId);
        if (sportItem!=null&&sportItem.getDeletedAt()==null){
            return sportItem;
        }
        return null;
    }

    public void merge(SportItem sportItem) {
        Objects.requireNonNull(sportItem);

        if (sportItem.getId()==null){
            sportItem.setCreatedAt(TimeUtils.currentTime());
            sportItemMapper.insertSelective(sportItem);
        }else{
            sportItemMapper.updateByPrimaryKeySelective(sportItem);
        }
    }
}
