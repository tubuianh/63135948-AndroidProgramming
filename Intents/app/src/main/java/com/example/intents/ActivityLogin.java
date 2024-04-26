package com.example.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityLogin extends AppCompatActivity {

    TextView ten;
    EditText matKhau;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void ChuyenManHinhHome(View v){
        ten = findViewById(R.id.edtUsername);
        matKhau = findViewById(R.id.edtPassword);
        Intent manHinhHome = new Intent(this, ActivityHome.class);

        String tenDangNhap = ten.getText().toString();
        String matKhauDangNhap = matKhau.getText().toString();

        if(tenDangNhap.equals("buianhtu") && matKhauDangNhap.equals("63135948")){
            manHinhHome.putExtra("tenDangNhap", tenDangNhap);
            startActivity(manHinhHome);
        }
        else{
            Toast.makeText(this, "Sai mật khẩu hoặc tài khoản", Toast.LENGTH_SHORT).show();
        }
    }
}