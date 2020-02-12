package com.vision.telecount;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;

import com.google.android.material.tabs.TabLayout;
import com.vision.telecount.com.vision.telecount.entity.Group;
import com.vision.telecount.com.vision.telecount.entity.Payment;
import com.vision.telecount.com.vision.telecount.entity.User;

import java.nio.BufferUnderflowException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LogFragment.OnFragmentInteractionListener, RegisterFragment.OnFragmentInteractionListener{

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private LogFragment logFragment;
    private RegisterFragment registerFragment;

    ArrayList<User> users = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Creation auto
        Group g1 = new Group("Groupe 1", 1000, new ArrayList<User>(), new ArrayList<Payment>(), "Description  du premier groupe de paiement.");
        Group g2 = new Group("Groupe 2", 2000, new ArrayList<User>(), new ArrayList<Payment>(), "Description  du deuxieme groupe de paiement.");
        Group g3 = new Group("Groupe 3", 3000, new ArrayList<User>(), new ArrayList<Payment>(), "Description  du troisieme groupe de paiement.");

        User u1 = new User("yann.moulaire@gmail.com", "password", "Moulaire", "Yann", new ArrayList<Group>());
        User u2 = new User("arthur.pinier@gmail.com", "password", "Pinier", "Arthur", new ArrayList<Group>());
        User u3 = new User("theo.dupuis@gmail.com", "password", "Dupuis", "Theo", new ArrayList<Group>());

        u1.addGroup(g1);
        u1.addGroup(g2);
        u2.addGroup(g1);
        u2.addGroup(g2);
        u3.addGroup(g3);

        users.add(u1);
        users.add(u2);
        users.add(u3);


        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.pager);

        Bundle bundle = new Bundle();
        bundle.putSerializable("users", users);

        logFragment = new LogFragment();
        logFragment.setUsers(users);

        registerFragment = new RegisterFragment();
        registerFragment.setUsers(users);

        setViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        Intent intent = getIntent();

        if(intent != null && intent.getExtras() != null && intent.getExtras().get("users") != null) {
            users = (ArrayList<User>) intent.getExtras().get("users");
        }
    }

    private void setViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(logFragment, "Log In");
        adapter.addFragment(registerFragment, "Register");

        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }


    }
    @Override
    public void onFragmentInteraction(Uri uri){
        //you can leave it empty
    }
}
