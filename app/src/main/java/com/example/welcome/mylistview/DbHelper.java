package com.example.welcome.mylistview;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DbHelper extends SQLiteOpenHelper {

    private static final String TAG = "DbHelper";

    private static final String Table_name ="Student";
    private static final String col1 ="ID";
    private static final String col2 ="name";

    public DbHelper(Context context){

        super(context, Table_name, null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createtable = "CREATE TABLE " + Table_name + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " + col2 +" TEXT)";
        db.execSQL(createtable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP IF TABLE EXISTS "+ Table_name);
        onCreate(db);
    }
    public boolean addData(String item){
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col2,item);

        Log.d(TAG, "addData: Adding "+ item +" to "+ Table_name);
        long result = db.insert(Table_name, null, contentValues);

        if (result == -1){
            return false;
        }else {
            return true;
        }
    }

    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query ="SELECT * FROM " + Table_name;
        Cursor data = db.rawQuery(query,null);
        return data;
    }
}
