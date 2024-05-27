package com.example.baitaptonghop.fragment;


import static android.content.Context.MODE_PRIVATE;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.baitaptonghop.R;

import java.util.ArrayList;


public class DatabaseFragment extends Fragment {
    EditText edtMalop, edtTenlop, edtSiso;
    Button btnThem, btnXoa, btnCapnhat, btnInDs;

    //khai bao listview
    ListView lv;
    ArrayList<String> mylist;
    ArrayAdapter<String> myadapter;
    public DatabaseFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_database, container, false);


        edtMalop = view.findViewById(R.id.editMaLop);
        edtTenlop = view.findViewById(R.id.editTenLop);
        edtSiso = view.findViewById(R.id.editSiSo);

        btnThem = view.findViewById(R.id.btnThem);
        btnXoa = view.findViewById(R.id.btnXoa);
        btnCapnhat = view.findViewById(R.id.btnCapNhat);
        btnInDs = view.findViewById(R.id.btnIn);

        //tao ListView
        lv = view.findViewById(R.id.lv);
        mylist = new ArrayList<>();
        myadapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1,mylist);
        lv.setAdapter(myadapter);

        //tao database
        Context context = requireContext();
        SQLiteDatabase mydatabase = context.openOrCreateDatabase("qllophoc.db", MODE_PRIVATE, null);

        //tao bang
        try{
            String sqlTaoBang = "CREATE TABLE SinhVien(malop TEXT primary key, tenlop TEXT, siso INTEGER)";
            mydatabase.execSQL(sqlTaoBang);
        }
        catch (Exception e){
            Log.e("Error","Table đã tồn tại!");
        }

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String malop = edtMalop.getText().toString();
                String tenlop = edtTenlop.getText().toString();
                int siso = Integer.parseInt(edtSiso.getText().toString());

                ContentValues myvalue = new ContentValues();
                myvalue.put("malop",malop);
                myvalue.put("tenlop",tenlop);
                myvalue.put("siso",siso);

                String msg = "";
                if(mydatabase.insert("SinhVien",null,myvalue) == -1){//neu ko chen duoc
                    msg = "Thêm thất bại!";
                }
                else{
                    msg = "Thêm thành công!";
                }
                Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show();
            }
        });

        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String malop = edtMalop.getText().toString();
                int n = mydatabase.delete("SinhVien","malop = ?",new String[]{malop});
                String msg="";
                if(n == 0){
                    msg = "Không xóa bản ghi nào!";
                }
                else {
                    msg = n+" bản ghi được xóa!";
                }
                Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show();
            }
        });

        btnCapnhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String malop = edtMalop.getText().toString();
                String tenlop = edtTenlop.getText().toString();
                int siso = Integer.parseInt(edtSiso.getText().toString());
                ContentValues myvalue = new ContentValues();
                myvalue.put("siso",siso);
                myvalue.put("tenlop",tenlop);
                int n = mydatabase.update("SinhVien",myvalue,"malop = ?",new String[]{malop});
                String msg="";
                if(n == 0){
                    msg = "Không bản ghi nào được cập nhật!";
                }
                else {
                    msg = n+" bản ghi được cập nhật!";
                }
                Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show();

            }
        });

        btnInDs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mylist.clear();
                Cursor c = mydatabase.query("SinhVien",null,null,null,null,null,null);
                c.moveToFirst();
                String data = "";
                while (c.isAfterLast() == false){
                    data = c.getString(0)+" - "+c.getString(1)+" - " + c.getString(2);
                    c.moveToNext();
                    mylist.add(data);
                }
                c.close();
                myadapter.notifyDataSetChanged();

            }
        });
        return view;
    }
}