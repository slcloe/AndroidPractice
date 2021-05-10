package com.example.androidpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SubActivity extends AppCompatActivity {

    private TextView username;
    private ListView list;
    Button next_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        next_btn = (Button)findViewById(R.id.next_btn);
        list = (ListView)findViewById(R.id.list);
        username = findViewById(R.id.username);

        Intent intent = getIntent();
        String name = intent.getStringExtra("username");
        username.setText(name);

        List<String> data = new ArrayList<>();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,data);
        list.setAdapter(adapter);

        data.add("paka");
        data.add("android");
        data.add("settings");
        adapter.notifyDataSetChanged();

        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SubActivity.this, NavigationActivity.class);
                intent.putExtra("name", name);
                startActivity(intent);
            }
        });

    }
}