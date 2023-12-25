package com.example.doan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doan.MainMenuFolder.Test;

import java.util.ArrayList;

public class LeaderboardAdapter extends RecyclerView.Adapter<LeaderboardAdapter.MyViewHolder> {
    Context context;
    ArrayList<ReadWriteUserDetail> list;

    public LeaderboardAdapter(Context context, ArrayList<ReadWriteUserDetail> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public LeaderboardAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.user_leaderboard, parent, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull LeaderboardAdapter.MyViewHolder holder, int position) {
        ReadWriteUserDetail readWriteUserDetail = list.get(position);
        holder.username.setText(readWriteUserDetail.getUsername());
        holder.score.setText(readWriteUserDetail.getScore());
        holder.rank.setText(readWriteUserDetail.getRank());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView username, score, rank;
        public MyViewHolder (@NonNull View itemView)
        {
            super(itemView);
            username = itemView.findViewById(R.id.tvUsername);
            score = itemView.findViewById(R.id.tvScore);
            rank = itemView.findViewById(R.id.tvRank);
        }

    }
}
