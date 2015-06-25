package com.hemant.directory.db;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by software on 6/22/15.
 */
@Database(name = AppDatabase.NAME, version = AppDatabase.VERSION)
public class AppDatabase {
    public static final String NAME = "Directory";

    public static final int VERSION = 1;
}
