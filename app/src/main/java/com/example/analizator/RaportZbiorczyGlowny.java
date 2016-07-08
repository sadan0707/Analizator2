package com.example.analizator;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

/**
 * Created by krzysiek on 2016-05-11.
 */
public class RaportZbiorczyGlowny extends FragmentActivity implements ActionBar.TabListener {

    private ViewPager viewPager;
    private AdapterOkien adapterOkien;
    private ActionBar actionBar;

    private String[] zakladki = {
            "Czujniki",
            "Sieć",
            "Urzadzenie"
    };

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zbiorczy_glowny);

        // Inicjalizacja
        viewPager = (ViewPager) findViewById(R.id.pager);
        actionBar = getActionBar();
        adapterOkien = new AdapterOkien(getSupportFragmentManager());

        viewPager.setAdapter(adapterOkien);
        actionBar.setHomeButtonEnabled(false);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        //Dodawanie zakładek
        for (String zakladki_nazwy: zakladki) {
            actionBar.addTab(actionBar.newTab().setText(zakladki_nazwy).setTabListener(this));
        }

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener(){

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageSelected(int position) {
                actionBar.setSelectedNavigationItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {

            }
        });
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        viewPager.setCurrentItem(tab.getPosition());

    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {


    }
}
