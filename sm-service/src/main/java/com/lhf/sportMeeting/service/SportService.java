package com.lhf.sportMeeting.service;

import com.github.pagehelper.PageInfo;
import com.lhf.sportMeeting.domain.entity.Sport;

public interface SportService {
    PageInfo<Sport> pages(Integer pageNo, Integer pageSize);
}
