package com.sananibrahimov.adding_new_column;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class enterofuserinfo extends AppCompatActivity {
 Button button,update,delete;
 EditText username,sexsiyyet,musteri_gmail,muqavilenin_tarixi,muraciet_tarixi,muqavilenin_nomresi,olke,sirket,vakansiya_date,odenilecek_mebleg,ilkin_odenis,qaliq_borc,number,dogum_tarixi,xarici_passportun_nomrsi,milliyeti,unvan,xarici_paspoert_baslama,xarici_passport_bitme,anket;
    Intent intent23;


 private  FirebaseFirestore firestore;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enterofuserinfo);
            firestore=FirebaseFirestore.getInstance();
        button=findViewById(R.id.button1);
        delete=findViewById(R.id.delete);
        username=findViewById(R.id.user_name);
        update=findViewById(R.id.update);
        sexsiyyet=findViewById(R.id.sexsiyyetvesiqesi);
        muqavilenin_tarixi=findViewById(R.id.muqavile_tarixi);
        muqavilenin_nomresi=findViewById(R.id.muqavile_nomresi);
        muraciet_tarixi=findViewById(R.id.muraciet_vaxti);
        olke=findViewById(R.id.gedeceyi_olke);
        sirket=findViewById(R.id.qebul_eden_sirket);
        vakansiya_date=findViewById(R.id.vakansiya_date);
        odenilecek_mebleg=findViewById(R.id.odenilecek_mebleg);
        ilkin_odenis=findViewById(R.id.ilkin_odenis);
                qaliq_borc=findViewById(R.id.qaliq_borc);
                number=findViewById(R.id.mobile_nomre);
                dogum_tarixi=findViewById(R.id.dogumtarxi);
                xarici_passportun_nomrsi=findViewById(R.id.xarici_passportnomresi);
                milliyeti=findViewById(R.id.Milliyeti);
                unvan=findViewById(R.id.adress);
                musteri_gmail=findViewById(R.id.musteri_gmail);
                xarici_paspoert_baslama=findViewById(R.id.xarici_passport_baslama);
                xarici_passport_bitme=findViewById(R.id.xarici_passport_bitme);
                anket=findViewById(R.id.anket_melumati);




         intent23=getIntent();

        username.setText(intent23.getStringExtra("name"));
        sexsiyyet.setText(intent23.getStringExtra("vesiqe"));
        muraciet_tarixi.setText(intent23.getStringExtra("muraciettarixi"));
        muqavilenin_tarixi.setText(intent23.getStringExtra("muqavilenintarixi"));
        muqavilenin_nomresi.setText(intent23.getStringExtra("muqavilenin_nomresi"));
        olke.setText(intent23.getStringExtra("olke"));
        sirket.setText(intent23.getStringExtra("sirket"));
        vakansiya_date.setText(intent23.getStringExtra("vakansiya_date"));
        odenilecek_mebleg.setText(intent23.getStringExtra("odenilecek_mebleg"));
        qaliq_borc.setText(intent23.getStringExtra("qaliq_borc"));
        ilkin_odenis.setText(intent23.getStringExtra("ilkin_odenis"));
        number.setText(intent23.getStringExtra("number"));
        xarici_passportun_nomrsi.setText(intent23.getStringExtra("xarici_paspport"));
        dogum_tarixi.setText(intent23.getStringExtra("dogum"));
        milliyeti.setText(intent23.getStringExtra("millliyet"));
        unvan.setText(intent23.getStringExtra("unvan12"));
        musteri_gmail.setText(intent23.getStringExtra("gmail"));
        xarici_paspoert_baslama.setText(intent23.getStringExtra("xaricbaslama"));
        xarici_passport_bitme.setText(intent23.getStringExtra("xaricbitme"));
        anket.setText(intent23.getStringExtra("anket123"));






        int value=intent23.getIntExtra("salam",0);
        System.out.println(value);
         switch (value){

             case 1:
                 setdelete();
                 break;

             case 2:
                 setUpdate();
                 break;
             case 3:
                 setadddata();
                 break;

         }







    }

    public  void setUpdate(){

             button.setVisibility(View.GONE);
             delete.setVisibility(View.GONE);
             update.setVisibility(View.VISIBLE);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userNAme=username.getText().toString();
                String sexsiyyet2=sexsiyyet.getText().toString();
                String muraciettarixi=muraciet_tarixi.getText().toString();
                String muqavivileninnomresi=muqavilenin_nomresi.getText().toString();
                String muuqavilenintarixi=muqavilenin_tarixi.getText().toString();
                System.out.println(muuqavilenintarixi);
                String olkee=olke.getText().toString();
                String sirkett=sirket.getText().toString();
                String vakansiyadate1=vakansiya_date.getText().toString();
                String odenilecek_mebleg2=odenilecek_mebleg.getText().toString();
                String ilkiniodenis=ilkin_odenis.getText().toString();
                String qaliqborc1=qaliq_borc.getText().toString();
                String number1=number.getText().toString();
                String dogum=dogum_tarixi.getText().toString();
                String xarici=xarici_passportun_nomrsi.getText().toString();
                String milliyeti1=milliyeti.getText().toString();
                String unvan1=unvan.getText().toString();
                String gmail123=musteri_gmail.getText().toString();
                String xarici_PASPORT_BITME=xarici_passport_bitme.getText().toString();
                String xaricipassport_bbaslama=xarici_paspoert_baslama.getText().toString();
                String ankett=anket.getText().toString();

                generalinfo geninfo=new generalinfo(userNAme,sexsiyyet2,muuqavilenintarixi,muraciettarixi,muqavivileninnomresi,olkee,sirkett,vakansiyadate1,odenilecek_mebleg2,ilkiniodenis,qaliqborc1,number1,dogum,xarici,milliyeti1,unvan1,gmail123,xaricipassport_bbaslama,xarici_PASPORT_BITME,ankett);
                String ids=intent23.getStringExtra("id");

                firestore.collection("infoafterreg").document(ids).update("username",geninfo.getUsername(),
                        "sexsiyyet",geninfo.getSexsiyyet(),"muraciet_tarixi",geninfo.getMuraciet_tarixi(),"muqavilenin_nomresi",
                        geninfo.getMuqavilenin_nomresi(),"muqavilenin_tarixi",geninfo.getMuqavilenin_tarixi(),"gedeceyi_olke",geninfo.getOlke(),"qebul_eden_sirket",geninfo.getSirket(),"vakansiya_ve_date",geninfo.getVakansiya_date(),"odenilecek_mebleg",geninfo.getOdenilecek_mebleg(),"ilkin_odenis",geninfo.getIlkin_odenis(),"qaliq_borc",geninfo.getQaliq_borc(),"phone_number",geninfo.getNumber(),"dogum_date",geninfo.getDogum_tarixi(),"xarici_passportunun_nomresi",geninfo.getXarici_passportun_nomrsi(),"milliyeti",geninfo.getMilliyeti(),"unvanı",geninfo.getUnvan(),"musteri_gmail",geninfo.getGmail(),"xarici_passport_baslama",geninfo.getXaricipassport_baslama(),"xarici_passport_bitme",geninfo.getXaricipassport_bitme(),"anketi",geninfo.getAnket()
                ).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        finish();
                        Toast.makeText(enterofuserinfo.this, "product updated", Toast.LENGTH_SHORT).show();
                         Intent intent=new Intent(enterofuserinfo.this,navigation_activity.class);
                         intent.putExtra("navigation",1);
                         startActivity(intent);

                    }
                });

            }
        });
    }



    public void setdelete(){
        update.setVisibility(View.GONE);
        button.setVisibility(View.GONE);
        username.setEnabled(false);
        sexsiyyet.setEnabled(false);
        muraciet_tarixi.setEnabled(false);
        muqavilenin_tarixi.setEnabled(false);
        muqavilenin_nomresi.setEnabled(false);
        olke.setEnabled(false);
        sirket.setEnabled(false);
        vakansiya_date.setEnabled(false);
        odenilecek_mebleg.setEnabled(false);
        qaliq_borc.setEnabled(false);
        ilkin_odenis.setEnabled(false);
        number.setEnabled(false);
        xarici_passportun_nomrsi.setEnabled(false);
        dogum_tarixi.setEnabled(false);
        milliyeti.setEnabled(false);
        unvan.setEnabled(false);
        musteri_gmail.setEnabled(false);




        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder alert=new AlertDialog.Builder(enterofuserinfo.this);
                alert.setCancelable(false);
                alert.setTitle("Warning!!!");
                alert.setMessage("datani silmeye əminsiz?");

                alert.setPositiveButton("delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String id=intent23.getStringExtra("id");

                        firestore.collection("infoafterreg").document(id).delete().addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Intent intent=new Intent(enterofuserinfo.this,navigation_activity.class);
                                intent.putExtra("navigation",1);

                                startActivity(intent);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                finish();
                                Toast.makeText(enterofuserinfo.this,"data deleted",Toast.LENGTH_SHORT).show();
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

public  void setadddata(){


        update.setVisibility(View.GONE);
        delete.setVisibility(View.GONE);
        button.setVisibility(View.VISIBLE);




    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String gmail=musteri_gmail.getText().toString();
            String userNAme=username.getText().toString();
            String sexsiyyet2=sexsiyyet.getText().toString();
            String muraciettarixi=muraciet_tarixi.getText().toString();
            String muqavivileninnomresi=muqavilenin_nomresi.getText().toString();
            String muuqavilenintarixi=muqavilenin_tarixi.getText().toString();
            String olkee=olke.getText().toString();
            String sirkett=sirket.getText().toString();
            String vakansiyadate1=vakansiya_date.getText().toString();
            String odenilecek_mebleg2=odenilecek_mebleg.getText().toString();
            String ilkiniodenis=ilkin_odenis.getText().toString();
            String qaliqborc1=qaliq_borc.getText().toString();
            String number1=number.getText().toString();
            String dogum=dogum_tarixi.getText().toString();
            String xarici=xarici_passportun_nomrsi.getText().toString();
            String milliyeti1=milliyeti.getText().toString();
            String unvan1=unvan.getText().toString();
            String xaricbaslama=xarici_paspoert_baslama.getText().toString();
            String xaricibitme=xarici_passport_bitme.getText().toString();
            String anket12=anket.getText().toString();


            HashMap<String,Object>  objectHashMap=new HashMap<>();
            objectHashMap.put("username",userNAme);
            objectHashMap.put("musteri_gmail",gmail);
            objectHashMap.put("sexsiyyet",sexsiyyet2);
            objectHashMap.put("muraciet_tarixi",muraciettarixi);
            objectHashMap.put("muqavilenin_nomresi",muqavivileninnomresi);
            objectHashMap.put("muqavilenin_tarixi",muuqavilenintarixi);
            objectHashMap.put("gedeceyi_olke",olkee);
            objectHashMap.put("qebul_eden_sirket",sirkett);
            objectHashMap.put("vakansiya_ve_date",vakansiyadate1);
            objectHashMap.put("odenilecek_mebleg",odenilecek_mebleg2);
            objectHashMap.put("ilkin_odenis",ilkiniodenis);
            objectHashMap.put("qaliq_borc",qaliqborc1);
            objectHashMap.put("phone_number",number1);
            objectHashMap.put("dogum_date",dogum);
            objectHashMap.put("xarici_passportunun_nomresi",xarici);
            objectHashMap.put("milliyeti",milliyeti1);
            objectHashMap.put("unvanı",unvan1);
            objectHashMap.put("xarici_passport_baslama",xaricbaslama);
            objectHashMap.put("xarici_passport_bitme",xaricibitme);
            objectHashMap.put("anketi",anket12);



            firestore.collection("infoafterreg").add(objectHashMap).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                @Override
                public void onSuccess(DocumentReference documentReference) {

                    Intent intent=new Intent(enterofuserinfo.this,navigation_activity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.putExtra("navigation",1);

                    startActivity(intent);
                    finish();

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(enterofuserinfo.this,e.getLocalizedMessage(),Toast.LENGTH_SHORT).show();
                }
            });
        }
    });
}


    @Override
    public void onBackPressed() {
        Intent intent=new Intent(enterofuserinfo.this,navigation_activity.class);
        intent.putExtra("navigation",1);
        startActivity(intent);
        finish();
    }
}