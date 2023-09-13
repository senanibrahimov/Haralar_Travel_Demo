package com.sananibrahimov.adding_new_column;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class user_musteri extends AppCompatActivity {
    FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_musteri);
        Intent intent=getIntent();
        firebaseUser=FirebaseAuth.getInstance().getCurrentUser();

        int  musteri=intent.getIntExtra("musteri",0);

        switch (musteri){
            case 1:
                vizainfomusteri();
                break;
            case 2:
                musteriinfo();

                break;

        }



    }


    @Override
    public void onBackPressed() {
        Intent intent=new Intent(user_musteri.this,MainActivity.class);

          if (firebaseUser.getEmail().equals("qəzənfər.aloyev@gmail.com")){
              intent.putExtra("port","dns");
          }else {
              intent.putExtra("port","musteri");
          }

          intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();

        super.onBackPressed();
    }

    private  void  musteriinfo(){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.musteriselfmelumat,new Musteri_user_info_fragment()).commit();

    }

    private  void vizainfomusteri(){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.musteriselfmelumat,new MusteriVizafragment_info()).commit();

    }





}