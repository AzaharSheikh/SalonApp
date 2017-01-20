package com.example.amitvarma.salonapp.Activities;

import android.app.DownloadManager;
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

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  Created byAshwiniBadgujar on 19-01-2017.
 */
public class User_Register extends AppCompatActivity {

    Button btn_user_register_submit;
    EditText edt_username, edt_user_address, edt_user__mobile, edt_user_email, edt_user_password, edt_user_comfirm_pass;
    String login_name;
    private ProgressDialog pDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        setContentView(R.layout.user_register);
        btn_user_register_submit = (Button) findViewById(R.id.btn_user_register_submit);
        edt_username =(EditText) findViewById(R.id.edt_username);
        edt_user_address=(EditText)findViewById(R.id.edt_user_address);
        edt_user__mobile=(EditText)findViewById(R.id.edt_user__mobile);
        edt_user_email=(EditText)findViewById(R.id.edt_user_email) ;
        edt_user_password=(EditText)findViewById(R.id.edt_user_password);
        edt_user_comfirm_pass=(EditText)findViewById(R.id.edt_user_comfirm_pass);
//        // Reading all contacts
//        Log.d("Reading: ", "Reading all contacts..");
//        List<User_Register> User = db.getUser_RegisterCount();
//
//        for (User_Register cn : User) {
//            String log = "user_name: "+cn.getuser_name()+" ,Name: " + cn.getuser_address() + " ,Phone: " + cn.getmobile_number();
//            // Writing Contacts to log
//            Log.d("Name: ", log);
//        }

        btn_user_register_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str_edt_username = edt_username.getText().toString().trim();
                String str_user_address = edt_user_address.getText().toString().trim();
                String str_mobile = edt_user__mobile.getText().toString().trim();
                String str__email = edt_user_email.getText().toString().trim();
                String str_password = edt_user_password.getText().toString().trim();
                String str_confirm_password = edt_user_comfirm_pass.getText().toString().trim();

                if (str_edt_username.equalsIgnoreCase("") || str_user_address.equalsIgnoreCase("") || str_mobile.equalsIgnoreCase("") || str__email.equalsIgnoreCase("") || str_password.equalsIgnoreCase("") || str_confirm_password.equalsIgnoreCase("")) {
                    Toast.makeText(User_Register.this, "some field missing", Toast.LENGTH_SHORT).show();
                } else {
                    if (!str_password.equalsIgnoreCase(str_confirm_password)) {
                        Toast.makeText(User_Register.this, "password Not matched", Toast.LENGTH_SHORT).show();
                    } else {
                        pDialog = new ProgressDialog(User_Register.this);
                        pDialog.setCancelable(false);
                        //RegisterAsync(str_edt_username,str_user_address,str_mobile,str__email,str_password);
                        // LocalRegisterDb(str_edt_username, str_user_address, str_mobile, str__email, str_password);
                        DatabaseHandler db = new DatabaseHandler(User_Register.this);
                        db.addRegistration(new User_Data_Model(str_edt_username, str_user_address, str_mobile, str__email, str_password));


                    }
                }
            }
        });


    }

    private void LocalRegisterDb(String str_edt_username, String str_user_address, String str_mobile, String str__email, String str_password) {

        DatabaseHandler handler = new DatabaseHandler(User_Register.this);
        SQLiteDatabase db = handler.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DatabaseHandler.KEY_USER_NAME, str_edt_username);
        values.put(DatabaseHandler.KEY_USER_ADDRESS, str_user_address);
        values.put(DatabaseHandler.KEY_USER_MOBILE, str_mobile);
        values.put(DatabaseHandler.KEY_USER_EMAIL, str__email);
        values.put(DatabaseHandler.KEY_USER_PASSWORD, str_password);

        boolean b = db.insert(DatabaseHandler.TABLE_REGISTER, null, values) > 0;
        if (b) {
            Toast.makeText(User_Register.this, "User created successfully", Toast.LENGTH_SHORT).show();
            Bundle bundle = new Bundle();
            Intent i = new Intent(User_Register.this, User_Login.class);
            bundle.putString("login_name", login_name);
            i.putExtras(bundle);
            startActivity(i);
            finish();


        } else {
            Toast.makeText(User_Register.this, "Plsease try again, with another email", Toast.LENGTH_SHORT).show();
        }
    }


    private void showDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;

    }


}


