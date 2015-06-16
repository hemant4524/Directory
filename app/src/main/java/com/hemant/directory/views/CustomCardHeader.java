package com.hemant.directory.views;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import it.gmariotti.cardslib.library.internal.CardHeader;

public class CustomCardHeader extends CardHeader
    {
        public CustomCardHeader(Context context) {
            super(context);
        }

        @Override
        public void setupInnerViewElements(ViewGroup parent, View view) {

            if(parent!=null)
            {

                // ViewGroup

                RelativeLayout.LayoutParams viewgroup_params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

                viewgroup_params.addRule(RelativeLayout.CENTER_HORIZONTAL,RelativeLayout.TRUE);
                parent.setLayoutParams(viewgroup_params);


                FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

                params.gravity = Gravity.CENTER;
                view.setLayoutParams(params);
               // view.setBackgroundResource(android.R.color.holo_orange_dark);
            }
            super.setupInnerViewElements(parent, view);
        }
    }