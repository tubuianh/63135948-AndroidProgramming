package com.example.intents;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class ActivityQuiz extends AppCompatActivity {

    private Button submitBtn1, submitBtn2;
    private RadioGroup dapAnCauHoi1, dapAnCauHoi2;
    private RadioButton selectedRadioButton1, selectedRadioButton2;
    private TextView cauhoi1, cauhoi2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        cauhoi1 = findViewById(R.id.cauhoi1);
        cauhoi2 = findViewById(R.id.cauhoi2);
        dapAnCauHoi1 = findViewById(R.id.dapAnCauHoi1);
        dapAnCauHoi2 = findViewById(R.id.dapAnCauHoi2);
        submitBtn1 = findViewById(R.id.submitBtn1);
        submitBtn2 = findViewById(R.id.submitBtn2);

        // Thiết lập sự kiện click cho nút Submit câu hỏi 1
        submitBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy RadioButton được chọn trong RadioGroup
                int selectedId = dapAnCauHoi1.getCheckedRadioButtonId();
                selectedRadioButton1 = findViewById(selectedId);

                // Kiểm tra đáp án
                if (selectedRadioButton1.getText().toString().equals("200")) {
                    Toast.makeText(ActivityQuiz.this, "Đáp án đúng!", Toast.LENGTH_SHORT).show();
                    selectedRadioButton1.setTextColor(Color.GREEN);

                } else {
                    Toast.makeText(ActivityQuiz.this, "Đáp án sai!", Toast.LENGTH_SHORT).show();
                    selectedRadioButton1.setTextColor(Color.RED);
                }
            }
        });

        // Thiết lập sự kiện click cho nút Submit câu hỏi 2
        submitBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy RadioButton được chọn trong RadioGroup
                int selectedId = dapAnCauHoi2.getCheckedRadioButtonId();
                selectedRadioButton2 = findViewById(selectedId);

                // Kiểm tra đáp án
                if (selectedRadioButton2.getText().toString().equals("Một phần mềm xử lý văn bản")) {
                    Toast.makeText(ActivityQuiz.this, "Đáp án đúng!", Toast.LENGTH_SHORT).show();
                    selectedRadioButton2.setTextColor(Color.GREEN);
                } else {
                    Toast.makeText(ActivityQuiz.this, "Đáp án sai!", Toast.LENGTH_SHORT).show();
                    selectedRadioButton2.setTextColor(Color.RED);
                }
            }
        });
    }

}