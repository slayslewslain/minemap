package com.augmentis.ayp.minemap.model;

import java.util.ArrayList;

/**
 * Created by Apinya on 10/4/2016.
 */

public class LocationItem {

    public static  ArrayList<LocationItem> locationItems = new ArrayList<LocationItem>();

    private String id_user;
    private String loc_id;
    private String loc_name;
    private String loc_lat;
    private String loc_long;
    private String loc_type;
    private String loc_tel;
    private String loc_des;
    private String loc_pic;
    private String loc_date;


    public LocationItem(){
        id_user = "";
        loc_id = "";
        loc_name = "";
        loc_lat = "";
        loc_long = "";
        loc_type = "";
        loc_tel = "";
        loc_des = "";
        loc_pic = "";
        loc_date = "";
    }

    protected static LocationItem instance;

    public static LocationItem getInstance() {
        if (instance == null) {
            instance = new LocationItem();
        }
        return instance;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public String getLoc_id() {
        return loc_id;
    }

    public void setLoc_id(String loc_id) {
        this.loc_id = loc_id;
    }

    public String getLoc_name() {
        return loc_name;
    }

    public void setLoc_name(String loc_name) {
        this.loc_name = loc_name;
    }

    public String getLoc_lat() {
        return loc_lat;
    }

    public void setLoc_lat(String loc_lat) {
        this.loc_lat = loc_lat;
    }

    public String getLoc_long() {
        return loc_long;
    }

    public void setLoc_long(String loc_long) {
        this.loc_long = loc_long;
    }

    public String getLoc_type() {
        return loc_type;
    }

    public void setLoc_type(String loc_type) {
        this.loc_type = loc_type;
    }

    public String getLoc_tel() {
        return loc_tel;
    }

    public void setLoc_tel(String loc_tel) {
        this.loc_tel = loc_tel;
    }

    public String getLoc_des() {
        return loc_des;
    }

    public void setLoc_des(String loc_des) {
        this.loc_des = loc_des;
    }

    public String getLoc_pic() {
        return "IMG_" + getLoc_id() + ".jpg";
    }

    public void setLoc_pic(String loc_pic) {
        this.loc_pic = loc_pic;
    }

    public String getLoc_date() {
        return loc_date;
    }

    public void setLoc_date(String loc_date) {
        this.loc_date = loc_date;
    }
}
