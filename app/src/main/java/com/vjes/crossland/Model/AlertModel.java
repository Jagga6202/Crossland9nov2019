package com.vjes.crossland.Model;

public class AlertModel {
    String no;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;

    public AlertModel(String no, String name) {
        this.no = no;
        this.name = name;
    }
}
