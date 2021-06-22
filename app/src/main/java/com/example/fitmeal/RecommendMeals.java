package com.example.fitmeal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RecommendMeals extends AppCompatActivity {

    ListView lstview1;
    ArrayList<Meal> aryMeals=new ArrayList<Meal>();
    User user;
    private AdapterView.OnItemClickListener lst1Listener=new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id)
        {
            //Toast.makeText(RecommendMeals.this, aryMeals.get(position).toString(), Toast.LENGTH_LONG).show();
            String grocery = (String) lstview1.getAdapter().getItem(position);
            Intent intent = new Intent(lstview1.getContext(), ingridiants.class);
            lstview1.getContext().startActivity(intent);

            //Intent meals1 = new Intent(this, ingridiants.class);
            //startActivity(meals1);

        }
    };

    private AdapterView.OnItemLongClickListener lst1LongClick = new AdapterView.OnItemLongClickListener() {
        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            /*
            final String [] shareAry = {"Meal 1", "Chicken rice", "calories: 550"};
            AlertDialog.Builder adb = new AlertDialog.Builder(RecommendMeals.this);
            adb.setTitle("Information");
            ArrayAdapter<String> arySharing = new ArrayAdapter<String>(RecommendMeals.this, android.R.layout.simple_list_item_1, shareAry);

            adb.setAdapter(arySharing, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i)
                {
                    Toast.makeText(RecommendMeals.this, shareAry[i], Toast.LENGTH_SHORT).show();
                }
            });
            AlertDialog ad = adb.create();
            ad.getListView().setBackgroundColor(Color.GREEN);
            ad.show();
            return true;
            */
            String grocery = (String) lstview1.getAdapter().getItem(position);
            Intent intent = new Intent(lstview1.getContext(), ingridiants.class);
            lstview1.getContext().startActivity(intent);
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend_meals);
        user = (User)getIntent().getSerializableExtra("User");
        lstview1 = findViewById(R.id.lv);
        getMealData();
        MealAdapter ma = new MealAdapter(this, R.layout.meal, aryMeals);

        lstview1.setAdapter(ma);
        lstview1.setOnItemClickListener(lst1Listener);
        lstview1.setOnItemLongClickListener(lst1LongClick);

    }

    public void getMealData() {
        Bitmap chicken = BitmapFactory.decodeResource(getResources(), R.drawable.fitmeal);
        Meal m = new Meal("Meal 1", "Chicken", 550, chicken);
        aryMeals.add(m);
        Bitmap RiceMeal = BitmapFactory.decodeResource(getResources(), R.drawable.rice_meal);
        Meal m1 = new Meal("Meal 2", "rice", 600, RiceMeal);
        aryMeals.add(m1);
        Bitmap broccoli = BitmapFactory.decodeResource(getResources(), R.drawable.broccoli_meal);
        Meal m2 = new Meal("Meal 3", "broccolie", 620, broccoli);
        aryMeals.add(m2);
        Bitmap pottato = BitmapFactory.decodeResource(getResources(), R.drawable.pottato);
        Meal m3 = new Meal("Meal 4", "pottato", 500, pottato);
        aryMeals.add(m3);
    }

    public void OnClick(View view) {

        switch(view.getId())
        {
            case (R.id.settings):
                Intent settings = new Intent(this, Settings.class);
                settings.putExtra("User", user);
                startActivity(settings);
                break;
            case R.id.meals:
                Intent meals1 = new Intent(this, ingridiants.class);
                meals1.putExtra("User", user);
                startActivity(meals1);
                break;
            case R.id.follow:
                Intent follow = new Intent(this, Follow.class);
                follow.putExtra("User", user);
                startActivity(follow);
                break;
            case R.id.btnLogOut:
                Intent logout = new Intent(this, MainActivity.class);
                startActivity(logout);
                break;
            default:
                break;

        }
    }

}