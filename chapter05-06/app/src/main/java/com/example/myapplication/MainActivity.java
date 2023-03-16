package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button cancle;
    Button sure;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cancle=findViewById(R.id.cancel);
        sure=findViewById(R.id.sure);
        cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancle.setVisibility(View.INVISIBLE);
                sure.setVisibility(View.VISIBLE);
            }
        });
        sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancle.setVisibility(View.VISIBLE);
                sure.setVisibility(View.INVISIBLE);
            }
        });

    }
    public void GoActivityJava(View v){
        // Intent 去设置要跳转的页面
        Intent intent = new Intent(this,Activity_JAVA.class);
        // 进行跳转
        startActivity(intent);
    }
    public void GoActivityRelative(View v){
        Intent intent=new Intent(this,Activity_Relative.class);
        startActivity(intent);
    }
    public void GoActivityTable(View v){
        Intent intent=new Intent(this,Activity_Table.class);
        startActivity(intent);
    }
}