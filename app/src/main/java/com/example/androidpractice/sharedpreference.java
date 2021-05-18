package com.example.androidpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class sharedpreference extends AppCompatActivity {

    EditText et_name, et_password, et_age;
    String shared = "file";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharedpreference);

        et_name = (EditText)findViewById(R.id.et_name);
        et_password = (EditText)findViewById(R.id.et_password);
        et_age = (EditText)findViewById(R.id.et_age);

        SharedPreferences sharedPreferences = getSharedPreferences(shared, 0);

        String value_name = sharedPreferences.getString("name", "");
        et_name.setText(value_name);

        String value_password = sharedPreferences.getString("password","");
        et_password.setText(value_password);

        String value_age = sharedPreferences.getString("age","");
        et_age.setText(value_age);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        SharedPreferences sharedPreferences = getSharedPreferences(shared, 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        String value_age = et_age.getText().toString();
        editor.putString("age",value_age);

        String value_name = et_name.getText().toString();
        editor.putString("name", value_name);

        String value_password = et_password.getText().toString();
        editor.putString("password",value_password);

        editor.commit();

    }
}