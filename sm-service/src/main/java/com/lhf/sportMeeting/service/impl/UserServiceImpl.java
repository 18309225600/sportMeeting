package com.lhf.sportMeeting.service.impl;

import com.lhf.sportMeeting.common.std.WebException;
import com.lhf.sportMeeting.common.std.enums.WebErrCode;
import com.lhf.sportMeeting.common.utils.EncryptionUtils;
import com.lhf.sportMeeting.domain.entity.User;
import com.lhf.sportMeeting.repository.dao.UserDao;
import com.lhf.sportMeeting.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public void regist(User inputUser) throws WebException {
        //check email unique
        if (!singleEmail(inputUser.getEmail())){
            throw new WebException(WebErrCode.SM_USER_EMAIL_REPEAT);
        }

        userDao.merge(inputUser);
    }

    @Override
    public String login(HttpServletRequest request, String email, String password) throws WebException {
        List<User> users=userDao.queryUserByEmail(email);
        if(CollectionUtils.isEmpty(users)){
            return WebErrCode.SM_USER_AUTH_NOT_EXIST.getMsg();
        }
        if(users.size()>1){
            return WebErrCode.SM_USER_INFO_ERR.getMsg();
        }
        User user=users.get(0);
        if(!EncryptionUtils.md5(password).equalsIgnoreCase(user.getPassword())){
            return WebErrCode.SM_USER_NAMMERR_OR_ACCOUNT_ERR.getMsg();
        }
        if(user!=null){
            HttpSession session=request.getSession();
            session.setAttribute("user",user);
        }
        return null;
    }

    private boolean singleEmail(String email) {
        List<User> users = userDao.queryUserByEmail(email);
        if (CollectionUtils.isEmpty(users)){
            return true;
        }
        return false;
    }
}
