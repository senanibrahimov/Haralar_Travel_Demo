package com.sananibrahimov.adding_new_column;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.Map;

public class vakansiyaya_muraciet extends AppCompatActivity {

    TextView location,vaknasiya,vakansiya_melumat;
    ImageView imageView,upload;
    Button muraciet_et,delete;
    FirebaseFirestore firestore;
    FirebaseAuth auth;
    FirebaseUser user;


    FirebaseStorage storage;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vakansiyaya_muraciet);
           firestore=FirebaseFirestore.getInstance();
        muraciet_et=findViewById(R.id.muraciet_et);
        location=findViewById(R.id.locaotion_muraciet);
        vaknasiya=findViewById(R.id.muraciet_vakansiya23);
        imageView=findViewById(R.id.haralar_image);

        vakansiya_melumat=findViewById(R.id.vakansiyanameofmurciet);
        delete=findViewById(R.id.deletevakansiyamur);
        auth=FirebaseAuth.getInstance();
        user=auth.getCurrentUser();


        storage=FirebaseStorage.getInstance();





            Intent intent=getIntent();
            String vakansiya=intent.getStringExtra("vakansiyaninadi");
            vakansiya_melumat.setText(intent.getStringExtra("melumat"));

            location.setText(intent.getStringExtra("location"));
            vaknasiya.setText(vakansiya);
            String image=intent.getStringExtra("imageurl");
            Picasso.get().load(image).into(imageView);

        storage=FirebaseStorage.getInstance();

        if (user!=null) {


            String gmail = user.getEmail();

            if (gmail.equals("qezenfer.aloyev@haralar.com")) {
                muraciet_et.setVisibility(View.GONE);

                delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ProgressDialog progressDialog = new ProgressDialog(vakansiyaya_muraciet.this);
                        progressDialog.setMessage("Loading...");
                        progressDialog.show();
                        StorageReference reference = storage.getReferenceFromUrl(intent.getStringExtra("imageurl"));

                        reference.delete().addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {

                                firestore.collection("infovakansiya").document(intent.getStringExtra("id")).delete().addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        Intent intent1 = new Intent(vakansiyaya_muraciet.this, MainActivity.class);
                                        intent1.putExtra("port", "dns");
                                        startActivity(intent1);
                                        finish();
                                        progressDialog.dismiss();
                                        Toast.makeText(vakansiyaya_muraciet.this, "data deleted", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(vakansiyaya_muraciet.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });

            } else {

                delete.setVisibility(View.GONE);



                muraciet_et.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ProgressDialog progressDialog = new ProgressDialog(vakansiyaya_muraciet.this);
                        progressDialog.setMessage("Loading...");
                        progressDialog.show();
                        firestore.collection("girismelumatlari").whereEqualTo("gmail", gmail).addSnapshotListener(new EventListener<QuerySnapshot>() {
                            @Override
                            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                                for (DocumentSnapshot documentSnapshot : value.getDocuments()) {
                                    Map hashMap = documentSnapshot.getData();

                                    String gmail1 = (String) hashMap.get("gmail");
                                    String Name = (String) hashMap.get("Name");
                                    String Surname = (String) hashMap.get("Surname");
                                    String phone = (String) hashMap.get("phone");
                                    String text_melumat = (String) hashMap.get("melumat");



                                    HashMap<String, Object> hashMap1 = new HashMap();
                                    hashMap1.put("Name", Name);
                                    hashMap1.put("gmail", gmail1);
                                    hashMap1.put("Surname", Surname);
                                    hashMap1.put("phone", phone);
                                    hashMap1.put("Vakansiya", vakansiya);
                                    hashMap1.put("text_melumat", text_melumat);
                                    hashMap1.put("vakansiyaya_muaciet_tarix", FieldValue.serverTimestamp());
                                    hashMap1.put("request",false);


                                    firestore.collection("muracietedenler").add(hashMap1).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                        @Override
                                        public void onSuccess(DocumentReference documentReference) {


                                            if (documentReference != null) {
                                                progressDialog.dismiss();
                                                AlertDialog.Builder alert=new AlertDialog.Builder(vakansiyaya_muraciet.this);

                                                 alert.setTitle("Ugurlu");
                                                 alert.setMessage("müraciətiniz uğurla başa çatdı yaxın zamanda sizinlə əlaqə saxlanəlacaq");
                                                 alert.setCancelable(false);


                                                 alert.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                                                     @Override
                                                     public void onClick(DialogInterface dialogInterface, int i) {

                                                         Intent intent1 = new Intent(vakansiyaya_muraciet.this, MainActivity.class);
                                                         intent1.putExtra("port", "musteri");
                                                         intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                                         startActivity(intent1);
                                                         finish();


                                                     }
                                                 });
                                                alert.show();

                                            }
                                        }
                                    }).addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            progressDialog.dismiss();
                                            Toast.makeText(vakansiyaya_muraciet.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                                        }
                                    });

                                }
                            }
                        });
                    }
                });

            }
        }
        else {
            delete.setVisibility(View.GONE);
            muraciet_et.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder alert=new AlertDialog.Builder(vakansiyaya_muraciet.this);
                    alert.setTitle("Diqqət!!!");
                    alert.setMessage("Vakansiyaya müraciət etmək üçün login və ya register olun");

                    alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent=new Intent(vakansiyaya_muraciet.this,login_activity.class);
                            startActivity(intent);
                        }
                    });
                    alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    alert.show();
                }
            });
        }









    }
}