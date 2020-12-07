package com.example.fitmeal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class RecommendMeals extends AppCompatActivity {
    String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    Spinner spinner1;
    TextView textView1;
    ArrayAdapter<String> aa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend_meals);
        spinner1 = findViewById(R.id.spinner);
        textView1 = findViewById(R.id.textView123);
        aa = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, days);
        spinner1.setAdapter(aa);
        spinner1.setOnItemSelectedListener(spinner1Listener);
    }
    private AdapterView.OnItemSelectedListener spinner1Listener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            textView1.setText(days[position]);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };

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