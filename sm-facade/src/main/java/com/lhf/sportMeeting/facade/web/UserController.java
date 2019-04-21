package com.lhf.sportMeeting.facade.web;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.lhf.sportMeeting.common.std.PageIn;
import com.lhf.sportMeeting.domain.entity.User;
import com.lhf.sportMeeting.facade.config.oplog.annotations.OpLog;
import com.lhf.sportMeeting.facade.data.input.UserRegistInputDto;
import com.lhf.sportMeeting.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @ResponseBody
    @OpLog("编辑个人信息")
    @PostMapping("/edit/{userId}")
    public String edit(HttpServletRequest request, @PathVariable("userId")Long userId, @RequestBody UserRegistInputDto input){
        logger.info("编辑个人信息参数={}", JSONObject.toJSONString(input));
        User inputUser = input.transform();
        String msg = userService.updateUser(userId,inputUser);
        request.getSession().invalidate();
        return msg;
    }

    /**
     * 用户列表
     * @param model
     * @param page
     * @return
     */
    @GetMapping("/list")
    public String list(Map model, PageIn page){
        PageInfo<User> pageInfo = userService.list(page.getPageNo(),page.getPageSize());
        model.put("pageNo",page.getPageNo());
        model.put("list",pageInfo);
        return "user/list";
    }

    /**
     * 更改用户角色
     * @param userId
     * @return
     */
    @OpLog("更改用户角色")
    @GetMapping("/changeRole/{userId}")
    @ResponseBody
    public String changeRole(@PathVariable("userId")Long userId){
        String msg = userService.changeRole(userId);
        return msg;
    }
}
