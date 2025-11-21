package com.example.moviesapp.Api;

// Cập nhật import để trỏ đến package Domain
import com.example.moviesapp.Domain.LocalDateDeserializer;
import com.example.moviesapp.Domain.LocalDateTimeDeserializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TicketAPIRetrofitClient {
    private static final String BASE_URL = "http://10.90.220.137:6000/";
    private static Retrofit retrofit;

    public static TicketAPI getTicketAPI() {
        if (retrofit == null) {
            // Tạo Gson với deserializer tùy chỉnh
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(LocalDate.class, new LocalDateDeserializer())
                    .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeDeserializer())
                    .create();

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit.create(TicketAPI.class);
    }
}