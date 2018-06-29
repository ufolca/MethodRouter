package com.ufo.mr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.ufo.mr.a.AMethodProxy;
import com.ufo.mr.b.BTest;
import com.ufo.mr.base.MethoProxyCallBack;
import com.ufo.mr.base.ModelProxyManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //模块A的方法代理商添加到总的方法代理中心
        ModelProxyManager.getInstance().addMethodProxy(new AMethodProxy());
        final BTest bTest = new BTest();
        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bTest.test();
            }
        });
        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bTest.testContext(MainActivity.this);
            }
        });
        findViewById(R.id.btn3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bTest.testCallback(MainActivity.this, "bbb", new MethoProxyCallBack() {
                    @Override
                    public void callBack(String jsonStr) {
                        Toast.makeText(MainActivity.this, "moudle-a.testCallback()===para:" + jsonStr, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
