package com.vjes.crossland.Model;

public class AboutModel {
    public AboutModel(String abouttext, int aboutimage) {
        this.abouttext = abouttext;
        this.aboutimage = aboutimage;
    }

    public String getAbouttext() {
        return abouttext;
    }

    public void setAbouttext(String abouttext) {
        this.abouttext = abouttext;
    }

    public int getAboutimage() {
        return aboutimage;
    }

    public void setAboutimage(int aboutimage) {
        this.aboutimage = aboutimage;
    }

    String abouttext;
    int aboutimage;
}
