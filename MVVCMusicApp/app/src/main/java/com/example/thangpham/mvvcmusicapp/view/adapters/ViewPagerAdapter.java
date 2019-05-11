package com.example.thangpham.mvvcmusicapp.view.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.thangpham.mvvcmusicapp.view.fragment.DownloadFragment;
import com.example.thangpham.mvvcmusicapp.view.fragment.FavouriteFragment;
import com.example.thangpham.mvvcmusicapp.view.fragment.MusicTypeFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i){
            case 0: return new MusicTypeFragment();
            case 1: return new FavouriteFragment();
            case 2: return new DownloadFragment();
            default: return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
