package com.example.jobbox;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jobbox.models.Postlist;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class Post extends AppCompatActivity {

    TextView resultTv;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        resultTv = findViewById(R.id.postView);
        db=FirebaseFirestore.getInstance();

        db.collection("jobpost")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()){
                            String resultt="";

                            for(DocumentSnapshot document : task.getResult()){
                                Postlist postlist = document.toObject(Postlist.class);
                                resultt+=
                                        "headline: "+ postlist.getheadline()+
                                        "\nLocation: "+ postlist.getLocation()+
                                        "\nSalary: "+postlist.getSalary()+
                                        "\nLanguage: "+ postlist.getLanguage()+
                                        "\nExperience: "+postlist.getExperience()+"\n\n";

                            }

                            resultTv.setText(resultt);
                        }
                    }

                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(), "Error..."+e.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });

//==============================================================================================================
//        listView = findViewById(R.id.userListView);
//        post = generateUsers();
//        PostCustomAdapter adapter = new PostCustomAdapter(post);
//        listView.setAdapter(adapter);

//==============================================================================================================
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setSelectedItemId(R.id.nav_Post);

        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.nav_Add:startActivity(new Intent(getApplicationContext(), AddPost.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_Post: return true;
                }
                return false;
            }
        });
//================================================================================================================
    }
}
