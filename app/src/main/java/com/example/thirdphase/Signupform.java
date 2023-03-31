package com.example.thirdphase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Signupform extends AppCompatActivity {
    Button reg;
    EditText inputmail,inputpass,inputconf;
    FirebaseAuth mAuth;
    FirebaseUser mUser;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signupform);
        reg=findViewById(R.id.btnRegfin);
        inputmail=findViewById(R.id.etmailreg);
        inputpass=findViewById(R.id.etpassreg);
        inputconf=findViewById(R.id.etconfpass) ;


        mAuth= FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail,pass,conf;
                mail=inputmail.getText().toString();
                pass=inputpass.getText().toString();
                conf=inputconf.getText().toString();

                if(mail.isEmpty() || pass.isEmpty()|| conf.isEmpty() )
                {
                    Toast.makeText(Signupform.this, "Enter all the fields", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!pass.equals(conf))
                {
                    Toast.makeText(Signupform.this, "Passwords are not matching", Toast.LENGTH_SHORT).show();
                    return;
                }

                mAuth.createUserWithEmailAndPassword(mail,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful())
                    {
                        Toast.makeText(Signupform.this, "Registration complete", Toast.LENGTH_SHORT).show();
                        finish();

                    }else{
                        Toast.makeText(Signupform.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                    }
                    }
                });
            }
        });
    }

}