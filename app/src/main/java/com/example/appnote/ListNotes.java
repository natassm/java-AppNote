package com.example.appnote;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;


import java.util.ArrayList;

public class ListNotes extends AppCompatActivity {

    static final int REQUEST_CODE_ADD_NOTES = 101;
    static final int RESULT_CODE_ADD_NOTES = 201;


    private RecyclerView recyclerView;
    private KontenListAdapter adapter;
    private ArrayList<Konten> kontenArrayList = new ArrayList<>();
    FloatingActionButton FB_add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_notes);

        recyclerView = findViewById(R.id.rv);

        adapter = new KontenListAdapter(kontenArrayList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ListNotes.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

//        adapter = new KontenListAdapter(this, R.layout.activity_detail_notes, kontenList);
//        listview.setAdapter(adapter);

//        Toast.makeText(getApplicationContext(), "Data Tersimpan", Toast.LENGTH_SHORT).show();


        FB_add = findViewById(R.id.FBadd);
        FB_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListNotes.this, MainActivity.class);
                startActivityForResult(intent, REQUEST_CODE_ADD_NOTES);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_ADD_NOTES && resultCode == RESULT_CODE_ADD_NOTES && data != null) {
            Konten konten = new Konten(
                    data.getStringExtra("title"),
                    data.getStringExtra("description")
            );

            kontenArrayList.add(konten);
            adapter.notifyDataSetChanged();
        }
    }
}
