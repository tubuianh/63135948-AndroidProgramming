package com.example.bottomnavigation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.bottomnavigation.fragment.CalculateFragment;
import com.example.bottomnavigation.fragment.PersonFragment;
import com.example.bottomnavigation.fragment.RateFragment;
import com.example.bottomnavigation.fragment.TrangChuFragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment initialFragment = new TrangChuFragment();

        // Thay thế FragmentContainer bằng Fragment ban đầu
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, initialFragment)
                .commit();

        BottomNavigationView navigation = findViewById(R.id.bottom_navigation);

        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                int itemId = item.getItemId();

                if (itemId == R.id.tab_home) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new TrangChuFragment()).commit();
                    return true;
                } else if (itemId == R.id.tab_rate) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new RateFragment()).commit();
                    return true;
                } else if (itemId == R.id.tab_calculate) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new CalculateFragment()).commit();
                    return true;
                } else if(itemId == R.id.tab_person){
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new PersonFragment()).commit();
                    return true;
                }

                return false;
            }
        });

    }



}