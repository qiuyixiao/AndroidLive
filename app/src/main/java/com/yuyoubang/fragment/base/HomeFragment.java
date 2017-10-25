package com.yuyoubang.fragment.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yuyoubang.R;

import java.util.ArrayList;

/**
 * Created by lenovo on 2017/10/25.
 */

public class HomeFragment extends Fragment {
    @Nullable
    ViewPager viewPager;
    TabLayout tabLayout;
    ArrayList<Fragment> fragments = new ArrayList<>();
    View v;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fra_home,null);
        init();
        return v;
    }
    void init(){
        tabLayout = (TabLayout) v.findViewById(R.id.tablayout);
        viewPager= (ViewPager) v.findViewById(R.id.viewpger_home);
        fragments.add(new JCFragment());
        fragments.add(new RDFragment());
        viewPager.setAdapter(new FragmentPagerAdapter(getFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setText("精彩");
        tabLayout.getTabAt(1).setText("热点");

    }
}
