package com.hemant.directory.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hemant.directory.R;

/**
 * Created by software on 6/15/15.
 */
public class PopulerItemDetailFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate view
        View view = inflater.inflate(R.layout.fragment_populeritem_detail,
                container, false);
        // Return view
        return view;
    }
}
