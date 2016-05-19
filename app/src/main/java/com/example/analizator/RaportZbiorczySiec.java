package com.example.analizator;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by krzysiek on 2016-05-11.
 */
public class RaportZbiorczySiec extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_zbiorczy_siec, container, false);

//        Button button = (Button) getView().findViewById(R.id.siec_button);
        final TextView text = (TextView) getView().findViewById(R.id.siec_text);
        final EditText pole = (EditText) getView().findViewById(R.id.siec_pole);

        /* button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                text.setText(pole.getText().toString());

            }
        });

        */


        return rootView;




    }


}
