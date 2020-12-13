package com.example.jobbox;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.TaskStackBuilder;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationMenu;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navbottom = findViewById(R.id.bottom_navigation);
        navbottom.setSelectedItemId(R.id.nav_posts);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater =  getMenuInflater();
        inflater.inflate(R.menu.upper_nav, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_login:
                startActivity(new Intent(MainActivity.this, Login.class));
                return true;
            case R.id.nav_setting:
                Toast.makeText(this, "settings is selected", Toast.LENGTH_LONG).show();
                return true;
            default:return super.onOptionsItemSelected(item);
        }
    }

    public void login(View v){
        startActivity(new Intent(MainActivity.this, Post.class));
        finish();
    }
}
