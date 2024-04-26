package com.example.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.content.Intent;
import android.os.Bundle;
public class ActivityHome extends AppCompatActivity {

    EditText ten;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ten = findViewById(R.id.edtName);
        Intent intent = getIntent();
        String tenDangNhap = intent.getStringExtra("tenDangNhap");
        if (tenDangNhap != null) {
            ten.setText(tenDangNhap);
        }
    }
    public void ChuyenManHinhQuiz(View v){
        Intent manHinhQuiz = new Intent(this, ActivityQuiz.class);
        startActivity(manHinhQuiz);
    }


}