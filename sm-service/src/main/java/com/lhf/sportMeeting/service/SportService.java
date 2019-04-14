package com.lhf.sportMeeting.service;

import com.github.pagehelper.PageInfo;
import com.lhf.sportMeeting.domain.entity.Sport;
import com.lhf.sportMeeting.domain.entity.SportItem;
import com.lhf.sportMeeting.domain.entity.SportItemJoin;

import java.util.List;

public interface SportService {
    PageInfo<Sport> pages(Integer pageNo, Integer pageSize);

    PageInfo<SportItem> itemList(Long sportId, Integer pageNo, Integer pageSize);

    PageInfo<SportItemJoin> joinList(Long sportId,Long itemId, Integer pageNo, Integer pageSize);

    Sport querySportById(Long sportId);

    List<SportItem> querySportItems(Long sportId);

    List<SportItem> allSportItems();

    void saveSport(Sport sport);

    String delSport(Long sportId);

    SportItem querySportItem(Long itemId);

    String delSportItem(Long itemId);

    String saveItem(SportItem item);
}
