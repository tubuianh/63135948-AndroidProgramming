package com.example.ex3_simplesumapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText inputa;
    EditText inputb;
    TextView outputkq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




    }
    public void TinhTong(View view){
        inputa = findViewById(R.id.inputa);
        inputb = findViewById(R.id.inputb);
        outputkq = findViewById(R.id.outputkq);

        int a = Integer.parseInt(inputa.getText().toString());
        int b = Integer.parseInt(inputb.getText().toString());

        outputkq.setText(String.valueOf(a+b));
    }
}