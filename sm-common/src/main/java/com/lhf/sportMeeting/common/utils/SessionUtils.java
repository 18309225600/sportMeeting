package com.lhf.sportMeeting.common.utils;

import com.lhf.sportMeeting.domain.entity.User;

/**
 * 当前登录用户Session信息
 */
public class SessionUtils {
    //线程本地变量
    private static ThreadLocal<SessionHolder> context = new ThreadLocal<>();


    public static void set(User user){
        clean();
        SessionHolder sessionHolder = new SessionHolder(user);
        context.set(sessionHolder);
    }

    public static void clean(){
        context.remove();
    }

    public static long getUserId() {
        return context.get().getUserId();
    }

    public static String getUsername() {
        return context.get().getUserName();
    }

    public static class SessionHolder{
        private long userId;
        private String userName;
        private String gender;
        private Long phone;
        private String email;
        private String role;

        public SessionHolder() {
        }

        public SessionHolder(User user) {
            this.userId = user.getId();
            this.userName = user.getName();
            this.gender = user.getGender();
            this.phone = user.getPhone();
            this.email = user.getEmail();
            this.role = user.getRole();
        }

        public long getUserId() {
            return userId;
        }

        public void setUserId(long userId) {
            this.userId = userId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public long getPhone() {
            return phone;
        }

        public void setPhone(long phone) {
            this.phone = phone;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }
    }
}
