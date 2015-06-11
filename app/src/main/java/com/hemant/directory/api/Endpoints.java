package com.hemant.directory.api;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.GET;

public interface Endpoints {
        @GET("/foo/bar")
        void getGoogle(Callback<Response> callback);
    }
