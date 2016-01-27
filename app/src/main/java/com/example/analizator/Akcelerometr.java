package com.example.analizator;

import android.app.Activity;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.List;

/**
 * Created by Surykatka on 2016-01-17.
 */
public class Akcelerometr extends Activity {


    float xPoprzedniAccel;
    float yPoprzedniAccel;
    float zPoprzedniAccel;
    float xAccel;
    float yAccel;
    float zAccel;

    private SensorEventListener sluchaczAkcel = new SensorEventListener() {
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

            textxAccel.setText(""+xAccel);
            textyAccel.setText(""+yAccel);
            textzAccel.setText(""+zAccel);

        }
    };


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_akcelerometr);

        SensorManager managerSensorow = (SensorManager) getSystemService(SENSOR_SERVICE);


		/* AKCELEROMETR >>>> */

        List<Sensor> listaSensorowAccel = managerSensorow.getSensorList(Sensor.TYPE_ACCELEROMETER);

        boolean sensorAkcelPresent;

        if (listaSensorowAccel.size() > 0) {

            sensorAkcelPresent = true;
            Sensor sesnorAccel = listaSensorowAccel.get(0);

        }
        else
            sensorAkcelPresent = false;


        TextView dostepnoscAkcel = (TextView) findViewById(R.id.dostepAkcelerometr);

        if(sensorAkcelPresent) {
            dostepnoscAkcel.setText("DOSTĘPNY");
            dostepnoscAkcel.setTextColor(Color.GREEN);

        }
        else
            dostepnoscAkcel.setText("NIE DOSTĘPNY");

        managerSensorow.registerListener(sluchaczAkcel,
                managerSensorow.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_NORMAL);


        GraphView graf = (GraphView)findViewById(R.id.graf_akcelerometr);
        LineGraphSeries<DataPoint> akcel_punktyX = new LineGraphSeries<DataPoint>
                (new DataPoint[]{
                        new DataPoint(0,0),
                        new DataPoint(0.5,0.5),
                        new DataPoint(1,1),
                        new DataPoint(1.5,1.5),
                        new DataPoint(2,2),
                        new DataPoint(2.5,1.6),
                        new DataPoint(3,1.4),
                        new DataPoint(3.5,1),
                        new DataPoint(4,0.5)
                });

        graf.addSeries(akcel_punktyX);

        LineGraphSeries<DataPoint> akcel_punktyY = new LineGraphSeries<DataPoint>
                (new DataPoint[]{
                        new DataPoint(0,0),
                        new DataPoint(0.5,1),
                        new DataPoint(1,1.4),
                        new DataPoint(1.5,1.7),
                        new DataPoint(2,2.3),
                        new DataPoint(2.5,1.9),
                        new DataPoint(3,1.2),
                        new DataPoint(3.5,2.2),
                        new DataPoint(4,0.52)
                });
        akcel_punktyY.setColor(Color.RED);
        graf.addSeries(akcel_punktyY);

        LineGraphSeries<DataPoint> akcel_punktyZ = new LineGraphSeries<DataPoint>
                (new DataPoint[]{
                        new DataPoint(0,4),
                        new DataPoint(0.5,1.75),
                        new DataPoint(1,1.6),
                        new DataPoint(1.5,3),
                        new DataPoint(2, -2.1),
                        new DataPoint(2.5,2.9),
                        new DataPoint(3,2.2),
                        new DataPoint(3.5,-2.25),
                        new DataPoint(4,2.52)
                });
        akcel_punktyZ.setColor(Color.GREEN);
        graf.addSeries(akcel_punktyZ);

    }
}
