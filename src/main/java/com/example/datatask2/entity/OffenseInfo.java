package com.example.datatask2.entity;

public class OffenseInfo {
    private String ticketNo;
    private String time;
    private String location;
    private String plateNo;

    public String getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(String ticketNo) {
        this.ticketNo = ticketNo;
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

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    @Override
    public String toString() {
        return "OffenseInfo{" +
                "ticketNo='" + ticketNo + '\'' +
                ", time='" + time + '\'' +
                ", location='" + location + '\'' +
                ", plateNo='" + plateNo + '\'' +
                '}';
    }
}
