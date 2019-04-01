package com.lhf.sportMeeting.service;

import com.lhf.sportMeeting.common.std.WebException;
import com.lhf.sportMeeting.domain.entity.User;

public interface UserService {
    void regist(User inputUser) throws WebException;
}
