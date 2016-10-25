package com.bwie.information.myapplication.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bwie.information.myapplication.R;
import com.bwie.information.myapplication.adapter.MAdapter;
import com.bwie.information.myapplication.bean.Data;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRclv;
    private String path = "http://open.qyer.com/qyer/bbs/entry?client_id=qyer_android&client_secret=9fcaae8aefc4f9ac4915";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化控件
        initView();
        //准备数据
        getData();
    }


    private void initView() {
        mRclv = (RecyclerView) findViewById(R.id.rclv);
        mRclv.setLayoutManager(new LinearLayoutManager(this));
    }

    public void getData() {
        RequestQueue rQueue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(Request.Method.GET, path,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        //处理数据
                        processData(response);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        rQueue.add(request);
        rQueue.start();

    }

    private void processData(String response) {
        System.out.println("response==" + response);
        Data data = new Gson().fromJson(response, Data.class);
        //设置适配器
        mRclv.setAdapter(new MAdapter(MainActivity.this, data));
    }
}
