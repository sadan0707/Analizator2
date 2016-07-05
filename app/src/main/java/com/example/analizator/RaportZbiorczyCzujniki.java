package com.example.analizator;

import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.BreakIterator;
import java.util.List;

/**
 * Created by krzysiek on 2016-05-11.
 */
public class RaportZbiorczyCzujniki extends Fragment implements SensorEventListener{


    final String T = "TAG";
    //private static final String TextView = null;
    boolean sensorAkcelPresent, sensorOrientPresent, sensorTempPresent, sensorLightPresent,
            sensorCisnieniePresent, sensorZyroskopPresent, sensorIglaPresent;
    SensorManager managerSensorow;

    float xAccel;
    float yAccel;
    float zAccel;

    float xPoprzedniAccel;
    float yPoprzedniAccel;
    float zPoprzedniAccel;

    float xNowyAccel;
    float yNowyAccel;
    float zNowyAccel;

    boolean pierwszyPomiar = true;

    final float szybkiRuch = 1.5f;

    boolean jedenKierunek = false;

    View rootView;
    private BreakIterator textxAccel;
    private BreakIterator textyAccel;
    private BreakIterator textzAccel;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        managerSensorow = (SensorManager) getContext().getSystemService(Context.SENSOR_SERVICE);

        List<Sensor> listaSensorowAccel = managerSensorow.getSensorList(Sensor.TYPE_ACCELEROMETER);


        if (listaSensorowAccel.size() > 0) {

            sensorAkcelPresent = true;
            Sensor sesnorAccel = listaSensorowAccel.get(0);

        } else
            sensorAkcelPresent = false;
    }



    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.activity_zbiorczy_czujniki, container, false);

    }

    public void onViewCreated(View view, Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        TextView textxAccel = (TextView) view.findViewById(R.id.xAccel);
        TextView textyAccel = (TextView) view.findViewById(R.id.yAccel);
        TextView textzAccel = (TextView) view.findViewById(R.id.zAccel);

        TextView dostepnoscAkcel = (TextView) view.findViewById(R.id.dostepnoscAkcelerometr);

        if (sensorAkcelPresent) {
            dostepnoscAkcel.setText("DOSTĘPNY");
            dostepnoscAkcel.setTextColor(Color.GREEN);

        } else {
            dostepnoscAkcel.setText("NIE DOSTĘPNY");
            dostepnoscAkcel.setTextColor(Color.RED);
        }


    }

      /* AKCELEROMETR >>>> */

      //  List<Sensor> listaSensorowAccel = managerSensorow.getSensorList(Sensor.TYPE_ACCELEROMETER);


     /*   if (listaSensorowAccel.size() > 0) {

            sensorAkcelPresent = true;
            Sensor sesnorAccel = listaSensorowAccel.get(0);

        } else
            sensorAkcelPresent = false;

            */

        /*

        managerSensorow.registerListener(mojSluchaczSensorowAkcel,
                managerSensorow.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_NORMAL);


                */





    @Override
    public void onSensorChanged(SensorEvent se) {
        updateAkcelParameters(se.values[0], se.values[1], se.values[2]);

    }

        private void updateAkcelParameters(float xNowyAccel, float yNowyAccel, float zNowyAccel) {
            if(pierwszyPomiar) {
                xPoprzedniAccel = xNowyAccel;
                yPoprzedniAccel = yNowyAccel;
                zPoprzedniAccel = zNowyAccel;
                pierwszyPomiar = false;
            }
            else {
                xPoprzedniAccel = xAccel;
                yPoprzedniAccel = yAccel;
                zPoprzedniAccel = zAccel;
            }

            xAccel= xNowyAccel;
            yAccel = yNowyAccel;
            zAccel = zNowyAccel;

           // TextView textxAccel = (TextView) view.findViewById(R.id.xAccel);
           // TextView textyAccel = (TextView) rootView.findViewById(R.id.yAccel);
           // TextView textzAccel = (TextView) rootView.findViewById(R.id.zAccel);



            textxAccel.setText(""+ xAccel);
            textyAccel.setText(""+ yAccel);
            textzAccel.setText(""+ zAccel);

    }



    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    public void setMenuVisibility(boolean menuVisible) {
        super.setMenuVisibility(menuVisible);

        // First starts (gets called before everything else)
        if(managerSensorow == null) {
            return;
        }

        if(menuVisible) {
            this.registerSensorListener();
        } else {
            this.unregisterSensorListener();
        }
    }

    public void onStart() {
        super.onStart();

        if(this.getUserVisibleHint()) {
            this.registerSensorListener();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        this.unregisterSensorListener();
    }

    private void registerSensorListener() {
        managerSensorow.registerListener(this, managerSensorow.getSensorList(Sensor.TYPE_ACCELEROMETER).get(0), SensorManager.SENSOR_DELAY_FASTEST);
    }

    private void unregisterSensorListener() {
        managerSensorow.unregisterListener(this);
    }
}
