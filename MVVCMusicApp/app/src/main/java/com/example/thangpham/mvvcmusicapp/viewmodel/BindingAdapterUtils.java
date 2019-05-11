package com.example.thangpham.mvvcmusicapp.viewmodel;

import android.databinding.BindingAdapter;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.thangpham.mvvcmusicapp.R;
import com.example.thangpham.mvvcmusicapp.view.adapters.MusicTypeAdapter;
import com.example.thangpham.mvvcmusicapp.view.adapters.ViewPagerAdapter;

public class BindingAdapterUtils {

    @BindingAdapter("android:setAdapter")
    public static void setAdapter(RecyclerView recyclerView, MusicTypeAdapter adapter){
        Log.e("ThangPham","setadapter: "+adapter);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
    }
    @BindingAdapter("android:setViewPagerAdapter")
    public static void setViewPagerAdapter(ViewPager vp, ViewPagerAdapter adapter){
        vp.setAdapter(adapter);
    }

    @BindingAdapter("android:setDataForTabLayout")
    public static void setDataForTabLayout(TabLayout tabLayout, final ViewPager vp){
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_dashboard_black_24dp));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_favorite_black_24dp));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_file_download_black_24dp));
        tabLayout.getTabAt(0).getIcon().setAlpha(255);
        tabLayout.getTabAt(1).getIcon().setAlpha(100);
        tabLayout.getTabAt(2).getIcon().setAlpha(100);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tab.getIcon().setAlpha(255);
                vp.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.getIcon().setAlpha(100);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        vp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }
}
