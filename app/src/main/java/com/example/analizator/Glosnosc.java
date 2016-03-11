package com.example.analizator;

import android.app.Activity;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Surykatka on 2016-01-21.
 */
public class Glosnosc extends Activity{
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glosnosc);

    }

    public double wezAmplitude() {
        MediaRecorder mediaRecorder = new MediaRecorder();
        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        mediaRecorder.start();

        if(mediaRecorder != null) return (mediaRecorder.getMaxAmplitude());
        else return 0;
    }


    public void GLOSNOSC(View view) {
        double glosnosc = wezAmplitude();
        TextView text_glosnosc = (TextView) findViewById(R.id.glosnosc);
        text_glosnosc.setText(""+glosnosc);
    }
}

