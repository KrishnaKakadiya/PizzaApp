package com.krishna.kakadiya.pizzaapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author Krishna Kakadiya
 * @date 10-13-2016
 * @file PizzaActivity.java
 */

public class PizzaActivity extends AppCompatActivity {

    @Bind(R.id.toolbar_activity_name)
    TextView activityName;

    @Bind(R.id.toolbar_back)
    ImageView toolbarBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza);
        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbarBack.setVisibility(View.GONE);
        activityName.setText(getApplicationContext().getString(R.string.activity_krishna));

    }

    @OnClick(R.id.toolbar_logo)
    public void home()
    {
        Intent intent = new Intent(PizzaActivity.this, PizzaActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.imageView)
    public void onlineOrder()
    {
        Intent intent = new Intent(PizzaActivity.this, MenuActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.order_text)
    public void orderNow()
    {
        Intent intent = new Intent(PizzaActivity.this, MenuActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.miHelp:
                help();
                return true;
            case R.id.miPizza:
                openPizzaWebsite();
                return true;
            case R.id.miYourName:
                mySelf();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void mySelf() {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.setMessage(this.getString(R.string.my_self));

        alertDialog.setButton(this.getString(R.string.ok), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        alertDialog.show();
    }

    private void openPizzaWebsite() {
        String url = "http://www.gmail.com";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

    private void help() {
        String url = "https://www.dominos.ca";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
}
