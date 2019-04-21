package com.lhf.sportMeeting.service.impl;

import com.github.pagehelper.PageInfo;
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
    public String regist(User inputUser) throws WebException {
        //check email unique
        if (!singleEmail(inputUser.getEmail())){
            return WebErrCode.SM_USER_EMAIL_REPEAT.getMsg();
        }
        inputUser.setPassword(EncryptionUtils.md5(inputUser.getPassword()));
        userDao.merge(inputUser);
        return WebErrCode.SM_SYS_OP_SUCC.getMsg();
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

    @Override
    public String updateUser(Long userId, User inputUser) {
        User user = userDao.queryUserById(userId);
        if (user==null){
            return WebErrCode.SM_USER_INFO_ERR.getMsg();
        }

        inputUser.setId(userId);
        userDao.merge(inputUser);
        return WebErrCode.SM_SYS_OP_SUCC.getMsg();
    }

    @Override
    public PageInfo<User> list(Integer pageNo, Integer pageSize) {
        return userDao.list(pageNo,pageSize);
    }

    @Override
    public String changeRole(Long userId) {
        User user = userDao.queryUserById(userId);
        if (user==null){
            return WebErrCode.SM_SYS_OPTION_NOT_EXSIT.getMsg();
        }

        User update = new User();
        update.setId(userId);
        update.setRole(user.getRole().equalsIgnoreCase("admin")?"user":"admin");
        userDao.merge(update);
        return WebErrCode.SM_SYS_OP_SUCC.getMsg();
    }

    private boolean singleEmail(String email) {
        List<User> users = userDao.queryUserByEmail(email);
        if (CollectionUtils.isEmpty(users)){
            return true;
        }
        return false;
    }
}
