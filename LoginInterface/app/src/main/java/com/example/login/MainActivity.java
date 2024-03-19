package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    Button btnsign;
    TextInputLayout txtemail;
    TextInputLayout txtpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtemail = findViewById(R.id.txtEmail);
        txtpassword = findViewById(R.id.txtPassword);
        btnsign = findViewById(R.id.btnSign);
        btnsign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtemail.getEditText().getText().toString().equals("buianhtu@gmail.com")
                        && txtpassword.getEditText().getText().toString().equals("63cntt2")){
                    Toast.makeText(MainActivity.this,"Logged in successfully!",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this,"User or password is wrong!",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}