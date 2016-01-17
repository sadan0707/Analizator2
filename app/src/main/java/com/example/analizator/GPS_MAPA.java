package com.example.analizator;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by Surykatka on 2016-01-08.
 */
public class GPS_MAPA extends FragmentActivity implements OnMapReadyCallback, LocationListener{

    Location mojaAktualnaLokalizacja;
    GoogleMap mMap;
    public double dlugosc, szerokosc;



        @Override
        public void onLocationChanged(Location location) {
            mojaAktualnaLokalizacja = location;
            dlugosc = mojaAktualnaLokalizacja.getLongitude();
            szerokosc = mojaAktualnaLokalizacja.getLatitude();
            LatLng lokalizacja = new LatLng(dlugosc,szerokosc);
            mMap.addMarker(new MarkerOptions().position(lokalizacja).title("Środek Ziemi"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(lokalizacja));




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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gps_mapa);

        /*LocationManager managerLokalizacji = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Location location = new Location(LocationManager.NETWORK_PROVIDER);

        LocationListener sluchaczLokalizacji = new GPS_MAPA();
        sluchaczLokalizacji.onLocationChanged(location);
        managerLokalizacji.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, sluchaczLokalizacji);
*/
        MapFragment mapa = (MapFragment) getFragmentManager().findFragmentById(R.id.fragment);
        mapa.getMapAsync(this);



    }

    @Override
    public void onMapReady(GoogleMap map) {
        mMap = map;




        /*Intent intent = new Intent();
        String daneloka = intent.getStringExtra("Dane Lokalizacji");
        LatLng lokalizacja = new LatLng(0,0);
        map.addMarker(new MarkerOptions().position(lokalizacja).title("Środek Ziemi"));
        map.moveCamera(CameraUpdateFactory.newLatLng(lokalizacja));
*/
       // Toast.makeText(this, daneloka, Toast.LENGTH_SHORT).show();

    }
}
