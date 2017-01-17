package com.example.amitvarma.salonapp.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.amitvarma.salonapp.R;

/**
 * Created by AmitVarma on 07-01-2017.
 */
public class Booked_Detail extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.booked_detail);
    }
    public boolean onOptionsItemSelected(MenuItem item){
        finish();
        return true;

    }
}