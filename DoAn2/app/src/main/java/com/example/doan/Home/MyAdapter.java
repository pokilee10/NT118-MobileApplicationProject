package com.example.doan.Home;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doan.MainMenuFolder.GrammarCau;
import com.example.doan.MainActivity;
import com.example.doan.MainMenuFolder.GrammarTu;
import com.example.doan.MainMenuFolder.LeaderBoard;
import com.example.doan.MainMenuFolder.Test;
import com.example.doan.MainMenuFolder.Vocabulary;
import com.example.doan.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private Context context;
    private List<DataClass> dataList;


    public MyAdapter(Context context, List<DataClass> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        DataClass data = dataList.get(position);
        holder.recImage.setImageResource(dataList.get(position).getDataImage());

        holder.recCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data.getNo();
                int layoutType = data.getNo();
                if (layoutType == 1) {
                    Intent intent = new Intent(context, GrammarCau.class);
                    context.startActivity(intent);
                } else if (layoutType == 2) {
                    Intent intent = new Intent(context, GrammarTu.class);
                    context.startActivity(intent);
                } else if (layoutType == 3) {
                    Intent intent = new Intent(context, Vocabulary.class);
                    context.startActivity(intent);
                } else if (layoutType == 4) {
                    Intent intent = new Intent(context, Test.class);
                    context.startActivity(intent);
                } else if (layoutType == 5) {
                    Intent intent = new Intent(context, LeaderBoard.class);
                    context.startActivity(intent);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}

class MyViewHolder extends RecyclerView.ViewHolder{

    ImageView recImage;
    CardView recCard;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        recImage = itemView.findViewById(R.id.recImage);
        recCard = itemView.findViewById(R.id.recCard);
    }
}
