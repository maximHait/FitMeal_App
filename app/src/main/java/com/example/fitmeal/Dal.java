package com.example.fitmeal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;

public class Dal extends SQLiteAssetHelper {
    public Dal(Context context) {
        super(context, "database.db", null, 1);
    }

    public void addContact(User user)
    {
        SQLiteDatabase db = getWritableDatabase();
        String sql_INSERT = "INSERT INTO Users (username, password, age, height, weight, gender, activity, vegeterian, calorie, address) values(?,?,?,?,?,?,?,?,?,?)";
        SQLiteStatement statement = db.compileStatement(sql_INSERT);

        statement.bindString(1, user.getname());
        statement.bindString(2, user.getPassword());
        statement.bindLong(3, user.getAge());
        statement.bindLong(4, user.getHeight());
        statement.bindLong(5, user.getWeight());
        statement.bindLong(6, user.getGender());
        statement.bindLong(7, user.getActivityLevel());
        statement.bindLong(8, user.getVeg());
        statement.bindLong(9, user.getCalorieGoal());
        statement.bindString(10, user.getAddress());

        statement.execute();
        db.close();
    }
    public void addMeal(String name, String ingredients, int calories, int vegeterian, int price)
    {
        SQLiteDatabase db = getWritableDatabase();
        String sql_INSERT = "INSERT INTO Meals (name, ingredients, calories, vegeterian, price) values(?,?,?,?,?)";
        SQLiteStatement statement = db.compileStatement(sql_INSERT);

        statement.bindString(1, name);
        statement.bindString(2, ingredients);
        statement.bindLong(3, calories);
        statement.bindLong(7, vegeterian);
        statement.bindLong(9, price);

        statement.execute();
        db.close();
    }

    public User getUsernameAndPassword(String name, String password)
    {
        SQLiteDatabase db = getWritableDatabase();
        String sql_SELECT = "SELECT * FROM Users WHERE username='"+name+"' AND password='" + password +"'";
        Cursor cursor = db.rawQuery(sql_SELECT, null);
        int age=0, height=0, weight=0, veg=0, activity=0, gender=0;
        String username="", pass="", address="";
        while (cursor.moveToNext())
        {
            username = cursor.getString(cursor.getColumnIndex("username"));
            pass = cursor.getString(cursor.getColumnIndex("password"));
            age = cursor.getInt(cursor.getColumnIndex("age"));
            height = cursor.getInt(cursor.getColumnIndex("height"));
            weight = cursor.getInt(cursor.getColumnIndex("weight"));
            veg = cursor.getInt(cursor.getColumnIndex("vegeterian"));
            activity = cursor.getInt(cursor.getColumnIndex("activity"));
            gender = cursor.getInt(cursor.getColumnIndex("gender"));
//        int calorie = cursor.getInt(cursor.getColumnIndex("calorie"));
            address = cursor.getString(cursor.getColumnIndex("address"));

            User user = new User(username, pass, age, height, weight, gender, veg, activity, address);
            cursor.close();
            db.close();
            return user;
        }
        cursor.close();
        db.close();
        return null;
    }
//    public User getUser(String name)
//    {
//        SQLiteDatabase db = getWritableDatabase();
//        String sql_SELECT = "SELECT * FROM Users WHERE username = '"+name+"'";
//        Cursor cursor = db.rawQuery(sql_SELECT, null);
//        String username;
//        String pass;
//        int age;
//
//        while(cursor.moveToNext())
//        {
//            username = cursor.getString(cursor.getColumnIndex("username"));
//            pass = cursor.getString(cursor.getColumnIndex("password"));
//            int age = cursor.getInt(cursor.getColumnIndex("age"));
//            int height = cursor.getInt(cursor.getColumnIndex("height"));
//            int weight = cursor.getInt(cursor.getColumnIndex("weight"));
//            int veg = cursor.getInt(cursor.getColumnIndex("vegeterian"));
//            int activity = cursor.getInt(cursor.getColumnIndex("activity"));
//            int gender = cursor.getInt(cursor.getColumnIndex("gender"));
////        int calorie = cursor.getInt(cursor.getColumnIndex("calorie"));
//            String address = cursor.getString(cursor.getColumnIndex("address"));
//        }
//
//        User user = new User(username, pass, age, height, weight, gender, veg, activity, address);
//        cursor.close();
//        db.close();
//        return user;UPDATE table_name
//SET username= value1, password = value2, age = age, weight = weight, height = height, age = age, veg = veg, gender = gender, activity = activity, address = address, calorie = calorie
//WHERE username = username;
//    }

    public void updateUser(User user)
    {
        SQLiteDatabase db = getWritableDatabase();
        String sql_SELECT = "UPDATE Users SET username='" +user.getname()+"', password='" + user.getPassword()+"', age='" + String.valueOf(user.getAge())+"', weight = '" + String.valueOf(user.getWeight())+"', height = '" + String.valueOf(user.getHeight())+"', vegeterian = '" + String.valueOf(user.getVeg())+"', gender = '" + String.valueOf(user.getGender())+"', activity = '" + String.valueOf(user.getActivityLevel())+"', address = '" + user.getAddress()+"', calorie = '" + String.valueOf(user.getCalorieGoal())+"' WHERE username = '"+user.getname()+"' AND password='" + user.getPassword() +"'";
        Cursor cursor = db.rawQuery(sql_SELECT, null);
        cursor.close();
        db.close();
    }
    public int getUserId(String username)
    {
        SQLiteDatabase db = getWritableDatabase();
        String sql_SELECT = "SELECT * FROM Users WHERE username='"+username+"'";
        Cursor cursor = db.rawQuery(sql_SELECT, null);
        int id = 0;
        while (cursor.moveToNext())
        {
            id = cursor.getInt(cursor.getColumnIndex("_id"));
        }
        cursor.close();
        db.close();
        return id;
    }
//    public void updateUser(User user) {
//
//        // calling a method to get writable database.
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//
//        // on below line we are passing all values
//        // along with its key and value pair.
//        values.put(NAME_COL, courseName);
//        values.put(DURATION_COL, courseDuration);
//        values.put(DESCRIPTION_COL, courseDescription);
//        values.put(TRACKS_COL, courseTracks);
//
//        // on below line we are calling a update method to update our database and passing our values.
//        // and we are comparing it with name of our course which is stored in original name variable.
//        db.update(TABLE_NAME, values, "name='" + user.getname() +"'", new String[]{originalCourseName});
//        db.close();
//    }
    public ArrayList<Meal> getMeals()
    {
        SQLiteDatabase db = getWritableDatabase();
        String sql_SELECT = "SELECT * FROM Meals ";
        ArrayList<Meal> meals = new ArrayList<Meal>();
        Cursor cursor = db.rawQuery(sql_SELECT, null);
        while (cursor.moveToNext())
        {
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String ingredients = cursor.getString(cursor.getColumnIndex("ingredients"));
            int calories = cursor.getInt(cursor.getColumnIndex("calories"));
            int veg = cursor.getInt(cursor.getColumnIndex("vegeterian"));
            int price = cursor.getInt(cursor.getColumnIndex("price"));
            //Bitmap img = BitmapFactory.decodeByteArray(cursor.getBlob(cursor.getColumnIndex("img")), 0, cursor.getBlob(cursor.getColumnIndex("img")).length);

            Meal meal = new Meal(name, ingredients, calories, veg, price);
            meals.add(meal);
        }
        cursor.close();
        db.close();
        return meals.size() == 0 ? null : meals;
    }

}
