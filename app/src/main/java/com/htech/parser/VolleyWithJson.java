package com.htech.parser;

/**
 * Created by software on 7/23/15.
 * http://stackoverflow.com/questions/24537875/making-a-gson-request-using-volley
 */
public class VolleyWithJson {


    // Put this code into activty
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
