package com.example.doan.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.doan.Home.DataClass;
import com.example.doan.Home.MyAdapter;
import com.example.doan.R;

import java.util.ArrayList;
import java.util.List;


public class Home extends Fragment {

    RecyclerView recyclerView;
    List<DataClass> dataList;

    DataClass androidData;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = root.findViewById(R.id.recycleview);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(requireContext(), 1);
        recyclerView.setLayoutManager(gridLayoutManager);
        dataList = new ArrayList<>();

        androidData = new DataClass("Camera", R.string.camera, "Java", R.drawable.baseline_settings_24);
        dataList.add(androidData);
        androidData = new DataClass("RecycleView", R.string.recyclerview, "Kotlin", R.drawable.logoapp_removebg_preview);
        dataList.add(androidData);
        androidData = new DataClass("Date Picker", R.string.date, "Java", R.drawable.baseline_settings_24);
        dataList.add(androidData);
        androidData = new DataClass("Edit Text", R.string.edit, "Kotlin", R.drawable.baseline_settings_24);
        dataList.add(androidData);
        androidData = new DataClass("Rating Bar", R.string.rating, "Java", R.drawable.baseline_settings_24);
        dataList.add(androidData);

        MyAdapter adapter = new MyAdapter(requireContext(), dataList);
        recyclerView.setAdapter(adapter);
        return root; // Return the root view that you inflated.
    }

}