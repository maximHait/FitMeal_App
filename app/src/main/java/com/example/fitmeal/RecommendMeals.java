package com.example.fitmeal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RecommendMeals extends AppCompatActivity {
    ListView lstview1;
    ArrayList<Meal> aryMeals=new ArrayList<Meal>();
    //String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    //Spinner spinner1;
    TextView textView1;
    private AdapterView.OnItemClickListener lst1Listener=new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(RecommendMeals.this, aryMeals.get(position).toString(), Toast.LENGTH_LONG).show();
        }
    };

    //ArrayAdapter<String> aa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend_meals);
        //spinner1 = findViewById(R.id.spinner);
        textView1 = findViewById(R.id.textView123);
        //aa = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, days);
        //spinner1.setAdapter(aa);
       // spinner1.setOnItemSelectedListener(spinner1Listener);
        lstview1 = findViewById(R.id.listView1);
        getMealData();
        lstview1 = (ListView) findViewById(R.id.listView1);
        MealAdapter ma = new MealAdapter(this, R.layout.meal, aryMeals);
        lstview1.setAdapter(ma);
        lstview1.setOnItemClickListener(lst1Listener);
    }
/*
    private AdapterView.OnItemSelectedListener spinner1Listener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            textView1.setText(days[position]);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }


    };*/

    public void getMealData() {
        Meal m = new Meal("Meal 1", "Chicken", 550);
        aryMeals.add(m);
        Meal m1 = new Meal("Meal 2", "rice", 600);
        aryMeals.add(m1);
        Meal m2 = new Meal("Meal 3", "broccolie", 620);
        aryMeals.add(m2);
        Meal m3 = new Meal("Meal 4", "pottato", 500);
        aryMeals.add(m3);
    }

    public void OnClick(View view) {

        switch(view.getId())
        {
            case (R.id.settings):
                Intent settings = new Intent(this, Settings.class);
                startActivity(settings);
                break;
            case R.id.meals:
                Intent meals1 = new Intent(this, meals.class);
                startActivity(meals1);
                break;
            case R.id.follow:
                Intent follow = new Intent(this, Follow.class);
                startActivity(follow);
                break;
            default:
                break;

        }
    }
}