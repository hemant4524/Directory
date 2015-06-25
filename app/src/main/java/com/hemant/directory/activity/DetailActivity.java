package com.hemant.directory.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.hemant.directory.R;

/**
 * Created by software on 6/16/15.
 */
public class DetailActivity extends AppCompatActivity {
    private Toolbar mToolbar;
    private String TAG = DetailActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_layout);

       // String call_from = getIntent().getExtras().getString(AppConstant.CALL_FROM);

      //  Log.i(TAG,call_from);

        initView();
        if (mToolbar != null) {
            //setSupportActionBar(mToolbar);
            mToolbar.setNavigationIcon(R.drawable.ic_nav_back);
            mToolbar.setTitle("Contact Detail");
            //getSupportActionBar().setTitle("Popular");
            //mToolbar.setLogo(R.drawable.ic_launcher);
            mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });
        }
    }

    /**
     * Initialize toolbar
     */
    private void initView() {

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
    }


}
