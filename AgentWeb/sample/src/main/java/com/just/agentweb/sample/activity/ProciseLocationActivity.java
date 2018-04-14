package com.just.agentweb.sample.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.KeyEvent;

import com.just.agentweb.sample.bean.LocationDataBean;
import com.just.agentweb.sample.common.AndroidInterface;

public class ProciseLocationActivity extends BaseWebActivity implements BaseWebActivity.OnLocationStationListener{
    // String url = "http://new.16-expo.com/";

//    public LocationClient mLocationClient = null;
//    private MyLocationListener myListener = new MyLocationListener();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d("TAG", "开始获取地理位置信息！");
        super.onCreate(savedInstanceState);
        // initBdMap();
        if(mAgentWeb!=null){
            //注入对象
            mAgentWeb.getJsInterfaceHolder().addJavaObject("android",new AndroidInterface(mAgentWeb,ProciseLocationActivity.this));
        }
    }
//
//    private void initBdMap() {
//        mLocationClient = new LocationClient(getApplicationContext());
//        //声明LocationClient类
//        mLocationClient.registerLocationListener(myListener);
//        //注册监听函数
//
//        LocationClientOption option = new LocationClientOption();
//
//        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
////可选，设置定位模式，默认高精度
////LocationMode.Hight_Accuracy：高精度；
////LocationMode. Battery_Saving：低功耗；
////LocationMode. Device_Sensors：仅使用设备；
//
//        option.setCoorType("bd09ll");
////可选，设置返回经纬度坐标类型，默认gcj02
////gcj02：国测局坐标；
////bd09ll：百度经纬度坐标；
////bd09：百度墨卡托坐标；
////海外地区定位，无需设置坐标类型，统一返回wgs84类型坐标
//
//        option.setScanSpan(10000); // 每10秒请求一次
////可选，设置发起定位请求的间隔，int类型，单位ms
////如果设置为0，则代表单次定位，即仅定位一次，默认为0
////如果设置非0，需设置1000ms以上才有效
//
//        option.setOpenGps(true);
////可选，设置是否使用gps，默认false
////使用高精度和仅用设备两种定位模式的，参数必须设置为true
//
//        option.setLocationNotify(true);
////可选，设置是否当GPS有效时按照1S/1次频率输出GPS结果，默认false
//
//        option.setIgnoreKillProcess(false);
////可选，定位SDK内部是一个service，并放到了独立进程。
////设置是否在stop的时候杀死这个进程，默认（建议）不杀死，即setIgnoreKillProcess(true)
//
//        option.SetIgnoreCacheException(false);
////可选，设置是否收集Crash信息，默认收集，即参数为false
//
//        option.setWifiCacheTimeOut(5 * 60 * 1000);
////可选，7.2版本新增能力
////如果设置了该接口，首次启动定位时，会先判断当前WiFi是否超出有效期，若超出有效期，会先重新扫描WiFi，然后定位
//
//        option.setEnableSimulateGps(false);
////可选，设置是否需要过滤GPS仿真结果，默认需要，即参数为false
//
//        option.setIsNeedAddress(true);
////可选，是否需要地址信息，默认为不需要，即参数为false
////如果开发者需要获得当前点的地址信息，此处必须为true
//
//        option.setIsNeedLocationDescribe(true);
////可选，是否需要位置描述信息，默认为不需要，即参数为false
////如果开发者需要获得当前点的位置信息，此处必须为true
//
//        mLocationClient.setLocOption(option);
////mLocationClient为第二步初始化过的LocationClient对象
////需将配置好的LocationClientOption对象，通过setLocOption方法传递给LocationClient对象使用
////更多LocationClientOption的配置，请参照类参考中LocationClientOption类的详细说明
//
//        mLocationClient.start();
////mLocationClient为第二步初始化过的LocationClient对象
////调用LocationClient的start()方法，便可发起定位请求
//    }
//
//    public class MyLocationListener extends BDAbstractLocationListener {
//        @Override
//        public void onLocDiagnosticMessage(int i, int i1, String s) {
//            super.onLocDiagnosticMessage(i, i1, s);
//            Log.d("TAG", "i==="+i+", "+i1+",  "+s);
//        }
//
//        @Override
//        public void onReceiveLocation(BDLocation location) {
//            //此处的BDLocation为定位结果信息类，通过它的各种get方法可获取定位相关的全部结果
//            //以下只列举部分获取经纬度相关（常用）的结果信息
//            //更多结果信息获取说明，请参照类参考中BDLocation类中的说明
//
//            Log.d("TAG", "BDLocation.getLocType() "+location.getLocType()+":::describe+++"+location.getLocTypeDescription());
//            double latitude = location.getLatitude();    //获取纬度信息
//            double longitude = location.getLongitude();    //获取经度信息
//            float radius = location.getRadius();    //获取定位精度，默认值为0.0f
//
//            String coorType = location.getCoorType();
//            //获取经纬度坐标类型，以LocationClientOption中设置过的坐标类型为准
//
//            int errorCode = location.getLocType();
//            //获取定位类型、定位错误返回码，具体信息可参照类参考中BDLocation类中的说明
//
//            Log.d("TAG", "d定位信息：\n 经纬度：" + longitude + ", " + latitude + "\n");
//            Log.d("TAG", "无关紧要的信息：" + radius + ",,," + coorType + ",,," + errorCode);
//
//            String addr = location.getAddrStr();    //获取详细地址信息
//            String country = location.getCountry();    //获取国家
//            String province = location.getProvince();    //获取省份
//            String city = location.getCity();    //获取城市
//            String district = location.getDistrict();    //获取区县
//            String street = location.getStreet();    //获取街道信息
//
//            Log.d("TAG", "获取的地址信息：" + addr + "\n" + country + "\n" + province + "\n" + city + "\n" + district + "\n" + street);
//
//            String locationDescribe = location.getLocationDescribe();    //获取位置描述信息
//            Log.d("TAG", "位置描述信息：" + locationDescribe);
//            // 缓存当前定位数据
//            if (addr != null) {
//                LocationDataBean bean = new LocationDataBean();
//                bean.setLatitude(location.getLatitude());
//                bean.setLongitude(location.getLongitude());
//                bean.setAddr(location.getAddrStr());
//                bean.setCountry(location.getCountry());
//                bean.setProvince(location.getProvince());
//                bean.setCity(location.getCity());
//                bean.setDistrict(location.getDistrict());
//                bean.setStreet(location.getStreet());
//                bean.setLocationDescribe(location.getLocationDescribe());
//                Log.d("TAG", bean.toString());
//                // 调用web页面js函数，传入页面信息
//                mAgentWeb.getJsAccessEntrace().quickCallJs("click_location", new ValueCallback<String>() {
//                    @Override
//                    public void onReceiveValue(String value) {
//                        Log.e("Info","value:"+value);
//                    }
//                }, bean.toString());
////                webView.callHandler("click_location", bean.toString(), new CallBackFunction() {
////                    @Override
////                    public void onCallBack(String data) {
////                        Log.i(TAG, "回传结果：" + data);
////                        Toast.makeText(MainActivity.this, data, Toast.LENGTH_SHORT).show();
////                    }
////                });
//            } else {
////                mLocationClient.requestLocation();
//                // mLocationClient.restart();
//            }
//        }
//    }

    @Override
    public String getUrl() {
        String url = "file:///android_asset/test_location_in.html";
        return url;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onPause() {
        Log.d("TAG", "获取地理位置信息onPause！");
        super.onPause();
    }

    @Override
    protected void onResume() {
        Log.d("TAG", "获取地理位置信息页面加载完毕！");
        super.onResume();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void getLocation(LocationDataBean bean) {
        Log.d("TAG", "取得的定位信息："+bean.toString());
    }
}
