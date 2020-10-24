package com.example.fitmeal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class typemeals extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_typemeals);
    }
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.button4:
                Intent i = new Intent(this, ingridiants.class);
                startActivity(i);
                break;
            default:
                break;

        }
    }
}