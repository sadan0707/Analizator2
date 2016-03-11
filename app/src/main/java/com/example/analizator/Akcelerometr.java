package com.example.analizator;

import android.app.Activity;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Surykatka on 2016-01-17.
 */
public class Akcelerometr extends Activity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_akcelerometr);

        boolean sensorAkcelPresent;
        TextView dostepnoscAkcel = (TextView) findViewById(R.id.dostepAkcelerometr);
        SensorManager managerSensorow = (SensorManager) getSystemService(SENSOR_SERVICE);

        List<Sensor> listaSensorowAccel = managerSensorow.getSensorList(Sensor.TYPE_ACCELEROMETER);

        if (listaSensorowAccel.size() > 0) {

            sensorAkcelPresent = true;
            Sensor sesnorAccel = listaSensorowAccel.get(0);
        }
        else
            sensorAkcelPresent = false;


        if(sensorAkcelPresent) {
            dostepnoscAkcel.setText("DOSTĘPNY");
            dostepnoscAkcel.setTextColor(Color.GREEN);

        }
        else
            dostepnoscAkcel.setText("NIE DOSTĘPNY");

        managerSensorow.registerListener(sluchaczAkcel,
                managerSensorow.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_NORMAL);
    }

    private SensorEventListener sluchaczAkcel = new SensorEventListener() {

        float xPoprzedniAccel;
        float yPoprzedniAccel;
        float zPoprzedniAccel;
        float xAccel;
        float yAccel;
        float zAccel;

        @Override
        public void onSensorChanged(SensorEvent event) {
            updateAkcelParameters(event.values[0], event.values[1], event.values[2]);
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }

        private void updateAkcelParameters(float xNowyAccel, float yNowyAccel, float zNowyAccel) {
            boolean pierwszyPomiar = true;

            if (pierwszyPomiar) {
                xPoprzedniAccel = xNowyAccel;
                yPoprzedniAccel = yNowyAccel;
                zPoprzedniAccel = zNowyAccel;
                pierwszyPomiar = false;
            } else {
                xPoprzedniAccel = xAccel;
                yPoprzedniAccel = yAccel;
                zPoprzedniAccel = zAccel;
            }

            xAccel = xNowyAccel;
            yAccel = yNowyAccel;
            zAccel = zNowyAccel;

            TextView textxAccel = (TextView) findViewById(R.id.x2Accel);
            TextView textyAccel = (TextView) findViewById(R.id.y2Accel);
            TextView textzAccel = (TextView) findViewById(R.id.z2Accel);

            textxAccel.setText("" + xAccel);
            textyAccel.setText("" + yAccel);
            textzAccel.setText("" + zAccel);

        }
    };


}
