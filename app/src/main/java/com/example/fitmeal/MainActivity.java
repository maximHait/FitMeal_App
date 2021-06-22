package com.example.fitmeal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    VideoView vv;
    EditText username;
    EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vv=findViewById(R.id.videoView);
        username = (EditText) findViewById(R.id.editTextTextPersonName);
        password = (EditText) findViewById(R.id.password);
        vv.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.food);
        MediaController mc = new MediaController(this);
        mc.setAnchorView(vv);
        vv.setMediaController(mc);
        vv.start();

    }

    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                Dal dal = new Dal(this);
                String name = (String)username.getText().toString();
                String pass = (String)password.getText().toString();
                User user = null;
                user = dal.getUsernameAndPassword(name, pass);
                if(user!=null) {
                    Toast.makeText(getApplicationContext(), "User logined", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(this, RecommendMeals.class);
                    i.putExtra("User", user);
                    startActivity(i);
                }
                else {
                    Toast.makeText(getApplicationContext(), "User is not Signed up", Toast.LENGTH_SHORT).show();
                    username.setText("");
                    password.setText("");
                }
                break;
            default:
                break;
        }
    }
}