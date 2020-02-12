package com.vision.telecount.com.vision.telecount.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.vision.telecount.R;
import com.vision.telecount.com.vision.telecount.entity.User;

import java.util.ArrayList;

public class AddGroupActivity extends AppCompatActivity {

    private ArrayList<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addgroup);

        Intent intent = getIntent();

        if(intent != null && intent.getExtras() != null && intent.getExtras().get("users") != null) {
            users = (ArrayList<User>) intent.getExtras().get("users");
        }

        // Bouton de connexion de l'utilisateur
        Button button = (Button) findViewById(R.id.material_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
