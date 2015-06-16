package com.hemant.directory.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hemant.directory.R;

import java.util.List;

import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardGridArrayAdapter;
import it.gmariotti.cardslib.library.view.base.CardViewWrapper;

public class CustomGrid extends CardGridArrayAdapter {
        public CustomGrid(Context context, List<Card> cards) {
            super(context, cards);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {


            View view = convertView;
            CardViewWrapper mCardView;
            Card mCard;

            LayoutInflater mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            //Retrieve card from items
            mCard = (Card) getItem(position);
            if (mCard != null) {

                int layout = R.layout.home_cardlayout;
                boolean recycle = false;

                //Inflate layout
                if (view == null) {
                    recycle = false;
                    view = mInflater.inflate(layout, parent, false);
                } else {
                    recycle = true;
                }

                //Setup card
                mCardView = (CardViewWrapper) view.findViewById(R.id.carddemo);
                if (mCardView != null) {
                    //It is important to set recycle value for inner layout elements
                    mCardView.setForceReplaceInnerLayout(Card.equalsInnerLayout(mCardView.getCard(),mCard));

                    //It is important to set recycle value for performance issue
                    mCardView.setRecycle(recycle);

                    //Save original swipeable value
                    boolean origianlSwipeable = mCard.isSwipeable();
                    //Set false to avoid swape card default action
                    mCard.setSwipeable(false);
                    mCardView.setCard(mCard);

                    //mCard.setSwipeable(origianlSwipeable);
                    if (origianlSwipeable)
                        Log.d(TAG, "Swipe action not enabled in this type of view");

                    //If card has an expandable button override animation
                    if (mCard.getCardHeader() != null && mCard.getCardHeader().isButtonExpandVisible()) {
                        //setupExpandCollapseListAnimation(mCardView);
                        Log.d(TAG, "Expand action not enabled in this type of view");
                    }

                    //Setup swipeable animation
                    setupSwipeableAnimation(mCard, mCardView);

                    //setupMultiChoice
                    setupMultichoice(view,mCard,mCardView,position);
                }
            }

            return view;
        }



    }

