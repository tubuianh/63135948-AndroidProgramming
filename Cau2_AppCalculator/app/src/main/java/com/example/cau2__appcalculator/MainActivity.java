package com.example.cau2__appcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn0, btn1, btn2, btn3,btn4,btn5,btn6,btn7,btn8,btn9;
    Button bang,cong,tru,nhan,chia,ac,ce,btncham;
    TextView mainScreen, secondScreen;
    String tinhToan;
    String phepToan;

    boolean checkCham = false, checkBang = false;
    double so1, so2, ketQua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layid();
        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                secondScreen.setText("");
                mainScreen.setText("");
                tinhToan = "";
                phepToan = "";
                checkBang = false;
                checkCham = false;
            }
        });
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!checkBang){
                    tinhToan = mainScreen.getText().toString();
                    mainScreen.setText(tinhToan + "0");
                }
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!checkBang){
                    tinhToan = mainScreen.getText().toString();
                    mainScreen.setText(tinhToan + "1");
                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!checkBang){
                    tinhToan = mainScreen.getText().toString();
                    mainScreen.setText(tinhToan + "2");
                }
            }
        });
    }

    protected void layid(){
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btncham = findViewById(R.id.btnCham);
        bang = findViewById(R.id.btnBang);
        cong = findViewById(R.id.btnCong);
        tru = findViewById(R.id.btnTru);
        nhan = findViewById(R.id.btnNhan);
        chia = findViewById(R.id.btnChia);
        ac = findViewById(R.id.btnAc);
        ce = findViewById(R.id.btnCe);
        mainScreen = findViewById(R.id.manhinhnhap);
        secondScreen = findViewById(R.id.manhinhkq);

    }
}