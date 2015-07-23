package com.htech.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.android.volley.NoConnectionError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.hemant.directory.R;
import com.htech.MyApplication;
import com.htech.common.WebConstant;
import com.htech.model.MyContact;
import com.htech.parser.GsonRequest;

/**
 * https://developer.android.com/training/volley/request-custom.html
 * <p/>
 * making a GSON request using volley
 * http://stackoverflow.com/questions/24537875/making-a-gson-request-using-volley
 * Tag>list
 * http://stackoverflow.com/questions/24529973/parsing-and-storing-a-json-response-in-android
 *
 * Error code in volley
 * http://stackoverflow.com/questions/22948006/http-status-code-in-android-volley-when-error-networkresponse-is-null
 * http://stackoverflow.com/questions/27579468/error-no-internet-connection-when-using-volley
 *
 */
public class LoginActivity extends AppCompatActivity implements Response.ErrorListener, Response.Listener {
    private ProgressDialog pDialog;
    private String TAG = LoginActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Parse json response
        //jsonObjectRequest();

        gsonVolleyResponseParser();
    }


    /**
     * Volley custom object parse
     */
    public void gsonVolleyResponseParser() {
        MyApplication myApplication = MyApplication.getInstance();
        RequestQueue queue = myApplication.getRequestQueue();

        GsonRequest<MyContact> myReq = new GsonRequest<MyContact>(WebConstant.CONTACT_API,
                MyContact.class,
                null,
                this, // use this method createMyReqSuccessListener()
                this // use this method createMyReqErrorListener()
        );
        queue.add(myReq);
    }

    @Override
    public void onErrorResponse(VolleyError error) {

//        NetworkResponse networkResponse = error.networkResponse;
//        if (networkResponse != null && networkResponse.statusCode == HttpStatus.SC_UNAUTHORIZED) {
//            // HTTP Status Code: 401 Unauthorized
//            Log.d(TAG, "volleyError:" + error.getMessage() + " " + HttpStatus.SC_UNAUTHORIZED);
//        } else if (networkResponse != null && networkResponse.statusCode == HttpStatus.SC_UNAUTHORIZED) {
//            // HTTP Status Code: 401 Unauthorized
//            Log.d(TAG, "volleyError:" + error.getMessage());
//        }
        if(error instanceof NoConnectionError)
        {
            Log.d(TAG, "No internet Access, Check your internet connection.");
        }

    }

    @Override
    public void onResponse(Object object) {
        MyContact response = (MyContact) object;
        Log.d(TAG, "test response using volley name :" + response.name);
    }


//    private Response.ErrorListener createMyReqErrorListener() {
//        return new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                // Do whatever you want to do with error.getMessage();
//            }
//        };
//    }
//
//    private Response.Listener<MyContact> createMyReqSuccessListener() {
//        return new Response.Listener<MyContact>() {
//            @Override
//            public void onResponse(MyContact response) {
//
//                Log.d(TAG,"custom response using volley name :"+response.name);
//                // Do whatever you want to do with response;
//                // Like response.tags.getListing_count(); etc. etc.
//            }
//        };
//    }

    // Parse webservice data
//    public void jsonObjectRequest() {
//        // Tag used to cancel the request
//        String tag_json_obj = "json_obj_req";
//
//        String url = "http://api.androidhive.info/volley/person_object.json";
//
//        pDialog = new ProgressDialog(this);
//        pDialog.setMessage("Loading...");
//        pDialog.show();
//
//        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
//                url, null,
//                new Response.Listener<JSONObject>() {
//
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        Log.d(TAG, response.toString());
//                        Gson gson = new Gson();
//                        MyContact myContact = gson.fromJson(response.toString(), MyContact.class);
//
//                        // MyContact data
//                        Log.d(TAG,""+myContact.email);
//                        pDialog.hide();
//                    }
//                }, new Response.ErrorListener() {
//
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                VolleyLog.d(TAG, "Error: " + error.getMessage());
//                // hide the progress dialog
//                pDialog.hide();
//            }
//        });
//
//        // Adding request to request queue
//        MyApplication.getInstance().addToRequestQueue(jsonObjReq, tag_json_obj);
//    }

}
