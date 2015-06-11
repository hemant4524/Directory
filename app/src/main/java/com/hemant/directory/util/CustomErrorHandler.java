package com.hemant.directory.util;

import android.content.Context;
import android.util.Log;

import com.hemant.directory.R;

import retrofit.ErrorHandler;
import retrofit.RetrofitError;

/**
 * Converts the complex error structure into a single string you can get with error.getLocalizedMessage() in Retrofit error handlers.
 * Also deals with there being no network available
 * 
 * Uses a few string IDs for user-visible error messages
 *
 *  https://gist.github.com/benvium/66bf24e0de80d609dac0
 *  Below code available on this site
 */
public class CustomErrorHandler implements ErrorHandler {
    private static final String TAG = CustomErrorHandler.class.getName();
    private final Context ctx;
 
    public CustomErrorHandler(Context ctx) {
        this.ctx = ctx;
    }
 
    @Override
    public Throwable handleError(RetrofitError cause) {
        String errorDescription;
 
        if (cause.isNetworkError()) {
            errorDescription = ctx.getString(R.string.error_network);
        } else {
            if (cause.getResponse() == null) {
                errorDescription = ctx.getString(R.string.error_no_response);
            } else {
 
                // Error message handling - return a simple error to Retrofit handlers..
                try {
                    ErrorResponse errorResponse = (ErrorResponse) cause.getBodyAs(ErrorResponse.class);
                    errorDescription = errorResponse.error.data.message;
                } catch (Exception ex) {
                    try {
                        errorDescription = ctx.getString(R.string.error_network_http_error, cause.getResponse().getStatus());
                    } catch (Exception ex2) {
                        Log.e(TAG, "handleError: " + ex2.getLocalizedMessage());
                        errorDescription = ctx.getString(R.string.error_unknown);
                    }
                }
            }
        }
 
        return new Exception(errorDescription);
    }
}
 