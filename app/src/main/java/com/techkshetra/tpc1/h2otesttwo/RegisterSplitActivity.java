package com.techkshetra.tpc1.h2otesttwo;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class RegisterSplitActivity extends AppCompatActivity {

    private Button nextbtn,regbtn,reglogbtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_split);

        nextbtn=findViewById(R.id.nextbtnid);
        regbtn=findViewById(R.id.regbtnid);
        reglogbtn=findViewById(R.id.reglogbtn);
        Animation anim= AnimationUtils.loadAnimation(this,R.anim.leftright);
        reglogbtn.setAnimation(anim);

        FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        Regonefragment regonefragment=new Regonefragment();
        fragmentTransaction.add(R.id.fragment_container,regonefragment);
        fragmentTransaction.commit();

        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager=getFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                Regtwofragment regtwofragment=new Regtwofragment();
                fragmentTransaction.replace(R.id.fragment_container,regtwofragment);
                nextbtn.setVisibility(View.INVISIBLE);
                regbtn.setVisibility(View.VISIBLE);
                fragmentTransaction.commit();
            }
        });

        regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterSplitActivity.this,DashboardActivity.class));
            }
        });

        reglogbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterSplitActivity.this,LoginActivity.class));
                overridePendingTransition(R.anim.slideleft, R.anim.rightleftactivity);
            }
        });




    }
}
