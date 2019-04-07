package com.lhf.sportMeeting.repository.dao;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lhf.sportMeeting.domain.entity.Sport;
import com.lhf.sportMeeting.repository.mapper.SportMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.weekend.Weekend;

@Repository
public class SportDao {

    @Autowired
    private SportMapper sportMapper;

    public PageInfo<Sport> pages(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        Weekend<Sport> weekend = new Weekend<>(Sport.class);
        weekend.weekendCriteria().andIsNull(Sport::getDeletedAt);
        return new PageInfo<>(sportMapper.selectByExample(weekend));
    }
}
