package com.example.thangpham.mvvcmusicapp.view.adapters;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.thangpham.mvvcmusicapp.R;
import com.example.thangpham.mvvcmusicapp.Utils;
import com.example.thangpham.mvvcmusicapp.databinding.ItemListMusicTypeBinding;
import com.example.thangpham.mvvcmusicapp.events.OnClickMusicType;
import com.example.thangpham.mvvcmusicapp.model.MusicTypeModel;
import com.example.thangpham.mvvcmusicapp.view.activities.MainActivity;
import com.example.thangpham.mvvcmusicapp.view.fragment.TopSongFragment;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

public class MusicTypeAdapter extends RecyclerView.Adapter<MusicTypeAdapter.ViewHolder> {
    Fragment myFragment;
    public Context context;
    List<MusicTypeModel> listMusicType;
    public ItemListMusicTypeBinding binding;
    public MusicTypeAdapter(Fragment fragment, Context context, List<MusicTypeModel> listMusicType) {
        myFragment = fragment;
        this.context = context;
        this.listMusicType = listMusicType;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_list_music_type,viewGroup,false);

        return new ViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.setData(listMusicType.get(i));
    }

    @Override
    public int getItemCount() {
        Log.e("ThangPham","size ="+listMusicType.size());
        return listMusicType.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ObservableField<String> songName = new ObservableField<>();
        public ObservableField<String> imageUrl = new ObservableField<>();
        public int imageId;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            binding.setViewHolder(this);
        }

        public void setData(final MusicTypeModel model){
            songName.set(model.key);
            imageUrl.set("https://www.w3schools.com/w3css/img_lights.jpg");
            binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Utils.openFragment2(((MainActivity)context).getSupportFragmentManager(),R.id.rl_main,new TopSongFragment(),model);
                    EventBus.getDefault().postSticky(new OnClickMusicType(model));
                }
            });
        }

    }
    @BindingAdapter("android:setImage")
    public static void setImage(ImageView iv, String url){
        Glide.with(iv.getContext()).load(url).into(iv);
    }
}
