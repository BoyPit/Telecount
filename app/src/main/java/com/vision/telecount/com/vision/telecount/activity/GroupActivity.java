package com.vision.telecount.com.vision.telecount.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.vision.telecount.R;
import com.vision.telecount.com.vision.telecount.entity.Group;
import com.vision.telecount.com.vision.telecount.entity.GroupCard;
import com.vision.telecount.com.vision.telecount.entity.Payment;
import com.vision.telecount.com.vision.telecount.entity.User;

import java.util.ArrayList;

public class GroupActivity extends AppCompatActivity {
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final User user = new User();
        final Group g1 = new Group("groupe 1", "c'est le groupe 1, celui qu'on retient", 0, new ArrayList<User>(), new ArrayList<Payment>());

        final Group g2 = new Group("groupe 2", "c'est le 2ème groupe, il est beaucoup moins ouf", 0, new ArrayList<User>(), new ArrayList<Payment>());
        user.addGroup(g1);
        user.addGroup(g2);

        setContentView(R.layout.activity_main);
        GroupCard listAdapter = new GroupCard(GroupActivity.this, user.getGroups());
        list = (ListView) findViewById(R.id.list);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(GroupActivity.this, "You Clicked at " + user.getGroups().get(position), Toast.LENGTH_SHORT).show();
            }
        });

    }
}