package com.hansung.android.project_nicerestaurantapp;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class Food extends AppCompatActivity {

    private static final String TAG = "ActivityLifeCycle";
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        Log.i(TAG, getLocalClassName() + ".onCreate");
        Intent intent=getIntent();

        int getimg = intent.getIntExtra("foodimg", 0);
        ImageView img = (ImageView) findViewById(R.id.foodimage);
        img.setImageResource(getimg);

        int getname = intent.getIntExtra("foodname", 0);
        TextView name = (TextView)findViewById(R.id.foodname);
        name.setText(getname);

        int getprice = intent.getIntExtra("foodprice", 0);
        TextView price = (TextView)findViewById(R.id.foodprice);
        price.setText(getprice);

        int getstar = intent.getIntExtra("foodstar", 0);
        TextView star = (TextView)findViewById(R.id.foodstar);
        star.setText(getstar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            Drawable drawable = getDrawable(R.drawable.ic_keyboard_arrow_left_black_24dp);
            if (drawable != null) {
                drawable.setTint(Color.WHITE);
                actionBar.setHomeAsUpIndicator(drawable);
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, getLocalClassName() + ".onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, getLocalClassName() + ".onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, getLocalClassName() + ".onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, getLocalClassName() + ".onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, getLocalClassName() + ".onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, getLocalClassName() + ".onDestroy");
    }


}