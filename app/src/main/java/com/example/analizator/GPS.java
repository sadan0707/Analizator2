package com.example.analizator;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Surykatka on 2016-01-06.
 */
public class GPS extends Activity {

    LocationListener locationListener;
    LocationManager managerLokalizacji;




    public class MojSluchaczLokalizacji implements LocationListener {

        @Override
        public void onLocationChanged(Location location) {
            if (location != null) {

                TextView gps_szerokosc = (TextView) findViewById(R.id.gps_szerokosc);
                TextView gps_dlugosc = (TextView) findViewById(R.id.gps_dlugosc);
                TextView gps_provider = (TextView) findViewById(R.id.gps_provider);
                TextView gps_speed = (TextView) findViewById(R.id.gps_speed);
                TextView gps_bearing = (TextView) findViewById(R.id.gps_bearing);

                gps_szerokosc.setText("" + location.getLatitude());
                gps_dlugosc.setText("" + location.getLongitude());
                gps_provider.setText("" + location.getProvider());
                gps_speed.setText("" + location.getSpeed());
                gps_bearing.setText("" + location.getBearing());


                Toast.makeText(getBaseContext(), "Aktualne położenie: Szerokość: " + location.getLatitude() + "; Dlugość: " + location.getLongitude(), Toast.LENGTH_SHORT).show();

            } else
                Toast.makeText(getBaseContext(), "Lokalizacja NIE DOSTĘPNA!!", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {


        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gps);


        managerLokalizacji = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Location location = new Location(LocationManager.GPS_PROVIDER);


        locationListener = new MojSluchaczLokalizacji();
        locationListener.onLocationChanged(location);
        managerLokalizacji.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);

    }

    public double podajSzerokosc() {



        managerLokalizacji = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Location location = new Location(LocationManager.GPS_PROVIDER);


        locationListener = new MojSluchaczLokalizacji();
        locationListener.onLocationChanged(location);
        managerLokalizacji.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);


        double szerokosc=location.getLatitude();

        return szerokosc;
    }


    public double podajDlugosc() {



        managerLokalizacji = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Location location = new Location(LocationManager.NETWORK_PROVIDER);


        locationListener = new MojSluchaczLokalizacji();
        locationListener.onLocationChanged(location);
        managerLokalizacji.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);


        double dlugosc=location.getLongitude();

        return dlugosc;
    }

    public void Wyswietl_mape(View arg0) {
        Intent intent = new Intent(this, GPS_MAPA.class);
        startActivity(intent);
    }
}


