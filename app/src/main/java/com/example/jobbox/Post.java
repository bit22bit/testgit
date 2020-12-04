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

import com.example.jobbox.adapter.PostCustomAdapter;
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

    ListView listView;
    ArrayList<Postlist> post;
    TextView resultTv;
    Button retrieve;
    FirebaseFirestore db;

//    public ArrayList<Postlist> generateUsers() {
//        ArrayList<Postlist> post = new ArrayList<>();
//        post.add(new Postlist("","","","",""));
//        return post;
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        resultTv = findViewById(R.id.postView);
        retrieve = findViewById(R.id.addbtn);
        db=FirebaseFirestore.getInstance();

        retrieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getData();
            }
        });

//==============================================================================================================
//        listView = findViewById(R.id.userListView);
//        post = generateUsers();
//        PostCustomAdapter adapter = new PostCustomAdapter(post);
//        listView.setAdapter(adapter);

//==============================================================================================================
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setSelectedItemId(R.id.nav_posts);

        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.nav_home:startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_posts: return true;
                    case R.id.nav_save: startActivity(new Intent(getApplicationContext(), Save.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
//================================================================================================================
    }

    public void getData(){
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
                                        "Headline: "+ postlist.getheadline()+
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
    }
}
