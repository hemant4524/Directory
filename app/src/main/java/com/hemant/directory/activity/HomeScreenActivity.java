package com.hemant.directory.activity;

import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.hemant.directory.R;
import com.hemant.directory.fragment.HomeFragment;
import com.parse.ParseObject;

import java.util.ArrayList;

/**
 * Created by software on 6/11/15.
 *
 *  http://www.nkdroid.com/2014/11/Android-Lollipop-Navigation-Drawer-Example-Using-Appcompat-21.html
 */
public class HomeScreenActivity  extends AppCompatActivity {

    private Toolbar mToolbar;
    private ListView mLeftDrawerList;
    private DrawerLayout mDrawerLayout;
    private ArrayList<String> mMenulist;
    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homescreen_layout);

        ParseObject testObject = new ParseObject("TestObject");
        testObject.put("foo", "bar");
        testObject.saveInBackground();

        mMenulist = new ArrayList<String>();
        mMenulist.add("Profile");
        mMenulist.add("Add User");
        mMenulist.add("About");
        mMenulist.add("Help");


        initView();
        if (mToolbar != null) {
            mToolbar.setTitle("Whitepages");
            setSupportActionBar(mToolbar);
        }

        if(savedInstanceState == null) {
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            HomeFragment homeFragment = new HomeFragment();
            ft.add(R.id.fragment, homeFragment, "Home_Fragment");
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        }

        initDrawer();

    }


    private void initView() {

        mLeftDrawerList = (ListView) findViewById(R.id.left_drawer);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        ArrayAdapter<String> navigationDrawerAdapter = new ArrayAdapter<String>(HomeScreenActivity.this, android.R.layout.simple_list_item_1,mMenulist);
        mLeftDrawerList.setAdapter(navigationDrawerAdapter);
    }

    private void initDrawer() {

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.drawer_open, R.string.drawer_close) {

            @Override
            public void onDrawerClosed(View drawerView) {
               // mToolbar.setTitle("Open Drawer"); // Closed drawer text
                super.onDrawerClosed(drawerView);

            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // mToolbar.setTitle("Open Drawer"); // Opened drawer text
                super.onDrawerOpened(drawerView);

            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

}
