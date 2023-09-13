package com.sananibrahimov.adding_new_column;

import com.google.firebase.firestore.Exclude;

public class muraciet_data {

    String name;
    String surname;
    String telefon;
    String gmail;
    String vakansiya;
    String text_melumat;
    Boolean durum;


    @Exclude
    String id;

    public muraciet_data(String name,String gmail,String surname,String telefon,String vakansiya,String text_melumat,Boolean durum) {
        this.surname = surname;
        this.gmail = gmail;
        this.name=name;
        this.vakansiya=vakansiya;
        this.telefon=telefon;
        this.text_melumat=text_melumat;
        this.durum=durum;

    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getVakansiya_melumat() {
        return text_melumat;
    }

    public void setVakansiya_melumat(String text_melumat) {
        this.text_melumat = text_melumat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getVakansiya() {
        return vakansiya;
    }

    public void setVakansiya(String vakansiya) {
        this.vakansiya = vakansiya;
    }
}
