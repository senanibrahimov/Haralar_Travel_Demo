package com.sananibrahimov.adding_new_column;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.SignInMethodQueryResult;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class Register extends AppCompatActivity {
     EditText gamil,Name,password,repassword,Surname,phone;
      Button register;
      FirebaseFirestore firestore;
      FirebaseAuth auth;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

         gamil=findViewById(R.id.gmail);
         password=findViewById(R.id.password);
         Name=findViewById(R.id.name_register);
         Surname=findViewById(R.id.surname_register);
         phone=findViewById(R.id.phone_register);
         repassword=findViewById(R.id.copyofparol);
         register=findViewById(R.id.register_button);
         firestore=FirebaseFirestore.getInstance();
         auth=FirebaseAuth.getInstance();







         register.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {


                 if (!gamil.getText().toString().trim().contains("@") || gamil.getText().toString().trim().length()<10){

                     gamil.setError("zehmet olmasa emailiniz duz formatda daxil ederdiz");
                 }
                 else if(password.getText().toString().trim().length()<=5){
                     password.setError("Parolun uzunlugu 6 ve ya 6-dan yuxari olmalidi");
                 }
                 else if (Surname.getText().toString().trim().length()<4){
                     Surname.setError("Soyadın uzunlugu 5  ve 5 dan yuxari olmalidi");
                 }
                 else if (Name.getText().toString().trim().length()<2){
                     Name.setError("Isdifadeci adinin uzunlugu 6  ve 6 dan yuxari olmalidi");
                 }
                 else if (!password.getText().toString().trim().equals(repassword.getText().toString().trim())){
                     repassword.setError(" parollar bir birine uygunlasmir");
                 }
                 else{
                     registertration();
                 }

             }
         });

    }
    @Override
    public void onBackPressed() {
        Intent intent=new Intent(Register.this,login_activity.class);
        startActivity(intent);
      intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP) ;
        finish();
    }

    private  void registertration(){

        ProgressDialog progressDialog=new ProgressDialog(Register.this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();
        progressDialog.setCancelable(true);

        String Name1=Name.getText().toString().trim();
        String surname1=Surname.getText().toString().trim();
        String phone1=phone.getText().toString().trim();
        String mail=gamil.getText().toString().trim();
        String pasword1=password.getText().toString().trim();

        auth.fetchSignInMethodsForEmail(mail).addOnSuccessListener(new OnSuccessListener<SignInMethodQueryResult>() {
            @Override
            public void onSuccess(SignInMethodQueryResult signInMethodQueryResult) {
                boolean refence=signInMethodQueryResult.getSignInMethods().isEmpty();
                if (refence){
                    auth.createUserWithEmailAndPassword(mail,pasword1).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            if(authResult!=null){

                                FirebaseUser user= auth.getCurrentUser();



                                HashMap<String,Object> hashMap=new HashMap<>();
                                hashMap.put("Name",Name1);
                                hashMap.put("Surname",surname1);
                                hashMap.put("phone",phone1);
                                hashMap.put("gmail",mail);
                                hashMap.put("password",pasword1);
                                hashMap.put("userid",user.getUid());

                                firestore.collection("girismelumatlari").add(hashMap).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                    @Override
                                    public void onSuccess(DocumentReference documentReference) {
                                        Intent intent=new Intent(Register.this,MainActivity.class);
                                         intent.putExtra("port","musteri");
                                        progressDialog.dismiss();
                                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                        startActivity(intent);
                                        finish();
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        progressDialog.dismiss();
                                        Toast.makeText(Register.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                });

                            }
                        }
                    });
                }
                else{

                    Toast.makeText(Register.this, "daha evvel bu hesabla qeyydiyatdan kecilib", Toast.LENGTH_SHORT).show();
                     progressDialog.dismiss();
                }
            }
        });


    }
}