package com.example.f1;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    //Initialize Variables
    Activity activity;
    ArrayList<String> arrayList;

    //Create constructor
    public MainAdapter(Activity activity,ArrayList<String> arrayList){
        this.activity = activity;
        this.arrayList = arrayList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Initialize view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_drawer_main,parent,false);
        //Return holder view
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //Set text on text view
        holder.textView.setText(arrayList.get(position));

        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Get clicked item position
                int position = holder.getAdapterPosition();
                //Check Condition
                switch (position){
                    case 0:
                        //When position is equal to 0
                        //Redirect to homepage
                        activity.startActivity(new Intent(activity,MainActivity.class)
                                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                        break;

                    case 1:
                        //When position is equal to 1
                        //Redirect to Dashboard page
                        activity.startActivity(new Intent(activity,Dashboard.class)
                                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                        break;

                    case 2:
                        //When position is equal to 1
                        //Redirect to Dashboard page
                        activity.startActivity(new Intent(activity,About.class)
                                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                        break;
                    case 3:
                        //When position is equal to 1
                        //Redirect to Dashboard page
                        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                                //SetTitle
                        builder.setTitle("Logout");
                        //Set Message
                        builder.setMessage("Are you sure you want to Logout?");
                        //Positive Yes Button
                        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //Finnish all
                            activity.finishAffinity();
                            //Exit App
                            System.exit(0);
                        }
                    });
                        //Negative Cancel
                        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //Dismiss Dialog
                            dialog.dismiss();
                        }
                    });
                        //Show Dialog
                        builder.show();
                        break;
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        //Return Array List
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //Initialize Variables
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //Assigning variables
            textView = itemView.findViewById(R.id.text_view);
        }
    }
}
