package com.example.amitvarma.salonapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.amitvarma.salonapp.R;

/**
 * Created by AmitVarma on 21-12-2016.
 */
public class Welcome_User extends AppCompatActivity {
    ImageView iv_pic1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_user);

    iv_pic1=(ImageView)findViewById(R.id.iv_pic1);

    iv_pic1.setOnClickListener(new View.OnClickListener()

    {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(Welcome_User.this, Services.class);
            startActivity(i);

        }

    });
    }

}