package com.techkshetra.tpc1.h2otesttwo;

import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.util.Timer;

public class SplashActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private int i=0;
    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(Build.VERSION.SDK_INT>19) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        else
        {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }

        setContentView(R.layout.activity_splash);

        progressBar=findViewById(R.id.progressBar);


        Animation anim= AnimationUtils.loadAnimation(this,R.anim.move_up);
        ImageView imageview=(ImageView)findViewById(R.id.splashimg);
        imageview.setAnimation(anim);

     /*   Handler handler=new Handler();
        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this,LoginActivity.class));
                finish();
            }
        },4000); */

     new Thread(new Runnable() {
         @Override
         public void run() {
             doWork();
             startApp();
             finish();
         }
     }).start();
    }

    private void doWork(){
        for(int progress=25; progress<100; progress++){
           try {
               Thread.sleep(100);
               progressBar.setProgress(progress);
           } catch (Exception e) {
               e.printStackTrace();
           }
        }
    }
    private void startApp(){
        startActivity(new Intent(SplashActivity.this,LoginActivity.class));
    }
}
