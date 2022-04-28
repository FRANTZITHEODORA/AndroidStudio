package com.example.myandroidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MoovieActictity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moovie_actictity);

        TextView tvMoovie = findViewById(R.id.tvMoovie);
        String textMoovie = getIntent().getExtras().getString("movie");
        SharedPreferences preferences = getSharedPreferences("NOTES", MODE_PRIVATE);
        String strnotes = preferences.getString("notes", "");

        tvMoovie.setText(textMoovie);

        TextView tvNotes = findViewById(R.id.tvnotes);
        String textNotes = getIntent().getExtras().getString("notes");

        tvMoovie.setText(textNotes);

        TextView tvdate = findViewById(R.id.tvdate);
        String textDate = getIntent().getExtras().getString("date");

        tvMoovie.setText(textDate);

        TextView tvCategory = findViewById(R.id.tvcategory);
        String textCategory = getIntent().getExtras().getString("category");

        tvMoovie.setText(textCategory);

        ListView listView = findViewById(R.id.listnotes);
        String[] notes = {textMoovie, textNotes, textDate, textCategory};


        ArrayAdapter<String> adapter = new ArrayAdapter<>(MoovieActictity.this, R.layout.list_item, notes);
        listView.setAdapter(adapter);
    }
}