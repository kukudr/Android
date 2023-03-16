package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button transform;
    EditText input;
    TextView show;

    EditText et;
    Button add,remove;
    Spinner sp;
    ArrayList<String> list=new ArrayList<String>();
    ArrayAdapter<String> adapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        transform = findViewById(R.id.transform);
        input = findViewById(R.id.input);
        show = findViewById(R.id.show);
        transform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String editInput = input.getText().toString();
                int number = Integer.valueOf(editInput).intValue();
                if (number <= 100) {
                    int res = number / 10;
                    switch (res) {
                        case 10:
                            show.setText("优秀！！！");
                            break;
                        case 9:
                            show.setText("优秀！");
                            break;
                        case 8:
                            show.setText("良好！");
                            break;
                        case 7:
                            show.setText("中等！");
                            break;
                        case 6:
                            show.setText("及格！");
                            break;
                        default:
                            show.setText("不及格");
                    }
                    Toast.makeText(MainActivity.this, "您的成绩是" + show.getText(), Toast.LENGTH_SHORT).show();
                } else {
                    show.setText("输入的内容不合法！！！请输入0-100之间的数字");
                    Toast.makeText(MainActivity.this, "输入的内容不合法！！！请输入0-100之间的数字", Toast.LENGTH_SHORT).show();
                }
            }
        });
//        ===============================================================
        et=(EditText)findViewById(R.id.et);
        add=(Button)findViewById(R.id.add);
        remove=(Button)findViewById(R.id.remove);
        sp=(Spinner)findViewById(R.id.sp);
        String[] ls=getResources().getStringArray(R.array.action);
        for(int i=0;i<ls.length;i++){
            list.add(ls[i]);
        }
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(adapter);
        sp.setPrompt("标题栏");

        add.setOnClickListener(new View.OnClickListener(){//添加按钮监听器
            @Override
            public void onClick(View v) {
                adapter.add(et.getText().toString());
                setTitle(String.valueOf(list.size()));
            }
        });
        remove.setOnClickListener(new View.OnClickListener() {//删除按钮监听器
            @Override
            public void onClick(View v) {
                adapter.remove(sp.getSelectedItem().toString());
                setTitle(String.valueOf(list.size()));
            }
        });

    }
}
