package com.example.baitaptonghop.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import com.example.baitaptonghop.MainActivity;
import com.example.baitaptonghop.R;

public class PersonFragment extends Fragment{
    private FragmentManager fragmentManager;
    public PersonFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof FragmentActivity) {
            fragmentManager = ((FragmentActivity) context).getSupportFragmentManager();
        }
    }

//
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_person, container, false);

    // Tìm kiếm và gán sự kiện cho nút btn_info
    Button button = view.findViewById(R.id.btn_info);
    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ChuyenManHinhInfo();
        }
    });

    return view;
}
    public void ChuyenManHinhInfo() {
        FragmentManager fragmentManager = ((MainActivity) requireActivity()).getSupportFragmentManager();
        ProfileInformation profileInformation = new ProfileInformation();

        // Sử dụng fragmentManager để thay thế Fragment hiện tại bằng Fragment mới
        getParentFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, profileInformation)
                .addToBackStack(null)
                .commit();
    }


}