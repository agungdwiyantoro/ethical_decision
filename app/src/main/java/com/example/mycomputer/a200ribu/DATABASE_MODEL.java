package com.example.mycomputer.a200ribu;

public class DATABASE_MODEL
{
    public static String TABLE_NAME = "DATA";
    public static String COLUMN_INDEX = "INDEX";
    public static String COLUMN_DATA = "DATA";
    public static String COLUMN_ID = "ID";


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    private int id;
    private int data;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    private int index;

    public DATABASE_MODEL(){

    }

    public DATABASE_MODEL(int id, int data, int index){
        this.id = id;
        this.data = data;
        this.index = index;
    }

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER"
                    + COLUMN_DATA + " INTEGER"
                    + COLUMN_INDEX + " INTEGER"
                    + ")";

}
