package com.example.fitmeal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class meals extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meals);
    }
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.button9:
                Intent i = new Intent(this, RecommendMeals.class);
                startActivity(i);
                break;
            case R.id.button5:
                Intent types = new Intent(this, typemeals.class);
                startActivity(types);
                break;
            default:
                break;

        }
    }
}