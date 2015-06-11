package com.hemant.directory.util;// on error the server sends JSON
/*
 { "error": { "data": { "message":"A thing went wrong" } } } 
*/
 
// create model classes..
 
public class ErrorResponse {
    Error error;

    public static class Error {
        Data data;

        public static class Data {
            String message;
        }

    }
}