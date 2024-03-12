package com.example.simple_login_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText userName;
    EditText passWord;
    TextView attempt;
    Button login;
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = findViewById(R.id.button);
        userName = findViewById(R.id.editUserName);
        passWord = findViewById(R.id.editPassword);
        attempt = findViewById(R.id.attemp);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(userName.getText().toString().equals("buianhtu") && passWord.getText().toString().equals("Cntt63ntu")){
                    Toast.makeText(MainActivity.this,"Logged in successfully!",Toast.LENGTH_SHORT).show();
                    count++;
                    attempt.setText("Attemps: "+String.valueOf(count));
                }
                else{
                    Toast.makeText(MainActivity.this,"User or password is wrong!",Toast.LENGTH_SHORT).show();
                    count++;
                    attempt.setText("Attemps: "+String.valueOf(count));
                }
            }
        });
    }
}