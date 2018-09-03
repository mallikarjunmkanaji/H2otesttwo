package com.techkshetra.tpc1.h2otesttwo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

public class RegtwoActivity extends AppCompatActivity {

    private CheckBox allcheck,moncheck,tuecheck,wedcheck,thucheck,fricheck,satcheck,suncheck;
    private Button regbtn,increment,decrement;
    TextView qtyvalue;
    int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regtwo);

        regbtn=findViewById(R.id.regbtnid);
        increment=findViewById(R.id.regplus_id);
        decrement=findViewById(R.id.regminus_id);
        qtyvalue=findViewById(R.id.reg_qty_no_id);

        increment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counter<25) {
                    counter++;
                    qtyvalue.setText(Integer.toString(counter));
                } else{
                    Toast.makeText(getApplicationContext(),"limits reached! Maximum delivery per customer a day is 25",Toast.LENGTH_LONG).show();
                }
            }
        });
        decrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counter>0) {
                    counter--;
                    qtyvalue.setText(Integer.toString(counter));
                } else {
                    counter=0;
                    qtyvalue.setText(Integer.toString(counter));
                }
            }
        });


        regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!allcheck.isChecked()&& !moncheck.isChecked() && !tuecheck.isChecked() && !wedcheck.isChecked() && !thucheck.isChecked() && !fricheck.isChecked() &&
                        !satcheck.isChecked() && !suncheck.isChecked()){
                    Toast.makeText(getApplicationContext(),"Please Choose atleast one service day",Toast.LENGTH_LONG).show();
                } else if(counter<=0){
                    Toast.makeText(getApplicationContext(),"Choose atleast one quantity",Toast.LENGTH_LONG).show();
                } else {
                    startActivity(new Intent(RegtwoActivity.this, DashboardActivity.class));
                }

            }
        });

        allcheck=findViewById(R.id.allchk);
        moncheck=findViewById(R.id.monchk);
        tuecheck=findViewById(R.id.tuechk);
        wedcheck=findViewById(R.id.wedchk);
        thucheck=findViewById(R.id.thuchk);
        fricheck=findViewById(R.id.frichk);
        satcheck=findViewById(R.id.satchk);
        suncheck=findViewById(R.id.sunchk);

        allcheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (allcheck.isChecked()){
                    moncheck.setChecked(true);
                    tuecheck.setChecked(true);
                    wedcheck.setChecked(true);
                    thucheck.setChecked(true);
                    fricheck.setChecked(true);
                    satcheck.setChecked(true);
                    suncheck.setChecked(true);
                }

                else {
                    moncheck.setChecked(false);
                    tuecheck.setChecked(false);
                    wedcheck.setChecked(false);
                    thucheck.setChecked(false);
                    fricheck.setChecked(false);
                    satcheck.setChecked(false);
                    suncheck.setChecked(false);
                }
            }
        });
    }
}
