package com.example.doan.ViewResult;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doan.R;

import java.util.List;

public class ResultAdapter extends RecyclerView.Adapter<ResultAdapter.ViewHolder> {

    private List<ListResultItems> listItems;
    private Context context;

    public ResultAdapter(List<ListResultItems> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_result_items, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ListResultItems listItem = listItems.get(position);

        holder.tvQuestion.setText("Question "+ Integer.toString(position+1) +": " + listItem.getQuestion());
        holder.tvAns1.setText("A. " + listItem.getAns1());
        holder.tvAns2.setText("B. " + listItem.getAns2());
        holder.tvAns3.setText("C. " + listItem.getAns3());
        holder.tvAns4.setText("D. " + listItem.getAns4());
        if (listItem.getPos() == 1) {
            if (listItem.getAns1().equals(listItem.getResult())) {
                holder.tvAns1.setTextColor(0xFF00FF00);
            } else {
                holder.tvAns1.setTextColor(0xFFFF0000);
            }
        } else if (listItem.getPos() == 2) {
            if (listItem.getAns1().equals(listItem.getResult())) {
                holder.tvAns2.setTextColor(0xFF00FF00);
            } else {
                holder.tvAns2.setTextColor(0xFFFF0000);
            }
        } else if (listItem.getPos() == 3) {
            if (listItem.getAns1().equals(listItem.getResult())) {
                holder.tvAns3.setTextColor(0xFF00FF00);
            } else {
                holder.tvAns3.setTextColor(0xFFFF0000);
            }
        } else if (listItem.getPos() == 4) {
            if (listItem.getAns1().equals(listItem.getResult())) {
                holder.tvAns4.setTextColor(0xFF00FF00);
            } else {
                holder.tvAns4.setTextColor(0xFFFF0000);
            }
        }
        holder.tvResult.setText("Result: "+listItem.getResult());
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvQuestion;
        public TextView tvAns1;
        public TextView tvAns2;
        public TextView tvAns3;
        public TextView tvAns4;
        public TextView tvResult;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvQuestion = itemView.findViewById(R.id.Question);

            tvAns1 = itemView.findViewById(R.id.Answer_1);
            tvAns2 = itemView.findViewById(R.id.Answer_2);
            tvAns3 = itemView.findViewById(R.id.Answer_3);
            tvAns4 = itemView.findViewById(R.id.Answer_4);
            tvResult = itemView.findViewById(R.id.Result);
        }
    }
}
