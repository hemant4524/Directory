package com.hemant.directory;

import android.app.Application;

import com.parse.Parse;
import com.raizlabs.android.dbflow.config.FlowManager;

/**
 * Created by software on 6/19/15.
 */
public class DirectoryApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        FlowManager.init(this);
        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);

        Parse.initialize(this, "bHsK1pfV8uAfWk1yYDo7Dj4CGc1UxxbM6PIbdxx1", "JtgmTz1J8Ebl2VBB9sq13RwtFjXo5XmJGBwxCPV5");

    }
}

