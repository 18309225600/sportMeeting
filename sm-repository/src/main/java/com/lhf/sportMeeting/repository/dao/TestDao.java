package com.lhf.sportMeeting.repository.dao;

import com.lhf.deviceMS.domain.entity.TestUser;
import com.lhf.sportMeeting.repository.mapper.TestUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.weekend.Weekend;

import java.util.List;

@Repository
public class TestDao {

    @Autowired
    private TestUserMapper testUserMapper;

    public String search(){
        Weekend<TestUser> weekend = new Weekend<>(TestUser.class);
        weekend.weekendCriteria().andLike(TestUser::getPhone,"%60011224%");
        List<TestUser> testUsers = testUserMapper.selectByExample(weekend);
        return testUsers.toString();
    }



    public void insert(TestUser testUser) {
        testUserMapper.insertSelective(testUser);
    }


    public void update(TestUser testUser) {
        testUserMapper.updateByPrimaryKeySelective(testUser);
    }
}

