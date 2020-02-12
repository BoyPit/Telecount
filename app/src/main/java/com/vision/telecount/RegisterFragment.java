package com.vision.telecount;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;
import com.vision.telecount.com.vision.telecount.entity.Group;
import com.vision.telecount.com.vision.telecount.entity.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RegisterFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link RegisterFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegisterFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private ArrayList<User> users;

    private AlertDialog.Builder alert;

    private OnFragmentInteractionListener mListener;

    public RegisterFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RegisterFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RegisterFragment newInstance(String param1, String param2) {
        RegisterFragment fragment = new RegisterFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        alert = new AlertDialog.Builder(getActivity());
        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                dialog.dismiss();
            }
        });
        alert.setCancelable(false);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_register, container, false);

        // Récupération des données via Intent
        /*
        if(getArguments() != null && getArguments().getSerializable("users") != null) {
            users = (ArrayList<User>) getArguments().getSerializable("users");
        }
         */

        final TextInputLayout emailLayout = (TextInputLayout)rootView.findViewById(R.id.email);
        final TextInputLayout passwordLayout = (TextInputLayout)rootView.findViewById(R.id.password);
        final TextInputLayout firstNameLayout = (TextInputLayout)rootView.findViewById(R.id.first_name);
        final TextInputLayout lastNameLayout = (TextInputLayout)rootView.findViewById(R.id.last_name);

        // Bouton de connexion de l'utilisateur
        Button button = (Button) rootView.findViewById(R.id.material_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Ajout du nouvel utilisateur

                boolean alreadyExists = false;

                String password = passwordLayout.getEditText().getText().toString();
                String firstName = firstNameLayout.getEditText().getText().toString();
                String lastName = lastNameLayout.getEditText().getText().toString();
                String email = emailLayout.getEditText().getText().toString();

                if(password.isEmpty() || firstName.isEmpty() || lastName.isEmpty() || email.isEmpty()){
                    alert.setMessage("Aucun champ ne doit rester vide.\n");
                    alert.create().show();
                }else {

                    for (User u : users) {
                        if (u.getEmail().equals(email)) {
                            alreadyExists = true;
                            break;
                        }
                    }

                    if (!alreadyExists) {

                        User newUser = new User(email, password, lastName, firstName, new ArrayList<Group>());
                        users.add(newUser);

                        emailLayout.getEditText().setText("");
                        passwordLayout.getEditText().setText("");
                        firstNameLayout.getEditText().setText("");
                        lastNameLayout.getEditText().setText("");
                        alert.setMessage("Votre compte a bien été créé.\n");
                        alert.create().show();
                    }else{
                        alert.setMessage("Un compte avec cet e-mail existe déjà.\n");
                        alert.create().show();
                    }
                }


                /*
                Bundle bundle = new Bundle();
                bundle.putSerializable("users", users);

                ViewPager viewPager = (ViewPager) view.findViewById(R.id.pager);

                Fragment logFragment = getActivity().getSupportFragmentManager().getFragments().get(0);
                logFragment.setArguments(bundle);

                Intent intent = new Intent(getActivity().getBaseContext(), MainActivity.class);
                intent.putExtra("users", users);
                startActivity(intent);
                */
            }
        });

        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }
}
