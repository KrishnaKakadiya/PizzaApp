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
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author eInfochips
 * @date 27-11-2015
 * @file Constant.java
 */

public class PizzaDetailActivity extends AppCompatActivity {

    @Bind(R.id.chk_1)
    CheckBox chk_1;

    @Bind(R.id.chk_2)
    CheckBox chk_2;

    @Bind(R.id.chk_3)
    CheckBox chk_3;

    @Bind(R.id.chk_4)
    CheckBox chk_4;

    @Bind(R.id.chk_5)
    CheckBox chk_5;

    @Bind(R.id.chk_6)
    CheckBox chk_6;

    @Bind(R.id.chk_7)
    CheckBox chk_7;

    @Bind(R.id.chk_8)
    CheckBox chk_8;

    @Bind(R.id.chk_9)
    CheckBox chk_9;

    @Bind(R.id.chk_10)
    CheckBox chk_10;

    @Bind(R.id.toolbar_activity_name)
    TextView activityName;

    private Spinner spinnerDough,spinnerSize;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_detail);
        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        activityName.setText(getApplicationContext().getString(R.string.activity_detail));
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
        Intent intent = new Intent(PizzaDetailActivity.this, PizzaActivity.class);
      // intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        /*intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);*/
        startActivity(intent);
    }

    public void addListenerOnSpinnerItemSelection() {
        spinnerDough = (Spinner) findViewById(R.id.spinner_dough);
        spinnerSize = (Spinner) findViewById(R.id.spinner_size);

        spinnerDough.setOnItemSelectedListener(new CustomOnItemSelectedListener());
        spinnerSize.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }

    @OnClick(R.id.btn_checkout)
    public void checkOut()
    {
        Intent intent = new Intent(PizzaDetailActivity.this, ShippingAddressActivity.class);
        startActivity(intent);
    }

    @Override
    public void onPause() {
        super.onPause();

        if (chk_1.isChecked()) {
            chk_1.setChecked(false);
        }
        if (chk_2.isChecked()) {
            chk_2.setChecked(false);
        }
        if (chk_3.isChecked()) {
            chk_3.setChecked(false);
        }
        if (chk_4.isChecked()) {
            chk_4.setChecked(false);
        }
        if (chk_5.isChecked()) {
            chk_5.setChecked(false);
        }
        if (chk_6.isChecked()) {
            chk_6.setChecked(false);
        }
        if (chk_7.isChecked()) {
            chk_7.setChecked(false);
        }
        if (chk_8.isChecked()) {
            chk_8.setChecked(false);
        }
        if (chk_9.isChecked()) {
            chk_9.setChecked(false);
        }
        if (chk_10.isChecked()) {
            chk_10.setChecked(false);
        }

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

class CustomOnItemSelectedListener implements AdapterView.OnItemSelectedListener {

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        Toast.makeText(parent.getContext(),
                "You choose " + parent.getItemAtPosition(pos).toString(),
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

}
