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

public class ChildLogin extends AppCompatActivity {
    Button back,signin;
    EditText name,pass;
    FirebaseAuth mAuth;
    FirebaseUser mUser;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mAuth=FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_login);
        back=findViewById(R.id.btnBack2);
        signin=findViewById(R.id.btnSignin2);
        name=findViewById(R.id.etName2);
        pass=findViewById(R.id.etPass2);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intsen = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intsen);
            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String naam=name.getText().toString();
                String password=pass.getText().toString();


                if(TextUtils.isEmpty(naam)|| TextUtils.isEmpty(password))
                {
                    Toast.makeText(ChildLogin.this, "Please enter in all the fields", Toast.LENGTH_SHORT).show();
                }

                mAuth.signInWithEmailAndPassword(naam, password)
                        .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(ChildLogin.this, "Logging you in", Toast.LENGTH_SHORT).show();
                                    Intent childdas= new Intent(getApplicationContext(),Childdashboard.class);
                                            startActivity(childdas);
                                            finish();
                                } else {

                                    Toast.makeText(ChildLogin.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();

                                }
                            }
                        });
            }
        });
    }
}