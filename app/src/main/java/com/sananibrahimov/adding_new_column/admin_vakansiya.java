package com.sananibrahimov.adding_new_column;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class admin_vakansiya extends AppCompatActivity {
    EditText editText,location_text,vakansiya;
    ImageView view;
    Uri uri;
    ActivityResultLauncher<Intent> activityResultLauncher;
    ActivityResultLauncher<String> permissionlauncher;
    Button upload;
    FirebaseFirestore firestore;
    FirebaseStorage storage;
    private StorageReference storageReference;
    Spinner spinner,vakansiya_name,sirket;

    ArrayList<user> arrayList;

    String []sirkeett={"Tempo","Getbit","Haralar"};
    String vakansiyanamearray[]={"Qaynaqci","Elektrik","Malyar","bənna","Mobile developer","it mutexesisi"};


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_vakansiya);
        view=findViewById(R.id.add_image);
         upload=findViewById(R.id.click);
         firestore=FirebaseFirestore.getInstance();
         storage=FirebaseStorage.getInstance();


        vakansiya=findViewById(R.id.vakansiyaAddmelumt);

         spinner=findViewById(R.id.spinner_lacation);
         vakansiya_name=findViewById(R.id.vakansiya_spinner);
         sirket=findViewById(R.id.Sirket_vakansiya);



         storageReference=storage.getReference();
         arrayList=new ArrayList<>();


        user  xorvatiya=new user("1","Xorvatiya",R.drawable.xorvatiya);
        user  slovakia=new user("2","Slovakia",R.drawable.slovakia_flag_icon);
        user  Bəə=new user("3","Bəə",R.drawable.bee);
        user  Latvia=new user("4","Latvia",R.drawable.flag_of_latvia);
        user  Litva=new user("5","Litva",R.drawable.litva);
        user  israil=new user("6","İsrail",R.drawable.israil);
        user  slovenia=new user("32","Slovenia",R.drawable.slovenia);


        arrayList.add(xorvatiya);
        arrayList.add(slovakia);
        arrayList.add(Bəə);
        arrayList.add(Latvia);
        arrayList.add(Litva);
        arrayList.add(israil);
        arrayList.add(slovenia);


        sipnnerada sipnnerada1=new sipnnerada(this,R.layout.custom_spinner,arrayList);
        spinner.setPrompt("ssssss");
        spinner.setAdapter(sipnnerada1);

        ArrayAdapter arrayAdapter=new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,vakansiyanamearray);
        vakansiya_name.setAdapter(arrayAdapter);

        ArrayAdapter adaptersirket=new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,sirkeett);
        sirket.setAdapter(adaptersirket);


        registerlauncher();


            upload.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ProgressDialog progressDialog=new ProgressDialog(admin_vakansiya.this);
                    progressDialog.setMessage("Loading");
                    progressDialog.setCancelable(false);
                    progressDialog.show();


                    if (uri!=null) {
                        UUID uuid = UUID.randomUUID();
                        String imagname = "images/" + uuid + ".jpg";

                        storageReference.child(imagname).putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                            @Override
                            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                //download url

                                StorageReference newreference=storageReference.getStorage().getReference(imagname);

                                newreference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                    @Override
                                    public void onSuccess(Uri uri) {
                                       String downloadurl=uri.toString();
                                       String VakansiyaName=vakansiyanamearray[vakansiya_name.getSelectedItemPosition()];
                                       String locationtext22=arrayList.get(spinner.getSelectedItemPosition()).getName();
                                       String sirket_name=sirkeett[sirket.getSelectedItemPosition()];
                                        HashMap<String,Object> hashMap=new HashMap();

                                        hashMap.put("pictureurl",downloadurl);
                                        hashMap.put("Vakansiyaname",VakansiyaName);
                                        hashMap.put("location",locationtext22);
                                        hashMap.put("sirket",sirket_name);
                                        hashMap.put("Vakansiyaninqoyulusu", FieldValue.serverTimestamp());
                                        hashMap.put("vakansiyanin_etrafli",vakansiya.getText().toString());

                                       firestore.collection("infovakansiya").add(hashMap).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                           @Override
                                           public void onSuccess(DocumentReference documentReference) {

                                               progressDialog.dismiss();
                                                 Intent intent=new Intent(admin_vakansiya.this,MainActivity.class);
                                                 intent.putExtra("port","dns");
                                                 intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                                 startActivity(intent);
                                           }
                                       }).addOnFailureListener(new OnFailureListener() {
                                           @Override
                                           public void onFailure(@NonNull Exception e) {
                                               progressDialog.dismiss();
                                               Toast.makeText(admin_vakansiya.this,e.getLocalizedMessage(),Toast.LENGTH_SHORT).show();
                                           }
                                       });
                                       // burasi yarimciqdi admin vakansiayay qayidarsan
                                    }
                                });
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                progressDialog.dismiss();
                                Toast.makeText(admin_vakansiya.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT);

                            }
                        });
                    }
                }

            });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ContextCompat.checkSelfPermission(admin_vakansiya.this, Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
                    if (ActivityCompat.shouldShowRequestPermissionRationale(admin_vakansiya.this,Manifest.permission.READ_EXTERNAL_STORAGE)){


                        Snackbar.make(view,"sekil ucun icaze",Snackbar.LENGTH_INDEFINITE).setAction("icaze verin", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                permissionlauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE);

                            }
                        }).show();
                    }
                    else{
                   permissionlauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE);
                    }
                }
                else{
                    //write here
                    Intent inttogalery=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                      activityResultLauncher.launch(inttogalery);
                }
            }
        });
        
        
        
        
        

        
    }

    private void registerlauncher() {

        activityResultLauncher=registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {

              if (result.getResultCode()==RESULT_OK){
                 Intent intent= result.getData();
                 if (intent!=null){
                     uri= intent.getData();
                     view.setImageURI(uri);
                 }
              }
            }
        });


        permissionlauncher=registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ActivityResultCallback<Boolean>() {
            @Override
            public void onActivityResult(Boolean result) {
                if (result){
                    Intent intentgalery=new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    activityResultLauncher.launch(intentgalery);
                }else{
                    Toast.makeText(admin_vakansiya.this,"permission needed",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }



}