package com.hemant.directory.views;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import it.gmariotti.cardslib.library.internal.CardThumbnail;

public class CustomThumb extends CardThumbnail {
        public CustomThumb(Context context) {
            super(context);
        }
        @Override
        public void setupInnerViewElements(ViewGroup parent, View viewImage) {

            if (viewImage!=null){
                //viewImage.getLayoutParams().width=250;
                //viewImage.getLayoutParams().height=250;

                DisplayMetrics metrics=parent.getResources().getDisplayMetrics();
                //viewImage.getLayoutParams().width= (int)(250*metrics.density);
                //viewImage.getLayoutParams().height = (int)(250*metrics.density);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

                params.gravity = Gravity.CENTER;

                parent.setLayoutParams(params);


            }
        }


    }