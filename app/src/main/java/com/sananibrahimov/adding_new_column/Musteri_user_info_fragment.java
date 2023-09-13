package com.sananibrahimov.adding_new_column;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Map;

public class Musteri_user_info_fragment extends Fragment {

  FirebaseFirestore firestore;
  EditText username,muraciet_tarixi,gedeceyi_olke,muqavile_nomresi,mobil_nomre,dogum_tarixi,muqaviletarixi,odenileckmebleg,ilkinodenis,vakansiyasontarix,qaliqborc,qebuledensirket,X_passportum,millliyeti,adressi,Svesiqenomresi,xarici_bitmeee,xarici_baslma,anketttt;
  FirebaseUser firbaseUser;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_musteri_user_info_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

           firbaseUser=FirebaseAuth.getInstance().getCurrentUser();

             username=view.findViewById(R.id.musterifragment_user_name);
        muraciet_tarixi=view.findViewById(R.id.musterifragment_muraciet_vaxti);
        gedeceyi_olke=view.findViewById(R.id.musterifragment_gedeceyi_olke);
        muqavile_nomresi=view.findViewById(R.id.musterifragment_muqavile_nomresi);
        mobil_nomre=view.findViewById(R.id.musterifragment_mobile_nomre);
        dogum_tarixi=view.findViewById(R.id.musterifragment_dogumtarxi);
        muqaviletarixi=view.findViewById(R.id.musterifragment_muqavile_tarixi);
        odenileckmebleg=view.findViewById(R.id.musterifragment_odenilecek_mebleg);
        ilkinodenis=view.findViewById(R.id.musterifragment_ilkin_odenis);
        vakansiyasontarix=view.findViewById(R.id.musterifragment_vakansiya_date);
        qaliqborc=view.findViewById(R.id.musterifragment_qaliq_borc);
        qebuledensirket=view.findViewById(R.id.musterifragment_qebul_eden_sirket);
        X_passportum=view.findViewById(R.id.musterifragment_xarici_passportnomresi);
        millliyeti=view.findViewById(R.id.musterifragment_Milliyeti);
        adressi=view.findViewById(R.id.musterifragment_adress);
        Svesiqenomresi=view.findViewById(R.id.musterifragment_sexsiyyetvesiqesi);
        xarici_baslma=view.findViewById(R.id.musteri_xarici_passport_baslama);
        xarici_bitmeee=view.findViewById(R.id.musteri_xarici_passport_bitme);
        anketttt=view.findViewById(R.id.musteri_anket_melumati);




        username.setEnabled(false);
        muraciet_tarixi.setEnabled(false);
        gedeceyi_olke.setEnabled(false);
        muqavile_nomresi.setEnabled(false);
        mobil_nomre.setEnabled(false);
        dogum_tarixi.setEnabled(false);
        muqaviletarixi.setEnabled(false);
        odenileckmebleg.setEnabled(false);
        ilkinodenis.setEnabled(false);
        vakansiyasontarix.setEnabled(false);
        qaliqborc.setEnabled(false);
        qebuledensirket.setEnabled(false);
        X_passportum.setEnabled(false);
        millliyeti.setEnabled(false);
        adressi.setEnabled(false);
        Svesiqenomresi.setEnabled(false);
        xarici_baslma.setEnabled(false);
        xarici_bitmeee.setEnabled(false);
        anketttt.setEnabled(false);






        firestore=FirebaseFirestore.getInstance();
        firbaseUser=FirebaseAuth.getInstance().getCurrentUser();
        Intent intent=requireActivity().getIntent();
         String username123=intent.getStringExtra("usernamemusteri");
        System.out.println(username123);


        firestore.collection("infoafterreg").whereEqualTo("musteri_gmail",firbaseUser.getEmail()).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                if (value!=null){

                    for (DocumentSnapshot snapshot:value.getDocuments()){

                       Map<String,Object> hashMap= snapshot.getData();

                        String username1= (String) hashMap.get("username");
                        String idvesiq=(String) hashMap.get("sexsiyyet") ;
                        String muuqavilenintarixi=(String) hashMap.get("muqavilenin_tarixi");
                        String muraciettarixi=(String) hashMap.get("muraciet_tarixi");
                        String muqavivileninnomresi=(String) hashMap.get("muqavilenin_nomresi");
                        String olkee=(String)hashMap.get("gedeceyi_olke");
                        String sirkett=(String)hashMap.get("qebul_eden_sirket");
                        String vakansiyadate1=(String) hashMap.get("vakansiya_ve_date") ;
                        String odenilecek_mebleg2=(String) hashMap.get("odenilecek_mebleg");
                        String ilkiniodenis=(String) hashMap.get("ilkin_odenis");
                        String qaliqborc1=(String) hashMap.get("qaliq_borc") ;
                        String number1=(String) hashMap.get("phone_number");
                        String dogum=(String)hashMap.get("dogum_date");
                        String xarici=(String) hashMap.get("xarici_passportunun_nomresi");
                        String milliyeti1=(String) hashMap.get("milliyeti");
                        String unvan1=(String) hashMap.get("unvanı");
                        String xariccci_baslama=(String) hashMap.get("xarici_passport_baslama");;
                        String xarici_bitme=(String) hashMap.get("xarici_passport_bitme");;
                        String ankkettt=(String) hashMap.get("anketi");
                        username.setText(username1);
                        muraciet_tarixi.setText(muraciettarixi);
                        gedeceyi_olke.setText(olkee);
                        muqavile_nomresi.setText(muqavivileninnomresi);
                        mobil_nomre.setText(number1);
                        dogum_tarixi.setText(dogum);
                        muqaviletarixi.setText(muuqavilenintarixi);
                        odenileckmebleg.setText(odenilecek_mebleg2);
                        ilkinodenis.setText(ilkiniodenis);
                        vakansiyasontarix.setText(vakansiyadate1);
                        qaliqborc.setText(qaliqborc1);
                        qebuledensirket.setText(sirkett);
                        X_passportum.setText(xarici);
                        millliyeti.setText(milliyeti1);
                        adressi.setText(unvan1);
                        Svesiqenomresi.setText(idvesiq);
                        xarici_baslma.setText(xariccci_baslama);
                        xarici_bitmeee.setText(xarici_bitme);
                        anketttt.setText(ankkettt);
                    }
                }
            }
        });
    }

}