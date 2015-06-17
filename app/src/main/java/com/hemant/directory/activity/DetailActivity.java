package com.hemant.directory.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import com.hemant.directory.R;

/**
 * Created by software on 6/16/15.
 */
public class DetailActivity  extends AppCompatActivity{

    private Toolbar toolbar;
    private ListView leftDrawerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_layout);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);

            getSupportActionBar().setTitle("Contact Detail");
        }



    }


}
