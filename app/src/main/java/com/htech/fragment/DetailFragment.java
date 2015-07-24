package com.htech.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hemant.directory.R;

public class DetailFragment extends Fragment {

    private TextView mtvDetailContent;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =   inflater.inflate(R.layout.fragment_detail, container, false);
        mtvDetailContent = (TextView) view.findViewById(R.id.frag_detail_tvDetailContent);

        return view ;
    }

    public void changeData(int index)
    {
        String[] menuDetails = getResources().getStringArray(R.array.main_menu_list_details);
        mtvDetailContent.setText(menuDetails[index]);
    }

}
