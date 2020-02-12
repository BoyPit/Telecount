package com.vision.telecount.com.vision.telecount.entity;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.recyclerview.widget.ListAdapter;

import com.vision.telecount.R;

import java.util.ArrayList;
import java.util.List;


public class GroupCard extends ArrayAdapter<Group> {
   // private final Activity context;
    //private final ArrayList<Group> group;

    public GroupCard(Activity context,
                     ArrayList<Group> group) {
        super(context,0, group);
      //  this.context = context;
       // this.group = group;
    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
       // LayoutInflater inflater = context.getLayoutInflater();
        Group group = getItem(position);

        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.element, parent, false);
        }
       // View rowView= inflater.inflate(R.layout.element, null, true);
        TextView txtTitle = (TextView) view.findViewById(R.id.txt);
        TextView txtDesc = (TextView) view.findViewById(R.id.txt2);

        txtTitle.setText(group.getLabel());
        txtDesc.setText(group.getDescription());
        return view;
    }
}
