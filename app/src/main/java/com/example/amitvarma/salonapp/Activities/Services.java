package com.example.amitvarma.salonapp.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.example.amitvarma.salonapp.R;

/**
 * Created by AmitVarma on 22-12-2016.
 */
public class Services extends AppCompatActivity {
    LinearLayout li_hair,li_makeup,li_facial,li_spa;

    RadioGroup services_type;
    RadioButton rbt_hair_details, rbt_makeup_details, rbt_facial_details,rbt_massage_details,rbt_spa_details;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.services);

        services_type = (RadioGroup) findViewById(R.id.services_type);
        rbt_hair_details = (RadioButton) findViewById(R.id.rbt_hair_details);
        rbt_makeup_details = (RadioButton) findViewById(R.id.rbt_makeup_details);
        rbt_facial_details = (RadioButton) findViewById(R.id.rbt_facial_details);
//        rbt_massage_details = (RadioButton) findViewById(R.id.rbt_massage_details);
        rbt_spa_details = (RadioButton) findViewById(R.id.rbt_spa_details);

        li_spa= (LinearLayout) findViewById(R.id.li_spa);
        li_hair = (LinearLayout) findViewById(R.id.li_hair);
        li_facial=(LinearLayout) findViewById(R.id.li_facial);
        li_makeup = (LinearLayout) findViewById(R.id.li_makeup);

        services_type.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()

        {

            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rbt_hair_details:
//                        li_hair_hightlights.setVisibility(View.GONE);
                        li_spa.setVisibility(View.GONE);
                        li_facial.setVisibility(View.GONE);
                        li_makeup.setVisibility(View.GONE);
                        li_hair.setVisibility(View.VISIBLE);

                        break;
                    case R.id.rbt_makeup_details:
//                        li_bridal_makeup.setVisibility(View.GONE);
                        li_spa.setVisibility(View.GONE);
                        li_facial.setVisibility(View.GONE);
                        li_makeup.setVisibility(View.VISIBLE);
                        li_hair.setVisibility(View.GONE);
                        break;
                    case R.id.rbt_facial_details:
//                        li_hair_hightlights.setVisibility(View.GONE);
                       li_spa.setVisibility(View.GONE);
                        li_facial.setVisibility(View.VISIBLE);
                        li_hair.setVisibility(View.GONE);
                        li_makeup.setVisibility(View.GONE);
                        break;
//                    case R.id.rbt_massage_details:
//                        li_hair_hightlights.setVisibility(View.GONE);
//                        li_hair_straight.setVisibility(View.VISIBLE);
//                        li_hair_clr.setVisibility(View.GONE);
//                        li_hair.setVisibility(View.GONE);
//                        li_makeup.setVisibility(View.GONE);
//                        break;
                    case R.id.rbt_spa_details:
                        li_spa.setVisibility(View.VISIBLE);
                        li_facial.setVisibility(View.GONE);
                        li_hair.setVisibility(View.GONE);
                        li_makeup.setVisibility(View.GONE);
                        break;
                }

            }


        });
    }
}
