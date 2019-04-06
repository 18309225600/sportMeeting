package com.lhf.sportMeeting.service;

import com.lhf.sportMeeting.common.std.WebException;
import com.lhf.sportMeeting.domain.entity.User;

import javax.servlet.http.HttpServletRequest;

public interface UserService {
    void regist(User inputUser) throws WebException;
    String login(HttpServletRequest request, String email, String password) throws WebException;
}
