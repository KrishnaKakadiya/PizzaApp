package com.krishna.kakadiya.pizzaapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author Krishna Kakadiya
 * @date 10-13-2016
 * @file PizzaListAdapter.java
 */

public class PizzaListAdapter extends ArrayAdapter<String> {

    private final String[] mPizzaName;
    private final String[] mPizzaDescription;
    private final String[] mPizzaRate;
    private final Integer[] mImageId;
    private LayoutInflater mLayoutInflater;

    public PizzaListAdapter(Activity context, String[] pizzaName, String[] pizzaDescription, String[] pizzaRate, Integer[] imageId) {
        super(context, R.layout.activity_custom_pizza_list, pizzaName);
        this.mPizzaName = pizzaName;
        this.mPizzaDescription = pizzaDescription;
        this.mPizzaRate = pizzaRate;
        this.mImageId = imageId;
        this.mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder = null;
        if(view == null) {
            view = mLayoutInflater.inflate(R.layout.activity_custom_pizza_list, parent, false);
            holder = new ViewHolder();
            holder.mName = (TextView) view.findViewById(R.id.pizza_name);
            holder.mDescription = (TextView) view.findViewById(R.id.pizza_description);
            holder.mRate = (TextView) view.findViewById(R.id.pizza_Rate);
            holder.mImageView = (ImageView) view.findViewById(R.id.imageView);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        holder.mName.setText(mPizzaName[position]);
        holder.mDescription.setText(mPizzaDescription[position]);
        holder.mRate.setText(mPizzaRate[position]);
        holder.mImageView.setBackgroundResource(mImageId[position]);

        return view;
    }

    static class ViewHolder {
        private TextView mName,mDescription,mRate;
        private ImageView mImageView;
    }
}
