package com.example.datatask2.entity;

public class TicketDetail {
    private String detailNo;
    private int point;
    private int fine;
    private int detention;
    private String ticketNo;

    public String getDetailNo() {
        return detailNo;
    }

    public void setDetailNo(String detailNo) {
        this.detailNo = detailNo;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getFine() {
        return fine;
    }

    public void setFine(int fine) {
        this.fine = fine;
    }

    public int getDetention() {
        return detention;
    }

    public void setDetention(int detention) {
        this.detention = detention;
    }

    public String getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(String ticketNo) {
        this.ticketNo = ticketNo;
    }

    public TicketDetail(String detailNo, int point, int fine, int detention, String ticketNo) {
        this.detailNo = detailNo;
        this.point = point;
        this.fine = fine;
        this.detention = detention;
        this.ticketNo = ticketNo;
    }
}
