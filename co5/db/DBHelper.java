package com.example.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "student.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table studentdetails(name text primary key,contact text,dob text)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists studentdetails");
    }

    public boolean insertuserdata(String name, String contact, String dob) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name", name);
        cv.put("contact", contact);
        cv.put("dob", dob);
        long result = db.insert("studentdetails", null, cv);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean updateuserdata(String name, String contact, String dob) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("contact", contact);
        cv.put("dob", dob);
        Cursor cursor = db.rawQuery("select * from studentdetails where name=?",new String[]{name});
        if(cursor.getCount()>0){
            long result = db.update("studentdetails", cv,"name=?",new String[]{name});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        }
        else {
        return false;
    }

} public boolean deleteuserdata(String name, String contact, String dob) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("contact", contact);
        cv.put("dob", dob);
        Cursor cursor = db.rawQuery("select * from studentdetails where name=?",new String[]{name});
        if(cursor.getCount()>0){
            long result = db.delete("studentdetails", "name=?",new String[]{name});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        }
        else {
            return false;
        }

    }
    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from studentdetails",null);
        return cursor;
    }
}
