package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class singup extends AppCompatActivity {
    EditText email, password, cpassword;
    Button singup;
    TextView textView;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);
        email = findViewById(R.id.singinemail);
        mAuth = FirebaseAuth.getInstance();
        password = findViewById(R.id.singinpassword);
        cpassword = findViewById(R.id.singinconpassword);
        singup = findViewById(R.id.btnsignup);
        textView = findViewById(R.id.logipnow);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "singup to page", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(singup.this,login.class);
                startActivity(intent);
            }
        });
        singup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CreateAccoUnt();
            }
        });


    }


    private void CreateAccoUnt() {
//        email = findViewById( R.id.singinemail);
//        password = findViewById( R.id.singinpassword);
//        cpassword = findViewById( R.id.singinconpassword);
        String Email = email.getText().toString();
        String Password = password.getText().toString();
        String Cpassword = cpassword.getText().toString();

        if (TextUtils.isEmpty(Email)) {

            Toast.makeText(this, "please enter your email ", Toast.LENGTH_SHORT).show();

        } else if (TextUtils.isEmpty(Password)) {

            Toast.makeText(this, "please enter your password ", Toast.LENGTH_SHORT).show();

        } else if (TextUtils.isEmpty(Cpassword)) {

            Toast.makeText(this, "please Confirm your password ", Toast.LENGTH_SHORT).show();
        } else if (!Password.equals(Cpassword)) {

            Toast.makeText(this, "Not confirm ", Toast.LENGTH_SHORT).show();
        } else {

            mAuth.createUserWithEmailAndPassword(Email, Password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(singup.this, "Account Created",
                                        Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(singup.this,login.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(singup.this, "Account Creation failed.",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    });


        }
    }
}