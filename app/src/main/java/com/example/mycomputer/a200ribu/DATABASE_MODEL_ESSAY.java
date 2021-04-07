package com.example.mycomputer.a200ribu;

public class DATABASE_MODEL_ESSAY
{
    public static String TABLE_NAME_ESSAY = "DATA_ESSAY";
    public static String COLUMN_INDEX = "tanda";
    public static String COLUMN_DATA = "data";
    public static String COLUMN_ID = "id";




    private int id;
    private String data;
    private int index;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }


    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }



    public DATABASE_MODEL_ESSAY(){

    }

    public DATABASE_MODEL_ESSAY(int id, String data, int index){
        this.id = id;
        this.data = data;
        this.index = index;
    }

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME_ESSAY + " ("
                    + COLUMN_ID + " INTEGER, "
                    + COLUMN_DATA + " TEXT, "
                    + COLUMN_INDEX + " INTEGER"
                    + ")";

}
