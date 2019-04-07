package com.lhf.sportMeeting.facade.web;


import com.lhf.sportMeeting.common.std.WebException;
import com.lhf.sportMeeting.domain.entity.User;
import com.lhf.sportMeeting.facade.data.input.UserRegistInputDto;
import com.lhf.sportMeeting.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/page")
    public String page(){
        return  "login/signin";
    }

    /**
     * 登录
     * @param model
     * @param request
     * @param email
     * @param password
     * @return
     * @throws WebException
     */
    @PostMapping("/login")
    public String login(Map model,HttpServletRequest request,String email,String password)throws WebException{
        String message=userService.login(request,email,password);
        if(StringUtils.isBlank(message)){
            return "index";
        }else{
            model.put("msg",message);
            return  "login/signin";
        }
    }

    @GetMapping("regist")
    public String regist(){
        return "regist/signup";
    }


    @PostMapping("/regist")
    public String regist(UserRegistInputDto input, Map model) throws WebException {
        User inputUser = input.verify().transform();
        userService.regist(inputUser);
        model.put("msg","regist succ");
        return "login/signin";
    }

    /**
     * 用户退出
     * @param request
     * @return
     */
    @GetMapping("exit")
    public String exit(HttpServletRequest request){
        HttpSession session=request.getSession();
        if(session!=null){
            session.invalidate();
        }
        return "login/signin";
    }
}
