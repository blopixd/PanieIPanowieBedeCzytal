package com.example.konkler;


import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface JSONPlaceholderAPI {
    @GET("pytania")
    public Call<List<k>> getPytania();
}
