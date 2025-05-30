package com.example.msapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class History extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.history);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);

        List<Item> items = new ArrayList<Item>();
        items.add(new Item("Air Jordan 1 High OG - Spiderman","Purchase Date : 11 March 2023","Rp 4.999.999",R.drawable.produk1));
        items.add(new Item("New York Black Cap - New Era","Purchase Date : 30 January 2023","Rp 475.000",R.drawable.produk2));
        items.add(new Item("Guess Watches - Gold","Purchase Date : 18 February 2023","Rp 2.099.000",R.drawable.produk3));
        items.add(new Item("Volcom Vaderetro - White","Purchase Date : 4 April 2023","Rp 645.000",R.drawable.produk4));
        items.add(new Item("Urban Cargo Joggers - Cotton On","Purchase Date : 9 May 2023","Rp 969.000",R.drawable.produk5));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(getApplicationContext(), items));

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.menu_history);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();

                if (itemId == R.id.menu_home) {
                    Intent homeIntent = new Intent(History.this, Dashboard.class);
                    startActivity(homeIntent);
                    return true;
                } else if (itemId == R.id.menu_loc) {
                    Intent locIntent = new Intent(History.this, MapsActivity.class);
                    startActivity(locIntent);
                    return true;
                }

                return false;
            }
        });

    }
}