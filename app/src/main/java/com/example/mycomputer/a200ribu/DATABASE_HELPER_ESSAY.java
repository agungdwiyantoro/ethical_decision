package com.example.mycomputer.a200ribu;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DATABASE_HELPER_ESSAY extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "DB_DATA_ESSAY";

    Context context;
    DATABASE_HELPER_ESSAY(Context context){
        super(context, DATABASE_NAME,null, DATABASE_VERSION);
        System.out.println("SQL CONSTRUCTOR");
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        System.out.println("SQL CREATE");
        sqLiteDatabase.execSQL(DATABASE_MODEL_ESSAY.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int inewVersion) {
        System.out.println("SQL UPGRADE");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DATABASE_MODEL_ESSAY.TABLE_NAME_ESSAY);
        onCreate(sqLiteDatabase);
    }

    public void insertData(int id, String data, int index)
    {


        SQLiteDatabase db = this.getWritableDatabase();
        //db.execSQL(DATABASE_MODEL_ESSAY.CREATE_TABLE);
        ContentValues values = new ContentValues();
        values.put(DATABASE_MODEL_ESSAY.COLUMN_ID, id);
        values.put(DATABASE_MODEL_ESSAY.COLUMN_DATA, data);
        values.put(DATABASE_MODEL_ESSAY.COLUMN_INDEX, index);


        db.insert(DATABASE_MODEL_ESSAY.TABLE_NAME_ESSAY, null, values);
        db.close();

       // return insert_to_table;
    }

    public Cursor getData(int column_id, int column_index)
    {
        SQLiteDatabase db = this.getReadableDatabase();
     //   DATABASE_MODEL data = null;
        Cursor cursor = db.query(DATABASE_MODEL_ESSAY.TABLE_NAME_ESSAY,
                new String[]{DATABASE_MODEL_ESSAY.COLUMN_ID, DATABASE_MODEL_ESSAY.COLUMN_DATA, DATABASE_MODEL_ESSAY.COLUMN_INDEX},
                DATABASE_MODEL_ESSAY.COLUMN_ID + "=?" +  " and " + DATABASE_MODEL_ESSAY.COLUMN_INDEX + "=?",
                new String[]{String.valueOf(column_id), String.valueOf(column_index)}, null, null, null, null);

        if(cursor!=null) {
            cursor.moveToFirst();
            System.out.println("cursor penis");
           // cursor.close();
/*
            data = new DATABASE_MODEL(
                    cursor.getInt(cursor.getColumnIndex(DATABASE_MODEL.COLUMN_ID)),
                    cursor.getInt(cursor.getColumnIndex(DATABASE_MODEL.COLUMN_DATA)),
                    cursor.getInt(cursor.getColumnIndex(DATABASE_MODEL.COLUMN_INDEX)));
*/

        }
        else
        {
            System.out.println("DATA PADA TABEL KOSONG");
        }

       // cursor.close();
        return cursor;

    }

    public int getDataCount()
    {
        String countQuery = "SELECT * FROM " + DATABASE_MODEL_ESSAY.TABLE_NAME_ESSAY;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }


    public void updateData(int id, String data, int index)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues  values = new ContentValues();
        values.put(DATABASE_MODEL_ESSAY.COLUMN_DATA, data);
        values.put(DATABASE_MODEL_ESSAY.COLUMN_DATA, index);
        db.update(DATABASE_MODEL_ESSAY.TABLE_NAME_ESSAY, values,
                DATABASE_MODEL_ESSAY.COLUMN_ID + "=?",
                new String[]{String.valueOf(getData(id,index).getString(0))});
    }




    public void deleteData(int database_model)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(DATABASE_MODEL_ESSAY.TABLE_NAME_ESSAY, DATABASE_MODEL_ESSAY.COLUMN_ID + "=?",
                new String[]{String.valueOf(database_model)});
        db.close();
    }


    public void delete_all()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + DATABASE_MODEL_ESSAY.TABLE_NAME_ESSAY);
        db.close();
    }



}
