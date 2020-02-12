package com.vision.telecount.com.vision.telecount.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.vision.telecount.R;

import java.io.Serializable;

public class DisplayGroupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.displaygroup);
        setTitle("Titre de l'Evenement");




        FloatingActionButton bt =    (FloatingActionButton) findViewById(R.id.floating_action_button);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               // startActivity(new );

            }
        });

    }
}
