package com.sananibrahimov.adding_new_column;

import com.google.firebase.firestore.Exclude;

public class visaclass {
String nameofvisauser;
String  xarici_passport;
String Apostil;
String sekil;
String vəsiqə_sureti;
String is_deveti;
String qalacagiyer_arayis;
String sigorta;
String sengen_vizasi_form;
String bron;
String viza_rusumu;
String sefirlik_muraciet_tarix;
String teyin_olunan_vaxt;
String sened_netice;
String gmail;
String Apostil_tercumel;
String Apostilin_geldiyi_vaxt;
String Apostin_baslama_tarixi;
String Apostilin_bitme_tarixi;
String isdevetine_muraciet;
String is_devetinin_baslama_tarixi;
String is_devetinin_bitme_tarixi;
String sigortaya_baslama_tarixi;
String sigortaya_muraciet_tarixi;
String sigorta_bitme_tarixi;
String reng;
 @Exclude
 String id;

    public visaclass(String nameofvisauser,String xarici_passport, String apostil, String sekil, String vəsiqə_sureti, String is_deveti, String qalacagiyer_arayis, String sigorta, String sengen_vizasi_form, String bron, String viza_rusumu, String sefirlik_muraciet_tarix, String teyin_olunan_vaxt, String sened_netice,String gmail,String Apostil_tercumel,String Apostilin_geldiyi_vaxt,String Apostin_baslama_tarixi,String Apostilin_bitme_tarixi,String isdevetine_muraciet,String is_devetinin_baslama_tarixi,String is_devetinin_bitme_tarixi,String sigortaya_baslama_tarixi,String sigorta_bitme_tarixi,String sigortaya_muraciet_tarixi,String reng) {

         this.nameofvisauser=nameofvisauser;
        this.xarici_passport = xarici_passport;
        Apostil = apostil;
        this.sekil = sekil;
        this.vəsiqə_sureti = vəsiqə_sureti;
        this.is_deveti = is_deveti;
        this.qalacagiyer_arayis = qalacagiyer_arayis;
        this.sigorta = sigorta;
        this.sengen_vizasi_form = sengen_vizasi_form;
        this.bron = bron;
        this.viza_rusumu = viza_rusumu;
        this.sefirlik_muraciet_tarix = sefirlik_muraciet_tarix;
        this.teyin_olunan_vaxt = teyin_olunan_vaxt;
        this.sened_netice = sened_netice;
        this.gmail=gmail;
        this.Apostil_tercumel=Apostil_tercumel;
        this.Apostilin_geldiyi_vaxt=Apostilin_geldiyi_vaxt;
        this.Apostilin_bitme_tarixi=Apostilin_bitme_tarixi;
        this.Apostin_baslama_tarixi=Apostin_baslama_tarixi;
        this.isdevetine_muraciet=isdevetine_muraciet;
        this.is_devetinin_baslama_tarixi=is_devetinin_baslama_tarixi;
        this.is_devetinin_bitme_tarixi=is_devetinin_bitme_tarixi;
        this.sigortaya_baslama_tarixi=sigortaya_baslama_tarixi;
        this.sigorta_bitme_tarixi=sigorta_bitme_tarixi;
        this.sigortaya_muraciet_tarixi=sigortaya_muraciet_tarixi;
        this.reng=reng;

    }

    public String getReng() {
        return reng;
    }

    public void setReng(String reng) {
        this.reng = reng;
    }

    public String getSigortaya_muraciet_tarixi() {
        return sigortaya_muraciet_tarixi;
    }

    public void setSigortaya_muraciet_tarixi(String sigortaya_muraciet_tarixi) {
        this.sigortaya_muraciet_tarixi = sigortaya_muraciet_tarixi;
    }

    public String getApostil_tercumel() {
        return Apostil_tercumel;
    }

    public void setApostil_tercumel(String apostil_tercumel) {
        Apostil_tercumel = apostil_tercumel;
    }

    public String getApostilin_geldiyi_vaxt() {
        return Apostilin_geldiyi_vaxt;
    }

    public void setApostilin_geldiyi_vaxt(String apostilin_geldiyi_vaxt) {
        Apostilin_geldiyi_vaxt = apostilin_geldiyi_vaxt;
    }

    public String getApostin_baslama_tarixi() {
        return Apostin_baslama_tarixi;
    }

    public void setApostin_baslama_tarixi(String apostin_baslama_tarixi) {
        Apostin_baslama_tarixi = apostin_baslama_tarixi;
    }

    public String getApostilin_bitme_tarixi() {
        return Apostilin_bitme_tarixi;
    }

    public void setApostilin_bitme_tarixi(String apostilin_bitme_tarixi) {
        Apostilin_bitme_tarixi = apostilin_bitme_tarixi;
    }

    public String getIsdevetine_muraciet() {
        return isdevetine_muraciet;
    }

    public void setIsdevetine_muraciet(String isdevetine_muraciet) {
        this.isdevetine_muraciet = isdevetine_muraciet;
    }

    public String getIs_devetinin_baslama_tarixi() {
        return is_devetinin_baslama_tarixi;
    }

    public void setIs_devetinin_baslama_tarixi(String is_devetinin_baslama_tarixi) {
        this.is_devetinin_baslama_tarixi = is_devetinin_baslama_tarixi;
    }

    public String getIs_devetinin_bitme_tarixi() {
        return is_devetinin_bitme_tarixi;
    }

    public void setIs_devetinin_bitme_tarixi(String is_devetinin_bitme_tarixi) {
        this.is_devetinin_bitme_tarixi = is_devetinin_bitme_tarixi;
    }

    public String getSigortaya_baslama_tarixi() {
        return sigortaya_baslama_tarixi;
    }

    public void setSigortaya_baslama_tarixi(String sigortaya_baslama_tarixi) {
        this.sigortaya_baslama_tarixi = sigortaya_baslama_tarixi;
    }

    public String getSigorta_bitme_tarixi() {
        return sigorta_bitme_tarixi;
    }

    public void setSigorta_bitme_tarixi(String sigorta_bitme_tarixi) {
        this.sigorta_bitme_tarixi = sigorta_bitme_tarixi;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getXarici_passport() {
        return xarici_passport;
    }

    public void setXarici_passport(String xarici_passport) {
        this.xarici_passport = xarici_passport;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getApostil() {
        return Apostil;
    }

    public void setApostil(String apostil) {
        Apostil = apostil;
    }

    public String getSekil() {
        return sekil;
    }

    public void setSekil(String sekil) {
        this.sekil = sekil;
    }

    public String getVəsiqə_sureti() {
        return vəsiqə_sureti;
    }

    public void setVəsiqə_sureti(String vəsiqə_sureti) {
        this.vəsiqə_sureti = vəsiqə_sureti;
    }

    public String getIs_deveti() {
        return is_deveti;
    }

    public void setIs_deveti(String is_deveti) {
        this.is_deveti = is_deveti;
    }

    public String getQalacagiyer_arayis() {
        return qalacagiyer_arayis;
    }

    public void setQalacagiyer_arayis(String qalacagiyer_arayis) {
        this.qalacagiyer_arayis = qalacagiyer_arayis;
    }

    public String getSigorta() {
        return sigorta;
    }

    public void setSigorta(String sigorta) {
        sigorta = sigorta;
    }

    public String getSengen_vizasi_form() {
        return sengen_vizasi_form;
    }

    public void setSengen_vizasi_form(String sengen_vizasi_form) {
        this.sengen_vizasi_form = sengen_vizasi_form;
    }

    public String getBron() {
        return bron;
    }

    public void setBron(String bron) {
        this.bron = bron;
    }

    public String getViza_rusumu() {
        return viza_rusumu;
    }

    public void setViza_rusumu(String viza_rusumu) {
        this.viza_rusumu = viza_rusumu;
    }

    public String getSefirlik_muraciet_tarix() {
        return sefirlik_muraciet_tarix;
    }

    public void setSefirlik_muraciet_tarix(String sefirlik_muraciet_tarix) {
        sefirlik_muraciet_tarix = sefirlik_muraciet_tarix;
    }

    public String getTeyin_olunan_vaxt() {
        return teyin_olunan_vaxt;
    }

    public void setTeyin_olunan_vaxt(String teyin_olunan_vaxt) {
        this.teyin_olunan_vaxt = teyin_olunan_vaxt;
    }

    public String getSened_netice() {
        return sened_netice;
    }

    public void setSened_netice(String sened_netice) {
        this.sened_netice = sened_netice;
    }

    public String getNameofvisauser() {
        return nameofvisauser;
    }

    public void setNameofvisauser(String nameofvisauser) {
        this.nameofvisauser = nameofvisauser;
    }
}
