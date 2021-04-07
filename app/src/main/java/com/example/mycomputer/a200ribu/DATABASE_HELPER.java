package com.example.mycomputer.a200ribu;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.SQLInput;

public class DATABASE_HELPER extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "DB_DATA";

    public DATABASE_HELPER(Context context){
        super(context, DATABASE_NAME,null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DATABASE_MODEL.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DATABASE_MODEL.TABLE_NAME  );
        onCreate(sqLiteDatabase);
    }

    public long insertData(int id, int data, int index)
    {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DATABASE_MODEL.COLUMN_ID, id);
        values.put(DATABASE_MODEL.COLUMN_DATA, data);
        values.put(DATABASE_MODEL.COLUMN_INDEX, index);

        long insert_to_table = db.insert(DATABASE_MODEL.TABLE_NAME, null, values);
        db.close();

        return insert_to_table;
    }

    public Cursor getData(long id, int column_id, int column_index)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        //DATABASE_MODEL data = null;
        Cursor cursor = db.query(DATABASE_MODEL.TABLE_NAME,
                new String[]{DATABASE_MODEL.COLUMN_ID, DATABASE_MODEL.COLUMN_DATA, DATABASE_MODEL.COLUMN_INDEX},
                DATABASE_MODEL.COLUMN_ID + "=" + column_id + " AND " + DATABASE_MODEL.COLUMN_INDEX + "=" + column_index,
                new String[]{String.valueOf(id)}, null, null, null, null);

        if(cursor!=null) {
            cursor.moveToFirst();
/*
            data = new DATABASE_MODEL(
                    cursor.getInt(cursor.getColumnIndex(DATABASE_MODEL.COLUMN_ID)),
                    cursor.getInt(cursor.getColumnIndex(DATABASE_MODEL.COLUMN_DATA)),
                    cursor.getInt(cursor.getColumnIndex(DATABASE_MODEL.COLUMN_INDEX)));
*/
            cursor.close();
        }
        else
        {
            System.out.println("DATA PADA TABEL KOSONG");
        }
        return cursor;

    }

    public int getDataCount()
    {
        String countQuery = "SELECT * FROM " + DATABASE_MODEL.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }


    public void updateData(DATABASE_MODEL database_model, int column_id, int column_index)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues  values = new ContentValues();
        values.put(DATABASE_MODEL.COLUMN_DATA, database_model.getData());
        db.update(DATABASE_MODEL.TABLE_NAME, values,
                DATABASE_MODEL.COLUMN_ID + "=" + column_id + " AND " + DATABASE_MODEL.COLUMN_INDEX + "=" + column_index,
                new String[]{String.valueOf(database_model.getData())});
    }


    public void deleteData(DATABASE_MODEL database_model)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(DATABASE_MODEL.TABLE_NAME, DATABASE_MODEL.COLUMN_ID + "=?",
                new String[]{String.valueOf(database_model.getId())});
        db.close();
    }



}
