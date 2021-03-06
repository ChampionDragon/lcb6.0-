package com.lcb.one;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.lcb.one.activity.AppInformationActivity;
import com.lcb.one.activity.CodeCreateActivity;
import com.lcb.one.activity.CustomMultiTypeActivity;
import com.lcb.one.activity.FileProvider7Activity;
import com.lcb.one.activity.GPVActivity;
import com.lcb.one.activity.MultiTypeActivity;
import com.lcb.one.activity.PermissionActivity;
import com.lcb.one.activity.PlateNumberInputActivity;
import com.lcb.one.activity.RefreshLoad;
import com.lcb.one.activity.RvCard;
import com.lcb.one.activity.RvStrTwoActivity;
import com.lcb.one.activity.TableLayoutActivity;
import com.lcb.one.activity.TableViewActivity;
import com.lcb.one.activity.Thirdlogin;
import com.lcb.one.activity.xmlJsonActivity;
import com.lcb.one.map.LocationActivity;
import com.lcb.one.map.MarkerActivity;
import com.lcb.one.map.NaviActivity;
import com.lcb.one.map.PoiSearchActivity;
import com.lcb.one.pay.RechargeActivity;
import com.lcb.one.pay.unionpay.JARActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainActivity extends AppCompatActivity {
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        test();
    }

    private void test() {

    }


    private void initView() {
        mListView = (ListView) findViewById(R.id.main_lv);
        mListView.setAdapter(new SimpleAdapter(this, getData(),
                android.R.layout.simple_list_item_1, new String[]{"title"}, new int[]{android.R.id.text1}));
        mListView.setOnItemClickListener(itemClickListener);
    }


    private List<Map<String, Object>> getData() {
        List<Map<String, Object>> myData = new ArrayList<>();
        addItem(myData, "安卓6.0动态权限", new Intent(this, PermissionActivity.class));
        addItem(myData, "地图定位", new Intent(this, LocationActivity.class));
        addItem(myData, "点击屏幕创建小图标", new Intent(this, MarkerActivity.class));
        addItem(myData, "POI搜索", new Intent(this, PoiSearchActivity.class));
        addItem(myData, "导航", new Intent(this, NaviActivity.class));
        addItem(myData, "银联支付", new Intent(this, JARActivity.class));
        addItem(myData, "支付界面", new Intent(this, RechargeActivity.class));
        addItem(myData, "自定义密码输入框测试", new Intent(this, GPVActivity.class));
        addItem(myData, "生成和扫描二维码", new Intent(this, CodeCreateActivity.class));
        addItem(myData, "APP和系统的信息", new Intent(this, AppInformationActivity.class));
        addItem(myData, "RecyclerView二级Strings列表", new Intent(this, RvStrTwoActivity.class));
        addItem(myData, "第三方登录", new Intent(this, Thirdlogin.class));
        addItem(myData, "自定义车牌输入", new Intent(this, PlateNumberInputActivity.class));
        addItem(myData, "上加载下刷新", new Intent(this, RefreshLoad.class));
        addItem(myData, "加载刷新小卡片模式", new Intent(this, RvCard.class));
        addItem(myData, "复杂数据类型的RecyclerView", new Intent(this, MultiTypeActivity.class));
        addItem(myData, "复杂类型RecyclerView(避免反射弊端)", new Intent(this, CustomMultiTypeActivity.class));
        addItem(myData, "自定义控件Tablelayout", new Intent(this, TableLayoutActivity.class));
        addItem(myData, "自定义控件TableView", new Intent(this, TableViewActivity.class));
        addItem(myData, "xml和json互换文件下载上传", new Intent(this, xmlJsonActivity.class));
        addItem(myData, "7.0共享文件图片加水印鲁班压缩图片", new Intent(this, FileProvider7Activity.class));
        return myData;
    }

    private void addItem(List<Map<String, Object>> data, String name, Intent intent) {
        Map<String, Object> temp = new HashMap<>();
        temp.put("title", name);
        temp.put("intent", intent);
        data.add(temp);
    }

    AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {
            Map<String, Object> map = (Map<String, Object>) mListView.getItemAtPosition(position);
            Intent intent = (Intent) map.get("intent");
            startActivity(intent);
        }
    };

}
