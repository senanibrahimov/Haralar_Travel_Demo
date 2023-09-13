package com.sananibrahimov.adding_new_column;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import org.apache.commons.codec.binary.Hex;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.IndexedColorMap;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    FirebaseAuth auth;
    FirebaseFirestore firestore;
    Reycelvieü reycelvieü;
    Button button;
    TextView usergamil,username;
    Spinner spinner,vakansiya;

    ArrayList<user> arrayListds;

      String [] arraydrop={"all","slovakia","xorvatiya","dddddddddddddddddddddddddddddddddd"};
      String [] vakansiyarray={"vakansiyalar","elektrik","qaynaqci"};

    SearchView seacView;
    ArrayList<vakacation_class> arrayList;
    DrawerLayout drawerLayout;
    RecyclerView recyclerView;
    Toolbar toolbar;
    FirebaseUser firebaseUser;
    TextView textView;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         toolbar=findViewById(R.id.toolbar);
         setSupportActionBar(toolbar);
         getSupportActionBar().setTitle("");


        auth=FirebaseAuth.getInstance();
        firebaseUser=auth.getCurrentUser();
        drawerLayout = findViewById(R.id.drawer_layout);
       // seacView = findViewById(R.id.searchview);
        recyclerView = findViewById(R.id.reycelview);
        firestore = FirebaseFirestore.getInstance();
        arrayList = new ArrayList<>();
        username=findViewById(R.id.namesurname);
        usergamil=findViewById(R.id.usernavaigation_gmail);
        spinner=findViewById(R.id.vakanssss);
        vakansiya=findViewById(R.id.butunvakansiyalar);
        Intent intent2122=getIntent();




        arrayListds=new ArrayList<>();
        user  xorvatiya1=new user("1","ölkələr",R.drawable.countr);
        user  xorvatiya=new user("1","Xorvatiya",R.drawable.xorvatiya);
        user  slovakia=new user("2","Slovakia",R.drawable.slovakia_flag_icon);
        user  Bəə=new user("3","Bəə",R.drawable.bee);
        user  Latvia=new user("4","Latvia",R.drawable.flag_of_latvia);
        user  Litva=new user("5","Litva",R.drawable.litva);
        user  israil=new user("6","İsrail",R.drawable.israil);
        user  slovenia=new user("32","Slovenia",R.drawable.slovenia);

        arrayListds.add(xorvatiya1);
        arrayListds.add(xorvatiya);
        arrayListds.add(slovakia);
        arrayListds.add(Bəə);
        arrayListds.add(Latvia);
        arrayListds.add(Litva);
        arrayListds.add(israil);
        arrayListds.add(slovenia);











        sipnnerada adapter=new sipnnerada(this,R.layout.custom_spinner,arrayListds);
        spinner.setAdapter(adapter);

        ArrayAdapter vakansiyaauyt=new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,vakansiyarray);
        vakansiya.setAdapter(vakansiyaauyt);



        getdata();
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        reycelvieü = new Reycelvieü(arrayList);
        recyclerView.setAdapter(reycelvieü);
        recyclerView.setHasFixedSize(true);


        System.out.println(arrayList.size());


        if (firebaseUser!=null) {


            String usergamil12 = firebaseUser.getEmail();


            findViewById(R.id.imagemenu).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    drawerLayout.openDrawer(GravityCompat.START);
                }
            });



       /* seacView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                myString(newText);
                return true;
            }
        });*/

            NavigationView navigationView = findViewById(R.id.navigation);
            View headerview = navigationView.getHeaderView(0);

            TextView namesurname = headerview.findViewById(R.id.namesurname);
            TextView userofgmail = headerview.findViewById(R.id.usernavaigation_gmail);

            firestore.collection("girismelumatlari").whereEqualTo("gmail", usergamil12).addSnapshotListener(new EventListener<QuerySnapshot>() {
                @Override
                public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                    for (DocumentSnapshot snapshot : value.getDocuments()) {

                        Map map = snapshot.getData();
                        String name = (String) map.get("Name");
                        String surname = (String) map.get("Surname");

                        namesurname.setText(name + " " + surname);
                        userofgmail.setText(usergamil12);
                        System.out.println(name + surname);

                    }
                }
            });


            Menu menu = navigationView.getMenu();
            Intent intent = getIntent();
            String port = intent.getStringExtra("port");
            System.out.println(port);

            if (firebaseUser.getEmail().equals("qezenfer.aloyev@haralar.com")) {
                menu.findItem(R.id.qebulbendleri).setVisible(true);
                menu.findItem(R.id.visa_muracieti).setVisible(true);
                menu.findItem(R.id.full_of_file).setVisible(false);
                menu.findItem(R.id.musteriinfo).setVisible(false);
                menu.findItem(R.id.musterivizainfo).setVisible(false);
                menu.findItem(R.id.logout).setVisible(true);
                menu.findItem(R.id.export_visa).setVisible(true);
                menu.findItem(R.id.contact).setVisible(false);

            } else {
                menu.findItem(R.id.qebulbendleri).setVisible(false);
                menu.findItem(R.id.visa_muracieti).setVisible(false);
                menu.findItem(R.id.full_of_file).setVisible(true);
                menu.findItem(R.id.musteriinfo).setVisible(true);
                menu.findItem(R.id.musterivizainfo).setVisible(true);
                menu.findItem(R.id.logout).setVisible(true);
                menu.findItem(R.id.export_visa).setVisible(false);
                menu.findItem(R.id.contact).setVisible(true);
            }


            navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    if (item.getItemId() == R.id.qebulbendleri) {
                        Intent intent = new Intent(MainActivity.this, navigation_activity.class);
                        intent.putExtra("navigation", 1);
                        startActivity(intent);
                    } else if (item.getItemId() == R.id.visa_muracieti) {
                        Intent intent = new Intent(MainActivity.this, navigation_activity.class);
                        intent.putExtra("navigation", 2);
                        startActivity(intent);
                    } else if (item.getItemId() == R.id.musteriinfo) {
                /*    firestore.collection("girismelumatlari").addSnapshotListener(new EventListener<QuerySnapshot>() {
                        @Override
                        public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                            for (DocumentSnapshot snapshot:value.getDocuments()){

                                Map<String,Object> hashMap= snapshot.getData();

                                String userid= (String) hashMap.get("userid");
                                String username=(String) hashMap.get("username");
                                if (firebaseUser.getUid().equals(userid)){

                                    Intent intent=new Intent(MainActivity.this,user_musteri.class);
                                    intent.putExtra("usernamemusteri",username);
                                    intent.putExtra("musteri",2);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    startActivity(intent);
                                    finish();

                                }



                            }



                        }
                    });*/

                        Intent intent = new Intent(MainActivity.this, user_musteri.class);
                        intent.putExtra("musteri", 2);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        finish();

                    } else if (item.getItemId() == R.id.export_visa) {
                        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);


                        firestore.collection("vizaprosuderi").addSnapshotListener(new EventListener<QuerySnapshot>() {
                            @Override
                            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                                ArrayList<visaclass> arrayListexport = new ArrayList();


                                for (DocumentSnapshot snapshot : value.getDocuments()) {
                                    Map<String, Object> hashMap = snapshot.getData();

                                    String username = (String) hashMap.get("Username_visa");
                                    String Apostil3 = (String) hashMap.get("Apostil");
                                    String Arayis = (String) hashMap.get("Arayis");
                                    String Vesiqe_sureti3 = (String) hashMap.get("Vesiqe_sureti");
                                    String Xarici_passport = (String) hashMap.get("Xarici passport");
                                    String is_deveti12 = (String) hashMap.get("is_deveti");
                                    String sefirliye_muraciet_olunan_tarix = (String) hashMap.get("sefirliye_muraciet_olunan tarix");
                                    String sefirliye_teyin_olunan_vaxt = (String) hashMap.get("sefirliye_teyin_olunan_vaxt");
                                    String sekil12 = (String) hashMap.get("sekil");
                                    String senedlerin_neticesi12 = (String) hashMap.get("senedlerin_neticesi");
                                    String sengen_vizasi_form = (String) hashMap.get("sengen_vizasi_form");
                                    String sigorta12 = (String) hashMap.get("sigorta");
                                    String ucus_bronu12 = (String) hashMap.get("ucus_bronu");
                                    String viza_rusumu12 = (String) hashMap.get("viza_rusumu");
                                    String gmail1231 = (String) hashMap.get("gmail");
                                    String apostilltercume = (String) hashMap.get("Apostil_tercume");
                                    String apostiltercumedengelenvaxt = (String) hashMap.get("Apostil_tercumeden_geldiyi_vaxt");
                                    String Apostil_bitme_tarixi = (String) hashMap.get("Apostil_bitme_tarixi");
                                    String Apostil_baslama_tarixi = (String) hashMap.get("Apostil_baslama_tarixi");
                                    String Isdevetine_muraciet = (String) hashMap.get("Isdevetine_muraciet");
                                    String isdevetinin_baslama_tarixi = (String) hashMap.get("isdevetinin_baslama_tarixi");
                                    String isdevetinin_bitme_tarixi = (String) hashMap.get("isdevetinin_bitme_tarixi");
                                    String sigortaya_muraciet = (String) hashMap.get("sigortaya_muraciet");
                                    String sigortanin_baslama_tarixi = (String) hashMap.get("sigortanin_baslama_tarixi");
                                    String sigortanin_bitme_tarixi = (String) hashMap.get("sigortanin_bitme_tarixi");
                                    String rng = (String) hashMap.get("reng");
                                    visaclass vizaclass1 = new visaclass(username, Xarici_passport, Apostil3, sekil12, Vesiqe_sureti3, is_deveti12, Arayis, sigorta12, sengen_vizasi_form, ucus_bronu12, viza_rusumu12, sefirliye_muraciet_olunan_tarix, sefirliye_teyin_olunan_vaxt, senedlerin_neticesi12, gmail1231, apostilltercume, apostiltercumedengelenvaxt, Apostil_baslama_tarixi, Apostil_bitme_tarixi, Isdevetine_muraciet, isdevetinin_baslama_tarixi, isdevetinin_bitme_tarixi, sigortaya_muraciet, sigortanin_bitme_tarixi, sigortanin_baslama_tarixi, rng);

                                    arrayListexport.add(vizaclass1);

                                }

                                firestore.collection("infoafterreg").addSnapshotListener(new EventListener<QuerySnapshot>() {
                                    @Override
                                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                                        ArrayList<generalinfo> arrayexportmusteri = new ArrayList();


                                        for (DocumentSnapshot snapshot : value.getDocuments()) {
                                            Map<String, Object> hashMap = snapshot.getData();
                                            String username1 = (String) hashMap.get("username");
                                            String idvesiq = (String) hashMap.get("sexsiyyet");
                                            String muuqavilenintarixi = (String) hashMap.get("muqavilenin_tarixi");
                                            String muraciettarixi = (String) hashMap.get("muraciet_tarixi");
                                            String muqavivileninnomresi = (String) hashMap.get("muqavilenin_nomresi");
                                            String olkee = (String) hashMap.get("gedeceyi_olke");
                                            String sirkett = (String) hashMap.get("qebul_eden_sirket");
                                            String vakansiyadate1 = (String) hashMap.get("vakansiya_ve_date");
                                            String odenilecek_mebleg2 = (String) hashMap.get("odenilecek_mebleg");
                                            String ilkiniodenis = (String) hashMap.get("ilkin_odenis");
                                            String qaliqborc1 = (String) hashMap.get("qaliq_borc");
                                            String number1 = (String) hashMap.get("phone_number");
                                            String dogum = (String) hashMap.get("dogum_date");
                                            String xarici = (String) hashMap.get("xarici_passportunun_nomresi");
                                            String milliyeti1 = (String) hashMap.get("milliyeti");
                                            String unvan1 = (String) hashMap.get("unvanı");
                                            String xariccci_baslama = (String) hashMap.get("xarici_passport_baslama");
                                            ;
                                            String xarici_bitme = (String) hashMap.get("xarici_passport_bitme");
                                            ;
                                            String ankkettt = (String) hashMap.get("anketi");
                                            generalinfo generalinfo = new generalinfo(username1, idvesiq, muuqavilenintarixi, muraciettarixi, muqavivileninnomresi, olkee, sirkett, vakansiyadate1, odenilecek_mebleg2, ilkiniodenis, qaliqborc1, number1, dogum, xarici, milliyeti1, unvan1, firebaseUser.getEmail(), xariccci_baslama, xarici_bitme, ankkettt);


                                            arrayexportmusteri.add(generalinfo);

                                        }

                                        File filpath = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), "Haralar Travel Folder");
                                        filpath.mkdir();
                                        File file = new File(filpath, "Haralar Travel(baza).xlsx");


                                        XSSFWorkbook workbook = new XSSFWorkbook();
                                        XSSFSheet sheet = workbook.createSheet("visa məlumatları");
                                        XSSFSheet sheet1 = workbook.createSheet("Müstərinin səxsi məlumatları");
                                        XSSFCellStyle fCellStyle = workbook.createCellStyle();
                                        fCellStyle.setFillForegroundColor(IndexedColors.GOLD.index);
                                        fCellStyle.setAlignment(HorizontalAlignment.CENTER);
                                        fCellStyle.setBorderBottom(BorderStyle.MEDIUM);
                                        fCellStyle.setBorderRight(BorderStyle.MEDIUM);
                                        fCellStyle.setBorderBottom(BorderStyle.MEDIUM);
                                        fCellStyle.setBorderLeft(BorderStyle.MEDIUM);

                                        sheet1.setColumnWidth(0, 10000);
                                        sheet1.setColumnWidth(1, 5000);
                                        sheet1.setColumnWidth(2, 5000);
                                        sheet1.setColumnWidth(3, 5000);
                                        sheet1.setColumnWidth(4, 5000);
                                        sheet1.setColumnWidth(5, 5000);
                                        sheet1.setColumnWidth(6, 5000);
                                        sheet1.setColumnWidth(7, 5000);
                                        sheet1.setColumnWidth(8, 5000);
                                        sheet1.setColumnWidth(9, 5000);
                                        sheet1.setColumnWidth(10, 5000);
                                        sheet1.setColumnWidth(11, 5000);
                                        sheet1.setColumnWidth(12, 5000);
                                        sheet1.setColumnWidth(13, 5000);
                                        sheet1.setColumnWidth(14, 5000);
                                        sheet1.setColumnWidth(15, 5000);
                                        sheet1.setColumnWidth(16, 5000);
                                        sheet1.setColumnWidth(17, 5000);
                                        sheet1.setColumnWidth(18, 5000);

                                        XSSFCell cell1;


                                        XSSFRow row2 = sheet1.createRow(0);
                                        cell1 = row2.createCell(0);
                                        cell1.setCellValue("username");
                                        cell1.setCellStyle(fCellStyle);


                                        cell1 = row2.createCell(1);
                                        cell1.setCellValue("Sexsiyyet/vesiqe/seriya");
                                        cell1.setCellStyle(fCellStyle);

                                        cell1 = row2.createCell(2);
                                        cell1.setCellValue("muraciet/tarixi");
                                        cell1.setCellStyle(fCellStyle);

                                        cell1 = row2.createCell(3);
                                        cell1.setCellValue("muqavilenin/tarixi");
                                        cell1.setCellStyle(fCellStyle);

                                        cell1 = row2.createCell(4);
                                        cell1.setCellValue("muqavilenin/nomresi");
                                        cell1.setCellStyle(fCellStyle);

                                        cell1 = row2.createCell(5);
                                        cell1.setCellValue("Gedeceyi/olke");
                                        cell1.setCellStyle(fCellStyle);

                                        cell1 = row2.createCell(6);
                                        cell1.setCellValue("gedeceyi/sirket");
                                        cell1.setCellStyle(fCellStyle);

                                        cell1 = row2.createCell(7);
                                        cell1.setCellValue("Vakansiya");
                                        cell1.setCellStyle(fCellStyle);

                                        cell1 = row2.createCell(8);
                                        cell1.setCellValue("odenilecek/mebleg");
                                        cell1.setCellStyle(fCellStyle);

                                        cell1 = row2.createCell(9);
                                        cell1.setCellValue("ilikn odenis");
                                        cell1.setCellStyle(fCellStyle);

                                        cell1 = row2.createCell(10);
                                        cell1.setCellValue("qaliq odenis");
                                        cell1.setCellStyle(fCellStyle);

                                        cell1 = row2.createCell(11);
                                        cell1.setCellValue("Telefon/nomresi");
                                        cell1.setCellStyle(fCellStyle);

                                        cell1 = row2.createCell(12);
                                        cell1.setCellValue("dogum/tarixi");
                                        cell1.setCellStyle(fCellStyle);

                                        cell1 = row2.createCell(13);
                                        cell1.setCellValue("xarici/paspport");
                                        cell1.setCellStyle(fCellStyle);

                                        cell1 = row2.createCell(14);
                                        cell1.setCellValue("xarici/passport/baslama");
                                        cell1.setCellStyle(fCellStyle);

                                        cell1 = row2.createCell(15);
                                        cell1.setCellValue("xarici/passport/bitme");
                                        cell1.setCellStyle(fCellStyle);

                                        cell1 = row2.createCell(16);
                                        cell1.setCellValue("Milliyeti");
                                        cell1.setCellStyle(fCellStyle);

                                        cell1 = row2.createCell(17);
                                        cell1.setCellValue("Unvani");
                                        cell1.setCellStyle(fCellStyle);

                                        cell1 = row2.createCell(18);
                                        cell1.setCellValue("Anketi");
                                        cell1.setCellStyle(fCellStyle);
                                        for (int i = 0; i < arrayexportmusteri.size(); i++) {
                                            XSSFRow xs = sheet1.createRow(i + 1);


                                            cell1 = xs.createCell(0);
                                            cell1.setCellValue(arrayexportmusteri.get(i).getUsername());


                                            cell1 = xs.createCell(1);
                                            cell1.setCellValue(arrayexportmusteri.get(i).getSexsiyyet());

                                            cell1 = xs.createCell(2);
                                            cell1.setCellValue(arrayexportmusteri.get(i).getMuraciet_tarixi());
                                            cell1 = xs.createCell(3);
                                            cell1.setCellValue(arrayexportmusteri.get(i).getMuqavilenin_tarixi());

                                            cell1 = xs.createCell(4);
                                            cell1.setCellValue(arrayexportmusteri.get(i).getMuqavilenin_nomresi());

                                            cell1 = xs.createCell(5);
                                            cell1.setCellValue(arrayexportmusteri.get(i).getOlke());

                                            cell1 = xs.createCell(6);
                                            cell1.setCellValue(arrayexportmusteri.get(i).getSirket());


                                            cell1 = xs.createCell(7);
                                            cell1.setCellValue(arrayexportmusteri.get(i).getVakansiya_date());

                                            cell1 = xs.createCell(8);
                                            cell1.setCellValue(arrayexportmusteri.get(i).getOdenilecek_mebleg());

                                            cell1 = xs.createCell(9);
                                            cell1.setCellValue(arrayexportmusteri.get(i).getIlkin_odenis());

                                            cell1 = xs.createCell(10);
                                            cell1.setCellValue(arrayexportmusteri.get(i).getQaliq_borc());

                                            cell1 = xs.createCell(11);
                                            cell1.setCellValue(arrayexportmusteri.get(i).getNumber());

                                            cell1 = xs.createCell(12);
                                            cell1.setCellValue(arrayexportmusteri.get(i).getDogum_tarixi());

                                            cell1 = xs.createCell(13);
                                            cell1.setCellValue(arrayexportmusteri.get(i).getXarici_passportun_nomrsi());

                                            cell1 = xs.createCell(14);
                                            cell1.setCellValue(arrayexportmusteri.get(i).getXaricipassport_baslama());

                                            cell1 = xs.createCell(15);
                                            cell1.setCellValue(arrayexportmusteri.get(i).getXaricipassport_bitme());

                                            cell1 = xs.createCell(16);
                                            cell1.setCellValue(arrayexportmusteri.get(i).getMilliyeti());

                                            cell1 = xs.createCell(17);
                                            cell1.setCellValue(arrayexportmusteri.get(i).getUnvan());

                                            cell1 = xs.createCell(18);
                                            cell1.setCellValue(arrayexportmusteri.get(i).getAnket());
                                        }


                                        XSSFCellStyle cellStyle = workbook.createCellStyle();
                                        XSSFFont font = workbook.createFont();
                                        font.setFontHeight(11);
                                        font.setBold(true);
                                        cellStyle.setFont(font);
                                        cellStyle.setFillForegroundColor(IndexedColors.LIME.index);
                                        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                                        cellStyle.setAlignment(HorizontalAlignment.CENTER);
                                        cellStyle.setBorderBottom(BorderStyle.MEDIUM);
                                        cellStyle.setBorderRight(BorderStyle.MEDIUM);
                                        cellStyle.setBorderBottom(BorderStyle.MEDIUM);
                                        cellStyle.setBorderLeft(BorderStyle.MEDIUM);


                                        sheet.setColumnWidth(0, 10000);
                                        sheet.setColumnWidth(1, 5000);
                                        sheet.setColumnWidth(2, 5000);
                                        sheet.setColumnWidth(3, 5000);
                                        sheet.setColumnWidth(4, 5000);
                                        sheet.setColumnWidth(5, 5000);
                                        sheet.setColumnWidth(6, 5000);
                                        sheet.setColumnWidth(7, 5000);
                                        sheet.setColumnWidth(8, 5000);
                                        sheet.setColumnWidth(9, 5000);
                                        sheet.setColumnWidth(10, 5000);
                                        sheet.setColumnWidth(11, 5000);
                                        sheet.setColumnWidth(12, 5000);
                                        sheet.setColumnWidth(13, 5000);
                                        sheet.setColumnWidth(14, 5000);
                                        sheet.setColumnWidth(15, 5000);
                                        sheet.setColumnWidth(16, 5000);
                                        sheet.setColumnWidth(17, 5000);
                                        sheet.setColumnWidth(18, 5000);
                                        sheet.setColumnWidth(19, 5000);
                                        sheet.setColumnWidth(20, 5000);
                                        sheet.setColumnWidth(21, 5000);
                                        sheet.setColumnWidth(22, 5000);
                                        sheet.setColumnWidth(23, 5000);


                                        XSSFCell cell;


                                        XSSFRow row = sheet.createRow(0);

                                        cell = row.createCell(0);
                                        cell.setCellValue("username");
                                        cell.setCellStyle(cellStyle);


                                        cell = row.createCell(1);
                                        cell.setCellValue("Xarici passport");
                                        cell.setCellStyle(cellStyle);

                                        cell = row.createCell(2);
                                        cell.setCellValue("Apostil");
                                        cell.setCellStyle(cellStyle);


                                        cell = row.createCell(3);
                                        cell.setCellValue("Apostil/tercume");
                                        cell.setCellStyle(cellStyle);

                                        cell = row.createCell(4);
                                        cell.setCellValue("Apostil/t/gelenvaxt");
                                        cell.setCellStyle(cellStyle);

                                        cell = row.createCell(5);
                                        cell.setCellValue("Apostil/basla/tarixi");
                                        cell.setCellStyle(cellStyle);

                                        cell = row.createCell(6);
                                        cell.setCellValue("Apostil/bitme/tarixi");
                                        cell.setCellStyle(cellStyle);

                                        cell = row.createCell(7);
                                        cell.setCellValue("sekil");
                                        cell.setCellStyle(cellStyle);

                                        cell = row.createCell(8);
                                        cell.setCellValue("sexsiyet suret");
                                        cell.setCellStyle(cellStyle);

                                        cell = row.createCell(9);
                                        cell.setCellValue("is deveti");
                                        cell.setCellStyle(cellStyle);

                                        cell = row.createCell(10);
                                        cell.setCellValue("is_devetine/muraciet");
                                        cell.setCellStyle(cellStyle);

                                        cell = row.createCell(11);
                                        cell.setCellValue("is/devetinin/baslamasi");
                                        cell.setCellStyle(cellStyle);

                                        cell = row.createCell(12);
                                        cell.setCellValue("is/devetinin/bitmesi");
                                        cell.setCellStyle(cellStyle);

                                        cell = row.createCell(13);
                                        cell.setCellValue("Arayis");
                                        cell.setCellStyle(cellStyle);

                                        cell = row.createCell(14);
                                        cell.setCellValue("Sigorta");
                                        cell.setCellStyle(cellStyle);

                                        cell = row.createCell(15);
                                        cell.setCellValue("Sigortaya/muraciet");
                                        cell.setCellStyle(cellStyle);

                                        cell = row.createCell(16);
                                        cell.setCellValue("Sigorta/baslama/tarixi");
                                        cell.setCellStyle(cellStyle);

                                        cell = row.createCell(17);
                                        cell.setCellValue("Sigorta/bitme/tarixi");
                                        cell.setCellStyle(cellStyle);

                                        cell = row.createCell(18);
                                        cell.setCellValue("Sengen form");
                                        cell.setCellStyle(cellStyle);

                                        cell = row.createCell(19);
                                        cell.setCellValue("Ucus bronu");
                                        cell.setCellStyle(cellStyle);

                                        cell = row.createCell(20);
                                        cell.setCellValue("viza rusumu");
                                        cell.setCellStyle(cellStyle);

                                        cell = row.createCell(21);
                                        cell.setCellValue("Sefirlik muraciet");
                                        cell.setCellStyle(cellStyle);

                                        cell = row.createCell(22);
                                        cell.setCellValue("sefirlik teyin");
                                        cell.setCellStyle(cellStyle);

                                        cell = row.createCell(23);
                                        cell.setCellValue("Sen-Netice");
                                        cell.setCellStyle(cellStyle);


                                        for (int i = 0; i < arrayListexport.size(); i++) {
                                            XSSFRow hssfRow = sheet.createRow(i + 1);
                                            XSSFCellStyle xssfCellStyle = workbook.createCellStyle();
                                            xssfCellStyle.setAlignment(HorizontalAlignment.CENTER);
                                            xssfCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                                            xssfCellStyle.setBorderBottom(BorderStyle.MEDIUM);
                                            xssfCellStyle.setBorderRight(BorderStyle.MEDIUM);
                                            xssfCellStyle.setBorderBottom(BorderStyle.MEDIUM);
                                            xssfCellStyle.setBorderLeft(BorderStyle.MEDIUM);
                                            System.out.println(arrayListexport.get(i).reng.toLowerCase(Locale.ROOT));
                                            if (arrayListexport.get(i).reng.toLowerCase(Locale.ROOT).substring(0,1).equals("q")) {
                                                xssfCellStyle.setFillForegroundColor(IndexedColors.BLACK.index);
                                                XSSFFont font1 = workbook.createFont();
                                                font1.setColor(IndexedColors.WHITE.index);
                                                xssfCellStyle.setFont(font1);
                                            } else if (arrayListexport.get(i).reng.toLowerCase(Locale.ROOT).substring(0,1).equals("n")) {
                                                xssfCellStyle.setFillForegroundColor(IndexedColors.ORANGE.index);

                                            } else if (arrayListexport.get(i).reng.toLowerCase(Locale.ROOT).substring(0,1).equals("y")) {
                                                xssfCellStyle.setFillForegroundColor(IndexedColors.BRIGHT_GREEN.index);

                                            } else if (arrayListexport.get(i).reng.toLowerCase(Locale.ROOT).substring(0,1).equals("m")) {
                                                xssfCellStyle.setFillForegroundColor(IndexedColors.SKY_BLUE.index);

                                            } else if (arrayListexport.get(i).reng.toLowerCase(Locale.ROOT).substring(0,1).equals("a")) {
                                                xssfCellStyle.setFillForegroundColor(IndexedColors.WHITE.index);

                                            } else if (arrayListexport.get(i).reng.toLowerCase(Locale.ROOT).substring(0,1).equals("s")) {
                                                xssfCellStyle.setFillForegroundColor(IndexedColors.YELLOW.index);

                                            }


                                            cell = hssfRow.createCell(0);
                                            cell.setCellValue(arrayListexport.get(i).getNameofvisauser());
                                            cell.setCellStyle(xssfCellStyle);


                                            cell = hssfRow.createCell(1);
                                            cell.setCellValue(arrayListexport.get(i).getXarici_passport());
                                            cell.setCellStyle(xssfCellStyle);

                                            cell = hssfRow.createCell(2);
                                            cell.setCellValue(arrayListexport.get(i).getApostil());
                                            cell.setCellStyle(xssfCellStyle);

                                            cell = hssfRow.createCell(3);
                                            cell.setCellValue(arrayListexport.get(i).getApostil_tercumel());
                                            cell.setCellStyle(xssfCellStyle);


                                            cell = hssfRow.createCell(4);
                                            cell.setCellValue(arrayListexport.get(i).getApostilin_geldiyi_vaxt());
                                            cell.setCellStyle(xssfCellStyle);

                                            cell = hssfRow.createCell(5);
                                            cell.setCellValue(arrayListexport.get(i).getApostin_baslama_tarixi());
                                            cell.setCellStyle(xssfCellStyle);

                                            cell = hssfRow.createCell(6);
                                            cell.setCellValue(arrayListexport.get(i).getApostilin_bitme_tarixi());
                                            cell.setCellStyle(xssfCellStyle);


                                            cell = hssfRow.createCell(7);
                                            cell.setCellValue(arrayListexport.get(i).getSekil());
                                            cell.setCellStyle(xssfCellStyle);

                                            cell = hssfRow.createCell(8);
                                            cell.setCellValue(arrayListexport.get(i).getVəsiqə_sureti());
                                            cell.setCellStyle(xssfCellStyle);

                                            cell = hssfRow.createCell(9);
                                            cell.setCellValue(arrayListexport.get(i).getIs_deveti());
                                            cell.setCellStyle(xssfCellStyle);

                                            cell = hssfRow.createCell(10);
                                            cell.setCellValue(arrayListexport.get(i).getIsdevetine_muraciet());
                                            cell.setCellStyle(xssfCellStyle);

                                            cell = hssfRow.createCell(11);
                                            cell.setCellValue(arrayListexport.get(i).getIs_devetinin_baslama_tarixi());
                                            cell.setCellStyle(xssfCellStyle);

                                            cell = hssfRow.createCell(12);
                                            cell.setCellValue(arrayListexport.get(i).getIs_devetinin_bitme_tarixi());
                                            cell.setCellStyle(xssfCellStyle);


                                            cell = hssfRow.createCell(13);
                                            cell.setCellValue(arrayListexport.get(i).getQalacagiyer_arayis());
                                            cell.setCellStyle(xssfCellStyle);

                                            cell = hssfRow.createCell(14);
                                            cell.setCellValue(arrayListexport.get(i).getSigorta());
                                            cell.setCellStyle(xssfCellStyle);

                                            cell = hssfRow.createCell(15);
                                            cell.setCellValue(arrayListexport.get(i).getSigortaya_muraciet_tarixi());
                                            cell.setCellStyle(xssfCellStyle);

                                            cell = hssfRow.createCell(16);
                                            cell.setCellValue(arrayListexport.get(i).getSigortaya_baslama_tarixi());
                                            cell.setCellStyle(xssfCellStyle);

                                            cell = hssfRow.createCell(17);
                                            cell.setCellValue(arrayListexport.get(i).getSigorta_bitme_tarixi());
                                            cell.setCellStyle(xssfCellStyle);

                                            cell = hssfRow.createCell(18);
                                            cell.setCellValue(arrayListexport.get(i).getSengen_vizasi_form());
                                            cell.setCellStyle(xssfCellStyle);

                                            cell = hssfRow.createCell(19);
                                            cell.setCellValue(arrayListexport.get(i).getBron());
                                            cell.setCellStyle(xssfCellStyle);

                                            cell = hssfRow.createCell(20);
                                            cell.setCellValue(arrayListexport.get(i).getViza_rusumu());
                                            cell.setCellStyle(xssfCellStyle);

                                            cell = hssfRow.createCell(21);
                                            cell.setCellValue(arrayListexport.get(i).getSefirlik_muraciet_tarix());
                                            cell.setCellStyle(xssfCellStyle);

                                            cell = hssfRow.createCell(22);
                                            cell.setCellValue(arrayListexport.get(i).getTeyin_olunan_vaxt());
                                            cell.setCellStyle(xssfCellStyle);

                                            cell = hssfRow.createCell(23);
                                            cell.setCellValue(arrayListexport.get(i).getSened_netice());
                                            cell.setCellStyle(xssfCellStyle);

                                            cell = hssfRow.createCell(23);
                                            cell.setCellValue(arrayListexport.get(i).getSened_netice());
                                            cell.setCellStyle(xssfCellStyle);
                                            XSSFCellStyle xssfCellStyle23 = workbook.createCellStyle();
                                            xssfCellStyle23.setAlignment(HorizontalAlignment.CENTER);
                                            xssfCellStyle23.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                                            xssfCellStyle23.setBorderBottom(BorderStyle.MEDIUM);
                                            xssfCellStyle23.setBorderRight(BorderStyle.MEDIUM);
                                            xssfCellStyle23.setBorderBottom(BorderStyle.MEDIUM);
                                            xssfCellStyle23.setBorderLeft(BorderStyle.MEDIUM);

                                            if (i == 0) {


                                                xssfCellStyle23.setFillForegroundColor(IndexedColors.WHITE.index);
                                                cell = hssfRow.createCell(25);
                                                cell.setCellStyle(xssfCellStyle23);

                                                cell = hssfRow.createCell(26);
                                                cell.setCellValue("Gun teyin olunmuyub");
                                            } else if (i == 1) {
                                                xssfCellStyle23.setFillForegroundColor(IndexedColors.GOLD.index);
                                                cell = hssfRow.createCell(25);
                                                cell.setCellStyle(xssfCellStyle23);

                                                cell = hssfRow.createCell(26);
                                                cell.setCellValue("Gün təyin olunanlar");
                                            } else if (i == 2) {
                                                xssfCellStyle23.setFillForegroundColor(IndexedColors.YELLOW.index);
                                                cell = hssfRow.createCell(25);
                                                cell.setCellStyle(xssfCellStyle23);

                                                cell = hssfRow.createCell(26);
                                                cell.setCellValue("viza Gözləyənlər");
                                            } else if (i == 3) {
                                                xssfCellStyle23.setFillForegroundColor(IndexedColors.SKY_BLUE.index);
                                                cell = hssfRow.createCell(25);
                                                cell.setCellStyle(xssfCellStyle23);

                                                cell = hssfRow.createCell(26);
                                                cell.setCellValue("viza alıb getməyənlər");
                                            } else if (i == 4) {
                                                xssfCellStyle23.setFillForegroundColor(IndexedColors.BRIGHT_GREEN.index);
                                                cell = hssfRow.createCell(25);
                                                cell.setCellStyle(xssfCellStyle23);

                                                cell = hssfRow.createCell(26);
                                                cell.setCellValue("Gedənlər");
                                            } else if (i == 5) {
                                                xssfCellStyle23.setFillForegroundColor(IndexedColors.BLACK.index);
                                                cell = hssfRow.createCell(25);
                                                cell.setCellStyle(xssfCellStyle23);

                                                cell = hssfRow.createCell(26);
                                                cell.setCellValue("Müqaviləyə xitam");
                                            }
                                        }


                                        try {

                                            file.createNewFile();


                                        } catch (Exception e) {
                                            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                                        }

                                        try {

                                            FileOutputStream fileOutputStream = new FileOutputStream(file);
                                            workbook.write(fileOutputStream);
                                            fileOutputStream.close();


                                        } catch (Exception e) {

                                        }


                                    }
                                });


                            }
                        });
                    } else if (item.getItemId() == R.id.musterivizainfo) {
                        firestore.collection("girismelumatlari").whereEqualTo("gmail", firebaseUser.getEmail()).addSnapshotListener(new EventListener<QuerySnapshot>() {
                            @Override
                            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                                for (DocumentSnapshot snapshot : value.getDocuments()) {

                                    Map<String, Object> hashMap = snapshot.getData();

                                    String userid = (String) hashMap.get("userid");
                                    String username = (String) hashMap.get("username");
                                    Intent intent = new Intent(MainActivity.this, user_musteri.class);
                                    intent.putExtra("usernamemusteri", username);
                                    intent.putExtra("musteri", 1);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    startActivity(intent);
                                    finish();


                                }


                            }
                        });
                    } else if (item.getItemId() == R.id.logout) {

                        auth.signOut();
                        Intent intent = new Intent(MainActivity.this, login_activity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        finish();

                    }else if (item.getItemId()==R.id.contact){
                       Intent intent1=new Intent(MainActivity.this,contact.class);
                        startActivity(intent1);

                    }


                    return false;
                }
            });
        }
        else{

            findViewById(R.id.imagemenu).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder alert=new AlertDialog.Builder(MainActivity.this);
                    alert.setTitle("Diqqət!!!");
                    alert.setMessage("Login və ya da register olunun");

                    alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent=new Intent(MainActivity.this,login_activity.class);
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

    private void getdata() {

        firestore.collection("infovakansiya").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                       arrayList.clear();
                if (error != null) {
                    Toast.makeText(MainActivity.this, error.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }

                if (value != null) {

                    for (DocumentSnapshot snapshot : value.getDocuments()) {
                        Map<String, Object> hashMap = snapshot.getData();

                        String pictureurl = (String) hashMap.get("pictureurl");
                        String vakansiayaname = (String) hashMap.get("Vakansiyaname");
                        String location_Name = (String) hashMap.get("location");

                        String text_melumat=(String)hashMap.get("vakansiyanin_etrafli");
                        System.out.println(snapshot.getId());
                        vakacation_class vakacationClass = new vakacation_class(pictureurl, vakansiayaname, location_Name,text_melumat);
                          vakacationClass.setId(snapshot.getId());
                        arrayList.add(vakacationClass);

                    }
                    System.out.println(arrayList.size());
                    reycelvieü.notifyDataSetChanged();

                    spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            ArrayList<vakacation_class> list=new ArrayList<>();
                            for (vakacation_class vakacationClass:arrayList){

                                System.out.println(  arrayListds.get(spinner.getSelectedItemPosition()).getName().toLowerCase(Locale.ROOT));

                                if (arrayListds.get(spinner.getSelectedItemPosition()).getName().toLowerCase(Locale.ROOT).equals("ölkələr")&&
                                        vakansiya.getSelectedItem().toString().equals("vakansiyalar")){
                                    list.add(vakacationClass);

                                }else if (arrayListds.get(spinner.getSelectedItemPosition()).getName().toLowerCase(Locale.ROOT).equals("ölkələr")
                                        && vakansiya.getSelectedItem().toString().toLowerCase(Locale.ROOT).equals(vakacationClass.getVakansiyanin_adi().toLowerCase(Locale.ROOT))) {
                                    list.add(vakacationClass);


                                }
                                else if (arrayListds.get(spinner.getSelectedItemPosition()).getName().toLowerCase(Locale.ROOT).equals(vakacationClass.getOlke().toLowerCase(Locale.ROOT))
                                        && vakansiya.getSelectedItem().toString().toLowerCase(Locale.ROOT).equals(vakacationClass.getVakansiyanin_adi().toLowerCase(Locale.ROOT))) {
                                    list.add(vakacationClass);

                                    System.out.println(vakansiya.getSelectedItem().toString());
                                    System.out.println(vakansiyarray[vakansiya.getSelectedItemPosition()]);

                                }
                                else if (arrayListds.get(spinner.getSelectedItemPosition()).getName().toLowerCase(Locale.ROOT).equals(vakacationClass.getOlke().toLowerCase(Locale.ROOT))
                                        && vakansiya.getSelectedItem().toString().toLowerCase(Locale.ROOT).equals("vakansiyalar") ){
                                    list.add(vakacationClass);


                                }
                            }
                            reycelvieü.filterList(list);
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });

                    vakansiya.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            ArrayList<vakacation_class> list=new ArrayList<>();
                            for (vakacation_class vakacationClass:arrayList){

                                System.out.println(  arrayListds.get(spinner.getSelectedItemPosition()).getName().toLowerCase(Locale.ROOT));

                                if (arrayListds.get(spinner.getSelectedItemPosition()).getName().toLowerCase(Locale.ROOT).equals("ölkələr")&&vakansiya.getSelectedItem().toString().equals("vakansiyalar")){
                                    list.add(vakacationClass);
                                }else if (arrayListds.get(spinner.getSelectedItemPosition()).getName().toLowerCase(Locale.ROOT).equals("ölkələr") && vakansiya.getSelectedItem().toString().toLowerCase(Locale.ROOT).equals(vakacationClass.getVakansiyanin_adi().toLowerCase(Locale.ROOT))) {
                                    list.add(vakacationClass);
                                    System.out.println("terkan");

                                }
                                else if (arrayListds.get(spinner.getSelectedItemPosition()).getName().toLowerCase(Locale.ROOT).equals(vakacationClass.getOlke().toLowerCase(Locale.ROOT)) && vakansiya.getSelectedItem().toString().toLowerCase(Locale.ROOT).equals(vakacationClass.getVakansiyanin_adi().toLowerCase(Locale.ROOT))) {
                                    list.add(vakacationClass);
                                    System.out.println("elanat");
                                    System.out.println(vakansiya.getSelectedItem().toString());
                                    System.out.println(vakansiyarray[vakansiya.getSelectedItemPosition()]);

                                }
                                else if (arrayListds.get(spinner.getSelectedItemPosition()).getName().toLowerCase(Locale.ROOT).equals(vakacationClass.getOlke().toLowerCase(Locale.ROOT)) && vakansiya.getSelectedItem().toString().toLowerCase(Locale.ROOT).equals("vakansiyalar") ){
                                    list.add(vakacationClass);
                                    System.out.println("kenan");
                                }
                            }
                            reycelvieü.filterList(list);
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });
                }
            }
        });

    }

    public void myString(String newstr) {
        ArrayList<vakacation_class> listofdata = new ArrayList<>();

        for (vakacation_class class1 : arrayList) {

            if (class1.getVakansiyanin_adi().toLowerCase(Locale.ROOT).contains(newstr.toLowerCase(Locale.ROOT))) {
                listofdata.add(class1);
            }
        }

            reycelvieü.filterList(listofdata);




    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.add_vakansiya) {
            Intent intent = new Intent(MainActivity.this, admin_vakansiya.class);
            startActivity(intent);
        }
        else if (item.getItemId()==R.id.muracietsiyahsi){
            Intent intent = new Intent(MainActivity.this,muraciet_edenler.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {


        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.admin_menu, menu);





        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        if (firebaseUser!=null) {


            Intent intent = getIntent();
            String portone = intent.getStringExtra("port");

            if (!firebaseUser.getEmail().equals("qezenfer.aloyev@haralar.com")) {
                MenuItem menuItem = menu.findItem(R.id.add_vakansiya);
                MenuItem menuItem1 = menu.findItem(R.id.delete_vakansiay);

                MenuItem menuItem3 = menu.findItem(R.id.muracietsiyahsi);

                menuItem.setVisible(false);
                menuItem1.setVisible(false);

                menuItem3.setVisible(false);
            }


        }
        else {
            MenuItem menuItem = menu.findItem(R.id.add_vakansiya);
            MenuItem menuItem1 = menu.findItem(R.id.delete_vakansiay);

            MenuItem menuItem3 = menu.findItem(R.id.muracietsiyahsi);

            menuItem.setVisible(false);
            menuItem1.setVisible(false);

            menuItem3.setVisible(false);
        }

        return super.onPrepareOptionsMenu(menu);
    }
}