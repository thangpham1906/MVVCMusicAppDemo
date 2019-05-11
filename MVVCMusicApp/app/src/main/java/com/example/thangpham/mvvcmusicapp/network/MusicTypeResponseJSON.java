package com.example.thangpham.mvvcmusicapp.network;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MusicTypeResponseJSON {
    @SerializedName("subgenres")
    public List<Subgenres> subgenres;

    public class Subgenres{
        public String id;
        public String translation_key;
    }
}
