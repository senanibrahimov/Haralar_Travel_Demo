package com.sananibrahimov.adding_new_column;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.SignInMethodQueryResult;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Map;

public class login_activity extends AppCompatActivity {
     TextView register,forgetpassword;
     FirebaseAuth auth;
     EditText gmail,parol;
     Button login;
     FirebaseUser user;
     FirebaseFirestore firestore;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        user = FirebaseAuth.getInstance().getCurrentUser();
        firestore=FirebaseFirestore.getInstance();
        System.out.println(user+"sss");

        if (user != null) {
            firestore.collection("girismelumatlari").whereEqualTo("gmail","qəzənfər.aloyev@gmail.com").addSnapshotListener(new EventListener<QuerySnapshot>() {
                @Override
                public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                        for (DocumentSnapshot documentSnapshot:value.getDocuments()){

                            Map map= documentSnapshot.getData();
                            String gmail=(String) map.get("qəzənfər.aloyev@gmail.com");
                            String userid=(String) map.get("userid");

                            System.out.println(userid);
                            System.out.println(user.getUid());
                            if (user.getUid().equals(userid)){

                                System.out.println("qəzənfər bey");
                                Intent intent=new Intent(login_activity.this,MainActivity.class);
                                intent.putExtra("port","dns");
                                startActivity(intent);
                                finish();
                            }
                            else{

                                System.out.println("musteri");
                                Intent intent=new Intent(login_activity.this,MainActivity.class);
                                 intent.putExtra("port","musteri");
                                startActivity(intent);
                                finish();
                            }

                        }




                }
            });



        } else {


            setContentView(R.layout.activity_login);

            forgetpassword=findViewById(R.id.forget_parol);
            auth = FirebaseAuth.getInstance();
            register = findViewById(R.id.registerolun);
            gmail = findViewById(R.id.gmail_login);
            parol = findViewById(R.id.password_login);
            login = findViewById(R.id.login_buttonu);

            forgetpassword.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(login_activity.this,reset_activity.class);
                    startActivity(intent);

                }
            });
            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (!gmail.getText().toString().trim().contains("@") || !(gmail.getText().toString().trim().length()>13)){
                        gmail.setError("zehmet olmasa emailinizi duz daxil edin");
                    }
                    else if(parol.getText().toString().trim().length()<7){
                        parol.setError("parolunuzu duzgun formada daxil edin");

                    }
                    else{

                        auth.fetchSignInMethodsForEmail(gmail.getText().toString().trim()).addOnSuccessListener(new OnSuccessListener<SignInMethodQueryResult>() {
                            @Override
                            public void onSuccess(SignInMethodQueryResult signInMethodQueryResult) {

                                boolean info=signInMethodQueryResult.getSignInMethods().isEmpty();


                                if (info){
                                    Toast.makeText(login_activity.this,"bele hesab movcud deyil",Toast.LENGTH_SHORT).show();
                                }
                                else{
                                    setLogin();
                                }

                            }
                        });

                    }



                }
            });


            register.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(login_activity.this, Register.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    finish();
                }
            });


        }



    }


    private   void setLogin(){
        ProgressDialog diolog = new ProgressDialog(login_activity.this);
        diolog.setMessage("Loading");
        diolog.show();
        diolog.setCancelable(false);
        String mail = gmail.getText().toString().trim();
        String password = parol.getText().toString().trim();

        System.out.println(mail);
        System.out.println(mail.length());


          if (mail.equals("qəzənfər.aloyev@gmail.com")){
              auth.signInWithEmailAndPassword(mail, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                  @Override
                  public void onSuccess(AuthResult authResult) {
                      Intent intent = new Intent(login_activity.this, MainActivity.class);
                       intent.putExtra("port","dns");
                      intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                      startActivity(intent);
                      finish();
                      diolog.dismiss();
                  }
              }).addOnFailureListener(new OnFailureListener() {
                  @Override
                  public void onFailure(@NonNull Exception e) {
                      diolog.dismiss();
                      Toast.makeText(login_activity.this,e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                  }
              });

          }else{
              auth.signInWithEmailAndPassword(mail, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                  @Override
                  public void onSuccess(AuthResult authResult) {
                      Intent intent = new Intent(login_activity.this, MainActivity.class);
                        intent.putExtra("port","musteri");
                      intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                      startActivity(intent);
                      finish();

                      diolog.dismiss();
                  }
              }).addOnFailureListener(new OnFailureListener() {
                  @Override
                  public void onFailure(@NonNull Exception e) {
                      diolog.dismiss();
                      Toast.makeText(login_activity.this,e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                  }
              });

          }


    }

}