package com.htech;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Base64;
import android.util.Log;

import com.facebook.FacebookSdk;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * SHA1 key  https://developers.facebook.com/docs/facebook-login/android/v2.4
 */
public class MyApplication extends Application {

    private String TAG = MyApplication.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        FacebookSdk.sdkInitialize(getApplicationContext());
        //printHashKey();
    }

    /**
     * Call this method inside onCreate once to get your hash key
     */
    public void printHashKey() {
        try {
            PackageInfo info = getPackageManager().getPackageInfo("com.hemant.directory", PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.e("SHA Key", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {
            Log.d(TAG, "Error:" + e);

        } catch (NoSuchAlgorithmException e) {
            Log.d(TAG, "Error:" + e);

        }
    }
}
