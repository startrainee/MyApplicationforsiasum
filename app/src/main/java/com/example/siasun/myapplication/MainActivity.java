package com.example.siasun.myapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.siasun.myapplication.fragment.FindFragment;
import com.example.siasun.myapplication.fragment.MainFragment;
import com.example.siasun.myapplication.fragment.UserFragment;
import com.example.siasun.myapplication.fragment.adapter.MyFragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    BottomNavigationView mBottomNavigation;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_main:
                    mViewPager.setCurrentItem(0);
                    return true;
                case R.id.navigation_find:
                    mViewPager.setCurrentItem(1);
                    return true;
                case R.id.navigation_user:
                    mViewPager.setCurrentItem(2);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBottomNavigation = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        mBottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        mViewPager = (ViewPager) findViewById(R.id.main_view_pager);
        mViewPager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager(), getFragmentList()));
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        mBottomNavigation.setSelectedItemId(R.id.navigation_main);
                        break;
                    case 1:
                        mBottomNavigation.setSelectedItemId(R.id.navigation_find);
                        break;
                    case 2:
                        mBottomNavigation.setSelectedItemId(R.id.navigation_user);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });



    }

    public List<Fragment> getFragmentList() {
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new MainFragment());
        fragmentList.add(new FindFragment());
        fragmentList.add(new UserFragment());
        return fragmentList;
    }
}
