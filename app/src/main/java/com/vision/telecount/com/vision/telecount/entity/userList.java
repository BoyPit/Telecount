package com.vision.telecount.com.vision.telecount.entity;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.vision.telecount.R;

import java.util.ArrayList;

public class userList extends ArrayAdapter<User> {

    public userList(Activity context,
                    ArrayList<User> users) {
        super(context,0, users);
        //  this.context = context;
        // this.group = group;
    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        // LayoutInflater inflater = context.getLayoutInflater();
        User user = getItem(position);

        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.user_check_box, parent, false);
        }
        // View rowView= inflater.inflate(R.layout.element, null, true);
        CheckBox txtName = (CheckBox) view.findViewById(R.id.usrcb);
        txtName.setText(user.getFirstName()+" "+user.getLastName());
        return view;
    }
}