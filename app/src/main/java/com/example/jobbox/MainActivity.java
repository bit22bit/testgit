package com.example.jobbox;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jobbox.models.Postlist;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {

    EditText headline,location,salary,language,experience;
    Button submit;

    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setSelectedItemId(R.id.nav_home);

        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.nav_home: return true;
                    case R.id.nav_posts: startActivity(new Intent(getApplicationContext(), Post.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_save: startActivity(new Intent(getApplicationContext(), Save.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

        headline=findViewById(R.id.headline);
        location=findViewById(R.id.location);
        salary=findViewById(R.id.salary);
        language=findViewById(R.id.language);
        experience=findViewById(R.id.exp);
        submit=findViewById(R.id.submit);

        db = FirebaseFirestore.getInstance();

        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String head = headline.getText().toString();
                String loc = location.getText().toString();
                String sal = salary.getText().toString();
                String lang = language.getText().toString();
                String exp = experience.getText().toString();
                addData(head,loc,sal,lang,exp);
            }
        });
    }

    public void addData(String headline, String location, String salary, String language, String experience){
        Postlist list = new Postlist(headline,location,salary,language,experience);
        db.collection("jobpost")
                .add(list)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(getApplicationContext(), "Post Recorded Successfully!", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(), "Something went wrong"+e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

    }
}
