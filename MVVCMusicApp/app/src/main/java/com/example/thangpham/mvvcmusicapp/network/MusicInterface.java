package com.example.thangpham.mvvcmusicapp.network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MusicInterface {

    @GET("api")
    Call<MusicTypeResponseJSON> getMusicType();

    @GET("https://itunes.apple.com/us/rss/topsongs/limit=50/genre={id}/explicit=true/json")
    Call<TopSongResponseJSON> getListTopSong(@Path("id") String id);
}
