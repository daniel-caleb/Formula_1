package com.example.f1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;


@SuppressLint("CustomSplashScreen")
public class SplashscreenActivity extends AppCompatActivity {

    //Variables
    Animation topAnim, bottomAnim;
    ImageView imageView,logo;
    TextView slogan;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splashscreen);

        //Animations
        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        //Hooks
        imageView = findViewById(R.id.imageView);
        logo = findViewById(R.id.logo);
        slogan = findViewById(R.id.textView2);

        imageView.setAnimation(topAnim);
        logo.setAnimation(bottomAnim);
        slogan.setAnimation(bottomAnim);

        int SPLASH_SCREEN = 5000;
        new Handler().postDelayed(() -> {
            Intent intent;
            intent = new Intent(SplashscreenActivity.this, SignupActivity.class);
            startActivity(intent);
            finish();
        },
                SPLASH_SCREEN);


    }
}