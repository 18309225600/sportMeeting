package com.lhf.sportMeeting.facade.web;

import com.github.pagehelper.PageInfo;
import com.lhf.sportMeeting.common.std.PageIn;
import com.lhf.sportMeeting.domain.entity.Sport;
import com.lhf.sportMeeting.domain.entity.SportItem;
import com.lhf.sportMeeting.domain.entity.SportItemJoin;
import com.lhf.sportMeeting.service.SportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/sport")
public class SportController {

    @Autowired
    private SportService sportService;


    /**
     *活动列表
     * @param model
     * @param page
     * @return
     */
    @GetMapping("/pages")
    public String pages(Map model, PageIn page){
        PageInfo<Sport> pageInfo = sportService.pages(page.getPageNo(),page.getPageSize());

        model.put("pageNo",page.getPageNo());
        model.put("list",pageInfo);
        return "sport/list";
    }

    /**
     * 比赛项目列表
     * @param model
     * @param sportId
     * @param page
     * @return
     */
    @GetMapping("/items")
    public String itemList(Map model,Long sportId,PageIn page){
        PageInfo<SportItem> pageInfo = sportService.itemList(sportId,page.getPageNo(),page.getPageSize());
        model.put("pageNo",page.getPageNo());
        model.put("list",pageInfo);
        return "sport/itemList";
    }


    /**
     * 报名列表
     * @param model
     * @param sportId
     * @param itemId
     * @param page
     * @return
     */
    @GetMapping("/joinList")
    public String joinList(Map model,Long sportId,Long itemId,PageIn page){
        PageInfo<SportItemJoin> pageInfo = sportService.joinList(sportId,itemId,page.getPageNo(),page.getPageSize());
        model.put("pageNo",page.getPageNo());
        model.put("list",pageInfo);
        return "sport/joinList";
    }


}
