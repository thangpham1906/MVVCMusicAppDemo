package com.example.thangpham.mvvcmusicapp.view.adapters;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thangpham.mvvcmusicapp.R;
import com.example.thangpham.mvvcmusicapp.databinding.ItemListSongBinding;
import com.example.thangpham.mvvcmusicapp.model.TopSongModel;

import java.util.List;

public class TopSongAdapter extends RecyclerView.Adapter<TopSongAdapter.TopSongViewHolder> {
    public List<TopSongModel> topSongModelList;
    public ItemListSongBinding binding;
    public TopSongAdapter(List<TopSongModel> topSongModelList) {
        this.topSongModelList = topSongModelList;
    }

    @NonNull
    @Override
    public TopSongViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        binding = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.item_list_song,viewGroup,false);

        return new TopSongViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull TopSongViewHolder topSongViewHolder, int i) {
    topSongViewHolder.setData(topSongModelList.get(i));
    }

    @Override
    public int getItemCount() {
        return topSongModelList.size();
    }

    public class TopSongViewHolder extends RecyclerView.ViewHolder {
        public ObservableField<String> songName = new ObservableField<>();
        public ObservableField<String> artistName = new ObservableField<>();
        public ObservableField<String> imageurl = new ObservableField<>();

        public TopSongViewHolder(@NonNull View itemView) {
            super(itemView);
            binding.setTopSongViewHolder(this);
        }
        public void setData(TopSongModel model){
            songName.set(model.song);
            artistName.set(model.singer);
            imageurl.set("https://www.w3schools.com/w3css/img_lights.jpg");
        }
    }
}
