package com.example.myfavoritemusic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> dsBH = new ArrayList<String>();
        dsBH.add("A Gift Of a Friend");
        dsBH.add("Apologize");
        dsBH.add("Count On Me");
        dsBH.add("Jingle Bells");
        dsBH.add("Lemon Tree");
        dsBH.add("One Day");
        dsBH.add("Take Me To Your Heart");

        ListView lvBH = (ListView)findViewById(R.id.listViewId);

        ArrayAdapter<String> baiHatAdapter = new ArrayAdapter<String>(this,
                                                                        android.R.layout.simple_list_item_1,
                                                                        dsBH);
        lvBH.setAdapter(baiHatAdapter);

        lvBH.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value = baiHatAdapter.getItem(position);
                Toast.makeText(MainActivity.this,value,Toast.LENGTH_SHORT).show();
            }
        });
    }


}