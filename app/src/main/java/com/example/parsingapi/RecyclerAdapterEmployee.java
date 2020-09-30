package com.example.parsingapi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.parsingapi.models.Result;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapterEmployee extends RecyclerView.Adapter<RecyclerAdapterEmployee.ViewHolder> {

    Context context;
    List<Result> resultList = new ArrayList<>();

    public RecyclerAdapterEmployee(Context context, List<Result> resultList) {
        this.context = context;
        this.resultList = resultList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.attendance_list, parent, false);
        return new RecyclerAdapterEmployee.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.date.setText(resultList.get(position).getDate());
        holder.end_time.setText(resultList.get(position).getEndDate());
        holder.start_time.setText(resultList.get(position).getTime());
        holder.status.setText(resultList.get(position).getStatus());
    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView date,end_time,start_time,status;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            date = itemView.findViewById(R.id.date);
            end_time = itemView.findViewById(R.id.end_time);
            start_time = itemView.findViewById(R.id.start_time);
            status = itemView.findViewById(R.id.status);
        }
    }
}
