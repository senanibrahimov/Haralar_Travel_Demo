package com.sananibrahimov.adding_new_column;

import com.google.firebase.firestore.Exclude;

public class vakacation_class {

    String image;
    String vakansiyanin_adi;
    String olke;
    String text_melmat;

    @Exclude
    String id;
    public vakacation_class(String image, String vakansiyanin_adi, String olke,String text_melmat) {
        this.image = image;
        this.vakansiyanin_adi = vakansiyanin_adi;
        this.olke = olke;
        this.text_melmat=text_melmat;
    }

    public String getText_melmat() {
        return text_melmat;
    }

    public void setText_melmat(String text_melmat) {
        this.text_melmat = text_melmat;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getVakansiyanin_adi() {
        return vakansiyanin_adi;
    }

    public void setVakansiyanin_adi(String vakansiyanin_adi) {
        this.vakansiyanin_adi = vakansiyanin_adi;
    }

    public String getOlke() {
        return olke;
    }

    public void setOlke(String olke) {
        this.olke = olke;
    }
}
