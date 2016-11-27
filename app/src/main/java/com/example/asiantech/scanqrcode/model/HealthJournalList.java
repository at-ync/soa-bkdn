package com.example.asiantech.scanqrcode.model;

/**
 * Copyright © 2016 AsianTech inc.
 * Created by ync on 26/11/2016.
 */
public class HealthJournalList {
    private long timestamp;
    private Pig pig;
    private Health health;
    private String note;
    private Account worker;

    public HealthJournalList(long timestamp, Pig pig, Health health, String note, Account worker) {
        this.timestamp = timestamp;
        this.pig = pig;
        this.health = health;
        this.note = note;
        this.worker = worker;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public Pig getPig() {
        return pig;
    }

    public void setPig(Pig pig) {
        this.pig = pig;
    }

    public Health getHealth() {
        return health;
    }

    public void setHealth(Health health) {
        this.health = health;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Account getWorker() {
        return worker;
    }

    public void setWorker(Account worker) {
        this.worker = worker;
    }
}
