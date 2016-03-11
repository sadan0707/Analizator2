package com.example.analizator;

import android.app.Activity;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class Pomiary extends Activity {
	SensorManager managerSensorow;

	boolean sensorAkcelPresent,
			sensorOrientPresent,
			sensorTempPresent,
			sensorLightPresent,
			sensorCisnieniePresent,
			sensorZyroskopPresent,
			sensorIglaPresent;

	protected void onCreate (Bundle sevedInstanceState) {
		
		super.onCreate(sevedInstanceState);
		setContentView(R.layout.activity_pomiary);

		managerSensorow = (SensorManager) getSystemService(SENSOR_SERVICE);

		// <<<<<< Sprawdzenie dostepnosci czujnika TEMPERATURY >>>>>

		List<Sensor> listaSensorowTemp = managerSensorow.getSensorList(Sensor.TYPE_TEMPERATURE);

		Button przycisk_temp = (Button) findViewById(R.id.przycisk_temp);

		Sensor sensorTemp = null;

		if (listaSensorowTemp.size() > 0) {
			sensorTempPresent = true;
			sensorTemp = listaSensorowTemp.get(0);
			przycisk_temp.setBackgroundResource(R.drawable.termometr2_xxhdpi);
			przycisk_temp.setClickable(true);
		}
		else {
			sensorTempPresent = false;
			przycisk_temp.setBackgroundResource(R.drawable.termometr2_nieaktywny_xxhdpi);
			przycisk_temp.setClickable(false);
		}

		//TextView dostepnoscTemp = (TextView) findViewById(R.id.dostepnoscTemp);
		//
		//if(sensorTempPresent) {
		//	dostepnoscTemp.setText("DOSTĘPNY");
		//	dostepnoscTemp.setTextColor(Color.GREEN);
		//}
		//else {
		//	dostepnoscTemp.setText("NIE DOSTĘPNY");
		//	dostepnoscTemp.setTextColor(Color.RED);
		//}
		//
		managerSensorow.registerListener(mojSluchaczSensorowTemp,
				managerSensorow.getDefaultSensor(Sensor.TYPE_TEMPERATURE),
				SensorManager.SENSOR_DELAY_FASTEST);

	}

	private final SensorEventListener mojSluchaczSensorowTemp = new SensorEventListener() {

		@Override
		public void onSensorChanged(SensorEvent sensorTemp) {
			float temp = sensorTemp.values[0];

			TextView odczytTemp = (TextView)findViewById(R.id.odczytTemp);
			odczytTemp.setText(temp+"[C]");

		}

		@Override
		public void onAccuracyChanged(Sensor sensor, int accuracy) {


		}
	};
	
	
	public void PrzyciskBateryjka(View arg0) {
	Intent intent = new Intent(this, Bateryjka.class);
	startActivity(intent);
		}
	
	public void PrzyciskZbiorczy(View arg0) {
		Intent intent = new Intent(this, RaportZbiorczy.class);
		startActivity(intent);
	}

	public void PrzyciskGPS(View view) {
		Intent intent = new Intent(this, GPS.class);
		startActivity(intent);
	}

	public void przycisk_akcelerometr(View view) {
		Intent intent = new Intent(this, Akcelerometr.class);
		startActivity(intent);
	}

	public void przycisk_wifi(View view) {
		Intent intent = new Intent(this, Wifi.class);
		startActivity(intent);
	}

	public void przycisk_zyroskop(View view) {
		Intent intent = new Intent(this, Zyroskop.class);
		startActivity(intent);
	}

	public void przycisk_igla_magnetyczna(View view) {
		Intent intent = new Intent(this, IglaMagnetyczna.class);
		startActivity(intent);
	}

	public void przycisk_orienntacja(View view) {
		Intent intent = new Intent(this, Orientacja.class);
		startActivity(intent);
	}

	public void przycisk_temp(View view) {
		Intent intent = new Intent(this, Temperatura.class);
		startActivity(intent);
	}

	public void przycisk_oswietlenie(View view) {
		Intent intent = new Intent(this, Oswietlenie.class);
		startActivity(intent);
	}

	public void przycisk_barometr(View view) {
		Intent intent = new Intent(this, Barometr.class);
		startActivity(intent);
	}

	public void przycisk_lacznosc(View view) {
		Intent intent = new Intent(this, Lacznosc.class);
		startActivity(intent);
	}

	public void przycisk_system(View view) {
		Intent intent = new Intent(this, MojSystem.class);
		startActivity(intent);
	}

	public void przycisk_nfc(View view) {
		Intent intent = new Intent(this, NFC.class);
		startActivity(intent);
	}

	public void przycisk_bloetooth(View view) {
		Intent intent = new Intent(this, Bluetooth.class);
		startActivity(intent);
	}

	public void przycisk_glosnosc(View view) {
		Intent intent = new Intent(this, Glosnosc.class);
		startActivity(intent);
	}
}
