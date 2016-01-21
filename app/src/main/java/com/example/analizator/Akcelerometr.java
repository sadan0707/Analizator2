package com.example.analizator;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

/**
 * Created by Surykatka on 2016-01-17.
 */
public class Akcelerometr extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_akcelerometr);

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

    }
}
