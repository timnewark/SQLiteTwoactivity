package com.example.sqlitetwoactivity;

import android.util.Log;


public class searchNumber{
    public String mSearchNumber;

    public searchNumber(String nameString2) {
        this.mSearchNumber = nameString2;
    }

//constructor

// constructor end

    // getter and setter
    public String getSearchNumber() { //The get method returns the value of the variable.
        Log.i("GET SearchNumber  is " , mSearchNumber);
        return mSearchNumber;

    }

    public void setSearchNumber(String mSearchNumber) { //The set method takes a parameter  and assigns it to the name variable. The this keyword is used to refer to the current object.
        Log.i("setSearchNumber  is " , mSearchNumber);
        this.mSearchNumber = mSearchNumber;
        Log.i("setSearchNumber  is " , mSearchNumber);
    }
// getter and setter end

}

