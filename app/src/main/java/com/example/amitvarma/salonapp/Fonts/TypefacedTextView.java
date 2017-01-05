package com.example.amitvarma.salonapp.Fonts;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by AzaharSheikh on 06-10-2016.
 */
public class TypefacedTextView extends TextView {

    public TypefacedTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "fonts/LatoRegular.ttf");
        setTypeface(typeface);
    }
}