package com.example.datatask2.entity;

import com.example.datatask2.item.Color;

public class Vehicle {
    private String plateNo;
    private String ownerId;
    private Color color;

    public Vehicle(String plateNo, String ownerId, int color) {
        this.plateNo = plateNo;
        this.ownerId = ownerId;
        this.color = Color.valueOf(color);
    }

    public Vehicle() {
    }

    public String getPlate_no() {
        return plateNo;
    }
    public void setPlate_no(String plateNo) {
        this.plateNo = plateNo;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = Color.valueOf(color);
    }
}
