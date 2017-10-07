package com.krishna.kakadiya.pizzaapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author Krishna Kakadiya
 * @date 10-13-2016
 * @file MenuActivity.java
 */

public class MenuActivity extends AppCompatActivity {

    @Bind(R.id.pizza_list_item)
    ListView pizzaListItem;

    @Bind(R.id.toolbar_activity_name)
    TextView activityName;

    Integer[] imageId = {R.drawable.pro1,R.drawable.pro2,R.drawable.pro3,R.drawable.pro4,R.drawable.pro5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        activityName.setText(getApplicationContext().getString(R.string.activity_menu));

        Resources res = getResources();
        String[] pizzaName = res.getStringArray(R.array.pizza_name);
        String[] pizzaDescription = res.getStringArray(R.array.pizza_description);
        String[] pizzaRate = res.getStringArray(R.array.pizza_rate);

        pizzaListItem.setAdapter(null);
        pizzaListItem.setAdapter(new PizzaListAdapter(this, pizzaName, pizzaDescription, pizzaRate, imageId));
        pizzaListItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MenuActivity.this, PizzaDetailActivity.class);
                startActivity(intent);
            }
        });
    }
    @OnClick(R.id.toolbar_back)
    public void back()
    {
        finish();
    }
    @OnClick(R.id.toolbar_logo)
    public void home()
    {
        finishAffinity();
        Intent intent = new Intent(MenuActivity.this, PizzaActivity.class);
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
