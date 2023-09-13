package com.sananibrahimov.adding_new_column;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.SignInMethodQueryResult;

public class reset_activity extends AppCompatActivity {

    FirebaseAuth auth;

    EditText mail;
    Button button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset);
        mail=findViewById(R.id.sifre_gmail);
        button=findViewById(R.id.sifreni_yenile);



        auth=FirebaseAuth.getInstance();


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String gmail=mail.getText().toString().trim();
                if (gmail.isEmpty() || !gmail.contains("@")){
                    mail.setError("Mailinizin düzgün daxil olmasına  diqqət yetirin");

                }else{
                    ProgressDialog progressDialog=new ProgressDialog(reset_activity.this);
                    progressDialog.setMessage("Loading...");
                    progressDialog.setCancelable(false);
                    progressDialog.show();

                    auth.fetchSignInMethodsForEmail(gmail).addOnSuccessListener(new OnSuccessListener<SignInMethodQueryResult>() {
                        @Override
                        public void onSuccess(SignInMethodQueryResult signInMethodQueryResult) {
                            Boolean reset= signInMethodQueryResult.getSignInMethods().isEmpty();

                            if (!reset){
                                auth.sendPasswordResetEmail(gmail).addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        progressDialog.dismiss();

                                        Toast.makeText(reset_activity.this, "Mailinizə mesaj göndərildi", Toast.LENGTH_SHORT).show();
                                        Intent intent=new Intent(reset_activity.this,login_activity.class);
                                        startActivity(intent);
                                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                        finish();
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        progressDialog.dismiss();
                                        Toast.makeText(reset_activity.this,e.getLocalizedMessage(),Toast.LENGTH_SHORT);
                                    }
                                });
                            }
                            else{
                                Toast.makeText(reset_activity.this, "Bele hesab movcud deyil", Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                            }
                        }
                    });

                }




            }
        });



    }
}