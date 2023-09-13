package com.sananibrahimov.adding_new_column;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.firebase.firestore.FirebaseFirestore;
import com.sananibrahimov.adding_new_column.databinding.AdapterrowBinding;
import com.sananibrahimov.adding_new_column.databinding.VisarowBinding;

import java.util.ArrayList;

public class visa_adapter extends RecyclerView.Adapter<visa_adapter.viewholder1> {

     ArrayList<visaclass> visaclassArrayList;
     FirebaseFirestore firestore=FirebaseFirestore.getInstance();

    public visa_adapter(ArrayList<visaclass> visaclassArrayList) {
        this.visaclassArrayList = visaclassArrayList;
    }

    public void funfiletlista(ArrayList<visaclass>  vizaarraylist){
       visaclassArrayList=vizaarraylist;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public visa_adapter.viewholder1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        VisarowBinding  binding=VisarowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
       return new viewholder1(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull visa_adapter.viewholder1 holder, @SuppressLint("RecyclerView") int position) {
      holder.binding.vizaofuser.setText(visaclassArrayList.get(position).nameofvisauser);

        System.out.println(visaclassArrayList.get(position).nameofvisauser);
        System.out.println(visaclassArrayList.size());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                BottomSheetDialog bottomSheetDialog=new BottomSheetDialog(holder.itemView.getContext());
                     bottomSheetDialog.setContentView(R.layout.bottom_sheet_diolog);
                LinearLayout read=bottomSheetDialog.findViewById(R.id.read);
                LinearLayout update=bottomSheetDialog.findViewById(R.id.update);
                bottomSheetDialog.show();

                read.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        visaclass visaclass025=visaclassArrayList.get(position);
                        Intent intent=new Intent(holder.itemView.getContext(),visaprosuderi.class);
                        intent.putExtra("uservisa",visaclass025.getNameofvisauser());
                        intent.putExtra("visaid",visaclass025.getId());
                        intent.putExtra("xaricipasportviza",visaclass025.getXarici_passport());
                        intent.putExtra("Apostilvisa",visaclass025.getApostil());
                        intent.putExtra("vizasekil3eded",visaclass025.getSekil());
                        intent.putExtra("svesiqesinin_sureti",visaclass025.getVəsiqə_sureti());
                        intent.putExtra("is_devetivisa",visaclass025.getIs_deveti());
                        intent.putExtra("visaqalacagiyerinarayis",visaclass025.getQalacagiyer_arayis());
                        intent.putExtra("sigortavisa",visaclass025.getSigorta());
                        intent.putExtra("sengenvizasivvisa",visaclass025.getSengen_vizasi_form());
                        intent.putExtra("visarusumu80",visaclass025.getViza_rusumu());
                        intent.putExtra("sefirliyemuraciet",visaclass025.getSefirlik_muraciet_tarix());
                        intent.putExtra("sefirlikle_gorus_tarix",visaclass025.getTeyin_olunan_vaxt());
                        intent.putExtra("neticeviza",visaclass025.getSened_netice());
                        intent.putExtra("ucusbronu",visaclass025.getBron());
                        intent.putExtra("gmail",visaclass025.getGmail());
                        intent.putExtra("Apostil_tercume",visaclass025.getApostil_tercumel());
                        intent.putExtra("tercumedengeldiyi_vaxt",visaclass025.getApostilin_geldiyi_vaxt());
                        intent.putExtra("apostil_baslama",visaclass025.getApostin_baslama_tarixi());
                        intent.putExtra("Apostyil_bitme",visaclass025.getApostilin_bitme_tarixi());
                        intent.putExtra("isdevetinemuraciet",visaclass025.getIsdevetine_muraciet());
                        intent.putExtra("isdevetinin_baslama_tarixi",visaclass025.getIs_devetinin_baslama_tarixi());
                        intent.putExtra("isdevetinin bitme tarixi",visaclass025.getIs_devetinin_bitme_tarixi());
                        intent.putExtra("sigortaya_muraciet",visaclass025.getSigortaya_muraciet_tarixi());
                        intent.putExtra("sigortaninbaslama_tarixi",visaclass025.getSigortaya_baslama_tarixi());
                        intent.putExtra("sigorta_bitme",visaclass025.getSigorta_bitme_tarixi());
                        intent.putExtra("reng",visaclass025.getReng());


                        intent.putExtra("visaprosdureri",2);
                        holder.itemView.getContext().startActivity(intent);
                        ((navigation_activity)holder.itemView.getContext()).finish();
                        bottomSheetDialog.dismiss();

                    }
                });

                update.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        visaclass visaclass025=visaclassArrayList.get(position);
                         Intent intent=new Intent(holder.itemView.getContext(),visaprosuderi.class);
                            intent.putExtra("uservisa",visaclass025.getNameofvisauser());
                            intent.putExtra("visaid",visaclass025.getId());
                            intent.putExtra("xaricipasportviza",visaclass025.getXarici_passport());
                            intent.putExtra("Apostilvisa",visaclass025.getApostil());
                        intent.putExtra("vizasekil3eded",visaclass025.getSekil());
                        intent.putExtra("svesiqesinin_sureti",visaclass025.getVəsiqə_sureti());
                        intent.putExtra("is_devetivisa",visaclass025.getIs_deveti());
                        intent.putExtra("visaqalacagiyerinarayis",visaclass025.getQalacagiyer_arayis());
                        intent.putExtra("sigortavisa",visaclass025.getSigorta());
                        intent.putExtra("sengenvizasivvisa",visaclass025.getSengen_vizasi_form());
                        intent.putExtra("visarusumu80",visaclass025.getViza_rusumu());
                        intent.putExtra("sefirliyemuraciet",visaclass025.getSefirlik_muraciet_tarix());
                        intent.putExtra("sefirlikle_gorus_tarix",visaclass025.getTeyin_olunan_vaxt());
                        intent.putExtra("neticeviza",visaclass025.getSened_netice());
                        intent.putExtra("ucusbronu",visaclass025.getBron());
                        intent.putExtra("gmail",visaclass025.getGmail());
                        intent.putExtra("Apostil_tercume",visaclass025.getApostil_tercumel());
                        intent.putExtra("tercumedengeldiyi_vaxt",visaclass025.getApostilin_geldiyi_vaxt());
                        intent.putExtra("apostil_baslama",visaclass025.getApostin_baslama_tarixi());
                        intent.putExtra("Apostyil_bitme",visaclass025.getApostilin_bitme_tarixi());
                        intent.putExtra("isdevetinemuraciet",visaclass025.getIsdevetine_muraciet());
                        intent.putExtra("isdevetinin_baslama_tarixi",visaclass025.getIs_devetinin_baslama_tarixi());
                        intent.putExtra("isdevetinin bitme tarixi",visaclass025.getIs_devetinin_bitme_tarixi());
                        intent.putExtra("sigortaya_muraciet",visaclass025.getSigortaya_muraciet_tarixi());
                        intent.putExtra("sigortaninbaslama_tarixi",visaclass025.getSigortaya_baslama_tarixi());
                        intent.putExtra("sigorta_bitme",visaclass025.getSigorta_bitme_tarixi());
                        intent.putExtra("reng",visaclass025.getReng());


                        intent.putExtra("visaprosdureri",1);
                        holder.itemView.getContext().startActivity(intent);
                        ((navigation_activity)holder.itemView.getContext()).finish();
                             bottomSheetDialog.dismiss();


                    }
                });


            }
        });

    }

    @Override
    public int getItemCount() {
        return visaclassArrayList.size();
    }

    public class viewholder1 extends RecyclerView.ViewHolder{

        VisarowBinding binding;

        public viewholder1( VisarowBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
