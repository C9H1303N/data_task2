package com.example.datatask2.entity;

public class Transaction {
    private String tradingNo;
    private String sellerId;
    private String buyerId;
    private String plateNo;

    public String getTradingNo() {
        return tradingNo;
    }

    public Transaction(String tradingNo, String sellerId, String buyerId, String plateNo) {
        this.tradingNo = tradingNo;
        this.sellerId = sellerId;
        this.buyerId = buyerId;
        this.plateNo = plateNo;
    }

    public void setTradingNo(String tradingNo) {
        this.tradingNo = tradingNo;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }
}
