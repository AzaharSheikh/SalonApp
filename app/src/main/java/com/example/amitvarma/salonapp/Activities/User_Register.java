package com.example.amitvarma.salonapp.Activities;

import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.amitvarma.salonapp.Database.DatabaseHandler;
import com.example.amitvarma.salonapp.R;
import com.example.amitvarma.salonapp.model.User_Data_Model;

import java.util.List;

/**
 * Created by AmitVarma on 19-12-2016.
 */
public class User_Register extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.user_register);
        DatabaseHandler db = new DatabaseHandler(this);
        db.addRegistration(new User_Data_Model("Ashwini","Mumbai","9766241425","ash@gmail.com","ash"));
        db.addRegistration(new User_Data_Model("azhar","Aroli","123456789","azr@gmail.com","azr"));

//        // Reading all contacts
//        Log.d("Reading: ", "Reading all contacts..");
//        List<User_Register> User = db.getUser_RegisterCount();
//
//        for (User_Register cn : User) {
//            String log = "user_name: "+cn.getuser_name()+" ,Name: " + cn.getuser_address() + " ,Phone: " + cn.getmobile_number();
//            // Writing Contacts to log
//            Log.d("Name: ", log);
//        }
    }
    public boolean onOptionsItemSelected(MenuItem item){
        finish();
        return true;

    }
}




