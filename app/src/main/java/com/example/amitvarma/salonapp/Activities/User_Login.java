package com.example.amitvarma.salonapp.Activities;

/**
 * Created by AmitVarma on 19-12-2016.
 */
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.ActionMode;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.example.amitvarma.salonapp.Database.DatabaseHandler;
import com.example.amitvarma.salonapp.R;

import org.json.JSONException;
import org.json.JSONObject;


/**
 * Created byAshwiniBadgujar on 19-01-2017.
 */
public class User_Login extends AppCompatActivity {

    Button btn_login, btn_register;
    EditText edt_username, edt_user_password,edt_login_mobilenumber,edt_login_password;
    ProgressDialog pDialog;
    private RadioGroup rg_member;
    private RadioButton rbtn_member;


    public static String imageurl;
    String login_name = "";

    TextView txt_forgot_password;
    private View view;
    CheckBox chk_remember;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        btn_login = (Button) findViewById(R.id.btn_login);
        btn_register = (Button) findViewById(R.id.btn_register);



        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(User_Login.this, User_Register.class);
                startActivity(i);

            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {


                edt_login_mobilenumber=(EditText)findViewById(R.id.edt_login_mobilenumber);
                edt_login_password=(EditText)findViewById(R.id.edt_login_password);

                String str_login_mobilenumber =   edt_login_mobilenumber.getText().toString().trim();
                String str_login_password =   edt_login_password.getText().toString().trim();

//                if (login_name.equalsIgnoreCase("user")) {
//                    Intent intent = new Intent(User_Login.this,
//                            MainActivity.class);
//
//                    startActivity(intent);
//                    finish();
//                } else {
//
//                 Intent b = new Intent(User_Login.this, Welcome_User.class);
//                    startActivity(b);
//
//                }
                local_login(str_login_mobilenumber, str_login_password);

            }

        });


    }

        private void local_login (String str_login_mobilenumber, String str_login_password) {
            DatabaseHandler handler = new DatabaseHandler(User_Login.this);
            SQLiteDatabase db = handler.getWritableDatabase();
            String[] colmn = new String[]{DatabaseHandler.KEY_USER_NAME, DatabaseHandler.KEY_USER_ADDRESS, DatabaseHandler.KEY_USER_MOBILE, DatabaseHandler.KEY_USER_EMAIL, DatabaseHandler.KEY_USER_PASSWORD,};
            Cursor cursor = db.query(DatabaseHandler.TABLE_REGISTER, colmn, DatabaseHandler.KEY_USER_EMAIL + " = '" + str_login_mobilenumber + "'" + " AND " + DatabaseHandler.KEY_USER_PASSWORD + " = '" + str_login_password + "'"  , null, null, null, null);
            if (cursor != null) {
                String str_username = "", str_user_address = "", str_user_mobile = "", str_user_email = "";
                if (cursor.getCount() > 0) {
                    while (cursor.moveToNext()) {
                        str_login_mobilenumber = cursor.getString(cursor.getColumnIndex(DatabaseHandler.KEY_USER_MOBILE));
                        str_user_address = cursor.getString(cursor.getColumnIndex(DatabaseHandler.KEY_USER_ADDRESS));
                        str_user_mobile = cursor.getString(cursor.getColumnIndex(DatabaseHandler.KEY_USER_MOBILE));
                        str_user_email = cursor.getString(cursor.getColumnIndex(DatabaseHandler.KEY_USER_EMAIL));

                    }
                    cursor.close();
                    db.close();

                    Bundle bundle = new Bundle();
                    bundle.putString(DatabaseHandler.KEY_USER_MOBILE, str_login_mobilenumber);
                    bundle.putString(DatabaseHandler.KEY_USER_ADDRESS, str_user_address);
                    bundle.putString(DatabaseHandler.KEY_USER_MOBILE, str_user_mobile);
                    bundle.putString(DatabaseHandler.KEY_USER_EMAIL, str_user_email);


                    if (login_name.equalsIgnoreCase("user")) {
                        Intent intent = new Intent(User_Login.this,
                                MainActivity.class);
                        intent.putExtras(bundle);
                        startActivity(intent);
                        finish();
                    } else {
                        Intent i = new Intent(User_Login.this, Welcome_User.class);
                        i.putExtras(bundle);
                        startActivity(i);
                        finish();
                    }

                } else {
                    Toast.makeText(User_Login.this, "Plsease try again, email or password wrong", Toast.LENGTH_SHORT).show();
                }
            }
        }
}



