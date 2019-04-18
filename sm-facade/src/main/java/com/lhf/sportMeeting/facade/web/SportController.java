package com.lhf.sportMeeting.facade.web;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.lhf.sportMeeting.common.std.PageIn;
import com.lhf.sportMeeting.common.std.enums.WebErrCode;
import com.lhf.sportMeeting.domain.entity.Sport;
import com.lhf.sportMeeting.domain.entity.SportItem;
import com.lhf.sportMeeting.domain.entity.SportItemJoin;
import com.lhf.sportMeeting.facade.config.oplog.annotations.OpLog;
import com.lhf.sportMeeting.facade.data.input.SportInputDto;
import com.lhf.sportMeeting.facade.data.input.SportItemInputDto;
import com.lhf.sportMeeting.facade.data.input.SportJoinInputDto;
import com.lhf.sportMeeting.facade.data.input.SportScoreInputDto;
import com.lhf.sportMeeting.service.SportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/sport")
public class SportController {

    @Autowired
    private SportService sportService;

    private Logger logger = LoggerFactory.getLogger(SportController.class);


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
     * 添加或编辑活动页面
     * @return
     */
    @GetMapping("/addSport")
    public String sportAddPage(Map model,Long sportId){
        Sport sport = null;
        if (sportId!=null){
            sport = sportService.querySportById(sportId);
        }
        //检索出所有的item
        List<SportItem> sportItems = sportService.querySportItems(null);

        model.put("sport",sport);
        model.put("sportItems",sportItems);
        return "sport/addSportPage";
    }

    /**
     * 保存活动
     * @param input
     * @return
     */
    @ResponseBody
    @PostMapping("/saveSport")
    public String saveSport(@RequestBody SportInputDto input){
        logger.info("save param ={}", JSONObject.toJSONString(input));
        Sport sport = input.transform();
        sportService.saveSport(sport);
        return WebErrCode.SM_SYS_OP_SUCC.getMsg();
    }

    /**
     * 删除活动
     * @param sportId
     * @return
     */
    @GetMapping("/{sportId}/delSport")
    @ResponseBody
    public String delSport(@PathVariable("sportId")Long sportId){
        String msg = sportService.delSport(sportId);
        return msg;
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
     * 添加比赛项目页面
     * @return
     */
    @GetMapping("/itemOpPage")
    public String itemOpPage(Long itemId,Map model){
        if (itemId!=null){
            SportItem item = sportService.querySportItem(itemId);
            model.put("item",item);
        }
        return "sport/itemOpPage";
    }

    /**
     * 删除项目
     * @param itemId
     * @return
     */
    @GetMapping("/{itemId}/delSportItem")
    @ResponseBody
    public String delSportItem(@PathVariable("itemId")Long itemId){
        String msg = sportService.delSportItem(itemId);
        return msg;
    }


    /**
     * 保存运动项目
     * @param input
     * @return
     */
    @ResponseBody
    @PostMapping("/saveItem")
    public String saveItem(@RequestBody SportItemInputDto input){
        SportItem item = input.transform();
        String msg = sportService.saveItem(item);
        return msg;
    }

    /**
     * 报名页
     * @param model
     * @return
     */
    @GetMapping("/joinPage")
    public String joinPage(Map model){
        //查询出活动列表
        List<Sport> sports = sportService.allSport();
        model.put("sports",sports);
        return "sport/joinPage";
    }

    /**
     * 获取某个sport下的所有sportItem
     * @param sportId
     * @return
     */
    @ResponseBody
    @GetMapping("/{sportId}/sportItems")
    public List<SportItem> getSportItem(@PathVariable("sportId")Long sportId){
        return sportService.querySportItems(sportId);
    }

    /**
     * 报名
     * @param input
     * @return
     */
    @ResponseBody
    @PostMapping("/join")
    @OpLog("运动会报名")
    public String join(@RequestBody SportJoinInputDto input){
        String msg = sportService.join(input.getSportId(),input.getSportItemId());
        return msg;
    }

    /**
     * 录入分数页面
     * @return
     */
    @GetMapping("/scorePage")
    public String scorePage(Map model){
        //查询出活动列表
        List<Sport> sports = sportService.allSport();
        model.put("sports",sports);
        return "sport/scorePage";
    }

    /**
     * 根据运动id，比赛id获取报名信息
     * @param sportId
     * @param sportItemId
     * @return
     */
    @ResponseBody
    @GetMapping("/sportItemUsers")
    public List<SportItemJoin> takeSportItemUsers(Long sportId,Long sportItemId){
        List<SportItemJoin> joins = sportService.querySportItemJoins(sportId,sportItemId);
        return joins;
    }

    /**
     * 录入分数
     * @param input
     * @return
     */
    @OpLog("录入分数")
    @ResponseBody
    @PostMapping("/score")
    public String score(@RequestBody SportScoreInputDto input){
        String msg = sportService.score(input.getSportId(),input.getSportItemId(),input.getUserId(),input.getScore(),input.getRealScore());
        return msg;
    }

    /**
     * 报名列表
     * @param model
     * @param sportId
     * @param sportItemId
     * @param page
     * @return
     */
    @GetMapping("/joinList")
    public String joinList(Map model,Long sportId,Long sportItemId,PageIn page){
        PageInfo<SportItemJoin> pageInfo = sportService.joinList(sportId,sportItemId,page.getPageNo(),page.getPageSize());
        model.put("pageNo",page.getPageNo());
        model.put("list",pageInfo);
        return "sport/joinList";
    }


}
