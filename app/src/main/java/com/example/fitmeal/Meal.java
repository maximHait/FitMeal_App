package com.example.fitmeal;

import androidx.annotation.NonNull;

public class Meal
{
    private String imgName;
    private String mealName;
    private int cla;

    public Meal(String imgName, String name, int cal)
    {
        this.cla = cal;
        this.mealName = name;
        this.imgName = imgName;
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

    @Override
    public String toString() {
        return "Meal{" +
                "imgName='" + imgName + '\'' +
                ", mealName='" + mealName + '\'' +
                ", cla=" + cla +
                '}';
    }
}
