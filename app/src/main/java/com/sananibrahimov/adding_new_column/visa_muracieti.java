package com.sananibrahimov.adding_new_column;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SearchView;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;

public class visa_muracieti extends Fragment {

    RecyclerView recyclerView;
    ArrayList<visaclass>arrayList;
        FirebaseFirestore firestore;
        Button addvizabuuton;
    visa_adapter visa_adapter1;
    SearchView searchView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_visa_muracieti, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        addvizabuuton=view.findViewById(R.id.addvisauser);
        firestore=FirebaseFirestore.getInstance();
        searchView=view.findViewById(R.id.visasearchview);


        arrayList=new ArrayList<>();
        recyclerView=view.findViewById(R.id.visa_reycelview);

        getdata();
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
         visa_adapter1=new visa_adapter(arrayList);
        recyclerView.setAdapter(visa_adapter1);
        addvizabuuton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(requireContext(),visaprosuderi.class);
                intent.putExtra("visaprosdureri",3);
                startActivity(intent);
                requireActivity().finish();
            }
        });

   searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
       @Override
       public boolean onQueryTextSubmit(String s) {
           return false;
       }

       @Override
       public boolean onQueryTextChange(String s) {

           searchvizuser(s);
           return false;
       }
   });





    }

    private void getdata() {

        firestore.collection("vizaprosuderi").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {


                if (value!=null){

                    for (DocumentSnapshot snapshot:value.getDocuments()){

                        Map<String,Object> hashMap=snapshot.getData();

                        String username= (String) hashMap.get("Username_visa");
                        String Apostil= (String) hashMap.get("Apostil");
                        String Apostil_tercume= (String) hashMap.get("Apostil_tercume");
                        String Arayis= (String) hashMap.get("Arayis");
                        String Vesiqe_sureti= (String) hashMap.get("Vesiqe_sureti");
                        String Xaricipassport= (String) hashMap.get("Xarici passport");
                        String is_deveti= (String) hashMap.get("is_deveti");
                        String sefirliye_muraciet_olunantarix= (String) hashMap.get("sefirliye_muraciet_olunan tarix");
                        String sefirliye_teyin_olunan_vaxt= (String) hashMap.get("sefirliye_teyin_olunan_vaxt");
                        String sekil= (String) hashMap.get("sekil");
                        String senedlerin_neticesi= (String) hashMap.get("senedlerin_neticesi");
                        String sengen_vizasi_form= (String) hashMap.get("sengen_vizasi_form");
                        String sigorta= (String) hashMap.get("sigorta");
                        String ucus_bronu= (String) hashMap.get("ucus_bronu");
                        String viza_rusumu= (String) hashMap.get("viza_rusumu");
                        String vixagmail34=(String) hashMap.get("gmail");
                        String apostiltercumedengelenvaxt=(String)hashMap.get("Apostil_tercumeden_geldiyi_vaxt");
                        String Apostil_bitme_tarixi=(String)hashMap.get("Apostil_bitme_tarixi");
                        String Apostil_baslama_tarixi=(String)hashMap.get("Apostil_baslama_tarixi");
                        String Isdevetine_muraciet=(String)hashMap.get("Isdevetine_muraciet");
                        String isdevetinin_baslama_tarixi=(String)hashMap.get("isdevetinin_baslama_tarixi");
                        String isdevetinin_bitme_tarixi=(String)hashMap.get("isdevetinin_bitme_tarixi");
                        String sigortaya_muraciet=(String)hashMap.get("sigortaya_muraciet");
                        String sigortanin_baslama_tarixi=(String)hashMap.get("sigortanin_baslama_tarixi");
                        String sigortanin_bitme_tarixi=(String)hashMap.get("sigortanin_bitme_tarixi");
                        String rengk=(String)hashMap.get("reng");



                        visaclass visaclass12=new visaclass(username,Xaricipassport,Apostil,sekil,Vesiqe_sureti,is_deveti,Arayis,sigorta,sengen_vizasi_form,ucus_bronu,viza_rusumu,sefirliye_muraciet_olunantarix,sefirliye_teyin_olunan_vaxt,senedlerin_neticesi,vixagmail34,Apostil_tercume,apostiltercumedengelenvaxt,Apostil_baslama_tarixi,Apostil_bitme_tarixi,Isdevetine_muraciet,isdevetinin_baslama_tarixi,isdevetinin_bitme_tarixi,sigortaya_muraciet,sigortanin_bitme_tarixi,sigortanin_baslama_tarixi,rengk);
                                 visaclass12.setId(snapshot.getId());
                        arrayList.add(visaclass12);


                    }
                    visa_adapter1.notifyDataSetChanged();
                }
            }
        });
    }

    private  void searchvizuser(String string){

          ArrayList<visaclass> arrayListwe=new ArrayList<>();
            for (visaclass visaAdapter123:arrayList){

                if (visaAdapter123.getNameofvisauser().toLowerCase(Locale.ROOT).contains(string.toLowerCase(Locale.ROOT))){
                    arrayListwe.add(visaAdapter123);
                }

            }
            visa_adapter1.funfiletlista(arrayListwe);

    }
}