package com.sananibrahimov.adding_new_column;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.sananibrahimov.adding_new_column.databinding.ReycelRowBinding;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Reycelvieü extends RecyclerView.Adapter<Reycelvieü.Myviewholder> {


    ArrayList<vakacation_class> arrayList;

    public Reycelvieü(ArrayList<vakacation_class> arrayList) {
        this.arrayList = arrayList;
    }
    public void filterList(ArrayList<vakacation_class> filterlist) {
        arrayList = filterlist;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Reycelvieü.Myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ReycelRowBinding binding=ReycelRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);

        return new Myviewholder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull Reycelvieü.Myviewholder holder, @SuppressLint("RecyclerView") int position) {
        holder.binding.workText.setText(arrayList.get(position).vakansiyanin_adi);
        holder.binding.locationText.setText(arrayList.get(position).olke);
        Picasso.get().load(arrayList.get(position).image).into(holder.binding.imagereycelview);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vakacation_class vakansiyainfo=arrayList.get(position);
                Intent intent=new Intent(holder.itemView.getContext(),vakansiyaya_muraciet.class);
                intent.putExtra("imageurl",vakansiyainfo.image);
                intent.putExtra("location",vakansiyainfo.olke);
                intent.putExtra("vakansiyaninadi",vakansiyainfo.vakansiyanin_adi);
                intent.putExtra("id",vakansiyainfo.getId());
                intent.putExtra("melumat",vakansiyainfo.getText_melmat());
                 holder.itemView.getContext().startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class Myviewholder extends  RecyclerView.ViewHolder {

        ReycelRowBinding binding;
        public Myviewholder(ReycelRowBinding binding) {

            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
