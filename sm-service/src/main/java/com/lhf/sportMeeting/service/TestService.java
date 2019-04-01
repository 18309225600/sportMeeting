package com.lhf.sportMeeting.service;


import com.lhf.sportMeeting.domain.entity.TestUser;

public interface TestService {
    String search();

    void insert(TestUser testUser);

    void update(TestUser testUser);
}
