package com.example.thangpham.mvvcmusicapp.view.fragment;


import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.thangpham.mvvcmusicapp.R;
import com.example.thangpham.mvvcmusicapp.databinding.FragmentMusicTypeBinding;
import com.example.thangpham.mvvcmusicapp.model.MusicTypeModel;
import com.example.thangpham.mvvcmusicapp.view.adapters.MusicTypeAdapter;
import com.example.thangpham.mvvcmusicapp.viewmodel.fragment.MusicTypeVM;
import com.example.thangpham.mvvcmusicapp.viewmodel.fragment.MusicTypeVMContract;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MusicTypeFragment extends Fragment implements MusicTypeVMContract.MainView {
    public FragmentMusicTypeBinding fragmentMusicTypeBinding;
    public MusicTypeVM musicTypeVM;
    public MusicTypeAdapter musicTypeAdapter;
    public ObservableField<MusicTypeAdapter> musicTypeAdapterObservableField = new ObservableField<>();
    public MusicTypeFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentMusicTypeBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_music_type,container,false);
        fragmentMusicTypeBinding.setMusicTypeFragment(this);
        //2. view sẽ gọi viewmodel (viewmodel lắng nghe sự kiện)
        musicTypeVM = new MusicTypeVM(this,getContext());
        return fragmentMusicTypeBinding.getRoot();
    }

    @Override
    public void loadData(List<MusicTypeModel> listMusicType) {
        Log.e("ThangPham","loadData: "+listMusicType.size() );
        musicTypeAdapterObservableField.set(new MusicTypeAdapter(this,getContext(),listMusicType));
    }

}
