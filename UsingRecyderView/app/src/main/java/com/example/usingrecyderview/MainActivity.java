package com.example.usingrecyderview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    LandScapeAdapter landScapeAdapter;
    ArrayList<LandScape> recyclerViewData;
    RecyclerView recyclerViewLandScape;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewData = getDataForRecyclerView();

        recyclerViewLandScape = findViewById(R.id.recyclerLand);

        RecyclerView.LayoutManager layoutLinear = new LinearLayoutManager(this);
        recyclerViewLandScape.setLayoutManager(layoutLinear);

        landScapeAdapter = new LandScapeAdapter(this, recyclerViewData);
        recyclerViewLandScape.setAdapter(landScapeAdapter);
    }

    ArrayList<LandScape> getDataForRecyclerView(){
        ArrayList<LandScape> dsDuLieu = new ArrayList<LandScape>();
        dsDuLieu.add(new LandScape("cau_rong", "Cầu rồng Đà Nẵng"));
        dsDuLieu.add(new LandScape("thap_eiffel", "Tháp Eiffel"));
        dsDuLieu.add(new LandScape("nu_than_tu_do", "Tượng nữ thần tự do"));
        dsDuLieu.add(new LandScape("van_ly_truong_thanh", "Vạn lý trường thành"));
        return dsDuLieu;
    }
}