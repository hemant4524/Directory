package com.hemant.directory.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hemant.directory.R;

import java.util.ArrayList;

import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardGridArrayAdapter;
import it.gmariotti.cardslib.library.internal.CardHeader;
import it.gmariotti.cardslib.library.internal.CardThumbnail;
import it.gmariotti.cardslib.library.view.CardGridView;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        return inflater.inflate(R.layout.fragment_home,container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        ArrayList<Card> cards = new ArrayList<Card>();



        // Popular
        //Create a CardHeader
        CardHeader header = new CardHeader(getActivity());

        //Create a Card
        Card card = new Card(getActivity());


        CardThumbnail thumb = new CardThumbnail(getActivity());
        thumb.setTitle("test");
        card.addCardThumbnail(thumb);

        header.setTitle("Popular");
        //Add Header to card
        card.addCardHeader(header);
        cards.add(card);

        // Restaurants

        header = new CardHeader(getActivity());
        header.setTitle("Restaurants");

        //Create a Card
         card = new Card(getActivity());
        //Add Header to card
        card.addCardHeader(header);
        cards.add(card);


        // Dentists

        header = new CardHeader(getActivity());
        header.setTitle("Dentists");

        //Create a Card
        card = new Card(getActivity());
        //Add Header to card
        card.addCardHeader(header);
        cards.add(card);

        // Dj Music

        header = new CardHeader(getActivity());
        header.setTitle("Dj Music");
        //Create a Card
        card = new Card(getActivity());
        //Add Header to card
        card.addCardHeader(header);
        cards.add(card);



        // Dj Music

        header = new CardHeader(getActivity());
        header.setTitle("Florist");
        //Create a Card
        card = new Card(getActivity());
        //Add Header to card
        card.addCardHeader(header);
        cards.add(card);

        // Doctor

        header = new CardHeader(getActivity());
        header.setTitle("Doctor");
        //Create a Card
        card = new Card(getActivity());
        //Add Header to card
        card.addCardHeader(header);
        cards.add(card);


        // Medical Store

        header = new CardHeader(getActivity());
        header.setTitle("Medical Store");

        //Create a Card
        card = new Card(getActivity());
        //Add Header to card
        card.addCardHeader(header);
        cards.add(card);


        // Graphics

        header = new CardHeader(getActivity());
        header.setTitle("Graphics");
        //Create a Card
        card = new Card(getActivity());
        //Add Header to card
        card.addCardHeader(header);
        cards.add(card);

        CardGridArrayAdapter mCardArrayAdapter = new CardGridArrayAdapter(getActivity(),cards);

        CardGridView gridView = (CardGridView) getActivity().findViewById(R.id.myGrid);
        if (gridView!=null){
            gridView.setAdapter(mCardArrayAdapter);
        }
    }
}
