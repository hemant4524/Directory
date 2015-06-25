package com.hemant.directory.fragment;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.hemant.directory.R;
import com.hemant.directory.activity.DetailActivity;
import com.hemant.directory.adapter.CategorylistAdapter;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardHeader;
import it.gmariotti.cardslib.library.internal.CardThumbnail;
import it.gmariotti.cardslib.library.view.CardListView;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * create an instance of this fragment.
 */
public class CategoryFragment extends Fragment {

    private static final String TAG =CategoryFragment.class.getName() ;
    private CardListView mlvCategory;
    private ProgressDialog proDialog;
    ArrayList<Card> cards = new ArrayList<Card>();
    public CategoryFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate");


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i(TAG, "onCreate");
        View view = inflater.inflate(R.layout.fragment_categorylist,container, false);
        mlvCategory = (CardListView) getActivity().findViewById(R.id.category_list_lvMatch);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");


        ParseQuery<ParseObject> query = ParseQuery.getQuery("User");

        try {
            Log.i(TAG,"row count:"+query.count());
            // Start progress bar
            startLoading();
            query.findInBackground(new FindCallback<ParseObject>() {

                                       public void done(List<ParseObject> scoreList, ParseException e) {
                                           for (ParseObject parseObject: scoreList)
                                           {
                                               Log.i(TAG,"first_name:"+parseObject.getString("first_name"));
                                               // Popular
                                               //Create a CardHeader
                                               CardHeader header = new CardHeader(getActivity());

                                               //Create a Card
                                               Card popular_card = new Card(getActivity());
                                               CardThumbnail thumb = new CardThumbnail(getActivity());
                                               thumb.setDrawableResource(R.drawable.ic_nearby_popular);
                                               popular_card.addCardThumbnail(thumb);

                                               header.setTitle(parseObject.getString("first_name"));
                                               //Add Header to card
                                               popular_card.addCardHeader(header);

                                               cards.add(popular_card);
                                               // Set click listener
                                               popular_card.setOnClickListener(new Card.OnCardClickListener() {
                                                   @Override
                                                   public void onClick(Card card, View view) {

                                                       Toast.makeText(getActivity(),"Detail Activity",Toast.LENGTH_LONG).show();
                                                       Intent i = new Intent(getActivity(), DetailActivity.class);
                                                       //                 Start the activity
                                                       startActivity(i);


                                                   }
                                               });
                                           }

                                           CategorylistAdapter mCardArrayAdapter = new CategorylistAdapter(getActivity(),cards);
                                           if (mlvCategory !=null){
                                               mlvCategory.setAdapter(mCardArrayAdapter);
                                           }else{
                                               Log.d(TAG,"mlvCategory:"+mlvCategory);
                                           }
                                           // Stop progress bar
                                           stopLoading();
                                       }
                                   }

            );
        } catch (ParseException e) {
            e.printStackTrace();
        }



    }

    /**
     * Create dynamic card for category
     * @return cards list
     */
    public  ArrayList<Card> createCards()
    {
        ArrayList<Card> cards = new ArrayList<Card>();


        for (int i = 0; i<10;i++)
        {
            // Popular
            //Create a CardHeader
            CardHeader header = new CardHeader(getActivity());

            //Create a Card
            Card popular_card = new Card(getActivity());
            CardThumbnail thumb = new CardThumbnail(getActivity());
            thumb.setDrawableResource(R.drawable.ic_nearby_popular);
            popular_card.addCardThumbnail(thumb);

            header.setTitle("Popular");
            //Add Header to card
            popular_card.addCardHeader(header);
            cards.add(popular_card);
            // Set click listener
            popular_card.setOnClickListener(new Card.OnCardClickListener() {
                @Override
                public void onClick(Card card, View view) {

                    Toast.makeText(getActivity(),"Detail Activity",Toast.LENGTH_LONG).show();
                    Intent i = new Intent(getActivity(), DetailActivity.class);
//                 Start the activity
                    startActivity(i);


                }
            });
        }



        return  cards;

    }

    /**
     * Show progress bar
     */
    protected void startLoading() {
        proDialog = new ProgressDialog(getActivity());
        proDialog.setMessage("loading...");
        proDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        proDialog.setCancelable(false);
        proDialog.show();
    }

    protected void stopLoading() {
        proDialog.dismiss();
        proDialog = null;
    }
}
