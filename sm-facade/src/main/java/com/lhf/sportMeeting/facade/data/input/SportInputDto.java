package com.lhf.sportMeeting.facade.data.input;

import com.lhf.sportMeeting.domain.entity.Sport;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

public class SportInputDto {
    private Long id;
    private String name;
    private Date startAt;
    private Date endAt;
    private String remark;
    private Long[] sportItems;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long[] getSportItems() {
        return sportItems;
    }

    public void setSportItems(Long[] sportItems) {
        this.sportItems = sportItems;
    }

    public Sport transform() {
        Sport sport = new Sport();

        sport.setId(this.id);
        sport.setName(this.name);
        sport.setStartAt(this.startAt);
        sport.setEndAt(this.endAt);
        sport.setRemark(this.remark);

        String sportItmes = null;
        if (this.sportItems.length>0){
            sportItmes = "";
            for (int i=0,j=this.sportItems.length;i<j;i++){
                if (i==j-1){
                    sportItmes+=this.sportItems[i];
                }else{
                    sportItmes=sportItmes+this.sportItems[i]+",";
                }
            }
        }

        sport.setSportItems(sportItmes);

        return sport;
    }
}
