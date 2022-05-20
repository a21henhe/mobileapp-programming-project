package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class TreeDetailsActivity extends AppCompatActivity {

    Intent intent;
    TextView textView;
    String json;
    Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tree_details);

        textView = findViewById(R.id.textView);
        intent = getIntent();
        Log.d("",intent.getStringExtra("json"));
        json = intent.getStringExtra("json");
        gson = new Gson();

        Type type = new TypeToken<Tree>() {}.getType();
        Tree tree = gson.fromJson(json, type);


        textView.setText(tree.getName());
    }



}