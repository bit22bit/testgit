package com.example.jobbox;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class AddPost extends AppCompatActivity {

    EditText addhead, addloc, addsal, addlang, addexp;
    Button add;

    private FirebaseFirestore mfire;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_post);

        mfire = FirebaseFirestore.getInstance();

        addhead =(EditText) findViewById(R.id.addhead);
        addloc =(EditText) findViewById(R.id.addloc);
        addsal =(EditText) findViewById(R.id.addsal);
        addlang =(EditText) findViewById(R.id.addlang);
        addexp =(EditText) findViewById(R.id.addexp);
        add =(Button) findViewById(R.id.Add);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String head = addhead.getText().toString().trim();
                String loc = addloc.getText().toString().trim();
                String sal = addsal.getText().toString().trim();
                String lang = addlang.getText().toString().trim();
                String exp = addexp.getText().toString().trim();

                if (TextUtils.isEmpty(head)) {
                    Toast.makeText(getApplicationContext(), "Enter", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(loc)) {
                    Toast.makeText(getApplicationContext(), "Enter !", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(sal)) {
                    Toast.makeText(getApplicationContext(), "Enter !", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(lang)) {
                    Toast.makeText(getApplicationContext(), "Enter !", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(exp)) {
                    Toast.makeText(getApplicationContext(), "Enter !", Toast.LENGTH_SHORT).show();
                    return;
                }

                Map<String,String> userMap = new HashMap<>();

                userMap.put("headline",head);
                userMap.put("Location",loc);
                userMap.put("Salary",sal);
                userMap.put("Language",lang);
                userMap.put("Experience",exp);

                mfire.collection("jobpost").add(userMap).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(AddPost.this, "submitted", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setSelectedItemId(R.id.nav_Add);

        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.nav_Add: return true;
                    case R.id.nav_Post:startActivity(new Intent(getApplicationContext(), Post.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

    }
}