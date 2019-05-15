package com.example.mt;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 添加了一行注释

        //本地新建的分支zyh_law
        TextView tv = findViewById(R.id.tv);
        tv.setText("老zhang v1.1.0");
    }
}
