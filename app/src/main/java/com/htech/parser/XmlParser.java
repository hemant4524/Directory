package com.htech.parser;

import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by software on 7/23/15.
 * http://theopentutorials.com/tutorials/android/xml/android-simple-xmlpullparser-tutorial/
 */
public class XmlParser {

    private String text;
    private boolean insideItem;
    private String TAG = XmlParser.class.getSimpleName();

    public void parseChannelData() {
        try {
            URL url = new URL("http://www.cricinfo.com/rss/content/story/feeds/6.xml");
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(false);
            XmlPullParser parser = factory.newPullParser();
            parser.setInput(getInputStream(url), "UTF_8");

            int eventType = parser.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {

                String tagname = parser.getName();
                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        if (tagname.equalsIgnoreCase("item")) {
                            // create a new instance of employee
                            // employee = new Employee();
                        }
                        break;

                    case XmlPullParser.TEXT:
                        text = parser.getText();
                        break;

                    case XmlPullParser.END_TAG:

                        if (tagname.equalsIgnoreCase("item")) {
                            Log.d(TAG,"item object add");
                            // add employee object to list
                            //employees.add(employee);
                        } else if (tagname.equalsIgnoreCase("title")) {
                            Log.d(TAG,"title:"+text);
                            // employee.setName(text);
                        } else if (tagname.equalsIgnoreCase("description")) {
                            Log.d(TAG,"description:"+text);
                            //employee.setId(Integer.parseInt(text));
                        } else if (tagname.equalsIgnoreCase("link")) {
                            Log.d(TAG,"link:"+text);
                            //employee.setDepartment(text);
                        } else if (tagname.equalsIgnoreCase("guid")) {
                            Log.d(TAG,"guid:"+text);
                            // employee.setEmail(text);
                        } else if (tagname.equalsIgnoreCase("pubDate")) {
                            Log.d(TAG,"pubDate:"+text);
                            // employee.setType(text);
                        }

                        break;

                    default:
                        break;
                }
                eventType = parser.next();
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public InputStream getInputStream(URL url) {  //open connection to url
        try {
            return url.openConnection().getInputStream();
        } catch (IOException e) {
            return null;
        }
    }
}
