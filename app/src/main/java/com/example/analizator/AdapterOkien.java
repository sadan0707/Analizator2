package com.example.analizator;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class AdapterOkien extends FragmentPagerAdapter {

	public AdapterOkien(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int position) {

		switch (position) {
			case 0:
				// W ttym miejscu uruchamiamy aktywnosc zakladki CZUJNIKI
				return new RaportZbiorczyCzujniki();
			case 1:
				// W ttym miejscu uruchamiamy aktywnosc zakladki SIEC
				return new RaportZbiorczySiec();
			case 2:
				// W ttym miejscu uruchamiamy aktywnosc zakladki SYSTEM
				return new RaportZbiorczyCzujnikiSystem();
			}
			return null;

	}

	@Override
	public int getCount() {
		return 3;
	}
}
