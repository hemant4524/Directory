package com.hemant.directory.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.hemant.directory.R;
import com.hemant.directory.activity.DetailActivity;
import com.hemant.directory.adapter.CategorylistAdapter;

import java.util.ArrayList;

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

    public CategoryFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_categorylist,container, false);
        mlvCategory = (CardListView) getActivity().findViewById(R.id.category_list_lvMatch);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        // Set cardgrid adapter
        ArrayList<Card> cards = createCards();
        CategorylistAdapter mCardArrayAdapter = new CategorylistAdapter(getActivity(),cards);
        if (mlvCategory !=null){
            mlvCategory.setAdapter(mCardArrayAdapter);
        }else{
            Log.d(TAG,"mlvCategory:"+mlvCategory);
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

}
