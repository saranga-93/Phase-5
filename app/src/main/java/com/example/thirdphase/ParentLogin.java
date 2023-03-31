package com.example.thirdphase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ParentLogin extends AppCompatActivity {

        Button signin, signup, back;
        EditText name,pass;
        FirebaseAuth mAuth;
        FirebaseUser mUser;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mAuth=FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_login);
        name=findViewById(R.id.etName);
        pass=findViewById(R.id.etPass);
        signin=findViewById(R.id.btnSignin);
        signup=findViewById(R.id.btnSignup);
        back=findViewById(R.id.btnBack);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intse = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intse);
            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String naam,password;
                        naam=name.getText().toString();
                        password=pass.getText().toString();

                if(naam.isEmpty()|| password.isEmpty())
                {
                    Toast.makeText(ParentLogin.this, "All fields should be filled", Toast.LENGTH_SHORT).show();
                }

                mAuth.signInWithEmailAndPassword(naam, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(ParentLogin.this, "Logging In", Toast.LENGTH_SHORT).show();
                                    Intent inside = new Intent(getApplicationContext(),parentdashboard.class);
                                    startActivity(inside);
                                    finish();

                                } else {

                                    Toast.makeText(ParentLogin.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();

                                }
                            }
                        });

            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regis = new Intent(getApplicationContext(),Signupform.class);
                startActivity(regis);


            }
        });


    }
}