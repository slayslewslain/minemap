package com.augmentis.ayp.minemap.model;

public class MineLocation {

    private double latitude;
    private double longitude;
    private int type;

    public MineLocation() {

        latitude = 0;
        longitude = 0;
        type = 1;
    }

    private static MineLocation instance;

    public static MineLocation getInstance() {
        if (instance == null) {
            instance = new MineLocation();
        }
        return instance;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }


}
