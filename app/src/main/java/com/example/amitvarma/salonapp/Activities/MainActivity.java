package com.example.amitvarma.salonapp.Activities;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.amitvarma.salonapp.Database.DatabaseHandler;
import com.example.amitvarma.salonapp.R;

public class MainActivity extends AppCompatActivity {
    //    private NavigationView navigationView;
    private View navHeader;

    private static final String TAG_HOME = "Home";
    private static final String TAG_SERVICES = "Our Services";
    private static final String TAG_BOOK = "Book An Apoinment";
    private static final String TAG_OFFERS = "Offers";
    private static final String TAG_CONTACT = "Contact";
    private static final String TAG_NOTIFICATION = "Notifications";
    private static final String TAG_LOGOUT = "Logout";

    TextView txtName;


    public static String str_user_name = "", str_user_address = "", str_user_mobile = "", str_user_email = "";
    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);
        DatabaseHandler db = new DatabaseHandler(this);
    }


}