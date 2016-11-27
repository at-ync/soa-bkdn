package com.example.asiantech.scanqrcode.model;

/**
 * Copyright © 2016 AsianTech inc.
 * Created by ync on 26/11/2016.
 */
public class Race {
    private int id;
    private String name;
    private String description;
    private int totalGrowingDays;
    private boolean valid;

    public Race(int id, String description, String name, int totalGrowingDays, boolean valid) {
        this.id = id;
        this.description = description;
        this.name = name;
        this.totalGrowingDays = totalGrowingDays;
        this.valid = valid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalGrowingDays() {
        return totalGrowingDays;
    }

    public void setTotalGrowingDays(int totalGrowingDays) {
        this.totalGrowingDays = totalGrowingDays;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }
}

