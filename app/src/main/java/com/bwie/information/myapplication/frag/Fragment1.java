package com.bwie.information.myapplication.frag;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment {


    private View view;
    private RecyclerView mRclv;
    private String path = "http://open.qyer.com/qyer/bbs/entry?client_id=qyer_android&client_secret=9fcaae8aefc4f9ac4915";
    public Fragment1() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragmen1, container, false);
        initView();
        getData();
        return view;
    }

    private void initView() {
        mRclv = (RecyclerView) view.findViewById(R.id.rclv);
        mRclv.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    public void getData() {
        RequestQueue rQueue = Volley.newRequestQueue(getActivity());
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
        mRclv.setAdapter(new MAdapter(getActivity(), data));
    }

}
