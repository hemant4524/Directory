package com.hemant.directory;

import android.os.AsyncTask;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by software on 6/10/15.
 */
public class JsoupClass {
    String url ="http://wap.milb.com/t517/scores";
    public static void main(String args[])
    {
        try {
            Document doc = Jsoup.connect("http://www.yahoo.com").get();
            Element element = doc.getElementById("html");

            System.out.println("element:"+element.html());

        } catch (IOException e) {
            // Never e.printStackTrace(), it cuts off after some lines and you'll
            // lose information that's very useful for debugging. Always use proper
            // logging, like Android's Log class, check out
            // http://developer.android.com/tools/debugging/debugging-log.html
         System.out.println("exception:"+e);
            // Also tell the user that something went wrong (keep it simple,

        }
    }

    class JobService extends AsyncTask<Void, Void, String>
    {
        Elements elements;

        @Override
        protected String doInBackground(Void... voids) {
            try {
                // Connect to the web site
                org.jsoup.nodes.Document document = Jsoup.connect(url).get();
                // Get the html document title
//                 elements = document.getElementById("main");
                elements = document.getElementsByClass("app_web");
                elements.select("header").first().remove();




            } catch (IOException e) {
                // e.printStackTrace();
            } catch(NullPointerException ex){
                // System.out.println(ex);
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            //mWebView.loadData( elements.toString(), "text/html", "utf-8");

        }
    }
    // Structure your code. If it's a larger block that does one thing,
    // extract it into a method.
    private void getHtmlCode() {
        try {
            Document doc = Jsoup.connect("http://www.yahoo.com").get();

        } catch (IOException e) {
            // Never e.printStackTrace(), it cuts off after some lines and you'll
            // lose information that's very useful for debugging. Always use proper
            // logging, like Android's Log class, check out
            // http://developer.android.com/tools/debugging/debugging-log.html
            Log.e("", "Failed to load HTML code", e);
            // Also tell the user that something went wrong (keep it simple,
            // no stacktraces):

        }
    }

}
