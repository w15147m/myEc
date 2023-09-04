package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class AdminCategary extends AppCompatActivity {
    ImageView bages, watches, laptops, mobiles, cctv, shoess, sweather, tshirts, sport;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_categary);

        bages = findViewById(R.id.bages);
        watches = findViewById(R.id.watches);
        mobiles = findViewById(R.id.mobiles);
        laptops = findViewById(R.id.laptops);
        cctv = findViewById(R.id.cctv);
        shoess = findViewById(R.id.shoess);
        sweather = findViewById(R.id.sweather);
        tshirts = findViewById(R.id.tshirts);
        sport = findViewById(R.id.sport);


        bages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminCategary.this, Adminhomepage.class);
                intent.putExtra("categary", "bages");
                startActivity(intent);
            }
        });
        watches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminCategary.this, Adminhomepage.class);
                intent.putExtra("categary", "watches");
                startActivity(intent);
            }
        });
        mobiles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminCategary.this, Adminhomepage.class);
                intent.putExtra("categary", "mobiles");
                startActivity(intent);
            }
        });
        laptops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminCategary.this, Adminhomepage.class);
                intent.putExtra("categary", "laptops");
                startActivity(intent);
            }
        });
        cctv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminCategary.this, Adminhomepage.class);
                intent.putExtra("categary", "cctv");
                startActivity(intent);
            }
        });
        shoess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminCategary.this, Adminhomepage.class);
                intent.putExtra("categary", "shoess");
                startActivity(intent);
            }
        });
        sweather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminCategary.this, Adminhomepage.class);
                intent.putExtra("categary", "sweather");
                startActivity(intent);
            }
        });
        tshirts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminCategary.this, Adminhomepage.class);
                intent.putExtra("categary", "tshirts");
                startActivity(intent);
            }
        });
        sport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminCategary.this, Adminhomepage.class);
                intent.putExtra("categary", "sport");
                startActivity(intent);
            }
        });



    }
}