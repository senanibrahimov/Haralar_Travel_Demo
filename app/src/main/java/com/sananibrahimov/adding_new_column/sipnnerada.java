package com.sananibrahimov.adding_new_column;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.firebase.firestore.auth.User;

import java.util.ArrayList;
import java.util.List;

public class sipnnerada extends ArrayAdapter<user>{






    LayoutInflater layoutInflater;


    public sipnnerada(@NonNull Context context, int resource, @NonNull ArrayList<user> userof) {
        super(context, resource, userof);


        layoutInflater=LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view= layoutInflater.inflate(R.layout.custom_spinner,parent,false);
        TextView textView=view.findViewById(R.id.spinner_text);
        ImageView imageView=view.findViewById(R.id.spinner_image);
        user user=getItem(position);
        textView.setText(user.getName());
        imageView.setImageResource(user.getImage());





        return view;
    }



    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView==null)
          convertView= layoutInflater.inflate(R.layout.custom_spinner,parent,false);
        TextView textView=convertView.findViewById(R.id.spinner_text);
        ImageView imageView=convertView.findViewById(R.id.spinner_image);
        user user=getItem(position);
        textView.setText(user.getName());
        imageView.setImageResource(user.getImage());

        return convertView;
    }



}
