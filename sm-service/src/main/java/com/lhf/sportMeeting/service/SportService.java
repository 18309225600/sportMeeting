package com.lhf.sportMeeting.service;

import com.github.pagehelper.PageInfo;
import com.lhf.sportMeeting.domain.entity.Sport;
import com.lhf.sportMeeting.domain.entity.SportItem;
import com.lhf.sportMeeting.domain.entity.SportItemJoin;

public interface SportService {
    PageInfo<Sport> pages(Integer pageNo, Integer pageSize);

    PageInfo<SportItem> itemList(Long sportId, Integer pageNo, Integer pageSize);

    PageInfo<SportItemJoin> joinList(Long sportId,Long itemId, Integer pageNo, Integer pageSize);
}
