package com.gfa.tinderclone.models;

public class SwipeRequest {
    private Long otherUserId;
    private String direction;

    public SwipeRequest() {
    }

    public Long getOtherUserId() {
        return otherUserId;
    }

    public void setOtherUserId(Long otherUserId) {
        this.otherUserId = otherUserId;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
