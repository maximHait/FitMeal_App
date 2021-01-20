package com.example.fitmeal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class MealAdapter extends ArrayAdapter<Meal>
{
    private Context ctx;
    private int mealResourceId;
    private List<Meal>data;

    public MealAdapter(Context context, int resource, List<Meal> objects)
    {
        super(context, resource, objects);
        this.ctx = context;
        this.mealResourceId = resource;
        this.data = objects;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater li = (LayoutInflater)this.ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = li.inflate(this.mealResourceId, null);

        Meal m = this.data.get(position);
        TextView tv1 = v.findViewById(R.id.MealName);
        tv1.setText(m.getMealName());
        TextView tv2 = v.findViewById(R.id.calories);
        tv2.setText(m.getCal());
        return v;
        //return super.getView(position, convertView, parent);
    }

    @Override
    public int getCount() {
        return this.data.size();
    }
}