package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn1=findViewById(R.id.btn1);
        Button btn2=findViewById(R.id.btn2);
        EditText input=findViewById(R.id.myWish);


        RadioGroup RG=findViewById(R.id.radio);
        RadioButton classical=findViewById(R.id.classcial);
        RadioButton noval=findViewById(R.id.noval);
        RadioButton essays=findViewById(R.id.essays);
        TextView selectRes=findViewById(R.id.selectRes);

       RG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(RadioGroup group, int checkedId) {
               if(R.id.classcial==checkedId){
                   selectRes.setText("您感兴趣的图书是："+classical.getText().toString());
                   setTitle(String.valueOf(classical.getText()));
               }else if(R.id.noval==checkedId){
                   selectRes.setText("您感兴趣的图书是："+noval.getText().toString());
                   setTitle(String.valueOf(noval.getText()));
               }else if(R.id.essays==checkedId){
                   selectRes.setText("您感兴趣的图书是："+essays.getText().toString());
                   setTitle(String.valueOf(essays.getText()));
               }
           }
       });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String wish=input.getText().toString();
                Toast.makeText(getApplicationContext(),"您的愿望是："+wish,Toast.LENGTH_LONG).show();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast=new Toast(getApplicationContext());
                ImageView img=new ImageView(getApplicationContext());
                img.setImageResource(R.drawable.img);
                toast.setView(img);
                toast.setGravity(Gravity.CENTER_HORIZONTAL,0,100);
                toast.show();
            }
        });
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,R.layout.list_item,getResources().getStringArray(R.array.school_values));
        AutoCompleteTextView autoCompleteTextView=findViewById(R.id.autoComplete);
        autoCompleteTextView.setAdapter(adapter);

    }
}