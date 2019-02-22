package com.example.saif.shop;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class Viewpageradapter extends FragmentPagerAdapter {

    private final List<Fragment> fragmentList= new ArrayList<>();
    private final List<String> fragmentTitles= new ArrayList<>();

    public Viewpageradapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentTitles.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentTitles.get(position);
    }

    public  void  Addfragment(Fragment fragment,String Title){
        fragmentList.add(fragment);
        fragmentTitles.add(Title);
    }
}
