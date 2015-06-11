package com.hemant.directory.api;

import com.hemant.directory.model.GitModel;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by software on 6/10/15.
 */
public interface GitApi {

    @GET("/users/{user}")

    public  void getFeed(@Path("user") String user, Callback<GitModel> response);
}
