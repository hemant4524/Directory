package com.htech.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.WindowManager;

import com.hemant.directory.R;
import com.htech.db.DatabaseService;
import com.htech.model.Waiter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Splash screen logic
 * http://www.androidhive.info/2013/07/how-to-implement-android-splash-screen-2/
 * <p/>
 * This is splash screen
 * application start
 * Get waiter list
 */
public class SplashScreen extends Activity {
    private ArrayList<Waiter> mWaiterList = new ArrayList<Waiter>();
    private DatabaseService mDatabaseService;
    private static int SPLASH_TIME_OUT = 1000;
    private String TAG = SplashScreen.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set splash screen full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splashscreen_layout);

        LoadWaiterDetailsAsync loadWaiterDetailsAsync = new LoadWaiterDetailsAsync();
        loadWaiterDetailsAsync.execute();

    }

    /**
     * Load data from server
     */
    private class LoadWaiterDetailsAsync extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected String doInBackground(String... params) {

            // Xml parsing
            //new XmlParser().parseChannelData();

            // Load waiter detail from webservice
            //loadWaitersDetails();

            // Create database instance
            try {
                mDatabaseService = DatabaseService.getInstance(SplashScreen.this);
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (mWaiterList != null) {
//                Boolean success = mDatabaseService
//                        .insertWaiterInfoInDb(mWaiterList);
//                Log.v("Insert Successfully in Home Data", " :" + success);

            }

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            sortingWaiterData();

            new Handler().postDelayed(new Runnable() {
            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

                @Override
                public void run() {
                    // This method will be executed once the timer is over
                    // Start your app main activity
                    // Start home screen
                    Intent intent = new Intent(SplashScreen.this, HomeActivity.class);
                    startActivity(intent);
                    // close this activity
                    finish();
                }
            }, SPLASH_TIME_OUT);

        }
    }

    // Get Waiter Details From Server
    private void loadWaitersDetails() {

        Waiter waiter = new Waiter();
        waiter.setId(1);
        waiter.setName("peter");
        waiter.setPhone("9044444");
        waiter.setCity("Denmark");
        waiter.setAddress("C Address");
        mWaiterList.add(waiter);
        // 2nd waiter list
        waiter = new Waiter();
        waiter.setId(2);
        waiter.setName("john mark");
        waiter.setCity("new york");

        waiter = new Waiter();
        waiter.setId(2);
        waiter.setName("jems");
        waiter.setCity("new york");
        waiter.setPhone("5044444");
        waiter.setAddress("B Address");

        waiter = new Waiter();
        waiter.setId(2);
        waiter.setName("joff");
        waiter.setCity("London");
        waiter.setPhone("7044444");
        waiter.setAddress("A Address");
        mWaiterList.add(waiter);
    }

    /**
     * This method used to sort waiter data by name
     */
    private void sortingWaiterData() {
        // Before  sort waiter data
        for (Waiter waiter : mWaiterList) {
            Log.d(TAG, "Before sort: " + waiter.getName() + " " + waiter.getPhone() + " " + waiter.getAddress());
        }
        Collections.sort(mWaiterList);
        Log.d(TAG, "Sort Arraylist data");
        for (Waiter waiter : mWaiterList) {
            Log.d(TAG, "After sort: " + waiter.getName());
        }

        // Sort by phone number

        // Sort by phone.
        Collections.sort(mWaiterList, Waiter.COMPARE_BY_PHONE);
        for (Waiter waiter : mWaiterList) {
            Log.d(TAG, "Sort by phone: " + waiter.getName() + " " + " " + waiter.getPhone());
        }

        // Sort by address.
        Collections.sort(mWaiterList, Waiter.COMPARE_BY_ADDRESS);
        for (Waiter waiter : mWaiterList) {
            Log.d(TAG, "Sort by address: " + waiter.getName() + " " + " " + waiter.getAddress());
        }
    }




}
