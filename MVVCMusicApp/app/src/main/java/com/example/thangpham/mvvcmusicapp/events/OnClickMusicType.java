package com.example.thangpham.mvvcmusicapp.events;

import com.example.thangpham.mvvcmusicapp.model.MusicTypeModel;

public class OnClickMusicType {
    public MusicTypeModel musicTypeModel;
    public OnClickMusicType(MusicTypeModel model){
        musicTypeModel = model;
    }
}
