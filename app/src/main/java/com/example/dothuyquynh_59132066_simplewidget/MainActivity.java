package com.example.dothuyquynh_59132066_simplewidget;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {


    EditText edtTen,edtNs,edtSt;
    RadioGroup checkRdo;
    CheckBox cbXp,cbNn,cbCf,cbOn,cbNa;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Gọi Phương Thức
        AddView();
        AddEvent();
    }
    private void AddView()
    {
        edtTen=findViewById(R.id.edtTen);
        edtNs=findViewById(R.id.edtNs);
        edtSt=findViewById(R.id.edtSt);
        checkRdo=findViewById(R.id.checkradio);
        cbCf=findViewById(R.id.cbCf);
        cbXp=findViewById(R.id.cbXp);
        cbNn=findViewById(R.id.cbNn);
        cbNa=findViewById(R.id.cbNa);
        cbOn=findViewById(R.id.cbOn);
        btn=findViewById(R.id.btXn);
    }
    //Click buton
    private void AddEvent()
    {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tienHanh();
            }
        });
    }
    private void tienHanh()
    {
        String KQua="";
        KQua = edtTen.getText()+"\n"+
                "Ngày Sinh: "+ edtNs.getText()+"\n";
        switch (checkRdo.getCheckedRadioButtonId())
        {
            case R.id.rdNam: KQua+="Giới Tính: "+"Nam"+"\n" +  "Sở Thích: ";break;
            case R.id.rdNu:  KQua+="Giới Tính: "+"Nữ"+"\n"+ "Sở Thích: ";  break;
        }
        // gọi hàm thực thi checkbox vào sự kiên
        KQua+=CheckBoxAction();
        Toast.makeText(MainActivity.this,KQua,Toast.LENGTH_SHORT).show();
    }
    private String CheckBoxAction()
    {
        String KQua="";
        CheckBox [] arrCb=new CheckBox[]{cbXp,cbNn,cbCf,cbOn,cbNa};
        for (int i=0;i<arrCb.length;i++)
        {
            if(arrCb[i].isChecked())
            {
                KQua+=arrCb[i].getText().toString()+"; ";
            }
        }
        // Thêm Sở thích khác.
        KQua+=edtSt.getText();
        return KQua;
    }

}

