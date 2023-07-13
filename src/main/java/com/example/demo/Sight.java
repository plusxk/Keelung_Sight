package com.example.demo;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
public class Sight {
    private String SightName;
    private String zone;
    private String Category;
    private String PhotoURL;
    private String Description;
    private String Address;
    public Sight(){

    }
    public Sight(String sightName, String zone, String category, String photoURL,String description,String address){
        this.SightName=sightName;
        this.zone=zone;
        this.Category=category;
        this.PhotoURL=photoURL;
        this.Description=description;
        this.Address=address;
    }
    public Sight(Sight x) {
        this.SightName = x.getSightName();
        this.zone = x.getZone();
        this.Category = x.getCategory();
        this.PhotoURL = x.getPhotoURL();
        this.Description = x.getDescription();
        this.Address = x.getAddress();
    }

    public String toString(){
        return "SightName: "+this.SightName+"\n"+"Zone: "+this.zone+"\n"+"Category: "+this.Category+"\n"+"PhotoURL: "+this.PhotoURL+"\n"+"Description: "+this.Description+"\n"+"Address: "+this.Address+"\n";
    }
    public String getSightName() {
        return SightName;
    }

    public void setSightName(String sightName) {
        SightName = sightName;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getPhotoURL() {
        return PhotoURL;
    }

    public void setPhotoURL(String photoURL) {
        PhotoURL = photoURL;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
