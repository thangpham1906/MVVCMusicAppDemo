package com.example.thangpham.mvvcmusicapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.thangpham.mvvcmusicapp.model.MusicTypeModel;


public class Utils {
    public static void openFragment(FragmentManager fragmentManager, int layoutID, Fragment fragment) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(layoutID, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
    public static void openFragment2(FragmentManager fragmentManager, int layoutID, Fragment fragment, MusicTypeModel model) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(layoutID, fragment);
        Bundle bundle = new Bundle();
        bundle.putSerializable("model",model);
        fragment.setArguments(bundle);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
