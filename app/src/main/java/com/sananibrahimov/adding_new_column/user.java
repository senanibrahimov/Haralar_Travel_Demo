package com.sananibrahimov.adding_new_column;

import java.util.ArrayList;

public class user  {

    private ArrayList<user> arrayList;



    String id;
    String  name;
    int image;

    public user(String id, String name,    int image
    ) {
        this.id = id;
        this.name = name;
        this.image=image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public  ArrayList<user> getarryylist(){

        return arrayList;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
