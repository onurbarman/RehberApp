package com.rehberapp.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rehberapp.R;
import com.rehberapp.model.Kullanici;

public class LoginActivity extends AppCompatActivity {

     DatabaseReference user;


     EditText txtUsername;
     EditText txtPassword;
     Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user=FirebaseDatabase.getInstance().getReference("Tables").child("Kullanici");

        txtUsername=(EditText)findViewById(R.id.txtUsername);
        txtPassword=(EditText)findViewById(R.id.txtPassword);
        btnLogin=(Button)findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                 doLogin(txtUsername.getText().toString(),txtPassword.getText().toString());
              }
        });
    }

    private void doLogin(final String username, final String password) {

        user.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds:dataSnapshot.getChildren())
                {
                    if (dataSnapshot.child(username).exists())
                    {
                        if (!username.isEmpty())
                        {
                            Kullanici kullanici=dataSnapshot.child(username).getValue(Kullanici.class);

                            if(kullanici.getPassword().equals(password))
                            {
                                Toast.makeText(LoginActivity.this,"Başarılı",Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(LoginActivity.this,RehberActivity.class);
                                intent.putExtra("userId",kullanici.getId());
                                startActivity(intent);
                            }
                        }
                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }}
        );
    }
}
