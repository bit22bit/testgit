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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Signup extends AppCompatActivity {
    private FirebaseAuth myAuth;
    private Button joinus;
    private TextView inputemail,inputpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        inputemail=(EditText)findViewById(R.id.email);
        inputpassword=(EditText)findViewById(R.id.pass);
        joinus=(Button)findViewById(R.id.join);
        myAuth=FirebaseAuth.getInstance();

        joinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        joinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = inputemail.getText().toString().trim();
                String password = inputpassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }

                myAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(Signup.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Toast.makeText(Signup.this, "createUserWithEmail:onComplete:" + task.isSuccessful(), Toast.LENGTH_SHORT).show();
                                if (!task.isSuccessful()) {
                                    Toast.makeText(Signup.this, "Authentication failed." + task.getException(),
                                            Toast.LENGTH_SHORT).show();
                                } else {
                                    startActivity(new Intent(Signup.this, MainActivity.class));
                                    finish();
                                }
                            }
                        });
            }
        });

//        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
//
//        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//                switch (menuItem.getItemId()){
//                    case R.id.nav_home:startActivity(new Intent(getApplicationContext(), MainActivity.class));
//                        overridePendingTransition(0,0);
//                        return true;
//                    case R.id.nav_posts:startActivity(new Intent(getApplicationContext(), Post.class));
//                        overridePendingTransition(0,0);
//                        return true;
//                    case R.id.nav_save:startActivity(new Intent(getApplicationContext(), Save.class));
//                        overridePendingTransition(0,0);
//                        return true;
//                }
//                return false;
//            }
//        });
    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}
