package com.yuyoubang.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RadioButton;

import com.yuyoubang.R;
import com.yuyoubang.activity.base.BaseActivity;
import com.yuyoubang.fragment.base.HomeFragment;
import com.yuyoubang.fragment.base.UserFragment;

import java.util.ArrayList;

/**
 * Created by lenovo on 2017/10/24.
 */

public class FirstActivity extends BaseActivity implements View.OnClickListener{
    ViewPager viewPager;
    RadioButton radioButton1;
    RadioButton radioButton2;
    ArrayList<Fragment> fragments = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    @Override
    protected void initTitleBar(HeaderBuilder builder) {

    }

    @Override
    protected int getContentResId() {
        return R.layout.first;
    }
    void init(){
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        radioButton1 = (RadioButton) findViewById(R.id.rbhome);
        radioButton2 = (RadioButton) findViewById(R.id.rbuser);
        radioButton1.setOnClickListener(this);
        radioButton2.setOnClickListener(this);
        fragments.add(new HomeFragment());
        fragments.add(new UserFragment());
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {


            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if(state==2){
                    if (viewPager.getCurrentItem()==0){
                        radioButton1.setChecked(true);
                    }else {
                        radioButton2.setChecked(true);
                    }
                }

            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rbhome:
                viewPager.setCurrentItem(0);
                break;
            case R.id.rbuser:
                viewPager.setCurrentItem(1);
                break;
            default:
                break;
        }
    }
}
