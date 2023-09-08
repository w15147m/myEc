package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class homeActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        drawerLayout = findViewById(R.id.DrawerLayout);
        navigationView = findViewById(R.id.navigationView);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.Close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        View headr= navigationView.getHeaderView(0);
        TextView name = headr.findViewById(R.id.username) ;
        TextView profile_image = headr.findViewById(R.id.profile_image) ;

        Losdfragment(new HomeFragment());
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {


            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.orders) {
                    Toast.makeText(homeActivity.this, "orders", Toast.LENGTH_SHORT).show();
                    Losdfragment(new HomeFragment());
                } else if (id == R.id.cart) {
                    Toast.makeText(homeActivity.this, "cart", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.profile) {
                    Toast.makeText(homeActivity.this, "profile", Toast.LENGTH_SHORT).show();

                } else if (id == R.id.category) {
                    Toast.makeText(homeActivity.this, "category", Toast.LENGTH_SHORT).show();

                } else if (id == R.id.settings) {
                    Toast.makeText(homeActivity.this, "settings", Toast.LENGTH_SHORT).show();

                } else if (id == R.id.logout) {
                    Toast.makeText(homeActivity.this, "logout", Toast.LENGTH_SHORT).show();
                }

                drawerLayout.closeDrawer(GravityCompat.START);
                return true;

            }
        });

    }

    private void Losdfragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.FrameLayout, fragment);
        ft.commit();

    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
        super.onBackPressed();

        }
    }
}