package com.example.datatask2.entity;

public class Person {
    private String id;
    private String name;
    private int status;
    private int point;

    public String getId() {
        return id;
    }

    public Person(String id, String name, int status, int point) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.point = point;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
