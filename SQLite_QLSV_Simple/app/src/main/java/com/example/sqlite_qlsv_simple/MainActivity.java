package com.example.sqlite_qlsv_simple;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText edtMalop, edtTenlop, edtSiso;
    Button btnThem, btnXoa, btnCapnhat, btnInDs;

    //khai bao listview
    ListView lv;
    ArrayList<String> mylist;
    ArrayAdapter<String> myadapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtMalop = findViewById(R.id.editMaLop);
        edtTenlop = findViewById(R.id.editTenLop);
        edtSiso = findViewById(R.id.editSiSo);

        btnThem = findViewById(R.id.btnThem);
        btnXoa = findViewById(R.id.btnXoa);
        btnCapnhat = findViewById(R.id.btnCapNhat);
        btnInDs = findViewById(R.id.btnIn);

        //tao ListView
        lv = findViewById(R.id.lv);
        mylist = new ArrayList<>();
        myadapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,mylist);
        lv.setAdapter(myadapter);

        //tao database
        SQLiteDatabase mydatabase = openOrCreateDatabase("qlsinhvien.db",MODE_PRIVATE,null);

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
                Toast.makeText(MainActivity.this,msg,Toast.LENGTH_SHORT).show();
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
                Toast.makeText(MainActivity.this,msg,Toast.LENGTH_SHORT).show();
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
                Toast.makeText(MainActivity.this,msg,Toast.LENGTH_SHORT).show();

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

    }
}