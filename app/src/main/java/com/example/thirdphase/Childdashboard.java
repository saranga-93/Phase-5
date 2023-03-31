package com.example.thirdphase;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Childdashboard extends AppCompatActivity {
    Button inputplus,inputminus,inputmulti,inputdivide ;
    EditText inputfrst,inputsecond;
    TextView ansh;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_childdashboard);
        inputfrst=findViewById(R.id.etFirst);
        inputsecond=findViewById(R.id.etSecond);
        inputplus=findViewById(R.id.btnPlus);
        inputminus=findViewById(R.id.btnMinus);
        inputmulti=findViewById(R.id.btnMulti);
        inputdivide=findViewById(R.id.btnDivide);
        ansh=findViewById(R.id.tvANs);

        inputplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int first, second, ans;
                first=Integer.parseInt(inputfrst.getText().toString());
                second=Integer.parseInt(inputsecond.getText().toString());
                ans=first+second;
                ansh.setText(""+ans);


            }
        });

        inputminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int first, second, ans;
                first=Integer.parseInt(inputfrst.getText().toString());
                second=Integer.parseInt(inputsecond.getText().toString());
                ans=first-second;
                ansh.setText(""+ans);


            }
        });

        inputmulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int first, second, ans;
                first=Integer.parseInt(inputfrst.getText().toString());
                second=Integer.parseInt(inputsecond.getText().toString());
                ans=first*second;
                ansh.setText(""+ans);


            }
        });

        inputdivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int first, second, ans;
                first=Integer.parseInt(inputfrst.getText().toString());
                second=Integer.parseInt(inputsecond.getText().toString());
                ans=first/second;
                ansh.setText(""+ans);


            }
        });




    }

}