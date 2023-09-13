package com.sananibrahimov.adding_new_column;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.sananibrahimov.adding_new_column.databinding.ActivityMuracietEdenlerBinding;
import com.sananibrahimov.adding_new_column.databinding.ActivityVakansiyayaMuracietBinding;
import com.sananibrahimov.adding_new_column.databinding.MuracietEdenlerBinding;

import java.util.ArrayList;

public class muracietadapter  extends RecyclerView.Adapter<muracietadapter.viewholder> {

     ArrayList<muraciet_data> muraciet_dataArrayList;
     muraciet_edenler muracietEdenler=new muraciet_edenler();

    public muracietadapter(ArrayList<muraciet_data> muraciet_dataArrayList) {
        this.muraciet_dataArrayList = muraciet_dataArrayList;
    }

    @NonNull
    @Override
    public muracietadapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MuracietEdenlerBinding binding=MuracietEdenlerBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);



        return new viewholder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull muracietadapter.viewholder holder, @SuppressLint("RecyclerView") int position) {
         holder.binding.textmuraciet.setText(muraciet_dataArrayList.get(position).gmail);

           if ( muraciet_dataArrayList.get(position).durum==true){
               holder.binding.imagemuraciet.setImageResource(R.drawable.truuname);
           }
           else {
               holder.binding.imagemuraciet.setImageResource(R.drawable.truuname);
           }

            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    return false;
                }
            });



         holder.itemView.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  muraciet_data muraciet_data=muraciet_dataArrayList.get(position);

                  Dialog diolog=new Dialog(holder.itemView.getContext());

                  diolog.requestWindowFeature(Window.FEATURE_NO_TITLE);

                  diolog.setContentView(R.layout.muraciet_edenler_diolog);
                  Button ok=diolog.findViewById(R.id.ok_buuton);
                  TextView name=diolog.findViewById(R.id.muracietname);
                  TextView Surname=diolog.findViewById(R.id.muraciesurname);
                  TextView phone=diolog.findViewById(R.id.telefonmuraciet);
                  TextView gmail=diolog.findViewById(R.id.muracietgmail);
                  TextView  muraciet_elediyi_vakansiya=diolog.findViewById(R.id.vaksinmuraciet);

                  name.setText(muraciet_data.name);
                  Surname.setText(muraciet_data.surname);
                  phone.setText(muraciet_data.telefon);
                  gmail.setText(muraciet_data.gmail);
                  muraciet_elediyi_vakansiya.setText(muraciet_data.vakansiya);
                   diolog.show();

                  ok.setOnClickListener(new View.OnClickListener() {
                      @Override
                      public void onClick(View view) {
                          FirebaseFirestore firestore=FirebaseFirestore.getInstance();
                          firestore.collection("muracietedenler").document(muraciet_data.getId()).update("request",true).addOnSuccessListener(new OnSuccessListener<Void>() {
                              @Override
                              public void onSuccess(Void unused) {

                              }
                          });
                          diolog.dismiss();
                      }
                  });



              }
          });

   }

    @Override
    public int getItemCount() {
        return muraciet_dataArrayList.size();
    }



    public class viewholder  extends RecyclerView.ViewHolder {
        MuracietEdenlerBinding binding;
        public viewholder( MuracietEdenlerBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }

}
