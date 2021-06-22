package com.example.fitmeal;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;

public class signUp extends AppCompatActivity {

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
        setContentView(R.layout.activity_sign_up);

        username = (EditText) findViewById(R.id.nameSettings);
        password = (EditText) findViewById(R.id.passwordSettings);
        weight = (EditText) findViewById(R.id.weightSettings);
        age = (EditText) findViewById(R.id.ageSettings);
        height = (EditText) findViewById(R.id.heightSettings);
        address = (EditText) findViewById(R.id.addressSettings);
        genderRadioGroup = findViewById(R.id.radioSex);
        vegSwitch = findViewById(R.id.vegSettings);
        activityRadioGroup = findViewById(R.id.radioGroupActivity);

        veg = 0;
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
                Intent i = new Intent(this, MainActivity.class);
                startActivity(i);
                break;
            case R.id.button14:
                user = new User(String.valueOf(username.getText()), String.valueOf(password.getText()), Integer.parseInt(age.getText().toString()), Integer.parseInt(height.getText().toString()), Integer.parseInt(weight.getText().toString()), gender, veg, activityLevel, address.getText().toString());
                Dal dal = new Dal(this);
                dal.addContact(user);
                Intent iNext = new Intent(this, RecommendMeals.class);
                iNext.putExtra("User", user);
                startActivity(iNext);
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
}