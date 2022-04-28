package com.example.myandroidproject;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DataSource {
    public SQLiteHelper getDbHelper() {
        return dbHelper;
    }

    public void setDbHelper(SQLiteHelper dbHelper) {
        this.dbHelper = dbHelper;
    }

    private SQLiteHelper dbHelper;
    private SQLiteDatabase database;
    private String[] allNoteColumns = {"id", "name", "mediate", "category"};

    public String[] getAllNoteColumns() {
        return allNoteColumns;
    }

    public void setAllNoteColumns(String[] allNoteColumns) {
        this.allNoteColumns = allNoteColumns;
    }



    public DataSource(Context context){
        dbHelper = new SQLiteHelper(context);
    }

    public DataSource() {

    }

    public void open(){
        database = dbHelper.getWritableDatabase();
    }

    public void close(){
        dbHelper.close();
    }


    public ArrayList<MoovieActictity> getAllNotes() {
        ArrayList<MoovieActictity> notes = new ArrayList<MoovieActictity>();

        try (Cursor cursor = database.query(
                "notes",
                new String[]{"id", "mvname", "mvnotes", "mvdate", "mvcategory"},
                null,
                null,
                null,
                null,
                null,
                null)) {
            cursor.moveToFirst();

            while (!cursor.isAfterLast()) {
                Movie movie = new Movie();
                movie.setId(cursor.getInt(0));
                movie.setName(cursor.getString((1)));

                movie.setDate(cursor.getString((3)));
                movie.setCategory(cursor.getString((4)));


            }
        }
        return notes;
    }
}



