package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {
    EditText email, password;
    Button login;
    TextView textView;
    FirebaseAuth mAuth;
    RadioButton user, admin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        email = findViewById(R.id.Email);
        password = findViewById(R.id.password);
        login = findViewById(R.id.btnlogin);
        textView = findViewById(R.id.Signup);
        user = findViewById(R.id.user);
        admin = findViewById(R.id.admin);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this, singup.class);
                startActivity(intent);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email = email.getText().toString();
                String Password = password.getText().toString();
//                if (TextUtils.isEmpty(Email)) {
//
//                    Toast.makeText(login.this, "please enter your email", Toast.LENGTH_SHORT).show();
//
//                } else if (TextUtils.isEmpty(Password)) {
//
//
//                    Toast.makeText(login.this, "please enter your password", Toast.LENGTH_SHORT).show();
//
//                } else {

                    if (admin.isChecked()) {
//                        mAuth.signInWithEmailAndPassword(Email, Password)
//                                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                                    @Override
//                                    public void onComplete(@NonNull Task<AuthResult> task) {
//                                        if (task.isSuccessful()) {
//
//                                            Intent intent = new Intent(login.this,AdminCategary.class);
//                                            startActivity(intent);
//
//                                        } else {
//                                            Toast.makeText(login.this, "please enter your password",
//                                                    Toast.LENGTH_SHORT).show();
//
//                                        }
//                                    }
//                                });
                        Intent intent = new Intent(login.this,AdminCategary.class);
                                            startActivity(intent);
                    } else if (user.isChecked()) {

//                        mAuth.signInWithEmailAndPassword(Email, Password)
//                                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                                    @Override
//                                    public void onComplete(@NonNull Task<AuthResult> task) {
//                                        if (task.isSuccessful()) {
//
//                                            Intent intent = new Intent(login.this, homeActivity.class);
//                                            startActivity(intent);
//
//                                        } else {
//                                            Toast.makeText(login.this, "please enter your password",
//                                                    Toast.LENGTH_SHORT).show();
//
//                                        }
//                                    }
//                                });

                        Intent intent = new Intent(login.this, homeActivity.class);
                                            startActivity(intent); }
//                    else {

//                        Toast.makeText(login.this, "please Check the box", Toast.LENGTH_SHORT).show();





                    }

//                }


//            }
        });
    }
}