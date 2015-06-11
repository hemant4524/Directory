package com.hemant.directory.activity;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.hemant.directory.R;
import com.hemant.directory.fragment.HomeFragment;

/**
 * Created by software on 6/11/15.
 */
public class HomeScreenActivity  extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.homescreen_layout);

        if(savedInstanceState == null) {
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            HomeFragment homeFragment = new HomeFragment();
            ft.add(R.id.fragment, homeFragment, "Home_Fragment");
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        }

    }
}
