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
import android.widget.EditText;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author eInfochips
 * @date 27-11-2015
 * @file Constant.java
 */

public class ShippingAddressActivity extends AppCompatActivity {

    @Bind(R.id.name)
    EditText name;

    @Bind(R.id.address)
    EditText address;

    @Bind(R.id.contact_number)
    EditText contactNumber;

    @Bind(R.id.credit_card)
    EditText creditCard;

    @Bind(R.id.toolbar_activity_name)
    TextView activityName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shipping_address);
        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        activityName.setText(getApplicationContext().getString(R.string.activity_address));
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
        Intent intent = new Intent(ShippingAddressActivity.this, PizzaActivity.class);
        startActivity(intent);
    }


    public boolean isValidate()
    {
        boolean isValid = true;

        if(name.getText().toString().matches(""))
        {
            isValid = false;
        }
        if(address.getText().toString().matches(""))
        {
            isValid = false;
        }if(contactNumber.getText().toString().matches(""))
        {
            isValid = false;
        }
        if(creditCard.getText().toString().matches(""))
        {
            isValid = false;
        }
        return isValid;
    }
    private boolean isValidateMobile() {
        boolean isValid = true;

        if(contactNumber.getText().toString().length()!=10)
        {
            isValid = false;
        }
        return isValid;
    }
    private boolean isValidateCreditCard() {
        boolean isValid = true;

        if(creditCard.getText().toString().length()!=14)
        {
            isValid = false;
        }
        return isValid;
    }

    @OnClick(R.id.btn_finalize_order)
    public void finalizeOrder()
    {
        if(isValidate()) {

            if(isValidateMobile())
            {
                if(isValidateCreditCard())
                {
                    Intent intent = new Intent(ShippingAddressActivity.this, ThankYouActivity.class);
                    intent.putExtra(Constant.KEY_NAME,name.getText().toString());
                    intent.putExtra(Constant.KEY_ADDRESS,address.getText().toString());
                    intent.putExtra(Constant.KEY_CONTACT_NUMBER,contactNumber.getText().toString());
                    startActivity(intent);
                }
                else
                {
                    AlertDialog alertDialog = new AlertDialog.Builder(this).create();
                    alertDialog.setCanceledOnTouchOutside(false);
                    alertDialog.setMessage(this.getString(R.string.validate_credit_card));

                    alertDialog.setButton(this.getString(R.string.ok), new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    alertDialog.show();
                }

            }
            else
            {
                AlertDialog alertDialog = new AlertDialog.Builder(this).create();
                alertDialog.setCanceledOnTouchOutside(false);
                alertDialog.setMessage(this.getString(R.string.validate_mobile));

                alertDialog.setButton(this.getString(R.string.ok), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                alertDialog.show();
            }
        }
        else
        {
            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setCanceledOnTouchOutside(false);
            alertDialog.setMessage(this.getString(R.string.validate_order));

            alertDialog.setButton(this.getString(R.string.ok), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            alertDialog.show();
        }
    }

    @OnClick(R.id.btn_cancel_order)
    public void cancelOrder()
    {
        finishAffinity();
        Intent intent = new Intent(ShippingAddressActivity.this, PizzaActivity.class);
        startActivity(intent);
    }
    @Override
    public void onPause() {
        super.onPause();
        name.setText("");
        address.setText("");
        contactNumber.setText("");
        creditCard.setText("");
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
