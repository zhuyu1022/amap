package com.centit.amap.database;

/**
 * Created by zhu_yu on 2017/10/10.
 */

public class Location {
    public Location() {

    }

    public Location(String time, double lat, double lng, String address, String userid,float speed) {
        this.time = time;
        this.lat = lat;
        this.lng = lng;
        this.address = address;
        this.userid = userid;
        this.speed=speed;
    }

    public String time;
    public double lat;
    public  double lng;
    public String address;
    public String userid;
    public float speed;
}
