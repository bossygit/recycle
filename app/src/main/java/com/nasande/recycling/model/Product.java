package com.nasande.recycling.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Product {
    @SerializedName("title")
    private String title;

    @SerializedName("price__number")
    private String price__number;

    @SerializedName("field_image")
    private String field_image;


    public Product(String title, String price__number, String field_image) {
        this.title = title;
        this.price__number = price__number;
        this.field_image = field_image;
    }

    public String getTitle() {
        return title;
    }

    public String getPrice__number() {
        return price__number;
    }

    public String getField_image() {
        return "http://mayamaya.nasande.cg" + field_image;
    }






    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice__number(String price__number) {
        this.price__number = price__number;
    }

    public void setField_image(String field_image) {
        this.field_image = field_image;
    }
}
