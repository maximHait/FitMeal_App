package com.example.fitmeal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;

public class Dal extends SQLiteAssetHelper {
    public Dal(Context context) {
        super(context, "database.db", null, 1);
    }

    public void addContact(String username, String password, int age, int height, int weight, int gender, int activity, int veg, int calorie, String address)
    {
        SQLiteDatabase db = getWritableDatabase();
        String sql_INSERT = "INSERT INTO Users (username, password, age, height, weight, gender, activity, vegeterian, calorie, address) values(?,?,?,?,?,?,?,?,?,?)";
        SQLiteStatement statement = db.compileStatement(sql_INSERT);

        statement.bindString(1, username);
        statement.bindString(2, password);
        statement.bindLong(3, age);
        statement.bindLong(4, height);
        statement.bindLong(5, weight);
        statement.bindLong(6, gender);
        statement.bindLong(7, activity);
        statement.bindLong(8, veg);
        statement.bindLong(9, calorie);
        statement.bindString(10, address);

        statement.execute();
    }
    public void addMeal(String name, String ingredients, int calories, int protein, int carbs, int fats, int vegeterian, int kosher, int price, byte[] img)
    {
        SQLiteDatabase db = getWritableDatabase();
        String sql_INSERT = "INSERT INTO Meals (name, ingredients, calories, protein, carbs, fats, vegeterian, kosher, price, img) values(?,?,?,?,?,?,?,?,?,?)";
        SQLiteStatement statement = db.compileStatement(sql_INSERT);

        statement.bindString(1, name);
        statement.bindString(2, ingredients);
        statement.bindLong(3, calories);
        statement.bindLong(4, protein);
        statement.bindLong(5, carbs);
        statement.bindLong(6, fats);
        statement.bindLong(7, vegeterian);
        statement.bindLong(8, kosher);
        statement.bindLong(9, price);
        statement.bindBlob(10, img);

        statement.execute();
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
        String sql_SELECT = "UPDATE Users SET username='" +user.getname()+"', password='" + user.getPassword()+"', age='" +user.getAge()+"', weight = '" + user.getWeight()+"', height = '" + user.getHeight()+"', veg = '" + user.getVeg()+"', gender = '" + user.getGender()+"', activity = '" + user.getActivityLevel()+"', address = '" + user.getAddress()+"', calorie = '" + user.getCalorieGoal()+"' WHERE username = '"+user.getname()+"' AND password='" + user.getPassword() +"'";
        Cursor cursor = db.rawQuery(sql_SELECT, null);
        cursor.close();
        db.close();
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

}
