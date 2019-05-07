package com.zhz.happyrun;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView mTextMessage;
    private Toolbar mToolbar;
    private BottomNavigationView mBottomNavigationView;
    private int lastIndex;
    List<Fragment> mFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);
        initView();
        initBottomNavigation();
        initData();
        Toolbar mtoolbar=(Toolbar)findViewById(R.id.toolbar);


    }

    public void initView() {
        mToolbar = findViewById(R.id.toolbar);
    }

    public void initData() {

        setSupportActionBar(mToolbar);
        mFragments = new ArrayList<>();
        mFragments.add(new homeFragment());
        mFragments.add(new calenderFragment());
        mFragments.add(new userFragment());
        // 初始化展示Fragment
        setFragmentPosition(0);
    }

    public void initBottomNavigation() {
        mBottomNavigationView = findViewById(R.id.bv_bottomNavigation);
        // 添加监听
        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_home:
                      setFragmentPosition(0);
                        break;
                    case R.id.menu_calender:
                      setFragmentPosition(1);
                        break;
                    case R.id.menu_user:
                      setFragmentPosition(2);
                        break;
                    default:
                        break;
                }
                // 这里注意返回true,否则点击失效
                return true;
            }
        });
    }

    private void setFragmentPosition(int position){
        FragmentTransaction ft =getSupportFragmentManager().beginTransaction();
        Fragment currentFragment =mFragments.get(position);
        Fragment lastFragment =mFragments.get(lastIndex);
        lastIndex=position;
        ft.hide(lastFragment);
        if(!currentFragment.isAdded()){
            getSupportFragmentManager().beginTransaction().remove(currentFragment).commit();
            ft.add(R.id.center_frameLayout, currentFragment);
        }
        ft.show(currentFragment);
        ft.commitAllowingStateLoss();
    }
}
