package com.vision.telecount.com.vision.telecount.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;

import com.google.android.material.textfield.TextInputLayout;
import com.vision.telecount.R;
import com.vision.telecount.com.vision.telecount.entity.Group;
import com.vision.telecount.com.vision.telecount.entity.Payment;
import com.vision.telecount.com.vision.telecount.entity.Group;
import com.vision.telecount.com.vision.telecount.entity.User;
import com.vision.telecount.com.vision.telecount.entity.userList;

import java.util.ArrayList;

public class AddGroupActivity extends AppCompatActivity {
    ListView list;
    private ArrayList<User> users;
    private User currentUser;
    private ArrayList<User> groupUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addgroup);

        Intent intent = getIntent();

        if(intent != null && intent.getExtras() != null && intent.getExtras().get("users") != null) {
            users = (ArrayList<User>) intent.getExtras().get("users");
            currentUser = (User) intent.getExtras().get("currentUser");
        }
        else
        {
            users = new ArrayList<User>();
        }

        userList listUser = new userList(this, users);

        final TextInputLayout labelLayout = (TextInputLayout) findViewById(R.id.label);
        final TextInputLayout descriptionLayout = (TextInputLayout) findViewById(R.id.description);

        list = (ListView) findViewById(R.id.list);

        list.setAdapter(listUser);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                if(((CheckBox)view.findViewById(R.id.usrcb)).isChecked()){
                    groupUsers.add(users.get(position));
                }else {
                    groupUsers.remove(users.get(position));
                }
            }
        });
        // Bouton de connexion de l'utilisateur
        Button button = (Button) findViewById(R.id.material_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String label = labelLayout.getEditText().getText().toString();
                String description = descriptionLayout.getEditText().getText().toString();

                if(!label.isEmpty()){
                    Group group = new Group(label, description, 0, groupUsers, new ArrayList<Payment>());
                }else{

                }
            }
        });
    }
}
