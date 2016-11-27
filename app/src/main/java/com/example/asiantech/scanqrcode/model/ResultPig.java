package com.example.asiantech.scanqrcode.model;

import java.util.List;

/**
 * Copyright © 2016 AsianTech inc.
 * Created by ync on 26/11/2016.
 */
public class ResultPig {
    private int id;
    private Race race;
    private int weight;
    private boolean gender;
    private long createdAt;
    private long updatedAt;
    private long deletedAt;
    private long soldAt;
    private long pigpenId;
    private List<HealthJournalList> healthJournalList;

    public ResultPig(int id, Race race, int weight, long createdAt, boolean gender, long updatedAt, long deletedAt, long soldAt, long pigpenId, List<HealthJournalList> healthJournalLists) {
        this.id = id;
        this.race = race;
        this.weight = weight;
        this.createdAt = createdAt;
        this.gender = gender;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
        this.soldAt = soldAt;
        this.pigpenId = pigpenId;
        this.healthJournalList = healthJournalLists;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public long getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(long deletedAt) {
        this.deletedAt = deletedAt;
    }

    public long getSoldAt() {
        return soldAt;
    }

    public void setSoldAt(long soldAt) {
        this.soldAt = soldAt;
    }

    public long getPigpenId() {
        return pigpenId;
    }

    public void setPigpenId(long pigpenId) {
        this.pigpenId = pigpenId;
    }

    public List<HealthJournalList> getHealthJournalLists() {
        return healthJournalList;
    }

    public void setHealthJournalLists(List<HealthJournalList> healthJournalLists) {
        this.healthJournalList = healthJournalLists;
    }
}
