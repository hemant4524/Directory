package com.htech.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.hemant.directory.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment implements AdapterView.OnItemClickListener {

    private Communicator communicator;
    private ListView mlvMain;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        mlvMain = (ListView) view.findViewById(R.id.fragmentlist_lvMain);
        ArrayAdapter arrayAdapter = ArrayAdapter.createFromResource(getActivity(),R.array.main_menu_list,android.R.layout.simple_list_item_1);
        mlvMain.setAdapter(arrayAdapter);
        mlvMain.setOnItemClickListener(this);

        return view;
    }

    public void setCommunicator(Communicator pCommunicator)
    {
        this.communicator  = pCommunicator;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        communicator.respond(position);
    }
    public interface Communicator
    {
        public void respond(int index);
    }

}
