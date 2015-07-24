package com.htech.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.hemant.directory.R;
import com.htech.fragment.DetailFragment;

/**
 * Created by software on 7/24/15.
 */
public class DetailMenuActivity  extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailmenuactivity_layout);

        Intent intent = getIntent();
        int index = intent.getIntExtra("index", 0);

        FragmentManager manager = getSupportFragmentManager();
        DetailFragment detailFragment = (DetailFragment) manager.findFragmentById(R.id.homeactivity_fgDetail);
        if(detailFragment != null)
        {
            detailFragment.changeData(index);
        }


    }
}
