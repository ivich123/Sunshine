package com.example.ivich.sunshine;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A placeholder fragment containing a simple view.
 */
public class DetailActivityFragment extends Fragment {
    String foreCastDetail;
    public DetailActivityFragment() {
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Intent intent = getActivity().getIntent();
        foreCastDetail = intent.getStringExtra(Intent.EXTRA_TEXT);
        View rootView =  inflater.inflate(R.layout.fragment_detail, container, false);

        TextView tv = (TextView) rootView.findViewById(R.id.forecast_detail);
        tv.setText(foreCastDetail);
        return rootView;
    }
}
