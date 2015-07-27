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

import java.util.ArrayList;

/**
 * https://developer.android.com/training/volley/request-custom.html
 * <p/>
 * making a GSON request using volley
 * http://stackoverflow.com/questions/24537875/making-a-gson-request-using-volley
 * Tag>list
 * http://stackoverflow.com/questions/24529973/parsing-and-storing-a-json-response-in-android
 * <p/>
 * Error code in volley
 * http://stackoverflow.com/questions/22948006/http-status-code-in-android-volley-when-error-networkresponse-is-null
 * http://stackoverflow.com/questions/27579468/error-no-internet-connection-when-using-volley
 */
public class LoginActivity extends AppCompatActivity implements Response.ErrorListener, Response.Listener {
    private ProgressDialog pDialog;
    private String TAG = LoginActivity.class.getSimpleName();
    private static int REQ_CODE = 0;
    private static final int REQ_CODE_SINGLE_DATA = 1;
    private static final int REQ_CODE_MULTIPLE_DATA = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Parse json response
        //jsonObjectRequest();

       // gsonVolleyResponseParser();

        // Json array volley request

        gsonVolleyArrayResponseParser();
    }


// Hemant

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
        if (error instanceof NoConnectionError) {
            Log.d(TAG, "No internet Access, Check your internet connection.");
        } else {
            Log.d(TAG, "Error:"+error.getMessage());
        }
    }

    @Override
    public void onResponse(Object object) {

        if (REQ_CODE_SINGLE_DATA == REQ_CODE) {
            MyContact response = (MyContact) object;
            Log.d(TAG, "test response using volley name :" + response.name);
        } else if (REQ_CODE_MULTIPLE_DATA == REQ_CODE) {
            Log.d(TAG, "Multiple data request");
            Contacts contacts = (Contacts) object;
            Log.d(TAG, "Multiple data request response ");
            for(MyContact contact : contacts.contacts)
            {
                Log.d(TAG, "name :" + contact.name);
            }

        }

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

    /**
     * Volley custom object parse
     */
    public void gsonVolleyResponseParser() {
        MyApplication myApplication = MyApplication.getInstance();
        RequestQueue queue = myApplication.getRequestQueue();
        REQ_CODE = REQ_CODE_SINGLE_DATA;
        GsonRequest<MyContact> myReq = new GsonRequest<MyContact>(WebConstant.CONTACT_API,
                MyContact.class,
                null,
                this, // use this method createMyReqSuccessListener()
                this // use this method createMyReqErrorListener()
        );
        queue.add(myReq);
    }
    /**
     * Parse json array using volley
     *   http://api.androidhive.info/contacts/
     *
     */
    /**
     * Volley custom object parse
     */
    public void gsonVolleyArrayResponseParser() {

//        pDialog = new ProgressDialog(this);
//        pDialog.setMessage("Loading...");
//        REQ_CODE = REQ_CODE_MULTIPLE_DATA;
//
//        MyApplication myApplication = MyApplication.getInstance();
//        RequestQueue queue = myApplication.getRequestQueue();
//
//        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
//                WebConstant.CONTACT_API_JSONARRAY, null,
//                new Response.Listener<JSONObject>() {
//
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        Log.d("Request", response.toString());
//                        try {
//                            response.getString("status");
//                            JSONArray array = response.getJSONArray("results");
//
//                            JSONObject id = (JSONObject)array.get(0);
//
//                            Toast.makeText(getApplicationContext(), response.getString("status"), Toast.LENGTH_LONG).show();
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                        pDialog.hide();
//
//                    }
//                }, new Response.ErrorListener() {
//
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                VolleyLog.d("Request", "Error: " + error.getMessage());
//
//                pDialog.hide();
//            }
//        }){
//            @Override
//            public Map<String, String> getHeaders() throws AuthFailureError {
//
//                HashMap<String, String> headers = new HashMap<String, String>();
//                headers.put("Content-Type", "application/json");
//
//                return headers;
//            }
//
//            @Override
//            protected Map<String, String> getParams() throws AuthFailureError {
//
//                return null;
//            }
//        };
//
//        queue.add(jsonObjReq);

        MyApplication myApplication = MyApplication.getInstance();
        RequestQueue queue = myApplication.getRequestQueue();
        REQ_CODE = REQ_CODE_MULTIPLE_DATA;
        GsonRequest<Contacts> myReq = new GsonRequest<Contacts>(WebConstant.CONTACT_API_JSONARRAY,
                Contacts.class,
                null,
                this, // use this method createMyReqSuccessListener()
                this // use this method createMyReqErrorListener()
        );
        queue.add(myReq);
    }

    class Contacts
    {
        ArrayList<MyContact> contacts ;
    }
}
