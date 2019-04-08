package com.lhf.sportMeeting.domain.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_sport_item")
public class SportItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 比赛项目名称
     */
    @Column(name = "item_name")
    private String itemName;

    /**
     * 限报名人数
     */
    @Column(name = "item_max_user_num")
    private Integer itemMaxUserNum;

    /**
     * 目前记录
     */
    private String record;

    /**
     * 记录创建时间
     */
    @Column(name = "record_at")
    private Date recordAt;

    /**
     * 记录对应的运动会信息
     */
    @Column(name = "record_sport_id")
    private Long recordSportId;

    /**
     * 记录保持者名称
     */
    @Column(name = "record_name")
    private String recordName;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "deleted_at")
    private Date deletedAt;

    /**
     * 项目描述
     */
    @Column(name = "item_desc")
    private String itemDesc;

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
     * 获取比赛项目名称
     *
     * @return item_name - 比赛项目名称
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * 设置比赛项目名称
     *
     * @param itemName 比赛项目名称
     */
    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    /**
     * 获取限报名人数
     *
     * @return item_max_user_num - 限报名人数
     */
    public Integer getItemMaxUserNum() {
        return itemMaxUserNum;
    }

    /**
     * 设置限报名人数
     *
     * @param itemMaxUserNum 限报名人数
     */
    public void setItemMaxUserNum(Integer itemMaxUserNum) {
        this.itemMaxUserNum = itemMaxUserNum;
    }

    /**
     * 获取目前记录
     *
     * @return record - 目前记录
     */
    public String getRecord() {
        return record;
    }

    /**
     * 设置目前记录
     *
     * @param record 目前记录
     */
    public void setRecord(String record) {
        this.record = record == null ? null : record.trim();
    }

    /**
     * 获取记录创建时间
     *
     * @return record_at - 记录创建时间
     */
    public Date getRecordAt() {
        return recordAt;
    }

    /**
     * 设置记录创建时间
     *
     * @param recordAt 记录创建时间
     */
    public void setRecordAt(Date recordAt) {
        this.recordAt = recordAt;
    }

    /**
     * 获取记录对应的运动会信息
     *
     * @return record_sport_id - 记录对应的运动会信息
     */
    public Long getRecordSportId() {
        return recordSportId;
    }

    /**
     * 设置记录对应的运动会信息
     *
     * @param recordSportId 记录对应的运动会信息
     */
    public void setRecordSportId(Long recordSportId) {
        this.recordSportId = recordSportId;
    }

    /**
     * 获取记录保持者名称
     *
     * @return record_name - 记录保持者名称
     */
    public String getRecordName() {
        return recordName;
    }

    /**
     * 设置记录保持者名称
     *
     * @param recordName 记录保持者名称
     */
    public void setRecordName(String recordName) {
        this.recordName = recordName == null ? null : recordName.trim();
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
     * 获取项目描述
     *
     * @return item_desc - 项目描述
     */
    public String getItemDesc() {
        return itemDesc;
    }

    /**
     * 设置项目描述
     *
     * @param itemDesc 项目描述
     */
    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc == null ? null : itemDesc.trim();
    }
}