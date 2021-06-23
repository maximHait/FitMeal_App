package com.example.fitmeal;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

import java.io.File;
import java.io.IOException;

public class  Follow extends AppCompatActivity {
    MediaPlayer mp;
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_follow);
        mp = MediaPlayer.create(this, R.raw.nba);
        user = (User)getIntent().getSerializableExtra("User");

        new Check().execute();
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
    public boolean checkFinished()
    {

        for (int i = 0; i < 5; i++) {
            if(user.getMeals()[i] == 0)
                return false;
        }
        return true;
    }
    private class Check extends AsyncTask<Void, Void, Void> {
        boolean flag;
        Check()
        {
            this.flag = false;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            final long time = System.currentTimeMillis();
            while (time + (1 * 55) > System.currentTimeMillis())
            {
                if(checkFinished())
                {
                    return null;
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result)
        {

            AlertDialog.Builder adb = new AlertDialog.Builder(Follow.this);
            adb.setTitle("WOW You finished your Meals for today");
            AlertDialog ad = adb.create();
            ad.show();
        }
    }
}