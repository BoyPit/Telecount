package com.vision.telecount.com.vision.telecount.activity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import com.vision.telecount.R;
import com.vision.telecount.com.vision.telecount.entity.Group;
import com.vision.telecount.com.vision.telecount.entity.Payment;
import com.vision.telecount.com.vision.telecount.entity.User;

import java.io.Serializable;
import java.util.ArrayList;

public class AddPayementActivity extends AppCompatActivity {

    private User currentUser;
    private Group currentGroup;
    ArrayList<User>   users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addpayement);


        Intent intent = getIntent();

        currentGroup = (Group) intent.getExtras().get("currentGroup");
        currentUser = (User) intent.getExtras().get("currentUser");
        users = (ArrayList<User>) intent.getExtras().get("users");

        MaterialButton bt =    (MaterialButton) findViewById(R.id.add);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextInputLayout labelLayout = (TextInputLayout) findViewById(R.id.title);
                TextInputLayout montantLayout = (TextInputLayout) findViewById(R.id.montant);


                users.get(users.indexOf(currentUser)).getGroups().get(users.get(users.indexOf(currentUser)).getGroups().indexOf(currentGroup))
                        .addPayment(Integer.valueOf(montantLayout.getEditText().getText().toString()),users.get(users.indexOf(currentUser)),labelLayout.getEditText().getText().toString());
                //currentGroup.addPayment(Integer.valueOf(montantLayout.getEditText().getText().toString()),currentUser,labelLayout.getEditText().getText().toString());
                Intent intent = new Intent(getBaseContext(), DisplayGroupActivity.class);
                intent.putExtra("users", (Serializable) users);
                intent.putExtra("currentUser", currentUser);
                intent.putExtra("currentGroup", currentGroup );

                startActivity(intent);

                // startActivity(new );

            }
        });


    }
}