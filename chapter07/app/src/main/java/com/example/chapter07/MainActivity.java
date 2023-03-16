package com.example.chapter07;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button sure =findViewById(R.id.sure);
        TextView selectRes=findViewById(R.id.selectRes);
        TextView money=findViewById(R.id.money);
        RadioGroup RG=findViewById(R.id.RG);
        RadioButton VIP=findViewById(R.id.VIP);
        RadioButton normalUser=findViewById(R.id.normalUser);
        EditText editText=findViewById(R.id.input);

        VIP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double amount = Double.parseDouble(editText.getText().toString());
                double discount = amount * 0.8;
                money.setText(String.format("%.2f", discount));
            }
        });

        normalUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double amount = Double.parseDouble(editText.getText().toString());
                money.setText(String.format("%.2f", amount));
            }
        });

     RG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(R.id.VIP==checkedId){
                    selectRes.setText(VIP.getText()+"顾客");
                }else if(R.id.normalUser==checkedId){
                    selectRes.setText(normalUser.getText()+"顾客");
                }
            }
        });
    }
}