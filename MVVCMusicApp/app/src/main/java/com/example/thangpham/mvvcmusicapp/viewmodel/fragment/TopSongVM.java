package com.example.thangpham.mvvcmusicapp.viewmodel.fragment;

import android.content.Context;

import com.example.thangpham.mvvcmusicapp.model.MusicTypeModel;
import com.example.thangpham.mvvcmusicapp.model.TopSongModel;
import com.example.thangpham.mvvcmusicapp.network.MusicInterface;
import com.example.thangpham.mvvcmusicapp.network.RetrofitInstance;
import com.example.thangpham.mvvcmusicapp.network.TopSongResponseJSON;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TopSongVM implements TopSongVMContract.ViewModel {
    //ViewModel muốn tương tác với view thì phải tạo biến TopSongVMContract.MainView
    public TopSongVMContract.MainView mainView;
    public Context context;
    public MusicTypeModel musicTypeModel;
    public List<TopSongModel> listTopSongModel = new ArrayList<>();
    public TopSongVM(Context context, TopSongVMContract.MainView mainView,MusicTypeModel musicTypeModel) {
        this.context = context;
        this.mainView = mainView;
        this.musicTypeModel = musicTypeModel;
        loadDataFromServer();
    }


    public void loadDataFromServer(){
        MusicInterface musicInterface = RetrofitInstance.getInstance().create(MusicInterface.class);
        musicInterface.getListTopSong(musicTypeModel.id).enqueue(new Callback<TopSongResponseJSON>() {
            @Override
            public void onResponse(Call<TopSongResponseJSON> call, Response<TopSongResponseJSON> response) {
                List<TopSongResponseJSON.FeedJSON.EntryJSON> entries = response.body().feed.entry;
                for(int i=0; i<entries.size();i++) {
                    TopSongModel topSongModel = new TopSongModel();
                    topSongModel.song = entries.get(i).name.label;
                    topSongModel.singer = entries.get(i).artist.label;
                    topSongModel.smallImage = entries.get(i).image.get(2).label;
                    listTopSongModel.add(topSongModel);
                }
                mainView.loadData(listTopSongModel); //lấy dữ liệu xong rồi thì gọi lại view
            }

            @Override
            public void onFailure(Call<TopSongResponseJSON> call, Throwable t) {

            }
        });
    }
}
