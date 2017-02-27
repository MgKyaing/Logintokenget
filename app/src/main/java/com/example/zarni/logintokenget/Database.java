package com.example.zarni.logintokenget;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by zarni on 2/24/17.
 */

public class Database extends SQLiteOpenHelper {

    public Database(DBConnect applicationcontext) {
        super(applicationcontext,"user.db",null,1);
    }


    @Override
    public void onCreate(SQLiteDatabase database) {
        String query;
        query ="CREATE  TABLE users(userId  TEXT,userName TEXT)";
        database.execSQL(query);
    }


    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {

        String query;
        query="DROP TABLE IF EXISTS users";
        database.execSQL(query);
    }

    public void  insertUser(HashMap<String,String>queryValues){

        SQLiteDatabase database=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("userId",queryValues.get("userId"));
        values.put("userName",queryValues.get("userName"));
        database.insert("users",null,values);
        database.close();
    }
    public ArrayList<HashMap<String,String>>getAllUsers(){
        ArrayList<HashMap<String ,String>>usersList;
        usersList=new ArrayList<HashMap<String, String>>();
        String selectQuery="SELECT * FROM users ";
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor=database.rawQuery(selectQuery,null);
        if (cursor.moveToFirst())
        {
         do {

             HashMap<String,String>map=new HashMap<String,String>();
             map.put("userId",cursor.getString(0));
             map.put("userName",cursor.getString(1));
             usersList.add(map);

         }while(cursor.moveToNext());
        }
        database.close();
        return usersList;
    }

}
