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

import java.util.HashMap;
import java.util.Map;


public class MusteriVizafragment_info extends Fragment {



     FirebaseFirestore firestore;
     FirebaseUser firebaseUser;
    EditText name,xarici_passport_viza,Apostil,Apostil_tercume,sekil,vesiqe_sureti,is_deveti,qalacagi_yerin_arayisi,sigorta,sengen_vizasi,ucusbronu,viza_rusumu,sefirlik_muraciet_tarix,sefirliye_gorus_tarrix,senedlerin_neticesi,Apostil_tercumeden_geldiyi_vaxt,apostil_baslama_tarixi,apostil_bitme_tarixi,is_devetine_muraciet,is_devetinin_baslama_tarixi,is_devetinin_bitme_tarixi,Sigortanin_baslama_tarixi,sigortanin_bitme_tarixi,Sigortaya_muraciet_tarix;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_musteri_vizainfo, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        Intent intent=requireActivity().getIntent();
        String username21=intent.getStringExtra("usernamemusteri");
             firebaseUser= FirebaseAuth.getInstance().getCurrentUser();
             String gmail=firebaseUser.getEmail();
        name=view.findViewById(R.id.musteri_visa_username);
        xarici_passport_viza=view.findViewById(R.id.musteri_visaadd_xaricipassport);
        Apostil=view.findViewById(R.id.musteri_apostil);
        Apostil_tercume=view.findViewById(R.id.musteri_apostil_tercume);
        vesiqe_sureti=view.findViewById(R.id.musteri_sexsiyyet_vesiqe_sureti);
        sekil=view.findViewById(R.id.musteri_sekil_visa);
        is_deveti=view.findViewById(R.id.musteri_isdeveti);
        qalacagi_yerin_arayisi=view.findViewById(R.id.musteri_visa_arayisi);
        sigorta=view.findViewById(R.id.musteri_sigorta);
        sengen_vizasi=view.findViewById(R.id.musteri_sengen_vizasi);
        ucusbronu=view.findViewById(R.id.musteri_ucus_bronu);
        viza_rusumu=view.findViewById(R.id.musteri_viza_rusumu);
        sefirlik_muraciet_tarix=view.findViewById(R.id.musteri_sefirliye_muraciet_olunan_tarix);
        sefirliye_gorus_tarrix=view.findViewById(R.id.musteri_sefirlik_teyin_olunanvaxt);
        senedlerin_neticesi=view.findViewById(R.id.musteri_musteri_viza_netice);
        Apostil_tercumeden_geldiyi_vaxt=view.findViewById(R.id.visamusteri_apostil_tercumeden_geldiyi_vaxt);
        apostil_baslama_tarixi=view.findViewById(R.id.visamusterii_apostilinbaslma_tarixi);
        apostil_bitme_tarixi=view.findViewById(R.id.visamusteriiiiiiii_apostil_bitme_tarix);
        is_devetine_muraciet=view.findViewById(R.id.visamusterii_isdevetine_muraciet);
        is_devetinin_baslama_tarixi=view.findViewById(R.id.visamusteri_isdevetinin_baslama_tarixi);
        is_devetinin_bitme_tarixi=view.findViewById(R.id.visamusteri_isdevetinin_bitme_tarixi);
        Sigortaya_muraciet_tarix=view.findViewById(R.id.visamusterii_sigortaya_muraciet_olunan_tarix);
        sigortanin_bitme_tarixi=view.findViewById(R.id.visamusteri_sigorta_bitme_tarixi);
        Sigortanin_baslama_tarixi=view.findViewById(R.id.visamusteri_sigorta_baslama_tarixi);


        firestore=FirebaseFirestore.getInstance();


        firestore.collection("vizaprosuderi").whereEqualTo("gmail",gmail).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                for (DocumentSnapshot snapshot:value.getDocuments()){

                    Map<String,Object> hashMap=snapshot.getData();
                    String usename= (String) hashMap.get("Username_visa");
                    String Apostil3= (String) hashMap.get("Apostil");
                    String Arayis= (String) hashMap.get("Arayis");
                    String Vesiqe_sureti3= (String) hashMap.get("Vesiqe_sureti");
                    String Xarici_passport= (String) hashMap.get("Xarici passport");
                    String is_deveti12= (String) hashMap.get("is_deveti");
                    String sefirliye_muraciet_olunan_tarix= (String) hashMap.get("sefirliye_muraciet_olunan tarix");
                    String sefirliye_teyin_olunan_vaxt= (String) hashMap.get("sefirliye_teyin_olunan_vaxt");
                    String sekil12= (String) hashMap.get("sekil");
                    String senedlerin_neticesi12= (String) hashMap.get("senedlerin_neticesi");
                    String sengen_vizasi_form= (String) hashMap.get("sengen_vizasi_form");
                    String sigorta12 = (String) hashMap.get("sigorta");
                    String ucus_bronu12= (String) hashMap.get("ucus_bronu");
                    String viza_rusumu12= (String) hashMap.get("viza_rusumu");
                    String apostiltercumedengelenvaxt1=(String)hashMap.get("Apostil_tercumeden_geldiyi_vaxt");
                    String Apostil_bitme_tarixi=(String)hashMap.get("Apostil_bitme_tarixi");
                    String Apostil_baslama_tarixi=(String)hashMap.get("Apostil_baslama_tarixi");
                    String Isdevetine_muraciet=(String)hashMap.get("Isdevetine_muraciet");
                    String isdevetinin_baslama_tarixi=(String)hashMap.get("isdevetinin_baslama_tarixi");
                    String isdevetinin_bitme_tarixi=(String)hashMap.get("isdevetinin_bitme_tarixi");
                    String sigortaya_muraciet=(String)hashMap.get("sigortaya_muraciet");
                    String sigortanin_baslama_tarixi=(String)hashMap.get("sigortanin_baslama_tarixi");
                    String sigortanin_bitme_tarixi1=(String)hashMap.get("sigortanin_bitme_tarixi");
                    String Apostil_tercume1= (String) hashMap.get("Apostil_tercume");


                    name.setText(usename);
                    xarici_passport_viza.setText(Xarici_passport);
                    Apostil.setText(Apostil3);
                    vesiqe_sureti.setText(Vesiqe_sureti3);
                    sekil.setText(sekil12);
                    is_deveti.setText(is_deveti12);
                    qalacagi_yerin_arayisi.setText(Arayis);
                    sigorta.setText(sigorta12);
                    sengen_vizasi.setText(sengen_vizasi_form);
                    ucusbronu.setText(ucus_bronu12);
                    viza_rusumu.setText(viza_rusumu12);
                    sefirlik_muraciet_tarix.setText(sefirliye_muraciet_olunan_tarix);
                    sefirliye_gorus_tarrix.setText(sefirliye_teyin_olunan_vaxt);
                    senedlerin_neticesi.setText(senedlerin_neticesi12);
                    Apostil_tercume.setText(Apostil_tercume1);
                    Apostil_tercumeden_geldiyi_vaxt.setText(apostiltercumedengelenvaxt1);
                    apostil_baslama_tarixi.setText(Apostil_baslama_tarixi);
                    apostil_bitme_tarixi.setText(Apostil_bitme_tarixi);
                    is_devetine_muraciet.setText(Isdevetine_muraciet);
                    is_devetinin_baslama_tarixi.setText(isdevetinin_baslama_tarixi);
                    is_devetinin_bitme_tarixi.setText(isdevetinin_bitme_tarixi);
                    Sigortaya_muraciet_tarix.setText(sigortaya_muraciet);
                    Sigortanin_baslama_tarixi.setText(sigortanin_baslama_tarixi);
                    sigortanin_bitme_tarixi.setText(sigortanin_bitme_tarixi1);

                }
            }
        });
    }
}