package com.example.fitmeal;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

public class Settings extends AppCompatActivity {

    User user;
    EditText username;
    EditText password;
    EditText age;
    EditText height;
    EditText weight;
    int gender;
    RadioGroup genderRadioGroup;// 1 for male 0 for female
    RadioButton genderRadioButton;
    int veg;
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    Switch vegSwitch;
    int activityLevel;
    RadioButton activityRadioButton;
    RadioGroup activityRadioGroup;
    EditText address;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        user = (User)getIntent().getSerializableExtra("User");

        username = (EditText) findViewById(R.id.nameSettings);
        password = (EditText) findViewById(R.id.passwordSettings);
        weight = (EditText) findViewById(R.id.weightSettings);
        age = (EditText) findViewById(R.id.ageSettings);
        height = (EditText) findViewById(R.id.heightSettings);
        address = (EditText) findViewById(R.id.addressSettings);
        genderRadioGroup = findViewById(R.id.radioSex);
        vegSwitch = findViewById(R.id.vegSettings);
        activityRadioGroup = findViewById(R.id.radioGroupActivity);

        username.setText(user.getname());
        password.setText(user.getPassword());
        weight.setText(String.valueOf(user.getWeight()));
        height.setText(String.valueOf(user.getHeight()));
        age.setText(String.valueOf(user.getAge()));
        address.setText(user.getAddress());
        gender = user.getGender();
        if (gender == 1)
        {
            genderRadioButton = findViewById(R.id.radioMale);
            genderRadioButton.setChecked(true);
        }
        else {
            genderRadioButton = findViewById(R.id.radioFemale);
            genderRadioButton.setChecked(true);
        }
        veg = user.getVeg();
        vegSwitch.setChecked(veg == 1);
        activityLevel = user.getActivityLevel();
        switch (activityLevel)
        {
            case 1:
                activityRadioButton = findViewById(R.id.radioNotActive);
                activityRadioButton.setChecked(true);
                break;
            case 2:
                activityRadioButton = findViewById(R.id.radioSmallActivity);
                activityRadioButton.setChecked(true);
                break;
            case 3:
                activityRadioButton = findViewById(R.id.radioActive);
                activityRadioButton.setChecked(true);
                break;
            case 4:
                activityRadioButton = findViewById(R.id.radioVeryActive);
                activityRadioButton.setChecked(true);
                break;
            case 5:
                activityRadioButton = findViewById(R.id.radioAthlete);
                activityRadioButton.setChecked(true);
                break;
            default:
                break;
        }
        vegSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    veg = 1;
                } else {
                    veg = 0;
                }
            }
        });
    }

    @SuppressLint("NonConstantResourceId")
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.button2:
                Intent i = new Intent(this, RecommendMeals.class);
                i.putExtra("User", user);
                startActivity(i);
                break;
            case R.id.button14:
                user.setname(String.valueOf(username.getText()));
                user.setPassword(String.valueOf(password.getText()));
                user.setWeight(Integer.parseInt(weight.getText().toString()));
                user.setHeight(Integer.parseInt(height.getText().toString()));
                user.setAge(Integer.parseInt(age.getText().toString()));
                user.setVeg(veg);
                user.setGender(gender);
                user.setActivityLevel(activityLevel);
                user.calcCaloriesAgain();
                user.setAddress(address.getText().toString());
                Dal dal = new Dal(this);
                dal.updateUser(user);
                break;
            case R.id.btnLogOut:
                Intent logout = new Intent(this, MainActivity.class);
                startActivity(logout);
                break;
            default:
                break;

        }
    }
    public void onRadioButtonClickedGender(View view) {
//        genderRadioGroup = findViewById(R.id.radioGroupGender);
//        int radioId = genderRadioGroup.getCheckedRadioButtonId();
//        genderRadioButton = findViewById(radioId);
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioMale:
                if (checked)
                    gender = 1;
                    break;
            case R.id.radioFemale:
                if (checked)
                    gender = 0;
                    break;
        }
    }
    @SuppressLint("NonConstantResourceId")
    public void onRadioButtonClickedActivity(View view)
    {
//        activityRadioGroup = findViewById(R.id.radioGroupActivity);
//        int radioActivity = activityRadioGroup.getCheckedRadioButtonId();
//        activityRadioButton = findViewById(radioActivity);
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.radioNotActive:
                activityLevel = 1;
                break;
            case R.id.radioSmallActivity:
                activityLevel = 2;
                break;
            case R.id.radioActive:
                activityLevel = 3;
                break;
            case R.id.radioVeryActive:
                activityLevel = 4;
                break;
            case R.id.radioAthlete:
                activityLevel = 5;
                break;
            default:
                break;
        }
    }

//    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//        Toast.makeText(this, "The vegeterian Switch is " + (isChecked ? "on" : "off"),
//                Toast.LENGTH_SHORT).show();
//        if(isChecked) {
//            veg = 1;
//        } else {
//            veg = 0;
//        }
//    }
}