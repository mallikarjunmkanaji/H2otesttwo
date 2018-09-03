package com.techkshetra.tpc1.h2otesttwo;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.google.common.collect.Range;

import static android.text.TextUtils.isEmpty;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    private CheckBox allcheck,moncheck,tuecheck,wedcheck,thucheck,fricheck,satcheck,suncheck;

    private EditText useredit,mobedit,pasedit,conpasedit;

    // private AwesomeValidation awesomeValidation;


    private Button regbtn,logbtn;
    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;

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

        setContentView(R.layout.activity_register);

     //   awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);




        spinner=findViewById(R.id.qtyspinner);
        adapter=ArrayAdapter.createFromResource(this,R.array.can_qty,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
              //  Toast.makeText(getBaseContext(),parent.getItemAtPosition(position)+" quatities choosed",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        useredit=findViewById(R.id.user_id);
        mobedit=findViewById(R.id.mob_id);
        pasedit=findViewById(R.id.pswd_id);
        conpasedit=findViewById(R.id.conpswd_id);



        /*
        //adding validation to edittexts
        awesomeValidation.addValidation(this, R.id.user_id, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        awesomeValidation.addValidation(this, R.id.mob_id, "^[2-9]{2}[0-9]{8}$", R.string.mobileerror);
        awesomeValidation.addValidation(this, R.id.conpswd_id, "^[2-9]{2}[0-9]{8}$", R.string.pswrderror);
*/

        Animation anim= AnimationUtils.loadAnimation(this,R.anim.leftright);
        regbtn=findViewById(R.id.regbtn);
        regbtn.setOnClickListener(this);
        logbtn=findViewById(R.id.reglogbtn);
        logbtn.setAnimation(anim);
        logbtn.setOnClickListener(this);

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


      /*  allcheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
        }); */
    }

   private void regisubmit(){

       /* if (awesomeValidation.validate())
        {
            startActivity(new Intent(RegisterActivity.this, DashboardActivity.class));
            finish();
        }
        else
            {
                Toast.makeText(this, "Please Enter Details", Toast.LENGTH_SHORT).show();
            //process the data further

            }*/

       String   username = useredit.getText().toString();
       String   email = mobedit.getText().toString();
       String   password = pasedit.getText().toString();
       String   conpassword = conpasedit.getText().toString();

       if (Validationfile.isValidUsername(this,username)
               && Validationfile.isValidEmail(this, email)
               && Validationfile.isValidPassword(this, password)
               && Validationfile.isValidconPassword(this,conpassword)
               && conpassword.equals(password)) {

           // All inputs are valid and we can go ahead and perform our further functions
           // Validationfile.showToast(this, "All fields are correct :)");
           startActivity(new Intent(RegisterActivity.this,DashboardActivity.class));
           finish();
       }
       else if (!conpassword.equals(password))
       {
           Validationfile.showToast(this,"Password did not match");
       }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.regbtn :
                regisubmit();
                break;

            case R.id.reglogbtn :
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                overridePendingTransition(R.anim.slideleft, R.anim.rightleftactivity);
                finish();
                break;
        }

    }
}
