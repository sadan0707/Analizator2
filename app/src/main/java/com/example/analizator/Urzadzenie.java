package com.example.analizator;

import android.app.Activity;
import android.app.admin.DeviceAdminReceiver;
import android.app.admin.DevicePolicyManager;
import android.content.Context;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.widget.TextView;

/**
 * Created by Surykatka on 2016-01-19.
 */
public class Urzadzenie extends Activity {
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urzadzenie);

         /* <<<<  KARTA SIM >>>> */

        TelephonyManager telManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);


        String simSN = telManager.getSimSerialNumber();                                         // numer seryjny karty SIM
        TextView text_simSn = (TextView) findViewById(R.id.text_simSN);
        text_simSn.setText(simSN);


        String simOperatorNazwa = telManager.getSimOperatorName();								// Name Service Provider (SPN)
        TextView text_simOperatorNazwa = (TextView) findViewById(R.id.text_simOperatorNazwa);
        text_simOperatorNazwa.setText(simOperatorNazwa);

        String simOperator = telManager.getSimOperator();										// MCC + MNC od dostawcy karty SIM
        TextView text_simOperator = (TextView) findViewById(R.id.text_simOperator);
        text_simOperator.setText(simOperator);

        int simStatus = telManager.getSimState();												// Zwraca stałą wskazującą stan karty SIM domyślne.
        TextView text_simStatus = (TextView) findViewById(R.id.text_simStatus);
        text_simStatus.setText(""+simStatus);

        String simIso = telManager.getSimCountryIso();											// Zwraca kod kraju odpowiednik ISO dla kodu kraju dostawcy SIM.

        DeviceAdminReceiver deviceAdminReceiver = new DeviceAdminReceiver();

        DevicePolicyManager devicePolicyManager = deviceAdminReceiver.getManager(this);



    }
}
