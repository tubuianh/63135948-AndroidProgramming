package com.example.baitaptonghop.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import com.example.baitaptonghop.MainActivity;
import com.example.baitaptonghop.R;

public class ProfileInformation extends Fragment {

    private FragmentManager fragmentManager;

    public ProfileInformation() {
        // Required empty public constructor
    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof FragmentActivity) {
            fragmentManager = ((FragmentActivity) context).getSupportFragmentManager();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.personal_information, container, false);
        ImageView imageView = view.findViewById(R.id.imageBack);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChuyenManHinhPerson();
            }
        });

        return view;
    }
    public void ChuyenManHinhPerson() {
        FragmentManager fragmentManager = ((MainActivity) requireActivity()).getSupportFragmentManager();
        PersonFragment personFragment = new PersonFragment();

        // Sử dụng fragmentManager để thay thế Fragment hiện tại bằng Fragment mới
        getParentFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, personFragment)
                .addToBackStack(null)
                .commit();
    }
}
