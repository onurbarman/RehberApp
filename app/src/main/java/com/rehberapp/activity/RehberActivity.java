package com.rehberapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rehberapp.R;
import com.rehberapp.adapter.RehberAdapter;
import com.rehberapp.model.Rehber;

import java.util.ArrayList;
import java.util.List;

public class RehberActivity extends AppCompatActivity implements RehberAdapter.OnItemClickListener {

    String userId="";
    Rehber rehberCls;
    RehberAdapter adapter;
    List<Rehber> rehberList=new ArrayList<>();
    DatabaseReference rehberData= FirebaseDatabase.getInstance().getReference("Tables").child("Rehber");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rehber);
        userId=String.valueOf(getIntent().getIntExtra("userId",1));
        rehberData= FirebaseDatabase.getInstance().getReference("Tables").child("Rehber");

        doGetRehber();

    }

    private void doGetRehber() {
       rehberCls=new Rehber();
        rehberData.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                rehberList.clear();
                for(DataSnapshot ds : dataSnapshot.getChildren())
                {
                    if (dataSnapshot.child(userId).exists())
                    {
                        rehberCls=dataSnapshot.child(userId).getValue(Rehber.class);
                        //rehberList.add(rehberCls);
                    }

                }
                generateUserList(rehberList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

    void generateUserList(List<Rehber> empDataList)
    {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        RehberAdapter adapter = new RehberAdapter(empDataList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(RehberActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(RehberActivity.this);
    }

    @Override
    public void onItemClick(int position) {
        Intent intent=new Intent(RehberActivity.this,IcerikActivity.class);
        intent.putExtra("adsoyad",rehberList.get(position).getAdsoyad());
        intent.putExtra("telefon",String.valueOf(rehberList.get(position).getTelefon()));
        startActivity(intent);
        //Toast.makeText(RehberActivity.this,rehberList.get(position).getAdsoyad()+" :"+
                //rehberList.get(position).getTelefon(),Toast.LENGTH_SHORT).show();
    }
}

