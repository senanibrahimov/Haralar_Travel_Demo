package com.sananibrahimov.adding_new_column;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.firebase.firestore.FirebaseFirestore;
import com.sananibrahimov.adding_new_column.databinding.AdapterrowBinding;
import com.sananibrahimov.adding_new_column.databinding.ReycelRowBinding;

import java.util.ArrayList;

public class adapterinfo extends RecyclerView.Adapter<adapterinfo.newviewholder> {

    ArrayList<generalinfo> arrayList;
    int postion1;



    public adapterinfo(ArrayList<generalinfo> arrayList) {
        this.arrayList = arrayList;



    }

    public  void filter(ArrayList<generalinfo> generalinfoArrayList){
        arrayList=generalinfoArrayList;
         notifyDataSetChanged();


    }




    @NonNull
    @Override
    public adapterinfo.newviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       AdapterrowBinding binding=AdapterrowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new newviewholder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull adapterinfo.newviewholder holder, @SuppressLint("RecyclerView") int position) {
       holder.binding.nameofuser.setText(arrayList.get(position).username);


       holder.itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               postion1=position;

               final BottomSheetDialog dialog=new BottomSheetDialog(holder.itemView.getContext());
               dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
               dialog.setContentView(R.layout.bottom_sheet_diolog);
               LinearLayout read=dialog.findViewById(R.id.read);
               LinearLayout update=dialog.findViewById(R.id.update);
               LinearLayout delete=dialog.findViewById(R.id.delete);
               dialog.show();

               read.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {
                       generalinfo generalinfo21=arrayList.get(position);
                       Intent intent=new Intent(holder.itemView.getContext(),enterofuserinfo.class);
                       intent.putExtra("id",generalinfo21.getId());
                       intent.putExtra("salam",1);
                       intent.putExtra("vesiqe",generalinfo21.sexsiyyet);
                       intent.putExtra("name",generalinfo21.username);
                       intent.putExtra("muqavilenintarixi",generalinfo21.muqavilenin_tarixi);
                       intent.putExtra("muqavilenin_nomresi",generalinfo21.muqavilenin_nomresi);
                       intent.putExtra("muraciettarixi",generalinfo21.muraciet_tarixi);
                       intent.putExtra("olke",generalinfo21.olke);
                       intent.putExtra("sirket",generalinfo21.sirket);
                       intent.putExtra("vakansiya_date",generalinfo21.vakansiya_date);
                       intent.putExtra("odenilecek_mebleg",generalinfo21.odenilecek_mebleg);
                       intent.putExtra("qaliq_borc",generalinfo21.qaliq_borc);
                       intent.putExtra("ilkin_odenis",generalinfo21.ilkin_odenis);
                       intent.putExtra("number",generalinfo21.number);
                       intent.putExtra("xarici_paspport",generalinfo21.getXarici_passportun_nomrsi());
                       intent.putExtra("dogum",generalinfo21.dogum_tarixi);
                       intent.putExtra("millliyet",generalinfo21.milliyeti);
                       intent.putExtra("unvan12",generalinfo21.unvan);
                       intent.putExtra("gmail",generalinfo21.gmail);
                       intent.putExtra("xaricbaslama",generalinfo21.xaricipassport_baslama);
                       intent.putExtra("xaricbitme",generalinfo21.xaricipassport_bitme);
                       intent.putExtra("anket123",generalinfo21.anket);

                       intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                       holder.itemView.getContext().startActivity(intent);
                       ((navigation_activity)holder.itemView.getContext()).finish();
                       dialog.dismiss();





                   }
               });
               update.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {
                       generalinfo generalinfo21=arrayList.get(position);
                       Intent intent=new Intent(holder.itemView.getContext(),enterofuserinfo.class);
                       intent.putExtra("salam",2);
                       intent.putExtra("vesiqe",generalinfo21.sexsiyyet);
                       intent.putExtra("name",generalinfo21.username);
                       intent.putExtra("muqavilenintarixi",generalinfo21.muqavilenin_tarixi);
                       intent.putExtra("muqavilenin_nomresi",generalinfo21.muqavilenin_nomresi);
                       intent.putExtra("muraciettarixi",generalinfo21.muraciet_tarixi);
                       intent.putExtra("olke",generalinfo21.olke);
                       intent.putExtra("sirket",generalinfo21.sirket);
                       intent.putExtra("vakansiya_date",generalinfo21.vakansiya_date);
                       intent.putExtra("odenilecek_mebleg",generalinfo21.odenilecek_mebleg);
                       intent.putExtra("qaliq_borc",generalinfo21.qaliq_borc);
                       intent.putExtra("ilkin_odenis",generalinfo21.ilkin_odenis);
                       intent.putExtra("number",generalinfo21.number);
                       intent.putExtra("xarici_paspport",generalinfo21.getXarici_passportun_nomrsi());
                       intent.putExtra("dogum",generalinfo21.dogum_tarixi);
                       intent.putExtra("millliyet",generalinfo21.milliyeti);
                       intent.putExtra("unvan12",generalinfo21.unvan);
                       intent.putExtra("id",generalinfo21.getId());
                       intent.putExtra("gmail",generalinfo21.gmail);
                       intent.putExtra("xaricbaslama",generalinfo21.xaricipassport_baslama);
                       intent.putExtra("xaricbitme",generalinfo21.xaricipassport_bitme);
                       intent.putExtra("anket123",generalinfo21.anket);
                       holder.itemView.getContext().startActivity(intent);
                       dialog.dismiss();
                       ((navigation_activity)holder.itemView.getContext()).finish();

                   }
               });






           }
       });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class newviewholder  extends RecyclerView.ViewHolder {
        AdapterrowBinding binding;
        public newviewholder(AdapterrowBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }


}
