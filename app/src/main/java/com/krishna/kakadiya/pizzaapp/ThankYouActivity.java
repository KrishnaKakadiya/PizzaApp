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
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author eInfochips
 * @date 27-11-2015
 * @file Constant.java
 */

public class ThankYouActivity extends AppCompatActivity {

    @Bind(R.id.name)
    TextView txtName;

    @Bind(R.id.address)
    TextView txtAddress;

    @Bind(R.id.contact_number)
    TextView txtContactNumber;

    @Bind(R.id.toolbar_activity_name)
    TextView activityName;

    String name,address,contactNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thankyou);
        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        activityName.setText(getApplicationContext().getString(R.string.activity_order));

        Intent intent = getIntent();
        name = intent.getStringExtra(Constant.KEY_NAME);
        address = intent.getStringExtra(Constant.KEY_ADDRESS);
        contactNumber = intent.getStringExtra(Constant.KEY_CONTACT_NUMBER);

        txtName.setText(name);
        txtAddress.setText(address);
        txtContactNumber.setText(contactNumber);
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
        Intent intent = new Intent(ThankYouActivity.this, PizzaActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.btn_thank_you)
    public void orderPlaced()
    {
        finishAffinity();
        Intent intent = new Intent(ThankYouActivity.this, PizzaActivity.class);
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
