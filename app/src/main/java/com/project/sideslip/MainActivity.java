package com.project.sideslip;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.mListview)
    ListView mLv;
    @BindView(R.id.mDrawerLayout)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.activity_main)
    LinearLayout activityMain;
    @BindView(R.id.toolBar)
    Toolbar toolbar;
    @BindView(R.id.ll_slipe)
    LinearLayout llSlipe;

    private String TAG = "MainActivity";

    private ActionBarDrawerToggle mActionBarDrawerToggle;

    private String[] lvs = {"List Item 01", "List Item 02", "List Item 03", "List Item 04"};
    private ArrayAdapter arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //初始化toolbar
        initBar();
        //初始化适配数据
        initAdapter();
        //初始化drawerlayout
        initDrawerLayout();
    }


    /**
     * 初始化toolbar
     */
    private void initBar() {
        toolbar.setTitle("Toolbar");//设置Toolbar标题
        toolbar.setTitleTextColor(Color.parseColor("#ffffff")); //设置标题颜色
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true); //设置返回键可用
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //通过代码设置侧滑界面
//                if(mDrawerLayout.isDrawerOpen(llSlipe)){
//                    mDrawerLayout.closeDrawer(llSlipe);
//                }else{
//                    mDrawerLayout.openDrawer(llSlipe);
//                }
//            }
//        });
    }

    /**
     * 初始化适配器
     */
    private void initAdapter() {
        //设置菜单列表
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, lvs);
        mLv.setAdapter(arrayAdapter);
    }

    /**
     * 初始化drawerlayout
     */
    private void initDrawerLayout() {
        // 监听方式1 结合toolabr，使用toolbar打开/销毁侧滑界面
        mActionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.open, R.string.close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                Log.i(TAG, "侧滑界面打开");
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                Log.i(TAG, "侧滑界面关闭");
            }
        };
        mActionBarDrawerToggle.syncState();
        mDrawerLayout.addDrawerListener(mActionBarDrawerToggle);
        //监听方式1 使用这个类的时候不必实现全部的回调函数，可以根据自己的需要重写相应的方法。
//        mDrawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
//            @Override
//            public void onDrawerOpened(View drawerView) {
//                super.onDrawerOpened(drawerView);
//            }
//
//            @Override
//            public void onDrawerClosed(View drawerView) {
//                super.onDrawerClosed(drawerView);
//            }
//        });

        //监听方式3 侧滑监听
//        mDrawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
//            @Override
//            public void onDrawerSlide(View drawerView, float slideOffset) {
//
//            }
//
//            @Override
//            public void onDrawerOpened(View drawerView) {
//
//            }
//
//            @Override
//            public void onDrawerClosed(View drawerView) {
//
//            }
//
//            @Override
//            public void onDrawerStateChanged(int newState) {
//
//            }
//        });



    }

}
