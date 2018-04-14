package com.just.agentweb.sample.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.just.agentweb.AgentWebConfig;
import com.just.agentweb.sample.R;
import com.just.agentweb.sample.bean.LocationDataBean;

/**
 * source code  https://github.com/Justson/AgentWeb
 */
public class MainActivity extends AppCompatActivity {


	private ListView mListView;

	private Toolbar mToolbar;
	private TextView mTitleTextView;

    protected LocationClient mLocationClient = null;
    private MyLocationListener myListener = new MyLocationListener();

    protected LocationDataBean bean;


	public static final String[] datas = new String[]{
//			"Activity 使用 AgentWeb",
//			"Fragment 使用 AgentWeb ",
//			"文件下载",
			// TODO：QRCodeCreate 修改案例名称
			"QRCodeCreate图片上传演示",
            "QRCodeCreate文字输入演示",
//			"Js 通信文件上传,兼用Android 4.4Kitkat",
//			"Js 通信", "Video 视频全屏播放",
//			"自定义进度条",
//			"自定义设置",
//			"电话 ， 信息 ， 邮件", "自定义 WebView", "下拉回弹效果",
//			"Jsbridge 例子", "继承 BaseAgentWebActivity",
//			"继承 BaseAgentWebFragment",
//			"SmartRefresh 下拉刷新",
//			"地图",
//			"VasSonic 首屏秒开",
//			"与ToolBar联动",
//			"百度地图精准定位与页面标记"
    };

	@RequiresApi(api = Build.VERSION_CODES.KITKAT)
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

        initBdMap();
		mToolbar = (Toolbar) this.findViewById(R.id.toolbar);
		mToolbar.setTitleTextColor(Color.WHITE);
		mToolbar.setTitle("");
		mTitleTextView = (TextView) this.findViewById(R.id.toolbar_title);
		mTitleTextView.setText("AgentWeb 使用指南");
		this.setSupportActionBar(mToolbar);
		if (getSupportActionBar() != null) {
			// Enable the Up button
			getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		}
		mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				MainActivity.this.finish();
			}
		});

		mListView = (ListView) this.findViewById(R.id.listView);
		mListView.setAdapter(new MainAdapter());
		mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

				doClick(position);
			}
		});


		if (AgentWebConfig.DEBUG) {
			Log.i("Info", "Debug 模式");
		} else {
			Log.i("Info", "release 模式");
		}

		AgentWebConfig.debug();
	}

	private void doClick(int position) {


		switch (position) {

            /* Activity agentWeb */
			case 0:// 项目中请使用常量替代
                // TODO：QRCodeCreate 图片上传演示
                startActivity(new Intent(this, CommonActivity.class).putExtra(CommonActivity.TYPE_KEY, 2));
                break;
				//startActivity(new Intent(this, WebActivity.class));
				//break;
			case 1:
                // TODO：QRCodeCreate 文字上传演示
				startActivity(new Intent(this, CommonActivity.class).putExtra(CommonActivity.TYPE_KEY, 3));
				break;
//			case 2:
//				startActivity(new Intent(this, CommonActivity.class).putExtra(CommonActivity.TYPE_KEY, 1));
//				break;
//			case 3:
//				startActivity(new Intent(this, CommonActivity.class).putExtra(CommonActivity.TYPE_KEY, 2));
//				break;
//			case 4:
//				startActivity(new Intent(this, CommonActivity.class).putExtra(CommonActivity.TYPE_KEY, 3));
//				break;
//			case 5:
//				startActivity(new Intent(this, CommonActivity.class).putExtra(CommonActivity.TYPE_KEY, 4));
//				break;
//			case 6:
//				startActivity(new Intent(this, CommonActivity.class).putExtra(CommonActivity.TYPE_KEY, 5));
//				break;
//
//			case 7:
//				startActivity(new Intent(this, CommonActivity.class).putExtra(CommonActivity.TYPE_KEY, 6));
//				break;
//
//			case 8:
//				startActivity(new Intent(this, CommonActivity.class).putExtra(CommonActivity.TYPE_KEY, 7));
//				break;
//
//			case 9:
//				startActivity(new Intent(this, CommonActivity.class).putExtra(CommonActivity.TYPE_KEY, 8));
//				break;
//			case 10:
//				startActivity(new Intent(this, CommonActivity.class).putExtra(CommonActivity.TYPE_KEY, 9));
//				break;
//			case 11:
//				startActivity(new Intent(this, CommonActivity.class).putExtra(CommonActivity.TYPE_KEY, 10));
//				break;
//			case 12:
//				startActivity(new Intent(this, CommonActivity.class).putExtra(CommonActivity.TYPE_KEY, 11));
//				break;
//			case 13:
//				startActivity(new Intent(this, EasyWebActivity.class));
//				break;
//
//			case 14:
//				startActivity(new Intent(this, ContainerActivity.class));
//				break;
//
//			case 15:
//				startActivity(new Intent(this, CommonActivity.class).putExtra(CommonActivity.TYPE_KEY, 12));
//				break;
//			case 16:
//				startActivity(new Intent(this, CommonActivity.class).putExtra(CommonActivity.TYPE_KEY, 13));
//				break;
//			case 17:
//				startActivity(new Intent(this, CommonActivity.class).putExtra(CommonActivity.TYPE_KEY, 14).putExtra(PARAM_CLICK_TIME, System.currentTimeMillis()));
//				break;
//			case 18:
//				startActivity(new Intent(this,AutoHidenToolbarActivity.class));
//			case 19:
//				startActivity(new Intent(this,ProciseLocationActivity.class));
			default:
				break;

		}


	}

    private void initBdMap() {
        mLocationClient = new LocationClient(getApplicationContext());
        //声明LocationClient类
        mLocationClient.registerLocationListener(myListener);
        //注册监听函数

        LocationClientOption option = new LocationClientOption();

        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
//可选，设置定位模式，默认高精度
//LocationMode.Hight_Accuracy：高精度；
//LocationMode. Battery_Saving：低功耗；
//LocationMode. Device_Sensors：仅使用设备；

        option.setCoorType("bd09ll");
//可选，设置返回经纬度坐标类型，默认gcj02
//gcj02：国测局坐标；
//bd09ll：百度经纬度坐标；
//bd09：百度墨卡托坐标；
//海外地区定位，无需设置坐标类型，统一返回wgs84类型坐标

        option.setScanSpan(10000); // 每10秒请求一次
//可选，设置发起定位请求的间隔，int类型，单位ms
//如果设置为0，则代表单次定位，即仅定位一次，默认为0
//如果设置非0，需设置1000ms以上才有效

        option.setOpenGps(true);
//可选，设置是否使用gps，默认false
//使用高精度和仅用设备两种定位模式的，参数必须设置为true

        option.setLocationNotify(true);
//可选，设置是否当GPS有效时按照1S/1次频率输出GPS结果，默认false

        option.setIgnoreKillProcess(false);
//可选，定位SDK内部是一个service，并放到了独立进程。
//设置是否在stop的时候杀死这个进程，默认（建议）不杀死，即setIgnoreKillProcess(true)

        option.SetIgnoreCacheException(false);
//可选，设置是否收集Crash信息，默认收集，即参数为false

        option.setWifiCacheTimeOut(5 * 60 * 1000);
//可选，7.2版本新增能力
//如果设置了该接口，首次启动定位时，会先判断当前WiFi是否超出有效期，若超出有效期，会先重新扫描WiFi，然后定位

        option.setEnableSimulateGps(false);
//可选，设置是否需要过滤GPS仿真结果，默认需要，即参数为false

        option.setIsNeedAddress(true);
//可选，是否需要地址信息，默认为不需要，即参数为false
//如果开发者需要获得当前点的地址信息，此处必须为true

        option.setIsNeedLocationDescribe(true);
//可选，是否需要位置描述信息，默认为不需要，即参数为false
//如果开发者需要获得当前点的位置信息，此处必须为true

        mLocationClient.setLocOption(option);
//mLocationClient为第二步初始化过的LocationClient对象
//需将配置好的LocationClientOption对象，通过setLocOption方法传递给LocationClient对象使用
//更多LocationClientOption的配置，请参照类参考中LocationClientOption类的详细说明

        mLocationClient.start();
//mLocationClient为第二步初始化过的LocationClient对象
//调用LocationClient的start()方法，便可发起定位请求
    }

    public class MyLocationListener extends BDAbstractLocationListener {
        @Override
        public void onLocDiagnosticMessage(int i, int i1, String s) {
            super.onLocDiagnosticMessage(i, i1, s);
            Log.d("TAG", "i===" + i + ", " + i1 + ",  " + s);
        }

        @Override
        public void onReceiveLocation(BDLocation location) {
            //此处的BDLocation为定位结果信息类，通过它的各种get方法可获取定位相关的全部结果
            //以下只列举部分获取经纬度相关（常用）的结果信息
            //更多结果信息获取说明，请参照类参考中BDLocation类中的说明

            Log.d("TAG", "BDLocation.getLocType() " + location.getLocType() + ":::describe+++" + location.getLocTypeDescription());
            double latitude = location.getLatitude();    //获取纬度信息
            double longitude = location.getLongitude();    //获取经度信息
            float radius = location.getRadius();    //获取定位精度，默认值为0.0f

            String coorType = location.getCoorType();
            //获取经纬度坐标类型，以LocationClientOption中设置过的坐标类型为准

            int errorCode = location.getLocType();
            //获取定位类型、定位错误返回码，具体信息可参照类参考中BDLocation类中的说明

            Log.d("TAG", "d定位信息：\n 经纬度：" + longitude + ", " + latitude + "\n");
            Log.d("TAG", "无关紧要的信息：" + radius + ",,," + coorType + ",,," + errorCode);

            String addr = location.getAddrStr();    //获取详细地址信息
            String country = location.getCountry();    //获取国家
            String province = location.getProvince();    //获取省份
            String city = location.getCity();    //获取城市
            String district = location.getDistrict();    //获取区县
            String street = location.getStreet();    //获取街道信息

            Log.d("TAG", "获取的地址信息：" + addr + "\n" + country + "\n" + province + "\n" + city + "\n" + district + "\n" + street);

            String locationDescribe = location.getLocationDescribe();    //获取位置描述信息
            Log.d("TAG", "位置描述信息：" + locationDescribe);
            // 缓存当前定位数据
            if (addr != null) {
                bean = new LocationDataBean();
                bean.setLatitude(location.getLatitude());
                bean.setLongitude(location.getLongitude());
                bean.setAddr(location.getAddrStr());
                bean.setCountry(location.getCountry());
                bean.setProvince(location.getProvince());
                bean.setCity(location.getCity());
                bean.setDistrict(location.getDistrict());
                bean.setStreet(location.getStreet());
                bean.setLocationDescribe(location.getLocationDescribe());
                Log.d("TAG", bean.toString());
                // 调用web页面js函数，传入页面信息
//                mAgentWeb.getJsAccessEntrace().quickCallJs("click_location", new ValueCallback<String>() {
//                    @Override
//                    public void onReceiveValue(String value) {
//                        Log.e("Info","value:"+value);
//                    }
//                }, bean.toString());

//                webView.callHandler("click_location", bean.toString(), new CallBackFunction() {
//                    @Override
//                    public void onCallBack(String data) {
//                        Log.i(TAG, "回传结果：" + data);
//                        Toast.makeText(MainActivity.this, data, Toast.LENGTH_SHORT).show();
//                    }
//                });
            } else {
                mLocationClient.requestLocation();
                // mLocationClient.restart();
            }
        }
    }


	public class MainAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			return datas.length;
		}

		@Override
		public Object getItem(int position) {
			return datas[position];
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ViewHolder mViewHolder;
			if (convertView == null) {
				mViewHolder = new ViewHolder();
				View mView = MainActivity.this.getLayoutInflater().inflate(R.layout.listview_main, parent, false);
				mViewHolder.mTextView = (TextView) mView.findViewById(R.id.content);
				mView.setTag(mViewHolder);
				convertView = mView;
			} else {
				mViewHolder = (ViewHolder) convertView.getTag();
			}

			mViewHolder.mTextView.setText(datas[position]);
			return convertView;
		}


	}

	class ViewHolder {
		TextView mTextView;
	}


}
