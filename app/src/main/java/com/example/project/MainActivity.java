package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener {

    RecyclerView recyclerView;
    RecyclerviewAdapter adapter;
    ArrayList<Tree> listOfTrees;
    String jsonData;
    Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.recyclerView);
        listOfTrees = new ArrayList<>();
        gson = new Gson();

        adapter = new RecyclerviewAdapter(this, listOfTrees, new RecyclerviewAdapter.OnClickListener() {
            @Override
            public void onClick(Tree tree) {
               // Toast.makeText(MainActivity.this, tree.getName(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, TreeDetailsActivity.class);
                intent.putExtra("json", gson.toJson(tree));
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        String JSON_URL = "https://mobprog.webug.se/json-api?login=a21henhe";
        new JsonTask(this).execute(JSON_URL);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onPostExecute(String json) {
        Log.d("", "testing: " + json);
        jsonData = json;
        Gson gson = new Gson();

        Type type = new TypeToken<List<Tree>>() {}.getType();
        List<Tree> trees = gson.fromJson(json,type);

        listOfTrees.addAll(trees);
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.main_page) {
            return true;
        }

        if (id == R.id.about_us) {
            Intent intent = new Intent(this, AboutUsActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
