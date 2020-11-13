package com.example.datatask2.entity;

public class Ticket {
    private String ticketNo;
    private String driverId;
    private String claimTime;
    private String offenseNo;

    public Ticket(String ticketNo, String driverId, String claimTime, String offenseNo) {
        this.ticketNo = ticketNo;
        this.driverId = driverId;
        this.claimTime = claimTime;
        this.offenseNo = offenseNo;
    }

    public String getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(String ticketNo) {
        this.ticketNo = ticketNo;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getClaimTime() {
        return claimTime;
    }

    public void setClaimTime(String claimTime) {
        this.claimTime = claimTime;
    }

    public String getOffenseNo() {
        return offenseNo;
    }

    public void setOffenseNo(String offenseNo) {
        this.offenseNo = offenseNo;
    }
}
