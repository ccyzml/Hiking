package com.nju.meanlay.hiking.Adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.nju.meanlay.hiking.Fragment.MyEventFragment;
import com.nju.meanlay.hiking.Fragment.TopEventFragment;

public class MyFragmentPageAdapter extends FragmentPagerAdapter {

    private Context context;
    private static final String[] mTitles = {"热门活动","我的活动"};

    public MyFragmentPageAdapter(FragmentManager fm, Context context) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0) {
            return new TopEventFragment();
        } else {
            return new MyEventFragment();
        }
    }

    @Override
    public int getCount() {
        return mTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}
