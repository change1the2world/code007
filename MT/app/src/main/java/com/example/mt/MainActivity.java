package com.example.mt;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.BounceInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Toast;

import com.example.RxUtil;
import com.example.mt.bean.PieData;
import com.example.mt.custom.HttpHelper;
import com.example.mt.imp.TestInterface;
import com.example.mt.second.SecondActivity;
import com.example.mt.widget.LoadingView;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;

import javax.inject.Inject;
import javax.inject.Named;

public class MainActivity extends AppCompatActivity{

    @Inject
    PieData pieData;
    @Named("first")
    @Inject
    TestInterface interfaceImp;
//    @Inject
//    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 添加了一行注释

//        final CustomView cv = findViewById(R.id.cv);
//        cv.setStep(3000);


//        cv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this, SecondActivity.class));
//            }
//        });
        //本地新建的分支zyh_law
        /*final TextView tv = findViewById(R.id.tv);
        tv.setText("Master v1.2.2");
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                    startActivity(new Intent(MainActivity.this, TestActivity.class));
//                    overridePendingTransition(0,0);
                tv.startAnimation(setAnimation(20));
            }
        });*/

//        DaggerTestCommponent.builder().testModule(new TestModule()).build().inject(this);

        App.Companion.getApp().getTestCommponent().inject(this);

        Log.e("TAG","PieData = "+pieData.toString()+", TestInterface = "+interfaceImp.getTestInfo());
        ArrayList<PieData> pieData = new ArrayList<>();
        pieData.add(new PieData("小1",10));
        pieData.add(new PieData("小2",20));
        pieData.add(new PieData("小3",30));
        pieData.add(new PieData("小4",40));
        pieData.add(new PieData("小5",50));

        HashMap<String, String> map = new HashMap<>();
        map.put("key","value");
        map.put("key1","value1");
        map.put("key2","value2");

        LoadingView pv = findViewById(R.id.pv);
        pv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });
        RxUtil.Companion.getInstance(this).request(1, new RxUtil.RxCompletedListener() {
            @Override
            public void onAgree() {
                Toast.makeText(MainActivity.this,"同意",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRefuse() {
                Toast.makeText(MainActivity.this,"拒绝",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAskNoMore() {
                Toast.makeText(MainActivity.this,"拒绝不再询问",Toast.LENGTH_SHORT).show();
            }
        },Manifest.permission.READ_PHONE_STATE);

    }
    public static Animation setAnimation(int counts) {
        Animation translateAnimation = new TranslateAnimation(0, 200, 0, 0);
        translateAnimation.setInterpolator(new BounceInterpolator());
        translateAnimation.setDuration(1000);
        translateAnimation.setFillAfter(true);
        return translateAnimation;
    }

}
