package com.bwie.information.myapplication.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bwie.information.myapplication.R;
import com.bwie.information.myapplication.frag.Fragment1;
import com.bwie.information.myapplication.frag.Fragment2;
import com.bwie.information.myapplication.frag.Fragment3;


public class TableActivity extends AppCompatActivity {

    private TabLayout mTbl;
    private String[] str;
    private ViewPager mVp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);
        //初始化控件
        initView();
        //初始化数据
        initData();
    }

    private void initData() {
        str = new String[]{"入驻部门", "政务联播","政治要闻"};
        for (int i = 0; i < str.length; i++) {
            //给tablelayout添加导航条目
            mTbl.addTab(mTbl.newTab().setText(str[i]));
        }


        mVp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                Fragment fragment = null;
                switch (position) {
                    case 0:
                        fragment = new Fragment1();
                        break;

                    case 1:
                        fragment = new Fragment2();
                        break;

                    case 2:
                        fragment = new Fragment3();
                        break;
                }
                return fragment;
            }

            @Override
            public int getCount() {
                return str.length;
            }
        });
        mVp.setCurrentItem(0);
        mTbl.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mVp.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        mVp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTbl));

    }

    private void initView() {
        mTbl = (TabLayout) findViewById(R.id.tbl);
        mVp = (ViewPager) findViewById(R.id.vp);
    }
}
