package com.lhf.sportMeeting.facade.web;

import com.github.pagehelper.PageInfo;
import com.lhf.sportMeeting.common.std.PageIn;
import com.lhf.sportMeeting.domain.entity.Log;
import com.lhf.sportMeeting.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/log")
public class LogController {

    @Autowired
    private LogService logService;

    /**
     * 操作日志列表
     * @param model
     * @param page
     * @return
     */
    @GetMapping("/list")
    public String list(Map model, PageIn page){
        PageInfo<Log> pageInfo = logService.list(page.getPageNo(),page.getPageSize());
        model.put("pageNo",page.getPageNo());
        model.put("list",pageInfo);
        return "oplog/list";
    }
}
