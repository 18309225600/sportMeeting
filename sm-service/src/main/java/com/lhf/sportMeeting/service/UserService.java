package com.lhf.sportMeeting.service;

import com.github.pagehelper.PageInfo;
import com.lhf.sportMeeting.common.std.WebException;
import com.lhf.sportMeeting.domain.entity.User;

import javax.servlet.http.HttpServletRequest;

public interface UserService {
    String regist(User inputUser) throws WebException;
    String login(HttpServletRequest request, String email, String password) throws WebException;

    String updateUser(Long userId, User inputUser);

    PageInfo<User> list(Integer pageNo, Integer pageSize);

    String changeRole(Long userId);
}
