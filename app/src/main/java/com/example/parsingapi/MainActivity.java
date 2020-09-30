package com.example.parsingapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        requestQueue = Volley.newRequestQueue(this);

        JSONObject jsonObject = new JSONObject();
        JSONObject jsonBody = new JSONObject();
        try {
           /* JSONObject jsonObject = new JSONObject();
            JSONObject jsonBody = new JSONObject();*/
            jsonObject.put("id","20");
            jsonObject.put("date","2020-08-25");
            jsonBody.put("emp",jsonObject);

            Log.e("jsonBody", ""+jsonBody);
        }catch (JSONException e){
            Log.e("TAG", ""+e);
        }


        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, "http://megainfomatix.com/emp/api/check_date", jsonBody, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.e("response", ""+response);

                try {
                    JSONObject jsonObject1 = response.getJSONObject("emp");
                    String resCOde= jsonObject1.getString("res_code");
                    String resMsg = jsonObject1.getString("res_msg");

                    Log.e("aboveLoop", ""+resCOde+"\t"+resMsg);

                    JSONArray jsonArray = jsonObject1.getJSONArray("result");

                    for (int i=0;i<jsonArray.length();i++){

                        JSONObject jsonObject2 = jsonArray.getJSONObject(i);

                        String date = jsonObject2.getString("date");
                        String time = jsonObject2.getString("time");

                        Log.e("onResponse",""+date+"\t"+time);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonObjectRequest);

    }
}