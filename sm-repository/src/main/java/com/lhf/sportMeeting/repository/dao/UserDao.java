package com.lhf.sportMeeting.repository.dao;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lhf.sportMeeting.common.utils.TimeUtils;
import com.lhf.sportMeeting.domain.entity.User;
import com.lhf.sportMeeting.repository.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.weekend.Weekend;

import java.util.List;
import java.util.Objects;
@Repository
public class UserDao {

    @Autowired
    private UserMapper userMapper;

    public List<User> queryUserByEmail(String email){
        Objects.requireNonNull(email);
        Weekend<User> weekend=new Weekend<>(User.class);
        weekend.weekendCriteria().andIsNull(User::getDeletedAt).andEqualTo(User::getEmail,email);
        return  userMapper.selectByExample(weekend);
    }

    public void merge(User user){
        Objects.requireNonNull(user);
        if (user.getId()==null){
            user.setCreateAt(TimeUtils.currentTime());
            userMapper.insertSelective(user);
        }else{
            userMapper.updateByPrimaryKeySelective(user);
        }
    }

    public User queryUserById(Long userId) {
        Weekend<User> weekend = new Weekend<>(User.class);
        weekend.weekendCriteria().andIsNull(User::getDeletedAt).andEqualTo(User::getId,userId);
        return userMapper.selectOneByExample(weekend);
    }

    public PageInfo<User> list(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        Weekend<User> weekend = new Weekend<>(User.class);
        weekend.weekendCriteria().andIsNull(User::getDeletedAt);
        return new PageInfo<>(userMapper.selectByExample(weekend));
    }
}
