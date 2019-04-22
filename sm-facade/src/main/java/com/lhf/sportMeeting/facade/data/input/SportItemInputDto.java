package com.lhf.sportMeeting.facade.data.input;

import com.lhf.sportMeeting.domain.entity.SportItem;

public class SportItemInputDto {

    private Long itemId;
    private String itemName;
    private Integer itemMaxUserNum;
    private String itemDesc;

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

    public SportItem transform() {
        SportItem item = new SportItem();

        item.setId(itemId);
        item.setItemName(itemName);
        item.setItemMaxUserNum(itemMaxUserNum);
        item.setItemDesc(itemDesc);

        return item;
    }
}
