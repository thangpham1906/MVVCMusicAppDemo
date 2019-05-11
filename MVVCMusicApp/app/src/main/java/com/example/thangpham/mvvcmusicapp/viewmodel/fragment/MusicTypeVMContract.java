package com.example.thangpham.mvvcmusicapp.viewmodel.fragment;

import android.content.Context;

import com.example.thangpham.mvvcmusicapp.model.MusicTypeModel;

import java.util.List;

public class MusicTypeVMContract  {
    // view thì implement MainView
    public interface MainView{
        void loadData(List<MusicTypeModel> listMusicType);
        Context getContext();
    }
    //viewModel thì implment ViewModel
    public interface ViewModel{

    }
}
