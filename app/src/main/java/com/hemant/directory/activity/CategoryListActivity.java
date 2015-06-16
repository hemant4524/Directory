package com.hemant.directory.activity;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.hemant.directory.R;
import com.hemant.directory.fragment.CategoryFragment;

/**
 * Created by software on 6/15/15.
 */
public class CategoryListActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.categorylist_layout);

        if(savedInstanceState == null) {
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            CategoryFragment categorylistFragment = new CategoryFragment();
            ft.add(R.id.categorylist_fragment, categorylistFragment, "categorylist_fragment");
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}
