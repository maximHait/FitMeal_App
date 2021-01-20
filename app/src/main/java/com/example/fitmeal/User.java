package com.example.fitmeal;

public class User {
    private String name;
    private int age;
    private float height;
    private int calorieGoal;


    User(String name, int age, float height, int calorieGoal)
    {

    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getCalorieGoal() {
        return calorieGoal;
    }

    public float getHeight() {
        return height;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setCalorieGoal(int calorieGoal) {
        this.calorieGoal = calorieGoal;
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
