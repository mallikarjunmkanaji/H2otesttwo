package com.techkshetra.tpc1.h2otesttwo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class RequestorderActivity extends AppCompatActivity{

    int counterbig,counterfive,counterone;
    private TextView bigtv,fivetv,onetv;
    private Button bigplusbtn,bigminusbtn,fiveplusbtn,fiveminusbtn,oneplusbtn,oneminusbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requestorder);

        Toolbar toolbar=findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Request Order");
        toolbar.setNavigationIcon(R.drawable.ic_tool_back);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
                finish();
            }
        });

        bigtv=findViewById(R.id.bigcountid);
        fivetv=findViewById(R.id.fivecountid);
        onetv=findViewById(R.id.onecountid);

        bigplusbtn=findViewById(R.id.bigplus_id);
        bigplusbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counterbig<100) {
                    counterbig++;
                    bigtv.setText(Integer.toString(counterbig));
                } else{
                    Toast.makeText(getApplicationContext(),"limits reached",Toast.LENGTH_LONG).show();
                }
            }
        });

        bigminusbtn=findViewById(R.id.bigminus_id);
        bigminusbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counterbig>0) {
                    counterbig--;
                    bigtv.setText(Integer.toString(counterbig));
                } else {
                    counterbig=0;
                    bigtv.setText(Integer.toString(counterbig));
                }
            }
        });

        fiveplusbtn=findViewById(R.id.fiveplus_id);
        fiveplusbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counterfive<100) {
                    counterfive++;
                    fivetv.setText(Integer.toString(counterfive));
                } else{
                    Toast.makeText(getApplicationContext(),"limits reached",Toast.LENGTH_LONG).show();
                }

            }
        });

        fiveminusbtn=findViewById(R.id.fiveminus_id);
        fiveminusbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counterfive>0) {
                    counterfive--;
                    fivetv.setText(Integer.toString(counterfive));
                } else {
                    counterfive=0;
                    fivetv.setText(Integer.toString(counterfive));
                }

            }
        });

        oneplusbtn=findViewById(R.id.oneplus_id);
        oneplusbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counterone<100) {
                    counterone++;
                    onetv.setText(Integer.toString(counterone));
                } else{
                    Toast.makeText(getApplicationContext(),"limits reached",Toast.LENGTH_LONG).show();
                }

            }
        });

        oneminusbtn=findViewById(R.id.oneminus_id);
        oneminusbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counterone>0) {
                    counterone--;
                    onetv.setText(Integer.toString(counterone));
                } else {
                    counterone=0;
                    onetv.setText(Integer.toString(counterone));
                }
            }
        });
    }

}
