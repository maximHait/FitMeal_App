package com.example.fitmeal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RecommendMeals extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend_meals);

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