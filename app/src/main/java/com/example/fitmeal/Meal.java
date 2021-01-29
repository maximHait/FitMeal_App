package com.example.fitmeal;

import android.graphics.Bitmap;

import androidx.annotation.NonNull;

public class Meal
{
    private String imgName;
    private String mealName;
    private int cla;
    private Bitmap bitmap;

    public Meal(String imgName, String name, int cal, Bitmap bitmap)
    {
        this.cla = cal;
        this.mealName = name;
        this.imgName = imgName;
        this.bitmap = bitmap;
    }

    public String getImgName()
    {
        return this.imgName;
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
        return this.cla;
    }
    public void setTime(int num)
    {
        this.cla = num;
    }
    public Bitmap getBitmap() {
        return bitmap;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "imgName='" + imgName + '\'' +
                ", mealName='" + mealName + '\'' +
                ", cla=" + cla +
                '}';
    }
}
