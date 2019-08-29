package com.example.istiqomahnw.astgafirullah;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.messaging.FirebaseMessaging;
import com.example.istiqomahnw.astgafirullah.Adapter.DateAdapter;
import com.example.istiqomahnw.astgafirullah.Model.Date;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.example.istiqomahnw.astgafirullah.R;
import java.util.ArrayList;

/**
 * Created by ISTIQOMAH NW on 01/07/2019.
 */

public class History extends AppCompatActivity {

    DatabaseReference reference;
    RecyclerView recyclerView;
    ArrayList<Date> list;
    DateAdapter adapter;
    private Button btn_delete;
    //TextView display_time;
    //Button set_time;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.history);

        //btn_delete = (Button) findViewById(R.id.button2);

        FirebaseApp.initializeApp(this);
        FirebaseMessaging.getInstance().subscribeToTopic("Notif");

        recyclerView = (RecyclerView) findViewById(R.id.myRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



        reference = FirebaseDatabase.getInstance().getReference().child("sensor");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list = new ArrayList<Date>();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    Date p = dataSnapshot1.getValue(Date.class);
                    list.add(p);
                }
                adapter = new DateAdapter(History.this, list);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(History.this, "Opsss.... Something is wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void btn_delete(View view) {
    }



}
