package com.example.lukag.registration_page;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    private EditText et_name, et_email, et_phone, et_password, et_cpassword;
    private String name, email, phone, password, cpassword;
    Button regbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        et_name = (EditText) findViewById(R.id.name);
        et_email = (EditText) findViewById(R.id.email);
        et_phone = (EditText) findViewById(R.id.phone);
        et_password = (EditText) findViewById(R.id.password);
        et_cpassword = (EditText) findViewById(R.id.cpassword);
        regbtn = (Button) findViewById(R.id.regbtn);
        regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();
            }
        });
    }
    public void register() {
        intialize();
        if (!validate()) {
            Toast.makeText(this,"Signup has Failed",Toast.LENGTH_SHORT).show();
        }
        else {
            onSignupSuccess();
        }
    }
    public void onSignupSuccess(){

    }
    public boolean validate() {
        boolean valid = true;
        if (name.isEmpty() ||name.length()>32) {
            et_name.setError("Please Enter valid Name");
            valid = false;
        }
        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            et_email.setError("Please Enter valid Email Addres");
            valid = false;
        }
        if (password.isEmpty()) {
            et_password.setError("Please Enter Valid Password");
            valid = false;
        }
        if (cpassword.isEmpty()) {
            et_cpassword.setError("Please Re-Enter Password");
            valid = false;
        }
        if (phone.isEmpty()) {
            et_phone.setError("Please Enter Your Number");
            valid = false;
        }
        return valid;
    }
    public void intialize() {
        name = et_name.getText().toString().trim();
        email = et_email.getText().toString().trim();
        phone = et_phone.getText().toString().trim();
        password = et_password.getText().toString().trim();
        cpassword = et_cpassword.getText().toString().trim();
    }
}
