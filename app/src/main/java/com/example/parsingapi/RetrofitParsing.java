package com.example.parsingapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.parsingapi.models.Example;
import com.example.parsingapi.models.Result;
import com.example.parsingapi.networkingStructure.ApiInterface;
import com.example.parsingapi.networkingStructure.RetrofitClient;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitParsing extends AppCompatActivity {

    List<Result> resultList = new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit_parsing);

        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        JsonObject jsonBody = new JsonObject();
        JsonObject jsonObject = new JsonObject();
        try {
            jsonBody.addProperty("id","20");
            jsonBody.addProperty("date","2020-09-28");
            jsonObject.add("emp",jsonBody);

        } catch (JsonIOException e) {
            e.printStackTrace();
        }
        Log.e("JSONBODY",""+jsonObject );

        ApiInterface apiInterface = RetrofitClient.getClient().create(ApiInterface.class);

        apiInterface.getAttendance(jsonObject).enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {

                if (response.isSuccessful()){

                    resultList = response.body().getEmp().getResult();
                    Log.e("resultListSize", ""+resultList.size());

                    for (int i=0;i<resultList.size();i++){

                        String date = resultList.get(i).getDate();
                        Log.e("date", ""+date);
                    }

                    RecyclerAdapterEmployee recyclerAdapterEmployee = new RecyclerAdapterEmployee(RetrofitParsing.this,resultList);
                    recyclerView.setAdapter(recyclerAdapterEmployee);
                }

            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {

            }
        });
    }
}