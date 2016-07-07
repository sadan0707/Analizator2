package com.example.analizator;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.widget.TextView;

/**
 * Created by Surykatka on 2016-01-19.
 */
public class MojSystem extends Activity {
    public void onClick(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system);

         /* <<<<  KARTA SIM >>>> */

        TelephonyManager telManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);


        String simSN = telManager.getSimSerialNumber();                                         // numer seryjny karty SIM
        TextView text_simSn = (TextView) findViewById(R.id.text_simSN);
        text_simSn.setText(simSN);


        String simOperatorNazwa = telManager.getSimOperatorName();								// Name Service Provider (SPN)
        String simOperator = telManager.getSimOperator();										// MCC + MNC od dostawcy karty SIM
        int simStatus = telManager.getSimState();												// Zwraca stałą wskazującą stan karty SIM domyślne.
        String simIso = telManager.getSimCountryIso();											// Zwraca kod kraju odpowiednik ISO dla kodu kraju dostawcy SIM.

    }
}
