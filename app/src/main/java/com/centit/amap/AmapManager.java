package com.centit.amap;

import android.content.Context;
import android.graphics.Color;

import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdate;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.PolylineOptions;
import com.centit.amap.database.Location;
import com.centit.amap.database.MapDatebaseManager;
import com.centit.amap.util.SharedUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhu_yu on 2017/10/24.
 */

public class AmapManager {
    Context mContext;

    //地图控制器对象
    private AMap aMap;
    // //坐标点集合
    List<LatLng> latLngs = new ArrayList<LatLng>();
    //绘制线段的选项类
    PolylineOptions polylineOptions;
    //地图摄像机
    private CameraUpdate mUpdate;

    //数据库管理类
    private MapDatebaseManager dbManager;
    //锚点
    private Marker marker;
    //锚点设置
    private MarkerOptions markerOptions;
    //第一个点是否是起点
    public  boolean isFirstPoint = false;
    //线段的颜色
    int lineColor = Color.argb(255, 216, 30, 6);

    public AmapManager(Context conext, MapView mapView) {
        this.mContext = conext;
        dbManager = new MapDatebaseManager(conext);
        if (aMap == null) {
            aMap = mapView.getMap();
        }
        //设置线段属性
        polylineOptions = new PolylineOptions().width(10).color(lineColor);
        //设置锚点属性锚点
        markerOptions = new MarkerOptions();
        // 绑定 Marker 被点击事件
        aMap.setOnMarkerClickListener(markerClickListener);
        //绑定信息窗点击事件
        aMap.setOnInfoWindowClickListener(infoWindowClicklistener);

    }

    /**
     * 每次开始定位前都需要初始化一下map
     */
    public void initAmapBeforeStart() {
        //每次开始服务之前，进行数据库清空
        //dbManager.clear();
        //清空坐标集合
        latLngs.clear();
        //i = 0;
        aMap.clear();
        //
        SharedUtil.putValue(mContext, SharedUtil.isRestartService, true);
        //第一个点是否是起点
        isFirstPoint = true;
        //设置线段属性
        polylineOptions = new PolylineOptions().width(10).color(lineColor);
        aMap.addPolyline(polylineOptions);
        //恢复marker点为起点
        markerOptions.anchor(0.5f, 1.0f).icon(BitmapDescriptorFactory.fromResource(R.drawable.start2_80));
    }

    public void clear(){
        //进行数据库清空
        dbManager.clear();
        //清空坐标集合
        latLngs.clear();
        //i = 0;
        aMap.clear();
    }
    int count =0;
    LatLng mlastlatLng;
    /**
     * 在mapservice成功定位后回调的业务逻辑
     */
    public void onAmapLocationSucces(Location location) {
        //真实路径点
        LatLng mTemplatLng = new LatLng(location.lat, location.lng);


        //测试
       // dbManager.add(location);
        //模拟路径点
        // LatLng mTemplatLng = new LatLng(31.972 + i, 118.755 + i);
        //i = i + 0.01;
       // latLngs.add(mTemplatLng);
        //如果第一个点是起点，先画个起点
        if (isFirstPoint) {
            // markerOptions.icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.start2_32)));
            markerOptions.anchor(0.5f, 1.0f).icon(BitmapDescriptorFactory.fromResource(R.drawable.start2_80));
            //添加锚点
            markerOptions.position(mTemplatLng).title("位置：" + location.address).snippet("时间" + location.time);
            //画锚点
            aMap.addMarker(markerOptions);
            isFirstPoint = false;
        }
        //画完第一个起始点后，将marker点改为小圆点
        markerOptions.anchor(0.5f, 0.5f).icon(BitmapDescriptorFactory.fromResource(R.drawable.point_32));
        //添加锚点
       markerOptions.position(mTemplatLng).title("位置：" + location.address).snippet("时间" + location.time);
        //画锚点
     aMap.addMarker(markerOptions);
        //添加坐标
        polylineOptions.add(mTemplatLng);
        //链接坐标
        aMap.addPolyline(polylineOptions);
        //第一个参数是缩放比例，0是倾斜度，30显示比例
       mUpdate = CameraUpdateFactory.newCameraPosition(new CameraPosition(mTemplatLng, 17, 0, 0));
        aMap.moveCamera(mUpdate);//移动摄像头


    //解决持续绘制时越来越卡顿的算法
        count++;
        if (count==2){
            mlastlatLng=mTemplatLng;
            polylineOptions = new PolylineOptions().width(10).color(lineColor);
            polylineOptions.add(mlastlatLng);
            count=0;
        }

    }

    /**
     * 从数据库中查询点并绘制
     */
    public void drawLineFromDB() {



        List<Location> locationList = dbManager.query();

       // List<Location> locationList = dbManager.queryLocationsById(0);
        LatLng latlng = null;
        polylineOptions = new PolylineOptions().width(10).color(lineColor);
        for (int j = 0; j < locationList.size(); j++) {
            Location location = locationList.get(j);
            latlng = new LatLng(location.lat, location.lng);
            // i = i + 0.01;
            //画起始点图标
            if (j == 0) {
                markerOptions.anchor(0.5f, 1.0f).icon(BitmapDescriptorFactory.fromResource(R.drawable.start2_80));
                //添加锚点
                markerOptions.position(latlng).title("位置：" + location.address).snippet("时间：" + location.time);
                //画锚点
                aMap.addMarker(markerOptions);
            }

            //然后画小圆点
            markerOptions.anchor(0.5f, 0.5f).icon(BitmapDescriptorFactory.fromResource(R.drawable.point_32));
            //添加锚点
            markerOptions.position(latlng).title("位置：" + location.address).snippet("时间：" + location.time);
            //画锚点
            aMap.addMarker(markerOptions);
            //添加坐标
            polylineOptions.add(latlng);
        }
        //链接坐标
        //第一个参数是缩放比例，0是倾斜度，30显示比例
        mUpdate = CameraUpdateFactory.newCameraPosition(new CameraPosition(latlng, 17, 0, 0));
        aMap.addPolyline(polylineOptions);
        aMap.moveCamera(mUpdate);//移动摄像头

    }

    /**
     * 绘制终点
     * 用在停止服务的时候
     */
    public void drawLastPositionFromDB() {
        Location location = null;
        //查询数据库中最后一个点
        List<Location> locationList = dbManager.querylastLocation(1);
        if (locationList.size() > 0) {
            location = locationList.get(0);
            //获取经纬度
            LatLng latlng = new LatLng(location.lat, location.lng);
            //获取地址
            String address = location.address;
            //获取时间
            String time = location.time;
            //设置终点图标
            markerOptions.anchor(0.5f, 1.0f).icon(BitmapDescriptorFactory.fromResource(R.drawable.end2_80));

            //添加锚点
            markerOptions.position(latlng).title("位置：" + address).snippet("时间：" + time);
            //画锚点
            aMap.addMarker(markerOptions);
        }
    }

    // 定义 Marker 点击事件监听
    AMap.OnMarkerClickListener markerClickListener = new AMap.OnMarkerClickListener() {
        // marker 对象被点击时回调的接口
        // 返回 true 则表示接口已响应事件，否则返回false
        @Override
        public boolean onMarkerClick(Marker marker) {

            //  显示marker点的信息
            marker.showInfoWindow();

            return true;
        }
    };
    //inforwindow 点击事件监听
    AMap.OnInfoWindowClickListener infoWindowClicklistener = new AMap.OnInfoWindowClickListener() {


        @Override
        public void onInfoWindowClick(Marker marker) {
            marker.hideInfoWindow();
        }
    };


}
