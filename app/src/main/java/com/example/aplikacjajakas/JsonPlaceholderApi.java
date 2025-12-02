package com.example.aplikacjajakas;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
public interface JsonPlaceholderApi {
    @GET("pytania")
    public Call<List<Pytanie>> getPytania();
}
