package com.example.myandroidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etmoovie = findViewById(R.id.etMovieName);

        EditText etnotes = findViewById(R.id.etNotes);
        EditText etdate = findViewById(R.id.etDate);
        EditText etcategory = findViewById(R.id.etCategory);

        Button buttonsave = findViewById(R.id.button3);
        DataSource dataSource = new DataSource(MainActivity.this);
//        ArrayList<MoovieActictity> moovieActictities = dataSource.getAllNotes();
        SharedPreferences preferences = getSharedPreferences("NOTES", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();



        buttonsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MoovieActictity.class);
                String txtmoovie = etmoovie.getText().toString();
                intent.putExtra("movie", txtmoovie);
                String txtnotes = etnotes.getText().toString();
                intent.putExtra("notes", txtnotes);
                String txtdate = etdate.getText().toString();
                intent.putExtra("date", txtdate);
                String txtcategory = etcategory.getText().toString();
                intent.putExtra("category", txtcategory);

                SharedPreferences preferences = getSharedPreferences("NOTES", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("mynotes", etnotes.getText().toString());

                editor.commit();

                startActivity(intent);





            }
        });




    }
}