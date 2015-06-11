package com.hemant.directory;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.webkit.WebView;

import com.hemant.directory.api.Endpoints;
import com.hemant.directory.constant.WSConstant;
import com.hemant.directory.util.MyErrorHandler;

import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardHeader;
import it.gmariotti.cardslib.library.internal.CardThumbnail;
import it.gmariotti.cardslib.library.view.CardView;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MainActivity extends ActionBarActivity {
    String user = "basil2style";
    private WebView mWebView;
    String url ="http://wap.milb.com/t517/scores";
    private String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWebView = (WebView) findViewById(R.id.webview);
        mWebView.clearCache(true);
        mWebView.clearHistory();
        mWebView.getSettings().setJavaScriptEnabled(true);


        //Create a Card
        Card card = new Card(this);

        //Create a CardHeader
        CardHeader header = new CardHeader(this);

        CardThumbnail thumb = new CardThumbnail(this);
        thumb.setTitle("test");
        thumb.setDrawableResource(R.drawable.ic_nearby_popular);
        card.addCardThumbnail(thumb);

        //Add Header to card
        card.addCardHeader(header);

//Set card in the cardView
        CardView cardView = (CardView) findViewById(R.id.carddemo);

        cardView.setCard(card);

        //Retrofit section start from here...
        RestAdapter restAdapter = new RestAdapter.Builder()
          //      .setLogLevel(retrofit.RestAdapter.LogLevel.FULL) // Get full  log
                .setEndpoint(WSConstant.API).build();

//        GitApi git = restAdapter.create(GitApi.class);
//
//        git.getFeed(user, new Callback<GitModel>() {
//            @Override
//            public void success(GitModel gitModel, Response response) {
//
//                System.out.println("Github Name :"+gitModel.getName()+"\nWebsite :"+gitModel.getBlog()+"\nCompany Name :"+gitModel.getCompany());
//            }
//
//            @Override
//            public void failure(RetrofitError retrofitError) {
//               if( retrofitError.getKind().equals(RetrofitError.Kind.NETWORK))
//               {
//                   System.out.println("Error:" + retrofitError.getMessage() + " Localization message:" + retrofitError.getLocalizedMessage());
//
//               }
//
//            }
//        });


        // Custom exception
        // Internet connection error
        // 404 Page not found

         restAdapter = new RestAdapter.Builder()
                 .setEndpoint("https://www.google.com")
                 .setErrorHandler(new MyErrorHandler())
                 //.setLogLevel(RestAdapter.LogLevel.FULL)  // Do this for development too.
                 .build();

        Endpoints endpoints = restAdapter.create(Endpoints.class);

        endpoints.getGoogle(new Callback<Response>() {
            @Override
            public void success(Response response, Response response2) {

            }

            @Override
            public void failure(RetrofitError retrofitError) {
                System.err.println("Custom message from handler."+retrofitError.getMessage());
            }
        });

    }


}


