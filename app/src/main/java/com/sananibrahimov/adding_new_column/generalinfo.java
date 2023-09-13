package com.sananibrahimov.adding_new_column;

import com.google.firebase.firestore.Exclude;

public class generalinfo {


    String username;
    String sexsiyyet;
    String  muqavilenin_tarixi;
    String   muraciet_tarixi;
            String muqavilenin_nomresi;
    String olke;
            String sirket;
    String  vakansiya_date;
            String odenilecek_mebleg;
    String  ilkin_odenis;
            String qaliq_borc;
    String  number;
            String  dogum_tarixi;
    String  xarici_passportun_nomrsi;
            String milliyeti;
                    String unvan;
                    String gmail;
                    String xaricipassport_baslama;
    String xaricipassport_bitme;
    String anket;
    @Exclude private  String id;

    public generalinfo(String username, String sexsiyyet, String muqavilenin_tarixi, String muraciet_tarixi, String muqavilenin_nomresi, String olke, String sirket, String vakansiya_date, String odenilecek_mebleg, String ilkin_odenis, String qaliq_borc, String number, String dogum_tarixi, String xarici_passportun_nomrsi, String milliyeti, String unvan,String gmail,    String xaricipassport_baslama,String xaricipassport_bitme,String anket) {
        this.username = username;
        this.sexsiyyet = sexsiyyet;
        this.muqavilenin_tarixi = muqavilenin_tarixi;
        this.muraciet_tarixi = muraciet_tarixi;
        this.muqavilenin_nomresi = muqavilenin_nomresi;
        this.olke = olke;
        this.sirket = sirket;
        this.vakansiya_date = vakansiya_date;
        this.odenilecek_mebleg = odenilecek_mebleg;
        this.ilkin_odenis = ilkin_odenis;
        this.qaliq_borc = qaliq_borc;
        this.number = number;
        this.dogum_tarixi = dogum_tarixi;
        this.xarici_passportun_nomrsi = xarici_passportun_nomrsi;
        this.milliyeti = milliyeti;
        this.unvan = unvan;
        this.gmail=gmail;
        this.xaricipassport_baslama=xaricipassport_baslama;
        this.xaricipassport_bitme=xaricipassport_bitme;
        this.anket=anket;


    }

    public String getXaricipassport_baslama() {
        return xaricipassport_baslama;
    }

    public void setXaricipassport_baslama(String xaricipassport_baslama) {
        this.xaricipassport_baslama = xaricipassport_baslama;
    }

    public String getXaricipassport_bitme() {
        return xaricipassport_bitme;
    }

    public void setXaricipassport_bitme(String xaricipassport_bitme) {
        this.xaricipassport_bitme = xaricipassport_bitme;
    }

    public String getAnket() {
        return anket;
    }

    public void setAnket(String anket) {
        this.anket = anket;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSexsiyyet() {
        return sexsiyyet;
    }

    public void setSexsiyyet(String sexsiyyet) {
        this.sexsiyyet = sexsiyyet;
    }

    public String getMuqavilenin_tarixi() {
        return muqavilenin_tarixi;
    }

    public void setMuqavilenin_tarixi(String muqavilenin_tarixi) {
        this.muqavilenin_tarixi = muqavilenin_tarixi;
    }

    public String getMuraciet_tarixi() {
        return muraciet_tarixi;
    }

    public void setMuraciet_tarixi(String muraciet_tarixi) {
        this.muraciet_tarixi = muraciet_tarixi;
    }

    public String getMuqavilenin_nomresi() {
        return muqavilenin_nomresi;
    }

    public void setMuqavilenin_nomresi(String muqavilenin_nomresi) {
        this.muqavilenin_nomresi = muqavilenin_nomresi;
    }

    public String getOlke() {
        return olke;
    }

    public void setOlke(String olke) {
        this.olke = olke;
    }

    public String getSirket() {
        return sirket;
    }

    public void setSirket(String sirket) {
        this.sirket = sirket;
    }

    public String getVakansiya_date() {
        return vakansiya_date;
    }

    public void setVakansiya_date(String vakansiya_date) {
        this.vakansiya_date = vakansiya_date;
    }

    public String getOdenilecek_mebleg() {
        return odenilecek_mebleg;
    }

    public void setOdenilecek_mebleg(String odenilecek_mebleg) {
        this.odenilecek_mebleg = odenilecek_mebleg;
    }

    public String getIlkin_odenis() {
        return ilkin_odenis;
    }

    public void setIlkin_odenis(String ilkin_odenis) {
        this.ilkin_odenis = ilkin_odenis;
    }

    public String getQaliq_borc() {
        return qaliq_borc;
    }

    public void setQaliq_borc(String qaliq_borc) {
        this.qaliq_borc = qaliq_borc;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDogum_tarixi() {
        return dogum_tarixi;
    }

    public void setDogum_tarixi(String dogum_tarixi) {
        this.dogum_tarixi = dogum_tarixi;
    }

    public String getXarici_passportun_nomrsi() {
        return xarici_passportun_nomrsi;
    }

    public void setXarici_passportun_nomrsi(String xarici_passportun_nomrsi) {
        this.xarici_passportun_nomrsi = xarici_passportun_nomrsi;
    }

    public String getMilliyeti() {
        return milliyeti;
    }

    public void setMilliyeti(String milliyeti) {
        this.milliyeti = milliyeti;
    }

    public String getUnvan() {
        return unvan;
    }

    public void setUnvan(String unvan) {
        this.unvan = unvan;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
