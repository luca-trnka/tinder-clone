package com.gfa.tinderclone.models;

import jakarta.persistence.*;

@Entity
@Table(name = "swipes")
public class Swipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long current_user_id;
    private Long other_user_id;
    private String direction;

    public Swipe(Long current_user_id, Long other_user_id, String direction) {
        this.current_user_id = current_user_id;
        this.other_user_id = other_user_id;
        this.direction = direction;
    }

    public Swipe() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCurrent_user_id() {
        return current_user_id;
    }

    public void setCurrent_user_id(Long current_user_id) {
        this.current_user_id = current_user_id;
    }

    public Long getOther_user_id() {
        return other_user_id;
    }

    public void setOther_user_id(Long other_user_id) {
        this.other_user_id = other_user_id;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
