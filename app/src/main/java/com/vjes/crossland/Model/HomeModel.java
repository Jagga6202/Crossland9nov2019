package com.vjes.crossland.Model;

public class HomeModel {
    public String getHometext() {
        return hometext;
    }

    public void setHometext(String hometext) {
        this.hometext = hometext;
    }

    public int getHomeimage() {
        return homeimage;
    }

    public void setHomeimage(int homeimage) {
        this.homeimage = homeimage;
    }

    String hometext;

    public HomeModel(String hometext, int homeimage) {
        this.hometext = hometext;
        this.homeimage = homeimage;
    }

    int homeimage;
}
