package com.sananibrahimov.adding_new_column;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import org.checkerframework.checker.units.qual.A;

import java.util.HashMap;

public class visaprosuderi extends AppCompatActivity {


    Spinner spinner;
    FirebaseFirestore firebaseFirestore;
    EditText name,xarici_passport_viza,Apostil,Apostil_tercume,sekil,vesiqe_sureti,is_deveti,qalacagi_yerin_arayisi,sigorta,sengen_vizasi,ucusbronu,viza_rusumu,sefirlik_muraciet_tarix,sefirliye_gorus_tarrix,senedlerin_neticesi,viza_gmail,Apostil_tercumeden_geldiyi_vaxt,apostil_baslama_tarixi,apostil_bitme_tarixi,is_devetine_muraciet,is_devetinin_baslama_tarixi,is_devetinin_bitme_tarixi,Sigortanin_baslama_tarixi,sigortanin_bitme_tarixi,Sigortaya_muraciet_tarix,reng;

   private String [] array={"Ağ(gün təyin olunmuyub)","Narıncı(Gün təyin olunanlar)","Sarı(Viza gözləyənlər)","Mavi(Viza alıb getmiyənlər)","Yaşıl(Gedənlər)","Qara(Müqaviləyə xitam)"};
  Button addbutton,vizaupdate,vizadelete;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visaprosuderi);
         firebaseFirestore=FirebaseFirestore.getInstance();
          name=findViewById(R.id.visa_username);
          xarici_passport_viza=findViewById(R.id.visaadd_xaricipassport);
          Apostil=findViewById(R.id.apostil);
          Apostil_tercume=findViewById(R.id.visa_apostil_tercume);
          vesiqe_sureti=findViewById(R.id.sexsiyyet_vesiqe_sureti);
          sekil=findViewById(R.id.sekil_visa);
          is_deveti=findViewById(R.id.isdeveti);
          qalacagi_yerin_arayisi=findViewById(R.id.visa_arayisi);
          sigorta=findViewById(R.id.sigorta);
          sengen_vizasi=findViewById(R.id.sengen_vizasi);
          ucusbronu=findViewById(R.id.ucus_bronu);
          viza_rusumu=findViewById(R.id.viza_rusumu);
          sefirlik_muraciet_tarix=findViewById(R.id.sefirliye_muraciet_olunan_tarix);
          sefirliye_gorus_tarrix=findViewById(R.id.sefirlik_teyin_olunanvaxt);
          senedlerin_neticesi=findViewById(R.id.viza_netice);
          addbutton=findViewById(R.id.Vizaelave);
          vizaupdate=findViewById(R.id.viza_update);
          vizadelete=findViewById(R.id.viza_delete);
          viza_gmail=findViewById(R.id.vizagmail);
          reng=findViewById(R.id.viza_reng);
          spinner=findViewById(R.id.vizaaaa_reng);
           Apostil_tercumeden_geldiyi_vaxt=findViewById(R.id.visa_apostil_tercumeden_geldiyi_vaxt);
           apostil_baslama_tarixi=findViewById(R.id.visa_apostilinbaslma_tarixi);
           apostil_bitme_tarixi=findViewById(R.id.visa_apostil_bitme_tarix);
           is_devetine_muraciet=findViewById(R.id.visa_isdevetine_muraciet);
           is_devetinin_baslama_tarixi=findViewById(R.id.visa_isdevetinin_baslama_tarixi);
           is_devetinin_bitme_tarixi=findViewById(R.id.visa_isdevetinin_bitme_tarixi);
           Sigortanin_baslama_tarixi=findViewById(R.id.visa_sigorta_baslama_tarixi);
           sigortanin_bitme_tarixi=findViewById(R.id.visa_sigorta_bitme_tarixi);
           Sigortaya_muraciet_tarix=findViewById(R.id.visa_sigortaya_muraciet_olunan_tarix);
        ArrayAdapter arrayAdapter=new ArrayAdapter(visaprosuderi.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,array);
        spinner.setAdapter(arrayAdapter);

           Intent intent=getIntent();
           int  visaprosduderi=intent.getIntExtra("visaprosdureri",0);
         switch (visaprosduderi){
             case 1:
                 vizaupdatedata();
                 break;
             case 2:

                 vizadeleletedata();
                 break;
             case 3:
                 visaadddata();
                 break;
         }



    }

    private void vizaupdatedata() {


          vizadelete.setVisibility(View.GONE);
          addbutton.setVisibility(View.GONE);
          Intent intent=getIntent();

           name.setText(intent.getStringExtra("uservisa"));
        xarici_passport_viza.setText(intent.getStringExtra("xaricipasportviza"));
           Apostil.setText(intent.getStringExtra("Apostilvisa"));
        sekil.setText(intent.getStringExtra("vizasekil3eded"));
        vesiqe_sureti.setText(intent.getStringExtra("svesiqesinin_sureti"));
        is_deveti.setText(intent.getStringExtra("is_devetivisa"));
        qalacagi_yerin_arayisi.setText(intent.getStringExtra("visaqalacagiyerinarayis"));
        sigorta.setText(intent.getStringExtra("sigortavisa"));
        sengen_vizasi.setText(intent.getStringExtra("sengenvizasivvisa"));
        viza_rusumu.setText(intent.getStringExtra("visarusumu80"));
        sefirlik_muraciet_tarix.setText(intent.getStringExtra("sefirliyemuraciet"));
        sefirliye_gorus_tarrix.setText(intent.getStringExtra("sefirlikle_gorus_tarix"));
        senedlerin_neticesi.setText(intent.getStringExtra("neticeviza"));
        ucusbronu.setText(intent.getStringExtra("ucusbronu"));
        viza_gmail.setText(intent.getStringExtra("gmail"));
        Apostil_tercume.setText(intent.getStringExtra("Apostil_tercume"));
        Apostil_tercumeden_geldiyi_vaxt.setText(intent.getStringExtra("tercumedengeldiyi_vaxt"));
        apostil_baslama_tarixi.setText(intent.getStringExtra("apostil_baslama"));
        apostil_bitme_tarixi.setText(intent.getStringExtra("Apostyil_bitme"));
        is_devetine_muraciet.setText(intent.getStringExtra("isdevetinemuraciet"));
        is_devetinin_baslama_tarixi.setText(intent.getStringExtra("isdevetinin_baslama_tarixi"));
        is_devetinin_bitme_tarixi.setText(intent.getStringExtra("isdevetinin bitme tarixi"));
        Sigortaya_muraciet_tarix.setText(intent.getStringExtra("sigortaya_muraciet"));
        Sigortanin_baslama_tarixi.setText(intent.getStringExtra("sigortaninbaslama_tarixi"));
        sigortanin_bitme_tarixi.setText(intent.getStringExtra("sigorta_bitme"));
        reng.setText(intent.getStringExtra("reng"));
        reng.setEnabled(false);
        String visaid=intent.getStringExtra("visaid");


         vizaupdate.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 ProgressDialog progressDialog=new ProgressDialog(visaprosuderi.this);
                  progressDialog.setMessage("Updating...");
                  progressDialog.show();
               String usernamevisa=  name.getText().toString();
                 String xarici_passportof=  xarici_passport_viza.getText().toString();
                 String  Apostil33=  Apostil.getText().toString();
                 String sekilvisa=  sekil.getText().toString();
                 String sexsiyyetvesiqe=  vesiqe_sureti.getText().toString();
                 String isdevetiof=  is_deveti.getText().toString();
                 String yerin_arayisi=  qalacagi_yerin_arayisi.getText().toString();
                 String sigortaofviza=  sigorta.getText().toString();
                 String sengenvizasiof=  sengen_vizasi.getText().toString();
                 String viza_rusumuofvisa=  viza_rusumu.getText().toString();
                 String sefirlik_muraciet_tarixof=  sefirlik_muraciet_tarix.getText().toString();
                 String sefirliye_gorus_tarrixofvisa=  sefirliye_gorus_tarrix.getText().toString();
                 String senedlerin_neticesiofvisa =  senedlerin_neticesi.getText().toString();
                 String ucusbronuofvisa= ucusbronu.getText().toString();
                 String viza_gmail2=viza_gmail.getText().toString().trim();
                 String apostiltercume=Apostil_tercume.getText().toString();
                 String   apostiltercumden_geldiyi_vaxt=Apostil_tercumeden_geldiyi_vaxt.getText().toString();
                 String   Apostil_baslamatarixi=apostil_baslama_tarixi.getText().toString();
                 String   Apostil_bitmetarixi=apostil_bitme_tarixi.getText().toString();
                 String   isdevetienmuraciett=is_devetine_muraciet.getText().toString();
                 String   isdevetinin_baslama_tarixi=is_devetinin_baslama_tarixi.getText().toString();
                 String   isdevetinin_bitmetarixi=is_devetinin_bitme_tarixi.getText().toString();
                 String   sigortaya_muraciett=Sigortaya_muraciet_tarix.getText().toString();
                 String   sigortaninbaslamatarixxi=Sigortanin_baslama_tarixi.getText().toString();
                 String   sigortaninbitmetarixi=sigortanin_bitme_tarixi.getText().toString();
                 String   rengj=spinner.getSelectedItem().toString();
                 visaclass visaclass=new visaclass(usernamevisa,xarici_passportof,Apostil33,sekilvisa,sexsiyyetvesiqe,isdevetiof,yerin_arayisi,sigortaofviza,sengenvizasiof,ucusbronuofvisa,viza_rusumuofvisa,sefirlik_muraciet_tarixof,sefirliye_gorus_tarrixofvisa,senedlerin_neticesiofvisa,viza_gmail2,apostiltercume,apostiltercumden_geldiyi_vaxt,Apostil_baslamatarixi,Apostil_bitmetarixi,isdevetienmuraciett,isdevetinin_baslama_tarixi,isdevetinin_bitmetarixi,sigortaninbaslamatarixxi,sigortaninbitmetarixi,sigortaya_muraciett,rengj);


                 firebaseFirestore.collection("vizaprosuderi").document(visaid).update("Username_visa",visaclass.getNameofvisauser(),"Xarici passport",visaclass.getXarici_passport(),"Apostil",visaclass.getApostil(),"sekil",visaclass.getSekil(),
                         "Vesiqe_sureti",visaclass.getVəsiqə_sureti(),"is_deveti",visaclass.getIs_deveti(),"Arayis",visaclass.getQalacagiyer_arayis(),"sigorta",visaclass.getSigorta(),"sengen_vizasi_form",visaclass.getSengen_vizasi_form(),"ucus_bronu",visaclass.getBron(),"viza_rusumu",visaclass.getViza_rusumu(),
                         "sefirliye_muraciet_olunan tarix",visaclass.getSefirlik_muraciet_tarix(),"sefirliye_teyin_olunan_vaxt",visaclass.getTeyin_olunan_vaxt(),"senedlerin_neticesi",visaclass.getSened_netice(),"Apostil_tercume",visaclass.getApostil_tercumel(),
                         "Apostil_tercumeden_geldiyi_vaxt",visaclass.getApostilin_geldiyi_vaxt(),"Apostil_bitme_tarixi",visaclass.getApostilin_bitme_tarixi(),"Apostil_baslama_tarixi",visaclass.getApostin_baslama_tarixi(),"Isdevetine_muraciet",visaclass.getIsdevetine_muraciet(),
                         "isdevetinin_baslama_tarixi",visaclass.getIs_devetinin_baslama_tarixi(),"isdevetinin_bitme_tarixi",visaclass.getIs_devetinin_bitme_tarixi(),"sigortaya_muraciet",visaclass.getSigortaya_muraciet_tarixi(),
                         "sigortanin_baslama_tarixi",visaclass.getSigortaya_baslama_tarixi(),"sigortanin_bitme_tarixi",visaclass.getSigorta_bitme_tarixi(),"gmail",visaclass.getGmail(),"reng",visaclass.getReng()).addOnSuccessListener(new OnSuccessListener<Void>() {
                     @Override
                     public void onSuccess(Void unused) {
                         Intent intent1=new Intent(visaprosuderi.this,navigation_activity.class);
                               intent1.putExtra("navigation",2);
                               progressDialog.dismiss();
                                startActivity(intent1);
                                finish();
                     }
                 });
             }
         });












    }

    private void vizadeleletedata() {
        addbutton.setVisibility(View.GONE);
        vizaupdate.setVisibility(View.GONE);
        vizadelete.setVisibility(View.VISIBLE);

         Intent intent=getIntent();
        name.setText(intent.getStringExtra("uservisa"));
        xarici_passport_viza.setText(intent.getStringExtra("xaricipasportviza"));
        Apostil.setText(intent.getStringExtra("Apostilvisa"));
        sekil.setText(intent.getStringExtra("vizasekil3eded"));
        vesiqe_sureti.setText(intent.getStringExtra("svesiqesinin_sureti"));
        is_deveti.setText(intent.getStringExtra("is_devetivisa"));
        qalacagi_yerin_arayisi.setText(intent.getStringExtra("visaqalacagiyerinarayis"));
        sigorta.setText(intent.getStringExtra("sigortavisa"));
        sengen_vizasi.setText(intent.getStringExtra("sengenvizasivvisa"));
        viza_rusumu.setText(intent.getStringExtra("visarusumu80"));
        sefirlik_muraciet_tarix.setText(intent.getStringExtra("sefirliyemuraciet"));
        sefirliye_gorus_tarrix.setText(intent.getStringExtra("sefirlikle_gorus_tarix"));
        senedlerin_neticesi.setText(intent.getStringExtra("neticeviza"));
        ucusbronu.setText(intent.getStringExtra("ucusbronu"));
        viza_gmail.setText(intent.getStringExtra("gmail"));
        Apostil_tercume.setText(intent.getStringExtra("Apostil_tercume"));
        Apostil_tercumeden_geldiyi_vaxt.setText(intent.getStringExtra("tercumedengeldiyi_vaxt"));
        apostil_baslama_tarixi.setText(intent.getStringExtra("apostil_baslama"));
        apostil_bitme_tarixi.setText(intent.getStringExtra("Apostyil_bitme"));
        is_devetine_muraciet.setText(intent.getStringExtra("isdevetinemuraciet"));
        is_devetinin_baslama_tarixi.setText(intent.getStringExtra("isdevetinin_baslama_tarixi"));
        is_devetinin_bitme_tarixi.setText(intent.getStringExtra("isdevetinin bitme tarixi"));
        Sigortaya_muraciet_tarix.setText(intent.getStringExtra("sigortaya_muraciet"));
        Sigortanin_baslama_tarixi.setText(intent.getStringExtra("sigortaninbaslama_tarixi"));
        sigortanin_bitme_tarixi.setText(intent.getStringExtra("sigorta_bitme"));
        reng.setText(intent.getStringExtra("reng"));

        String visaid=intent.getStringExtra("visaid");
        spinner.setVisibility(View.GONE);
        name.setEnabled(false);
        xarici_passport_viza.setEnabled(false);
        Apostil.setEnabled(false);
        sekil.setEnabled(false);
        vesiqe_sureti.setEnabled(false);
        is_deveti.setEnabled(false);
        qalacagi_yerin_arayisi.setEnabled(false);
        sigorta.setEnabled(false);
        sengen_vizasi.setEnabled(false);
        viza_rusumu.setEnabled(false);
        sefirlik_muraciet_tarix.setEnabled(false);
        sefirliye_gorus_tarrix.setEnabled(false);
        senedlerin_neticesi.setEnabled(false);
        ucusbronu.setEnabled(false);
        Apostil_tercume.setEnabled(false);
        Apostil_tercumeden_geldiyi_vaxt.setEnabled(false);
        apostil_bitme_tarixi.setEnabled(false);
        apostil_baslama_tarixi.setEnabled(false);
        is_devetine_muraciet.setEnabled(false);
        is_devetinin_bitme_tarixi.setEnabled(false);
        is_devetinin_baslama_tarixi.setEnabled(false);
        Sigortaya_muraciet_tarix.setEnabled(false);
        sigortanin_bitme_tarixi.setEnabled(false);
        Sigortanin_baslama_tarixi.setEnabled(false);
        viza_gmail.setEnabled(false);
        reng.setEnabled(false);
         vizadelete.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {

                 Intent intent=getIntent();
               String idi=  intent.getStringExtra("visaid");

                 AlertDialog.Builder alert=new AlertDialog.Builder(visaprosuderi.this);
                 alert.setCancelable(false);
                 alert.setTitle("Warning!!!");
                 alert.setMessage("datani silmeye əminsiz?");
                 alert.setPositiveButton("delete", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialogInterface, int i) {
                         firebaseFirestore.collection("vizaprosuderi").document(idi).delete().addOnSuccessListener(new OnSuccessListener<Void>() {
                             @Override
                             public void onSuccess(Void unused) {
                                 Intent intent1=new Intent(visaprosuderi.this,navigation_activity.class);
                                 intent1.putExtra("navigation",2);

                                 startActivity(intent1);
                                 finish();
                             }
                         });
                     }
                 });

                 alert.setNegativeButton("don't delete", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialogInterface, int i) {

                     }
                 });
                 alert.show();









             }
         });


    }

    private void visaadddata() {

        addbutton.setVisibility(View.VISIBLE);
        vizaupdate.setVisibility(View.GONE);
        vizadelete.setVisibility(View.GONE);
        reng.setVisibility(View.GONE);

        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    String namevisa=name.getText().toString();
                    String pasport=xarici_passport_viza.getText().toString();
                    String Apostilk=Apostil.getText().toString();
                    String Apostil_tercumer=Apostil_tercume.getText().toString();
                    String sekil2=sekil.getText().toString();
                    String vesiuqe_sureti1=vesiqe_sureti.getText().toString();String isdeveti2=is_deveti.getText().toString();
                String qalacacagiyerinarayisi=qalacagi_yerin_arayisi.getText().toString();
                String sigorta23=sigorta.getText().toString();
                String  sengenvizasi=sengen_vizasi.getText().toString();
                String ucusvronu=ucusbronu.getText().toString();
                String vizarusumu=viza_rusumu.getText().toString();
                String sefirliyemuracietolunantarix=sefirlik_muraciet_tarix.getText().toString();
                String sefirlikteyinolunanvaxt=sefirliye_gorus_tarrix.getText().toString();
                String senedlerin_neticesi21=senedlerin_neticesi.getText().toString();
                String viza_gmail322=viza_gmail.getText().toString().trim();
                String   apostiltercumden_geldiyi_vaxt=Apostil_tercumeden_geldiyi_vaxt.getText().toString();
                String   Apostil_baslamatarixi=apostil_baslama_tarixi.getText().toString();
                String   Apostil_bitmetarixi=apostil_bitme_tarixi.getText().toString();
                String   isdevetienmuraciett=is_devetine_muraciet.getText().toString();
                String   isdevetinin_baslama_tarixi=is_devetinin_baslama_tarixi.getText().toString();
                String   isdevetinin_bitmetarixi=is_devetinin_bitme_tarixi.getText().toString();
                String   sigortaya_muraciett=Sigortaya_muraciet_tarix.getText().toString();
                String   sigortaninbaslamatarixxi=Sigortanin_baslama_tarixi.getText().toString();
                String   sigortaninbitmetarixi=sigortanin_bitme_tarixi.getText().toString();
                String  reng1=reng.getText().toString();

                HashMap<String,Object> hashMap=new HashMap<>();
                hashMap.put("Username_visa",namevisa);
                hashMap.put("Xarici passport",pasport);
                hashMap.put("Apostil",Apostilk);
                hashMap.put("Apostil_tercume",Apostil_tercumer);
                hashMap.put("sekil",sekil2);
                hashMap.put("Vesiqe_sureti",vesiuqe_sureti1);
                hashMap.put("is_deveti",isdeveti2);
                hashMap.put("Arayis",qalacacagiyerinarayisi);
                hashMap.put("sigorta",sigorta23);
                hashMap.put("sengen_vizasi_form",sengenvizasi);
                hashMap.put("ucus_bronu",ucusvronu);
                hashMap.put("viza_rusumu",vizarusumu);
                hashMap.put("sefirliye_muraciet_olunan tarix",sefirliyemuracietolunantarix);
                hashMap.put("sefirliye_teyin_olunan_vaxt",sefirlikteyinolunanvaxt);
                hashMap.put("senedlerin_neticesi",senedlerin_neticesi21);
                hashMap.put("gmail",viza_gmail322);
                hashMap.put("Apostil_tercumeden_geldiyi_vaxt",apostiltercumden_geldiyi_vaxt);
                hashMap.put("Apostil_bitme_tarixi",Apostil_bitmetarixi);
                hashMap.put("Apostil_baslama_tarixi",Apostil_baslamatarixi);
                hashMap.put("Isdevetine_muraciet",isdevetienmuraciett);
                hashMap.put("isdevetinin_baslama_tarixi",isdevetinin_baslama_tarixi);
                hashMap.put("isdevetinin_bitme_tarixi",isdevetinin_bitmetarixi);
                hashMap.put("sigortaya_muraciet",sigortaya_muraciett);
                hashMap.put("sigortanin_baslama_tarixi",sigortaninbaslamatarixxi);
                hashMap.put("sigortanin_bitme_tarixi",sigortaninbitmetarixi);
                hashMap.put("reng",spinner.getSelectedItem().toString());









                firebaseFirestore.collection("vizaprosuderi").add(hashMap).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {

                        Intent intent=new Intent(visaprosuderi.this,navigation_activity.class);
                        intent.putExtra("navigation",2);
                        startActivity(intent);
                        finish();
                        Toast.makeText(visaprosuderi.this, " data added", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(visaprosuderi.this,e.getLocalizedMessage(),Toast.LENGTH_SHORT);
                    }
                });

            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(visaprosuderi.this,navigation_activity.class);
        intent.putExtra("navigation",2);
        startActivity(intent);
        finish();
    }
}