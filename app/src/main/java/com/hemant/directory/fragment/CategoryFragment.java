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
import com.hemant.directory.views.CustomCardHeader;
import com.hemant.directory.views.CustomThumb;

import java.util.ArrayList;

import it.gmariotti.cardslib.library.internal.Card;
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

        // Popular
        //Create a CardHeader
        CustomCardHeader header = new CustomCardHeader(getActivity());

        //Create a Card
        Card popular_card = new Card(getActivity());
        CustomThumb thumb = new CustomThumb(getActivity());
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
                // Embed the serialized item
//                 Start the activity
                startActivity(i);


            }
        });

        // Restaurants

        //Create a Card
        Card restaurants_card = new Card(getActivity());
        header = new CustomCardHeader(getActivity());
        header.setTitle("Restaurants");
        thumb = new CustomThumb(getActivity());
        thumb.setDrawableResource(R.drawable.ic_nearby_restaurants);
        restaurants_card.addCardThumbnail(thumb);
        //Add Header to card
        restaurants_card.addCardHeader(header);
        cards.add(restaurants_card);

        // Dentists
        //Create a Card
        Card dentists_card = new Card(getActivity());
        header = new CustomCardHeader(getActivity());
        header.setTitle("Dentists");
        thumb = new CustomThumb(getActivity());
        thumb.setDrawableResource(R.drawable.ic_nearby_dentists);
        dentists_card.addCardThumbnail(thumb);
        //Add Header to card
        dentists_card.addCardHeader(header);
        cards.add(dentists_card);

        // Dj Music
        //Create a Card
        Card taxis_card = new Card(getActivity());
        header = new CustomCardHeader(getActivity());
        header.setTitle("Dj Music");
        thumb = new CustomThumb(getActivity());
        thumb.setDrawableResource(R.drawable.ic_nearby_taxis);
        taxis_card.addCardThumbnail(thumb);
        //Add Header to card
        taxis_card.addCardHeader(header);
        cards.add(taxis_card);



        // Dj Music
        //Create a Card
        Card florists_card = new Card(getActivity());
        header = new CustomCardHeader(getActivity());
        header.setTitle("Florist");
        thumb = new CustomThumb(getActivity());
        thumb.setDrawableResource(R.drawable.ic_nearby_florists);
        florists_card.addCardThumbnail(thumb);
        //Add Header to card
        florists_card.addCardHeader(header);
        cards.add(florists_card);

        // Doctor
        //Create a Card
        Card doctors_card = new Card(getActivity());
        header = new CustomCardHeader(getActivity());
        header.setTitle("Doctor");
        thumb = new CustomThumb(getActivity());
        thumb.setDrawableResource(R.drawable.ic_nearby_doctors);
        doctors_card.addCardThumbnail(thumb);
        //Add Header to card
        doctors_card.addCardHeader(header);
        cards.add(doctors_card);


        // Medical Store
        //Create a Card
        Card medical_card = new Card(getActivity());
        header = new CustomCardHeader(getActivity());
        header.setTitle("Medical Store");
        thumb = new CustomThumb(getActivity());
        thumb.setDrawableResource(R.drawable.ic_nearby_hospitals);
        medical_card.addCardThumbnail(thumb);



        //Add Header to card
        medical_card.addCardHeader(header);


        cards.add(medical_card);


        // Graphics
        //Create a Card
        Card graphics_card = new Card(getActivity());
        header = new CustomCardHeader(getActivity());
        header.setTitle("Graphics");
        thumb = new CustomThumb(getActivity());
        thumb.setDrawableResource(R.drawable.ic_nearby_groceries);
        graphics_card.addCardThumbnail(thumb);
        //Add Header to card
        graphics_card.addCardHeader(header);
        cards.add(graphics_card);

        return  cards;

    }

}
