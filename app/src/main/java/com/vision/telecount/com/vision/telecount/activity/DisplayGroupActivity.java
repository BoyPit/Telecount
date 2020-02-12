package com.vision.telecount.com.vision.telecount.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.vision.telecount.R;
import com.vision.telecount.com.vision.telecount.entity.Group;
import com.vision.telecount.com.vision.telecount.entity.GroupCard;
import com.vision.telecount.com.vision.telecount.entity.Payment;
import com.vision.telecount.com.vision.telecount.entity.User;
import com.vision.telecount.com.vision.telecount.entity.listPayement;

import java.io.Serializable;
import java.util.ArrayList;

public class DisplayGroupActivity extends AppCompatActivity {

    ListView list;
    ArrayList<User>   users;
    User   currentUser;
    Group currentGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.displaygroup);
        setTitle("Titre de l'Evenement");

        Intent intent = getIntent();

        currentGroup = (Group) intent.getExtras().get("currentGroup");
        users = (ArrayList<User>) intent.getExtras().get("users");
           currentUser = (User) intent.getExtras().get("currentUser");

        listPayement listAdapter = new listPayement(this,(ArrayList<Payment>) currentGroup.getPayments());

        list = (ListView) findViewById(R.id.list);

        list.setAdapter(listAdapter);



        FloatingActionButton bt =    (FloatingActionButton) findViewById(R.id.floating_action_button);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LinearLayout mainL;


                    Intent intent2 = new Intent(getBaseContext(), AddPayementActivity.class);
                    intent2.putExtra("currentUser", currentUser);
                    intent2.putExtra("currentGroup", currentGroup);
                    intent2.putExtra("users",users);
                    startActivity(intent2);


               // startActivity(new );

            }
        });

    }
}
