package com.vision.telecount.com.vision.telecount.activity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.vision.telecount.R;
import com.vision.telecount.com.vision.telecount.entity.User;

import java.util.ArrayList;

public class AddPayementActivity extends AppCompatActivity {

    private ArrayList<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addgroup);


    }
}