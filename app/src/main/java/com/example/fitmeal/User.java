package com.example.fitmeal;

import android.content.Intent;

import java.io.Serializable;

public class User implements Serializable {
    private long id;
    private String name;
    private String password;
    private int age;
    private int height;

    public void setWeight(int weight) {
        this.weight = weight;
    }

    private int weight;
    private int calorie;

    public void setVeg(int veg) {
        this.veg = veg;
    }

    private int veg;// 1 for male 0 for female

    public void setGender(int gender) {
        this.gender = gender;
    }

    private int gender;// 1 for male 0 for female

    public void setActivityLevel(int activityLevel) {
        this.activityLevel = activityLevel;
    }

    private int activityLevel;
    private int[] meals;


    private String address;


    public User(String name, String pass, int age, int height, int weight, int gender, int veg, int level, String address)
    {
        this.name = name;
        this.password = pass;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.gender = gender;
        this.veg = veg;
        this.activityLevel = level;
        this.calorie = calcCalories(height, weight, age, gender, activityLevel);
        meals = new int[5];
        for (int i = 0; i < 5;i++)
        {
            this.meals[i] = 0;
        }
        this.address = address;
    }
    public int getVeg() {
        return this.veg;
    }
    public int getWeight() {
        return this.weight;
    }
    public int getGender() {
        return this.gender;
    }

//    public User(String name, String pass)
//    {
//        this.name = name;
//        this.password = pass;
//        this.age = 0;
//        this.height = 0;
//        this.weight = 0;
//        this.gender = 0;
//        this.veg = 0;
//        this.activityLevel = 0;
//        this.calorie = 0;
//        for (int i = 0; i < 5;i++)
//        {
//            this.meals[i] = 0;
//        }
//    }

    public String getname() {
        return this.name;
    }

    public String getPassword() {
        return this.password;
    }

    public int getAge() {
        return this.age;
    }

    public int getCalorieGoal() {
        return this.calorie;
    }

    public int getHeight() {
        return this.height;
    }

    public void setname(String name) {
        this.name = name;
    }

    public void setPassword(String pass) {
        this.password = pass;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setCalorieGoal(int calorieGoal) {
        this.calorie = calorieGoal;
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

    public void calcCaloriesAgain() {
        int BMR = (int) (10 * this.weight + 6.25 * this.height + -5 * this.age);
        if(this.gender == 0)
        {
            BMR -= 116;
        }
        else if(this.gender == 1)
        {
            BMR +=5;
        }

        switch(this.activityLevel)
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
        this.calorie = BMR;
    }


    public int getActivityLevel() {
        return this.activityLevel;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + this.name + '\'' +
                ", age=" + this.age +
                ", height=" + this.height +
                ", calorieGoal=" + this.calorie +
                '}';
    }

    public String getAddress() {
        return this.address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

}
