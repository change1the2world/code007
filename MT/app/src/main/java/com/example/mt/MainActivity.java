package com.example.mt;

import android.app.ActivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.jaredrummler.android.processes.AndroidProcesses;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 添加了一行注释

        //本地新建的分支zyh_law

        //获取运行中进程
        List<ActivityManager.RunningAppProcessInfo> infos = AndroidProcesses.getRunningAppProcessInfo(this);
        for (int i = 0; i < infos.size(); i++) {
            Log.e("MainActivity","name = "+infos.get(i).processName);
        }
    }
}
