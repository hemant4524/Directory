package com.hemant.directory.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.hemant.directory.R;
import com.hemant.directory.constant.AppConstant;
import com.hemant.directory.fragment.CategoryFragment;

/**
 * Created by software on 6/15/15.
 */
public class CategoryListActivity extends AppCompatActivity{
    private Toolbar mToolbar;
    private String TAG = CategoryListActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.categorylist_layout);

        String call_from = getIntent().getExtras().getString(AppConstant.CALL_FROM);
        Log.i(TAG, call_from);

        initView();
        if (mToolbar != null) {
            //setSupportActionBar(mToolbar);
            mToolbar.setNavigationIcon(R.drawable.ic_nav_back);
            mToolbar.setTitle("Popular");
            //getSupportActionBar().setTitle("Popular");
            //mToolbar.setLogo(R.drawable.ic_launcher);
            mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });
        }
        if(savedInstanceState == null) {
            Log.i(TAG, "savedInstanceState");
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            CategoryFragment categorylistFragment = new CategoryFragment();
            ft.replace(R.id.categorylist_fragment, categorylistFragment, "categorylist_fragment");
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            ft.commit();


        }
    }

    @Override
    protected void onStart() {
        super.onStart();

    }


    private void initView() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
    }
}
