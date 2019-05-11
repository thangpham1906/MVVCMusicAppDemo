package com.example.thangpham.mvvcmusicapp.model;

import java.io.Serializable;

public class MusicTypeModel implements Serializable {
    public String key;
    public String id;
    public int imageId;

    public MusicTypeModel(){}
    public MusicTypeModel(String key, String id, int imageId) {

        this.key = key;
        this.id = id;
        this.imageId = imageId;
    }
}

