package com.example.f1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class About extends AppCompatActivity {
    //Initialize Variables
    DrawerLayout drawerLayout;
    ImageView btMenu;
    RecyclerView recyclerView;
    Button date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        //Assign Variables
        drawerLayout = findViewById(R.id.drawer_layout);
        btMenu=findViewById(R.id.bt_menu);
        recyclerView=findViewById(R.id.recycler_view);
        date=findViewById(R.id.date);

        //Set Layout Manager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //Set Adapter
        recyclerView.setAdapter(new MainAdapter(this,MainActivity.arrayList));

        btMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Open Drawer
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        ////Close Drawer
        MainActivity.closeDrawer(drawerLayout);

    }
}