package com.example.jobbox;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.app.TaskStackBuilder;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationMenu;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=(Button)findViewById(R.id.btnn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Login frag = new Login();
                FragmentManager fm = getSupportFragmentManager();
                fm.beginTransaction().replace(R.id.mainactivity, frag).commit();

            }
        });

//        BottomNavigationView navbottom = findViewById(R.id.bottom_navigation);
//        navbottom.setSelectedItemId(R.id.nav_Housing);
//
//        navbottom.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//                switch (menuItem.getItemId()){
//                    case R.id.nav_Housing: startActivity(new Intent(getApplicationContext(), House.class));
//                        overridePendingTransition(0,0);
//                        return true;
//                    case R.id.nav_bs: startActivity(new Intent(getApplicationContext(), BuySell.class));
//                        overridePendingTransition(0,0);
//                        return true;
//                    case R.id.nav_Vehicles: startActivity(new Intent(getApplicationContext(), Vehicle.class));
//                        overridePendingTransition(0,0);
//                        return true;
//                }
//                return false;
//            }
//        });
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

//    public void login(View v){
//        startActivity(new Intent(MainActivity.this, Post.class));
//        finish();
//    }
}
