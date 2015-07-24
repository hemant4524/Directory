package com.htech.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.hemant.directory.R;
import com.htech.fragment.DetailFragment;
import com.htech.fragment.ListFragment;

public class HomeActivity extends AppCompatActivity implements ListFragment.Communicator{

    private ListFragment mListFragment;
    private DetailFragment mDetailFragment;
    private FragmentManager mFragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homeactivity_layout);
        mFragmentManager = getSupportFragmentManager();
        mListFragment = (ListFragment) mFragmentManager.findFragmentById(R.id.homeactivity_fgMailList);


        // Set communication for list fragment
        mListFragment.setCommunicator(this);
    }
    @Override
    protected void onResume() {
        super.onResume();
    }
    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public void respond(int index) {
        mDetailFragment = (DetailFragment) mFragmentManager.findFragmentById(R.id.homeactivity_fgDetail);
        // Landscape mode
        if( mDetailFragment !=null && mDetailFragment.isVisible())
        {
            mDetailFragment.changeData(index);
        }
        else // Portrait mode
        {
            Intent intent = new Intent(HomeActivity.this,DetailMenuActivity.class);
            intent.putExtra("index",index);
            startActivity(intent);

        }
    }
}
