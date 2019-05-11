package com.example.thangpham.mvvcmusicapp.view.activities;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.thangpham.mvvcmusicapp.R;
import com.example.thangpham.mvvcmusicapp.databinding.ActivityMainBinding;
import com.example.thangpham.mvvcmusicapp.view.adapters.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity {
    //1. user sẽ tương tác vào view
    //2. view sẽ gọi viewmodel (viewmodel lắng nghe sự kiện)
    //3. viewmodel sẽ xử lí logic, lấy dữ liệu từ model,data
    //4. data sẽ gọi lại viewmodel
    //5. viewmodel sẽ gọi lại view để tải dữ liệu cho view
    // viewmodel được tách biệt hoàn toàn với view, vì thế trong VM k có 1 biến UI nào cả
    //1 viewmodel có thể có nhiều view
    ActivityMainBinding activityMainBinding;
    public ViewPagerAdapter viewPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        activityMainBinding.setMain(this);

    }

}
