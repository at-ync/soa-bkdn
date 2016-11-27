package com.example.asiantech.scanqrcode.model;

/**
 * Copyright © 2016 AsianTech inc.
 * Created by ync on 26/11/2016.
 */
public class Health {
    private int id;
    private String rate;
    private String description;
    private String note;

    public Health(int id, String rate, String description, String note) {
        this.id = id;
        this.rate = rate;
        this.description = description;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
