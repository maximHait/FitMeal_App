package com.example.fitmeal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.button2:
                Intent i = new Intent(this, RecommendMeals.class);
                startActivity(i);
                break;
            default:
                break;

        }
    }
}