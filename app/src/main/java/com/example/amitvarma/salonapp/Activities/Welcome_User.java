package com.example.amitvarma.salonapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.amitvarma.salonapp.R;

/**
 *  Created byAshwiniBadgujar on 19-01-2017.
 */
public class Welcome_User extends AppCompatActivity {
    ImageView img_user_services;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_user);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        img_user_services=(ImageView)findViewById(R.id.img_user_services);

        img_user_services.setOnClickListener(new View.OnClickListener()

    {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(Welcome_User.this, Services.class);
            startActivity(i);

        }

    });
    }
    public boolean onOptionsItemSelected(MenuItem item){
        finish();
        return true;

    }
}