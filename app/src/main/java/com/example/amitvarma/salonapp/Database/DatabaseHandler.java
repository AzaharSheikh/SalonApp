package com.example.amitvarma.salonapp.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.amitvarma.salonapp.Activities.User_Register;
import com.example.amitvarma.salonapp.model.User_Data_Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AmitVarma on 20-12-2016.
 */
public class DatabaseHandler extends SQLiteOpenHelper {
    // All Static variables
    // com.example.amitvarma.salonapp.Database Version
    private static final int DATABASE_VERSION = 13;
    // com.example.amitvarma.salonapp.Database Name
    public static final String DATABASE_NAME = "salon_db";
    public static final String TABLE_REGISTER = "register_tb";

    // user reg  Table Columns names
    public static final String KEY_USER_NAME = "user_name";
    public static final String KEY_USER_ADDRESS = "user_address";
    public static final String KEY_USER_MOBILE = "user_mobile";
    public static final String KEY_USER_EMAIL = "user_email";
    public static final String KEY_USER_PASSWORD = "user_password";
    private List<User_Register> user_RegisterCount;


    public DatabaseHandler(Context context)  {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_REGISTER = "CREATE TABLE " + TABLE_REGISTER + "("
                + KEY_USER_NAME + " TEXT, " + KEY_USER_ADDRESS + " TEXT, "
                + KEY_USER_MOBILE + " TEXT, " +  KEY_USER_EMAIL + " TEXT, "+ KEY_USER_PASSWORD + " TEXT "+")";

        db.execSQL(CREATE_TABLE_REGISTER);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_REGISTER);

        // Create tables again
        onCreate(db);
    }

    // Adding new contact
    public void addRegistration(User_Data_Model user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_USER_NAME, user.getUser_name()); // Contact Name
        values.put(KEY_USER_ADDRESS, user.getUser_address());
        values.put(KEY_USER_MOBILE, user.getUser_email());
        values.put(KEY_USER_EMAIL, user.getUser_mobile());
        values.put(KEY_USER_PASSWORD, user.getUser_password());

        if(db.insert(TABLE_REGISTER, null, values)>0)
        {
            Log.d("databasestatus","true");
        }else
        {
            Log.d("databasestatus","false");
        }


        db.close(); // Closing database connection
    }
//    // Getting All Contacts
//    public List<User_Data_Model> getAllregisterlist() {
//        List<User_Data_Model> registerList = new ArrayList<User_Data_Model>();
//        // Select All Query
//        String selectQuery = "SELECT  * FROM " + TABLE_REGISTER;
//
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery(selectQuery, null);
//
//        // looping through all rows and adding to list
//        if (cursor.moveToFirst()) {
//            do {
//                User_Register registerlist = new User_Register();
//                registerlist.setuser_name(Integer.parseInt(cursor.getString(0)));
//                registerlist.setuser_address(cursor.getString(1));
//                registerlist.setPhoneNumber(cursor.getString(2));
//                // Adding contact to list
//                registerList.add(registerList);
//            } while (cursor.moveToNext());
//        }
//
//        // return contact list
//        return registerlist;
//    }
//
//    public List<User_Register> getUser_RegisterCount() {
//        return user_RegisterCount;
//    }
}