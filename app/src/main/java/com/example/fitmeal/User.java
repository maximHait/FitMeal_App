package com.example.fitmeal;

import android.content.Intent;

public class User {
    private String _name;
    private int _age;
    private int _height;
    private int _weight;
    private int _calorieGoal;
    private int _gender;// 1 for male 0 for female
    private int _activityLevel;
    private int[] _meals;


    User(String name, int age, int height, int weight, int gender, int level)
    {
        _name = name;
        _age = age;
        _height = height;
        _weight = weight;
        _gender = gender;
        _activityLevel = level;
        _calorieGoal = calcCalories(_height, _weight, _age, _gender, _activityLevel);
        for (int i = 0; i < 5;i++)
        {
            _meals[i] = 0;
        }
    }

    public String getName() {
        return _name;
    }

    public int getAge() {
        return _age;
    }

    public int getCalorieGoal() {
        return _calorieGoal;
    }

    public float getHeight() {
        return _height;
    }

    public void setName(String name) {
        this._name = name;
    }

    public void setAge(int age) {
        this._age = age;
    }

    public void setHeight(int height) {
        this._height = height;
    }

    public void setCalorieGoal(int calorieGoal) {
        this._calorieGoal = calorieGoal;
    }

    static int calcCalories(int height, int weight, int age, int gender, int level) {
        int BMR = (int) (10 * weight + 6.25 * height + -5 * age);
        if(gender == 0)
        {
            BMR -= 116;
        }
        else if(gender == 1)
        {
            BMR +=5;
        }

        switch(level)
        {
            case (1):
                BMR = (int) (BMR * 1.2);
                break;
            case 2:
                BMR = (int) (BMR * 1.375);
                break;
            case 3:
                BMR = (int) (BMR * 1.55);
                break;
            case 4:
                BMR = (int) (BMR * 1.725);
                break;
            case 5:
                BMR = (int) (BMR * 1.9);
                break;
            default:
                break;

        }
        return BMR;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", calorieGoal=" + calorieGoal +
                '}';
    }
}
