package com.sananibrahimov.adding_new_column;

import android.annotation.SuppressLint;
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
import android.widget.Toast;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class fragment_admin_qebulsenedleri extends Fragment {

    RecyclerView reycelview;
    FirebaseFirestore firestore;
    ArrayList<generalinfo> arrayList;
    Button gotonext;
    adapterinfo adapterinfo2;
    SearchView searchView;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_admin_qebulsenedleri, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        reycelview=view.findViewById(R.id.usercontract);
        firestore=FirebaseFirestore.getInstance();
        gotonext=view.findViewById(R.id.brrr);
        searchView=view.findViewById(R.id.searcheer);

        getdatainfo();
        gotonext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(requireContext(),enterofuserinfo.class);
                intent.putExtra("salam",3);
                startActivity(intent);
                requireActivity().finish();
            }
        });
        arrayList=new ArrayList();
        reycelview.setLayoutManager(new LinearLayoutManager(requireContext()));

         adapterinfo2=new adapterinfo(arrayList);
          reycelview.setAdapter(adapterinfo2);


          searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
              @Override
              public boolean onQueryTextSubmit(String s) {
                  return false;
              }

              @Override
              public boolean onQueryTextChange(String s) {



                  setSearchView(s);


                  return false;
              }
          });
    }



    public void getdatainfo(){

        firestore.collection("infoafterreg").addSnapshotListener(new EventListener<QuerySnapshot>() {

            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {


                if (error!=null){
                    Toast.makeText(requireContext(),error.getLocalizedMessage(),Toast.LENGTH_SHORT).show();

                }
                if (value!=null){
                    for (DocumentSnapshot documentSnapshot:value.getDocuments()){
                        Map<String,Object> hashMap=  documentSnapshot.getData();


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
                        String gmsil=(String) hashMap.get("musteri_gmail");
                        String xaricipassport_bas=(String)hashMap.get("xarici_passport_baslama");
                        String xarici_bbittme=(String)hashMap.get("xarici_passport_bitme");
                        String ankettttt=(String)hashMap.get("anketi");



                        generalinfo generalinfo2=new generalinfo(username1,idvesiq,muuqavilenintarixi,muraciettarixi,muqavivileninnomresi,olkee,sirkett,vakansiyadate1,odenilecek_mebleg2,ilkiniodenis,qaliqborc1,number1,dogum,xarici,milliyeti1,unvan1,gmsil,xaricipassport_bas,xarici_bbittme,ankettttt);
                        generalinfo2.setId(documentSnapshot.getId());

                         arrayList.add(generalinfo2);
                    }
                    adapterinfo2.notifyDataSetChanged();
                }
            }
        });
    }

    public  void setSearchView(String text){

        if (!(text.trim().isEmpty())){

        ArrayList<generalinfo> list=new ArrayList<>();

        for (generalinfo gen:arrayList) {

            if (gen.getUsername().toLowerCase(Locale.ROOT).contains(text.toLowerCase(Locale.ROOT))) {
                list.add(gen);

            }


        }
            System.out.println(list.size());
            adapterinfo2.filter(list);




        }else{
            adapterinfo2.filter(arrayList);
            System.out.println(            arrayList.size()
            );
        }







    }
}