package com.example.fitmeal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import java.io.File;
import java.io.IOException;

public class Follow extends AppCompatActivity {
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_follow);
        MediaPlayer mediaPlayer = new MediaPlayer();
        File path = android.os.Environment.getExternalStorageDirectory();
        try {
            mediaPlayer.setDataSource("C://Users//olgah//Downloads//NBA.mp3");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void btnPlay(View view)
    {
        mp.start();
    }
    public void btnStop(View view)
    {
        mp.stop();
    }
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.button3:
                Intent i = new Intent(this, RecommendMeals.class);
                startActivity(i);
                break;
            default:
                break;

        }
    }
}