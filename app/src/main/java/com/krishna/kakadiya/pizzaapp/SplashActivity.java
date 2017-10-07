package com.krishna.kakadiya.pizzaapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/**
 * @author Krishna Kakadiya
 * @date 10-13-2016
 * @file SplashActivity.java
 */

public class SplashActivity extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash_view);

        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                Intent intent = new Intent(SplashActivity.this, PizzaActivity.class);
                startActivity(intent);
                finish();
            }
        }, Constant.SPLASH_TIMEOUT);
    }
}
