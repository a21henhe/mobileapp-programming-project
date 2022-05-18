package com.example.project;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerviewAdapter adapter;
    ArrayList<Tree> listOfTrees;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.recyclerView);
        listOfTrees = new ArrayList<>(Arrays.asList(
                new Tree(1, "ek", 40),
                new Tree(2, "björk", 30),
                new Tree(3, "asp", 25)
        ));


        adapter = new RecyclerviewAdapter(this, listOfTrees, new RecyclerviewAdapter.OnClickListener() {
            @Override
            public void onClick(Tree tree) {
                Toast.makeText(MainActivity.this, tree.getName(), Toast.LENGTH_SHORT).show();
            }
        });



        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

}
