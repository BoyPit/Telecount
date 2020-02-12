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

public class listPayement extends ArrayAdapter<Payment> {

    public listPayement(Activity context,
                    ArrayList<Payment> users) {
        super(context,0, users);
        //  this.context = context;
        // this.group = group;
    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        // LayoutInflater inflater = context.getLayoutInflater();
        Payment payement = getItem(position);

        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.listpayement, parent, false);
        }
        // View rowView= inflater.inflate(R.layout.element, null, true);
        TextView txtTitle = (TextView) view.findViewById(R.id.intitule);
        TextView txtDesc = (TextView) view.findViewById(R.id.description);

        txtTitle.setText(payement.getLabel());
        txtDesc.setText(payement.getUser().getFirstName() + " a payé "+  payement.getCash()+" €");
        return view;
    }
}