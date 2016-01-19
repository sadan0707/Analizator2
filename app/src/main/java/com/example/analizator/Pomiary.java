package com.example.analizator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Pomiary extends Activity 

{
	protected void onCreate (Bundle sevedInstanceState) {
		
		super.onCreate(sevedInstanceState);
		setContentView(R.layout.activity_pomiary);
	}
	
	
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
}
