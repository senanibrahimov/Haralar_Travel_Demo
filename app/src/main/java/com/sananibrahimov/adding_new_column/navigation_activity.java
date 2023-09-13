package com.sananibrahimov.adding_new_column;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

public class navigation_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        Intent intent=getIntent();
        int id=intent.getIntExtra("navigation",0);
          switch (id){
              case 1:
                  senedlerin_qebulu();
                  break;
              case 2:
                  visa_muracieti1();
                  break;


          }

    }

    public void senedlerin_qebulu(){

        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame2,new fragment_admin_qebulsenedleri()).commit();

    }

    public void visa_muracieti1(){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame2,new visa_muracieti()).commit();

    }

}