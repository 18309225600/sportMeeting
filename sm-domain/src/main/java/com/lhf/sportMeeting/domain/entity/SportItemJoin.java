package com.lhf.sportMeeting.domain.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_sport_item_join")
public class SportItemJoin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "sport_id")
    private Long sportId;

    @Column(name = "sport_name")
    private String sportName;

    @Column(name = "item_id")
    private Long itemId;

    @Column(name = "item_name")
    private String itemName;

    /**
     * 评分
     */
    private Integer score;

    /**
     * 真正的成绩
     */
    @Column(name = "real_score")
    private String realScore;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "deleted_at")
    private Date deletedAt;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return user_id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * @return user_name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * @return sport_id
     */
    public Long getSportId() {
        return sportId;
    }

    /**
     * @param sportId
     */
    public void setSportId(Long sportId) {
        this.sportId = sportId;
    }

    /**
     * @return sport_name
     */
    public String getSportName() {
        return sportName;
    }

    /**
     * @param sportName
     */
    public void setSportName(String sportName) {
        this.sportName = sportName == null ? null : sportName.trim();
    }

    /**
     * @return item_id
     */
    public Long getItemId() {
        return itemId;
    }

    /**
     * @param itemId
     */
    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    /**
     * @return item_name
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * @param itemName
     */
    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    /**
     * 获取评分
     *
     * @return score - 评分
     */
    public Integer getScore() {
        return score;
    }

    /**
     * 设置评分
     *
     * @param score 评分
     */
    public void setScore(Integer score) {
        this.score = score;
    }

    /**
     * 获取真正的成绩
     *
     * @return real_score - 真正的成绩
     */
    public String getRealScore() {
        return realScore;
    }

    /**
     * 设置真正的成绩
     *
     * @param realScore 真正的成绩
     */
    public void setRealScore(String realScore) {
        this.realScore = realScore == null ? null : realScore.trim();
    }

    /**
     * @return created_at
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * @param createdAt
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * @return deleted_at
     */
    public Date getDeletedAt() {
        return deletedAt;
    }

    /**
     * @param deletedAt
     */
    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }
}