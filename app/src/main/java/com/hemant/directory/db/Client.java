package com.hemant.directory.db;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by software on 6/22/15.
 */
@Table(databaseName = AppDatabase.NAME)
public class Client extends BaseModel{
    @Column
    @PrimaryKey(autoincrement = true)
    long id;

    @Column
    public String first_name;
    @Column
    public String middle_name;
    @Column
    public String last_name;
    @Column
    public String address;
    @Column
    public String lat;
    @Column
    public String longt;
    @Column
    public String pic_url;
    @Column
    public  String phone_number;
    @Column
    public  String mobile_number_1;
    @Column
    public  String mobile_number_2;

}
