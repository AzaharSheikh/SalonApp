package com.example.amitvarma.salonapp.Activities;

/**
 * Created by AmitVarma on 19-12-2016.
 */
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.amitvarma.salonapp.R;


/**
 * Created by AzaharSheikh on 28-09-2016.
 */
public class User_Login extends AppCompatActivity  {

    Button btn_login, btn_register;
    EditText edt_username, edt_password;
    ProgressDialog pDialog;
    private RadioGroup rg_member;
    private RadioButton rbtn_member;

    public static String imageurl;
    String login_name="";

    TextView txt_forgot_password;
    private View view;
    CheckBox chk_remember;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);


        btn_login=(Button)findViewById(R.id.btn_login);
        btn_register=(Button)findViewById(R.id.btn_register);
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
                if (login_name.equalsIgnoreCase("user")) {
                    Intent intent = new Intent(User_Login.this,
                            MainActivity.class);

                    startActivity(intent);
                    finish();
                } else {
//            Intent i = new Intent(User_Login.this,Welcome_User.class);
//            startActivity(i);
//            finish();
                    Intent b = new Intent(User_Login.this, Welcome_User.class);
                    startActivity(b);
                }
            }
        });
    }
    }