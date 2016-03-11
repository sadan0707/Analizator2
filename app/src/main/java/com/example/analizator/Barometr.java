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
 * Created by Surykatka on 2016-01-19.
 */
public class Barometr extends Activity {
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barometr);

        boolean sensorCisnieniePresent;
        SensorManager managerSensorow = (SensorManager) getSystemService(SENSOR_SERVICE);

        List<Sensor> listaSensorowCisnienia = managerSensorow.getSensorList(Sensor.TYPE_PRESSURE);
        Sensor sensorCisnienie = null;
        if(listaSensorowCisnienia.size() > 0) {
            sensorCisnieniePresent = true;
            sensorCisnienie = listaSensorowCisnienia.get(0);
        }
        else
            sensorCisnieniePresent = false;

        TextView dostepnoscCisnienie = (TextView) findViewById(R.id.dostepnoscCisnienie);

        if (sensorCisnieniePresent) {
            dostepnoscCisnienie.setText("DOSTĘPNY");
            dostepnoscCisnienie.setTextColor(Color.GREEN);
        }
        else {
            dostepnoscCisnienie.setText("NIE DOSTĘPNY");
            dostepnoscCisnienie.setTextColor(Color.RED);
        }

        managerSensorow.registerListener(mojSluchaczSesnorowCisnienia,
                managerSensorow.getDefaultSensor(Sensor.TYPE_PRESSURE),
                SensorManager.SENSOR_DELAY_NORMAL);
    }

    private final SensorEventListener mojSluchaczSesnorowCisnienia = new SensorEventListener() {


        @Override
        public void onSensorChanged(SensorEvent sensorCisnienie) {

            float cisnienie = sensorCisnienie.values[0];

            TextView odczytCisnienie = (TextView) findViewById(R.id.odczytCisnienie);
            odczytCisnienie.setText(cisnienie+" [hPa]");

        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
            // TODO Auto-generated method stub

        }
    };

}
