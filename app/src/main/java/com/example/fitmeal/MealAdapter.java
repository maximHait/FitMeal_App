package com.example.fitmeal;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MealAdapter extends ArrayAdapter<Meal>
{
    private Context context;
    private int mealResourceId;
    private List<Meal> objects;

    public MealAdapter(@NonNull Context context, int resource, @NonNull List<Meal> objects) {
        super(context, resource, objects);
        this.context = (RecommendMeals) context;
        this.mealResourceId = resource;
        this.objects = objects;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater li = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = li.inflate(this.mealResourceId, null);

        TextView tv1 = (TextView)v.findViewById(R.id.MealName);
        TextView tv2 = (TextView)v.findViewById(R.id.calories);
        TextView tv3 = (TextView)v.findViewById(R.id.price);
        ImageView Mealimg=(ImageView)v.findViewById(R.id.ivMeal);

        Meal m = objects.get(position);

        Mealimg.setImageBitmap(m.getBitmap());
        tv1.setText(m.getMealName());
        tv2.setText(String.valueOf(m.getCal()));
        tv3.setText(m.getPrice());

        return v;
    }

    @Override
    public int getCount()
    {
        return objects.size();
    }
}