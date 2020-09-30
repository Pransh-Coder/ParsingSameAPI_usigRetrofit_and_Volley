package com.example.parsingapi.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Emp {

    @SerializedName("res_code")
    @Expose
    public String resCode;
    @SerializedName("res_msg")
    @Expose
    public String resMsg;
    @SerializedName("result")
    @Expose
    public List<Result> result = new ArrayList<>();

    public String getResCode() {
        return resCode;
    }

    public void setResCode(String resCode) {
        this.resCode = resCode;
    }

    public String getResMsg() {
        return resMsg;
    }

    public void setResMsg(String resMsg) {
        this.resMsg = resMsg;
    }

    public List<Result> getResult() {
        return result;
    }

    public void setResult(List<Result> result) {
        this.result = result;
    }
}
