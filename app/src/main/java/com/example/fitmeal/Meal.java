package com.example.fitmeal;

import android.graphics.Bitmap;

import androidx.annotation.NonNull;

public class Meal
{
    private String mealName;
    private String ingredients;
    private int calories;


    private int veg;



    private int price;
    private Bitmap bitmap;
//
    public Meal(String Name, String ingredients, int cal, int veg, int price, Bitmap bitmap)
    {
        this.calories = cal;
        this.mealName = Name;
        this.ingredients = ingredients;
        this.veg = veg;
        this.price = price;
        this.bitmap = bitmap;
    }
    public int getVeg() {
        return this.veg;
    }

    public void setMealName(String name)
    {
        this.mealName = name;
    }
    public String getMealName()
    {
        return this.mealName;
    }
    public int getCal()
    {
        return this.calories;
    }
    public void setCalories(int num)
    {
        this.calories = num;
    }
    public int getPrice() {
        return this.price;
    }
    public Bitmap getBitmap() {
        return bitmap;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "mealName='" + mealName + '\'' +
                ", cla=" + calories +
                '}';
    }
}
