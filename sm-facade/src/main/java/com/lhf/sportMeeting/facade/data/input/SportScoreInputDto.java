package com.lhf.sportMeeting.facade.data.input;

public class SportScoreInputDto {

    private Long sportId;
    private Long sportItemId;
    private Long userId;
    private Integer score;
    private String realScore;

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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getRealScore() {
        return realScore;
    }

    public void setRealScore(String realScore) {
        this.realScore = realScore;
    }
}
