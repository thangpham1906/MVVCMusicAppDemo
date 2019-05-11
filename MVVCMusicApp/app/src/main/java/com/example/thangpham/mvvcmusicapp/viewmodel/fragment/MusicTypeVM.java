package com.example.thangpham.mvvcmusicapp.viewmodel.fragment;

import android.content.Context;
import android.util.Log;

import com.example.thangpham.mvvcmusicapp.model.MusicTypeModel;
import com.example.thangpham.mvvcmusicapp.network.MusicInterface;
import com.example.thangpham.mvvcmusicapp.network.MusicTypeResponseJSON;
import com.example.thangpham.mvvcmusicapp.network.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MusicTypeVM implements MusicTypeVMContract.ViewModel {
    public MusicTypeVMContract.MainView mainView;
    public Context context;
    public List<MusicTypeModel> listMusicType = new ArrayList<>();
    public MusicTypeVM(MusicTypeVMContract.MainView mainView, Context context) {
        this.mainView = mainView;
        this.context = context;
        loadDataFromServer();
        Log.e("ThangPham","1234");
    }
    //3. viewmodel sẽ xử lí logic, lấy dữ liệu từ model,data

    public void loadDataFromServer(){



        MusicInterface musicInterface = RetrofitInstance.getInstance().create(MusicInterface.class);
                musicInterface.getMusicType().enqueue(new Callback<MusicTypeResponseJSON>() {
            @Override
            public void onResponse(Call<MusicTypeResponseJSON> call, Response<MusicTypeResponseJSON> response) {
                List<MusicTypeResponseJSON.Subgenres> subgenresList = response.body().subgenres;
                Log.e("ThangPham","list = "+ response.body().subgenres);
                for(MusicTypeResponseJSON.Subgenres subgenres : subgenresList){
                    MusicTypeModel musicTypeModel = new MusicTypeModel();
                    musicTypeModel.id =subgenres.id;
                    musicTypeModel.key = subgenres.translation_key;
                    musicTypeModel.imageId = context.getResources().getIdentifier(
                            "genre_x2_" + musicTypeModel.id,
                            "raw",
                            context.getPackageName()
                    );
                    listMusicType.add(musicTypeModel);  //lấy dữ liệu xong rồi thì gọi lại view
                    //5. viewmodel sẽ gọi lại view để tải dữ liệu cho view(not 4)

                }
                mainView.loadData(listMusicType);
                Log.e("ThangPham","final");
            }

            @Override
            public void onFailure(Call<MusicTypeResponseJSON> call, Throwable t) {
                Log.e("ThangPham","error = "+t.getMessage());
            }
        });

    }


}
