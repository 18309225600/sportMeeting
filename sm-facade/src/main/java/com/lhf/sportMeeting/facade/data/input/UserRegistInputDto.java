package com.lhf.sportMeeting.facade.data.input;

import com.lhf.sportMeeting.common.std.WebException;
import com.lhf.sportMeeting.common.std.enums.WebErrCode;
import com.lhf.sportMeeting.domain.entity.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;

public class UserRegistInputDto {
    private String username;
    private String gender;
    private String phone;
    private String email;
    private String password;
    private String img;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public UserRegistInputDto verify() throws WebException {
        if (StringUtils.isBlank(username)||
            StringUtils.isBlank(gender)||
            StringUtils.isBlank(phone)||
            StringUtils.isBlank(email)||
            StringUtils.isBlank(password)
            ){
            throw new WebException(WebErrCode.SM_COMMON_INVALID_PARAM);
        }
        return this;
    }

    public User transform(){
        User user = new User();
        BeanUtils.copyProperties(this,user);
        return user;
    }
}
