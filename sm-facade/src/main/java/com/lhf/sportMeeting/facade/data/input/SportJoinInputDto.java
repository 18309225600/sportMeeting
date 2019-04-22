package com.lhf.sportMeeting.facade.data.input;

public class SportJoinInputDto {

    private Long sportId;
    private Long sportItemId;

    public Long getSportId() {
        return sportId;
    }

    public void setSportId(Long sportId) {
        this.sportId = sportId;
    }

    public Long getSportItemId() {
        return sportItemId;
    }

    public void setSportItemId(Long sportItemId) {
        this.sportItemId = sportItemId;
    }
}
