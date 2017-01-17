package com.example.amitvarma.salonapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.amitvarma.salonapp.R;

/**
 * Created by AmitVarma on 06-01-2017.
 */
public class Book_Appoinment extends AppCompatActivity {
    TextView txt_view_book_now;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_appoinment);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        txt_view_book_now=(TextView)findViewById(R.id.txt_view_book_now);

        txt_view_book_now.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Book_Appoinment.this,Booked_Detail.class);
                startActivity(i);

            }

        });

    }
    public boolean onOptionsItemSelected(MenuItem item){
        finish();
        return true;

    }
}
