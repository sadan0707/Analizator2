package com.example.analizator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;

public class Glowna extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_glowna);
		
	}

	public void PrzyciskPomiary(View arg0) {
		Intent intent = new Intent(this, Pomiary.class);
		startActivity(intent);
	}
	
	public void PrzyciskZarejestrowane(View arg0) {
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
	}
	
	
	
}
