package com.example.baitaptonghop.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.baitaptonghop.R;


public class CalculateFragment extends Fragment {
    EditText inputa;
    EditText inputb;
    TextView outputkq;
    Button btnCong, btnTru, btnNhan,btnChia;
    public CalculateFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_calculate, container, false);
        inputa = view.findViewById(R.id.inputa);
        inputb = view.findViewById(R.id.inputb);
        outputkq = view.findViewById(R.id.outputkq);
        btnCong = view.findViewById(R.id.cong);
        btnTru = view.findViewById(R.id.tru);
        btnNhan = view.findViewById(R.id.nhan);
        btnChia = view.findViewById(R.id.chia);

        btnCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(inputa.getText().toString());
                int b = Integer.parseInt(inputb.getText().toString());
                outputkq.setText(String.valueOf(a+b));
            }
        });

        btnTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(inputa.getText().toString());
                int b = Integer.parseInt(inputb.getText().toString());
                outputkq.setText(String.valueOf(a-b));
            }
        });

        btnNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(inputa.getText().toString());
                int b = Integer.parseInt(inputb.getText().toString());
                outputkq.setText(String.valueOf(a*b));
            }
        });

        btnChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float a = Float.parseFloat(inputa.getText().toString());
                float b = Float.parseFloat(inputb.getText().toString());
                if(b!=0)
                    outputkq.setText(String.valueOf(a/b));
                else
                    outputkq.setText("Không chia được vì b = 0!");
            }
        });

        return view;



    }

}