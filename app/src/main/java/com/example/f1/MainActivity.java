package com.example.f1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //Initialize the variables
    DrawerLayout drawerLayout;
    ImageView btmenu;
    RecyclerView recyclerView;
    static ArrayList<String> arrayList = new ArrayList<>();
    MainAdapter adapter;

    public static void closeDrawer(DrawerLayout drawerLayout){
        //Check Condition
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            //When drawer is open, close drawer
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Assign Variables
        drawerLayout = findViewById(R.id.drawer_layout);
        btmenu = findViewById(R.id.bt_menu);
        recyclerView = findViewById(R.id.recycler_view);

        //Clear Array List
        arrayList.clear();

        //Add Menu item in array list
        arrayList.add("Home");
        arrayList.add("Constructors-Drivers");
        arrayList.add("Circuits");
        arrayList.add("Logout");

        //Initialize adapter
        adapter = new MainAdapter(this,arrayList);
        //Set Layout Manager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //Set Adapter
        recyclerView.setAdapter(adapter);

        btmenu.setOnClickListener(new View.OnClickListener() {
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
        //Close Drawer
        closeDrawer(drawerLayout);
    }
}