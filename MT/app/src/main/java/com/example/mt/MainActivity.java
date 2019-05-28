package com.example.mt;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.RxUtil;
import com.example.mt.second.SecondActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 添加了一行注释

        //本地新建的分支zyh_law
        TextView tv = findViewById(R.id.tv);
        tv.setText("Master v1.2.2");
        tv.setOnClickListener(new View.OnClickListener() {
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
}
