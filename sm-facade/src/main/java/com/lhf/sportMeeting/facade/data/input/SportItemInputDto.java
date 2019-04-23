package com.lhf.sportMeeting.facade.data.input;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lhf.sportMeeting.domain.entity.SportItem;

import java.util.Date;

public class SportItemInputDto {

    private Long itemId;
    private String itemName;
    private Integer itemMaxUserNum;
    private String itemDesc;
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date startAt;
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date endAt;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getItemMaxUserNum() {
        return itemMaxUserNum;
    }

    public void setItemMaxUserNum(Integer itemMaxUserNum) {
        this.itemMaxUserNum = itemMaxUserNum;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public Date getStartAt() {
        return startAt;
    }

    public void setStartAt(Date startAt) {
        this.startAt = startAt;
    }

    public Date getEndAt() {
        return endAt;
    }

    public void setEndAt(Date endAt) {
        this.endAt = endAt;
    }

    public SportItem transform() {
        SportItem item = new SportItem();

        item.setId(itemId);
        item.setItemName(itemName);
        item.setItemMaxUserNum(itemMaxUserNum);
        item.setItemDesc(itemDesc);
        item.setStartAt(startAt);
        item.setEndAt(endAt);

        return item;
    }
}
