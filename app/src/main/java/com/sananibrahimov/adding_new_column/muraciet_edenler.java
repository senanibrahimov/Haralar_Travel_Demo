package com.sananibrahimov.adding_new_column;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Map;

public class muraciet_edenler extends AppCompatActivity {

     ArrayList<muraciet_data> vakansiyaya_muraciet;
     FirebaseFirestore firestore;
     RecyclerView muraciet_reycelview;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muraciet_edenler);
        vakansiyaya_muraciet=new ArrayList<>();
          muraciet_reycelview=findViewById(R.id.muraciet_edenler_reycelview);
          muraciet_reycelview.setLayoutManager(new LinearLayoutManager(this));
        muracietadapter muracietadapter1=new muracietadapter(vakansiyaya_muraciet);


          firestore=FirebaseFirestore.getInstance();

          firestore.collection("muracietedenler").orderBy("vakansiyaya_muaciet_tarix", Query.Direction.DESCENDING).addSnapshotListener(new EventListener<QuerySnapshot>() {
              @Override
              public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                       vakansiyaya_muraciet.clear();
                 for (DocumentSnapshot documentSnapshot:value.getDocuments()){

                     Map map=documentSnapshot.getData();
                     String Name= (String) map.get("Name");String surname=(String) map.get("Surname");
                     String gmail=(String) map.get("gmail");
                     String Vakansiya=(String) map.get("Vakansiya");
                     String phone=(String) map.get("phone");
                     String vakansiay_melumat=(String)map.get("text_melumat");
                     Boolean vkansiya_durum=(Boolean)map.get("request");


                      muraciet_data muraciet_data=new muraciet_data(Name,gmail,surname,phone,Vakansiya,vakansiay_melumat,vkansiya_durum);
                        muraciet_data.setId(documentSnapshot.getId());
                      vakansiyaya_muraciet.add(muraciet_data);

              }
                 muracietadapter1.notifyDataSetChanged();
          }});

        muraciet_reycelview.setAdapter(muracietadapter1);







          }

          public   void updatedata(int position){



          }
}