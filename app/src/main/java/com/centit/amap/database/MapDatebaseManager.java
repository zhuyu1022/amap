package com.centit.amap.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by zhu_yu on 2017/10/10.
 */

public class MapDatebaseManager {
    private MapDatabaseHelper dbHelper;
    private SQLiteDatabase db;

    public MapDatebaseManager(Context context) {
        //打开、创建数据库
        dbHelper=new MapDatabaseHelper(context,"Location.db",null,1);
        //获取数据库的实例
        db=dbHelper.getWritableDatabase();
    }

    /**
     * 添加坐标数据
     * @param location
     */
    public boolean  add(Location location){
       // Date date=new Date();
       db.beginTransaction(); // 开始事务
        try
        {
            db.execSQL("insert into location(time ,lat,lon,address,userid) values(?,?,?,?,?)",
                    new Object[]{location.time,location.lat,location.lng,location.address,location.userid });

            db.setTransactionSuccessful(); // 设置事务成功完成
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
        finally
        {
            db.endTransaction(); // 结束事务
        }
        return true;
    }


    /**
     * 查询所有数据
     * @return
     */
    public ArrayList<Location> query(){

            Cursor cursor=db.rawQuery("select * from location ",null);
        ArrayList<Location> list=new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                Location location =new Location();
                location.time=cursor.getString(1);
                location.lat=cursor.getFloat(2);
                location.lng=cursor.getFloat(3);
                location.address=cursor.getString(4);
                location.userid=cursor.getString(5);

                list.add(location);
            }while(cursor.moveToNext());

        }
        cursor.close();
        return list;

    }




    /**
     * 查询大于某个id的所有数据
     * @return
     */
    public ArrayList<Location> queryLocationsById(int id){

        Cursor cursor=db.rawQuery("select * from location where id > "+id,null);
        ArrayList<Location> list=new ArrayList<>();
        if (cursor.moveToFirst()) {


            do {
                Location location =new Location();
                location.time=cursor.getString(1);
                location.lat=cursor.getFloat(2);
                location.lng=cursor.getFloat(3);
                location.address=cursor.getString(4);
                location.userid=cursor.getString(5);

                list.add(location);
            }while(cursor.moveToNext());

        }
        cursor.close();
        return list;

    }


    /**
     * 查询大于time的所有数据
     * @return
     */
    public ArrayList<Location> queryLocationsByTime(String time){

        Cursor cursor=db.rawQuery("select * from location where time > '"+time+"'",null);
        ArrayList<Location> list=new ArrayList<>();
        if (cursor.moveToFirst()) {


            do {
                Location location =new Location();
                location.time=cursor.getString(1);
                location.lat=cursor.getFloat(2);
                location.lng=cursor.getFloat(3);
                location.address=cursor.getString(4);
                location.userid=cursor.getString(5);

                list.add(location);
            }while(cursor.moveToNext());

        }
        cursor.close();
        return list;

    }


    /**
     * 查询数据库最后一条记录的id
     * @return
     */
    public int  querylastId(){

        Cursor cursor=db.rawQuery("select * from location order by id desc limit 1",null);
        int id=0;
        if (cursor.moveToFirst()) {
            do {

                id =cursor.getInt(0);

            }while(cursor.moveToNext());

        }
        cursor.close();
        return id;

    }


    /**
     * 查询数据库最后一条记录的Time
     * @return
     */
    public String  querylastTime(){

        Cursor cursor=db.rawQuery("select * from location order by id desc limit 1",null);
        String time="";
        if (cursor.moveToFirst()) {
            do {
                time =cursor.getString(1);
            }while(cursor.moveToNext());
        }
        cursor.close();
        return time;

    }



    /**
     * 查询最后几条数据
     * @return
     */
    public ArrayList<Location> querylastLocation(int n){

        Cursor cursor=db.rawQuery("select * from location order by id desc limit "+n,null);
        ArrayList<Location> list=new ArrayList<>();
        if (cursor.moveToFirst()) {


            do {
                Location location =new Location();
                location.time=cursor.getString(1);
                location.lat=cursor.getFloat(2);
                location.lng=cursor.getFloat(3);
                location.address=cursor.getString(4);
                location.userid=cursor.getString(5);

                list.add(location);
            }while(cursor.moveToNext());

        }
        cursor.close();
        return list;


    }

    /**
     * 清空数据库数据
     * @return
     */
    public boolean clear(){
        db.beginTransaction(); // 开始事务
        try
        {
            db.execSQL("delete from location");

            db.setTransactionSuccessful(); // 设置事务成功完成

        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
        finally
        {
            db.endTransaction(); // 结束事务
        }
        return true;
    }



}
