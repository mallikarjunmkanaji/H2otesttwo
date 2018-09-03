package com.techkshetra.tpc1.h2otesttwo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegoneActivity extends AppCompatActivity {

    private Button nextbtn,logbtn;
    private EditText useredit,mailedit,pasedit,conpasedit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regone);

        nextbtn=findViewById(R.id.nextbtnid);
        logbtn=findViewById(R.id.reglogbtn);

        useredit=findViewById(R.id.user_id);
        mailedit=findViewById(R.id.mail_id);
        pasedit=findViewById(R.id.pswd_id);
        conpasedit=findViewById(R.id.conpswd_id);

        logbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegoneActivity.this,LoginActivity.class));
            }
        });

        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regnext();
            }
        });
    }

    private void regnext() {
        String   username = useredit.getText().toString();
        String   email = mailedit.getText().toString();
        String   password = pasedit.getText().toString();
        String   conpassword = conpasedit.getText().toString();

        if (Validationfile.isValidUsername(this,username)
                && Validationfile.isValidEmail(this,email)
                && Validationfile.isValidPassword(this, password)
                && Validationfile.isValidconPassword(this,conpassword)
                && conpassword.equals(password)) {

            // All inputs are valid and we can go ahead and perform our further functions
            // Validationfile.showToast(this, "All fields are correct :)");

            startActivity(new Intent(RegoneActivity.this,RegtwoActivity.class));
            finish();
        }
        else if (!conpassword.equals(password))
        {
            Validationfile.showToast(this,"Password did not match");
        }
    }
}
