package com.example.myapplication;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

public class Activity_JAVA extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java);

        TextView title =findViewById(R.id.title);
        title.setText(R.string.title);
        title.setTextSize(30);

        TextView names=findViewById(R.id.names);
        names.setText(R.string.names);
        names.setTextSize(24);

        TextView gender=findViewById(R.id.gender);
        gender.setText(R.string.gender);
        gender.setTextSize(24);

        TextView age=findViewById(R.id.age);
        age.setText(R.string.age);
        age.setTextSize(24);

        TextView sno=findViewById(R.id.sno);
        sno.setText(R.string.gender);
        sno.setTextSize(24);

        Button jump=findViewById(R.id.jump);
        jump.setText(R.string.jump);
        jump.setTextSize(20);

    }



    public void GoActivityXML(View v){
        // Intent 去设置要跳转的页面
        Intent intent = new Intent(this,MainActivity.class);
        // 进行跳转
        startActivity(intent);
    }
}
