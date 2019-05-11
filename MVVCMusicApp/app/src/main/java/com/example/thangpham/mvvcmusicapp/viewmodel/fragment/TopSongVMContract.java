package com.example.thangpham.mvvcmusicapp.viewmodel.fragment;

import com.example.thangpham.mvvcmusicapp.model.TopSongModel;

import java.util.List;

public class TopSongVMContract {
    public interface MainView{
        void loadData(List<TopSongModel> listTopSongs);
    }
    public interface ViewModel{

    }
}
