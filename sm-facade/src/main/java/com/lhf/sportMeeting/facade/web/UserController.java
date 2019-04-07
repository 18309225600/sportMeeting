package com.lhf.sportMeeting.facade.web;

import com.alibaba.fastjson.JSONObject;
import com.lhf.sportMeeting.domain.entity.User;
import com.lhf.sportMeeting.facade.config.oplog.annotations.OpLog;
import com.lhf.sportMeeting.facade.data.input.UserRegistInputDto;
import com.lhf.sportMeeting.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @ResponseBody
    @OpLog("编辑个人信息")
    @PostMapping("/edit/{userId}")
    public String edit(@PathVariable("userId")Long userId, @RequestBody UserRegistInputDto input){
        logger.info("编辑个人信息参数={}", JSONObject.toJSONString(input));
        User inputUser = input.transform();
        String msg = userService.updateUser(userId,inputUser);
        return msg;
    }
}
