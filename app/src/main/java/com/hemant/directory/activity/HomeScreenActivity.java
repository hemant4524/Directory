package com.hemant.directory.activity;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.hemant.directory.R;
import com.hemant.directory.fragment.HomeFragment;

import java.util.ArrayList;

/**
 * Created by software on 6/11/15.
 */
public class HomeScreenActivity  extends AppCompatActivity {

    private Toolbar toolbar;
    private ListView leftDrawerList;
    private DrawerLayout drawerLayout;
    private ArrayList<String> mMenulist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.homescreen_layout);
        mMenulist = new ArrayList<String>();
        mMenulist.add("Popular");
        mMenulist.add("Restaurants");
        mMenulist.add("Dentists");
        mMenulist.add("Dj Music");
        mMenulist.add("Medical Store");
        mMenulist.add("Graphics");


       // nitView();
        if (toolbar != null) {
            setSupportActionBar(toolbar);

            getSupportActionBar().setTitle("Contact Detail");
        }

        if(savedInstanceState == null) {
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            HomeFragment homeFragment = new HomeFragment();
            ft.add(R.id.fragment, homeFragment, "Home_Fragment");
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        }

    }


    private void nitView() {

        leftDrawerList = (ListView) findViewById(R.id.left_drawer);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        ArrayAdapter<String> navigationDrawerAdapter = new ArrayAdapter<String>(HomeScreenActivity.this, android.R.layout.simple_list_item_1,mMenulist);
        leftDrawerList.setAdapter(navigationDrawerAdapter);
    }
}
