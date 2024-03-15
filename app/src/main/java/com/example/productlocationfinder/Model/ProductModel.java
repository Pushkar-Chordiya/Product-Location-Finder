package com.example.productlocationfinder.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ProductModel implements Serializable {
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("pk_id")
    @Expose
    private String pk_id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("model_no")
    @Expose
    private String model_no;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("purchase_date")
    @Expose
    private String purchase_date;
    @SerializedName("wall_number")
    @Expose
    private String wall_number;
    @SerializedName("rack_number")
    @Expose
    private String rack_number;
    @SerializedName("section")
    @Expose
    private String section;
    @SerializedName("box")
    @Expose
    private String box;

    public ProductModel(){

    }

    public ProductModel(String message, String pk_id, String name, String model_no, String price, String purchase_date, String wall_number, String rack_number, String section, String box) {
        this.message = message;
        this.pk_id = pk_id;
        this.name = name;
        this.model_no = model_no;
        this.price = price;
        this.purchase_date = purchase_date;
        this.wall_number = wall_number;
        this.rack_number = rack_number;
        this.section = section;
        this.box = box;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPk_id() {
        return pk_id;
    }

    public void setPk_id(String pk_id) {
        this.pk_id = pk_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel_no() {
        return model_no;
    }

    public void setModel_no(String model_no) {
        this.model_no = model_no;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPurchase_date() {
        return purchase_date;
    }

    public void setPurchase_date(String purchase_date) {
        this.purchase_date = purchase_date;
    }

    public String getWall_number() {
        return wall_number;
    }

    public void setWall_number(String wall_number) {
        this.wall_number = wall_number;
    }

    public String getRack_number() {
        return rack_number;
    }

    public void setRack_number(String rack_number) {
        this.rack_number = rack_number;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getBox() {
        return box;
    }

    public void setBox(String box) {
        this.box = box;
    }
}
