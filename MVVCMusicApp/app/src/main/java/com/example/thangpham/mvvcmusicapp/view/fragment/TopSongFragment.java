package com.example.thangpham.mvvcmusicapp.view.fragment;


import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thangpham.mvvcmusicapp.R;
import com.example.thangpham.mvvcmusicapp.databinding.FragmentTopSongBinding;
import com.example.thangpham.mvvcmusicapp.events.OnClickMusicType;
import com.example.thangpham.mvvcmusicapp.model.MusicTypeModel;
import com.example.thangpham.mvvcmusicapp.model.TopSongModel;
import com.example.thangpham.mvvcmusicapp.view.adapters.TopSongAdapter;
import com.example.thangpham.mvvcmusicapp.viewmodel.fragment.TopSongVM;
import com.example.thangpham.mvvcmusicapp.viewmodel.fragment.TopSongVMContract;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TopSongFragment extends Fragment implements TopSongVMContract.MainView{
    public ObservableField<TopSongAdapter> topSongAdapter= new ObservableField<>();
    MusicTypeModel musicTypeModel;
    public TopSongFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentTopSongBinding binding = DataBindingUtil.inflate(inflater,R.layout.fragment_top_song,container,false);
        EventBus.getDefault().register(this);
        binding.setTopSongFragment(this);
        Bundle bundle = getArguments();
        MusicTypeModel a = (MusicTypeModel) bundle.getSerializable("model");
        return binding.getRoot();
    }

    @Override
    public void loadData(List<TopSongModel> listTopSongs) {
        topSongAdapter.set(new TopSongAdapter(listTopSongs));
    }
    @Subscribe(sticky = true)
    void onReceivedMusicTypeCicked(OnClickMusicType onClickMusicType){
        Log.e("ThangPham", "onReceivedMusicTypeCicked- Model = "+onClickMusicType.musicTypeModel.key);
        musicTypeModel = onClickMusicType.musicTypeModel;
        TopSongVM topSongVM = new TopSongVM(getContext(),this,musicTypeModel);
    }
}
