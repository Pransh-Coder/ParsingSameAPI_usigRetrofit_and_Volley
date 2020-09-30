package com.example.parsingapi.networkingStructure;

import com.example.parsingapi.models.Example;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiInterface {

    @POST("check_date")
    Call<Example>getAttendance(@Body JsonObject jsonObject);
}
