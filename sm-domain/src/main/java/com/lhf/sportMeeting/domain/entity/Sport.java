package com.lhf.sportMeeting.domain.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_sport")
public class Sport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 运动会名称（例如2019年第一届运动会）
     */
    private String name;

    @Column(name = "start_at")
    private Date startAt;

    @Column(name = "end_at")
    private Date endAt;

    @Column(name = "sport_items")
    private String sportItems;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "deleted_at")
    private Date deletedAt;

    private String remark;

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
     * 获取运动会名称（例如2019年第一届运动会）
     *
     * @return name - 运动会名称（例如2019年第一届运动会）
     */
    public String getName() {
        return name;
    }

    /**
     * 设置运动会名称（例如2019年第一届运动会）
     *
     * @param name 运动会名称（例如2019年第一届运动会）
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return start_at
     */
    public Date getStartAt() {
        return startAt;
    }

    /**
     * @param startAt
     */
    public void setStartAt(Date startAt) {
        this.startAt = startAt;
    }

    /**
     * @return end_at
     */
    public Date getEndAt() {
        return endAt;
    }

    /**
     * @param endAt
     */
    public void setEndAt(Date endAt) {
        this.endAt = endAt;
    }

    /**
     * @return sport_items
     */
    public String getSportItems() {
        return sportItems;
    }

    /**
     * @param sportItems
     */
    public void setSportItems(String sportItems) {
        this.sportItems = sportItems == null ? null : sportItems.trim();
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

    /**
     * @return remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}