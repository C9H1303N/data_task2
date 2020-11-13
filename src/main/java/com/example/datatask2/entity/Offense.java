package com.example.datatask2.entity;

public class Offense {
    private String offenseNo;
    private int isClaimed;
    private String time;
    private String location;

    public Offense(String offenseNo, int isClaimed, String time, String location) {
        this.offenseNo = offenseNo;
        this.isClaimed = isClaimed;
        this.time = time;
        this.location = location;
    }

    @Override
    public String toString() {
        return "Offense{" +
                "offenseNo='" + offenseNo + '\'' +
                ", isClaimed=" + isClaimed +
                ", time='" + time + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    public String getOffenseNo() {
        return offenseNo;
    }

    public void setOffenseNo(String offenseNo) {
        this.offenseNo = offenseNo;
    }

    public int getIsClaimed() {
        return isClaimed;
    }

    public void setIsClaimed(int isClaimed) {
        this.isClaimed = isClaimed;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
