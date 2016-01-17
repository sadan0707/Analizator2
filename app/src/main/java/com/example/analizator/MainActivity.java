package com.example.analizator;

import java.util.List;
import java.util.Set;



import android.telephony.CellIdentityLte;
import android.telephony.CellInfo;
import android.telephony.CellInfoGsm;
import android.telephony.CellLocation;
import android.telephony.CellSignalStrength;
import android.telephony.CellSignalStrengthGsm;
import android.telephony.CellSignalStrengthLte;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import android.annotation.TargetApi;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {

	
	private static final String TextView = null;
	boolean sensorAkcelPresent, sensorOrientPresent, sensorTempPresent, sensorLightPresent, 
			sensorCisnieniePresent, sensorZyroskopPresent, sensorIglaPresent;
	SensorManager managerSensorow;
	
	private float xAccel;
	private float yAccel;
	private float zAccel;
	
	private float xPoprzedniAccel;
	private float yPoprzedniAccel;
	private float zPoprzedniAccel;
	
	private float xNowyAccel;
	private float yNowyAccel;
	private float zNowyAccel;
	
	private boolean pierwszyPomiar = true;
	
	private final float szybkiRuch = 1.5f;
	
	private boolean jedenKierunek = false;
	
	
	private final SensorEventListener mojSluchaczSensorowAkcel = new SensorEventListener() {
		
		@Override
		public void onSensorChanged(SensorEvent se) {
		
			updateAkcelParameters(se.values[0], se.values[1], se.values[2]);
			
		}
		
		private void updateAkcelParameters(float xNowyAccel, float yNowyAccel, float zNowyAccel) {
			if(pierwszyPomiar) {
				xPoprzedniAccel = xNowyAccel;
				yPoprzedniAccel = yNowyAccel;
				zPoprzedniAccel = zNowyAccel;
				pierwszyPomiar = false;
			}
			else {
				xPoprzedniAccel = xAccel;
				yPoprzedniAccel = yAccel;
				zPoprzedniAccel = zAccel;
			}
			
			xAccel = xNowyAccel;
			yAccel = yNowyAccel;
			zAccel = zNowyAccel;
		
			TextView textxAccel = (TextView) findViewById(R.id.xAccel);
			TextView textyAccel = (TextView) findViewById(R.id.yAccel);
			TextView textzAccel = (TextView) findViewById(R.id.zAccel);
			
			
			
			textxAccel.setText(""+xAccel);
			textyAccel.setText(""+yAccel);
			textzAccel.setText(""+zAccel);
		}
		
		

		@Override
		public void onAccuracyChanged(Sensor sensor, int accuracy) {
			// TODO Auto-generated method stub
			
		}
	};
	
	private final SensorEventListener mojSluchaczSensorowOrient = new SensorEventListener() {

		@Override
		public void onAccuracyChanged(Sensor sensor, int accuracy) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onSensorChanged(SensorEvent sensorEvent) {
		
			
				float azimuth = sensorEvent.values[0];
				float pitch = sensorEvent.values[1];
				float roll = sensorEvent.values[2];
				
				TextView xOrient = (TextView) findViewById(R.id.xOrient);
				TextView yOrient = (TextView) findViewById(R.id.yOrient);
				TextView zOrient = (TextView) findViewById(R.id.zOrient);
				
				xOrient.setText(""+azimuth);
				yOrient.setText(""+pitch);
				zOrient.setText(""+roll);
			
		}
		
	};
	
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
	
	private final SensorEventListener mojSluchaczSensorowSwiatlo = new SensorEventListener() {
		
		@Override
		public void onSensorChanged(SensorEvent sensorSwiatlo) {
		
			float swiatlo = sensorSwiatlo.values[0];
			
			TextView odczytSwiatlo = (TextView) findViewById(R.id.odczytSwiatlo);
			odczytSwiatlo.setText(swiatlo+" [lux]");
		}
		
		@Override
		public void onAccuracyChanged(Sensor sensor, int accuracy) {
			// TODO Auto-generated method stub
			
		}
	};
	
	private final SensorEventListener mojSluchaczSesnorowCisnienia = new SensorEventListener() {
		
		@Override
		public void onSensorChanged(SensorEvent sensorCisnienie) {
			float cisnienie = sensorCisnienie.values[0];
			
			TextView odczytCisnienie = (TextView) findViewById(R.id.odczytCisnienie);
			odczytCisnienie.setText(cisnienie+" [hPa]");
			
		}
		
		@Override
		public void onAccuracyChanged(Sensor sensor, int accuracy) {
			// TODO Auto-generated method stub
			
		}
	};
	
	private final SensorEventListener mojSluchaczSensorowZyroskop = new SensorEventListener() {
		
		@Override
		public void onSensorChanged(SensorEvent sensorZyroskop) {
			float xZyroskop = sensorZyroskop.values[0];
			float yZyroskop = sensorZyroskop.values[1];
			float zZyroskop = sensorZyroskop.values[2];
			
			TextView odczytxZyroskop = (TextView) findViewById(R.id.odczytxZyroskop);
			odczytxZyroskop.setText(""+xZyroskop);
			
			TextView odczytyZyroskop = (TextView) findViewById(R.id.odczytyZyroskop);
			odczytyZyroskop.setText(""+yZyroskop);
			
			TextView odczytzZyroskop = (TextView) findViewById(R.id.odczytzZyroskop);
			odczytzZyroskop.setText(""+zZyroskop);
			
		}
		
		@Override
		public void onAccuracyChanged(Sensor sensor, int accuracy) {
			// TODO Auto-generated method stub
			
		}
	};
	
	private SensorEventListener mojSluchaczSensorowIgla = new SensorEventListener() {
		
		@Override
		public void onSensorChanged(SensorEvent sensorIgla) {
			
			float pole = sensorIgla.values[0];
			
			TextView odczytIgla = (TextView) findViewById(R.id.odczytIgla);
			odczytIgla.setText(pole+" [uT]");
			
		}
		
		@Override
		public void onAccuracyChanged(Sensor sensor, int accuracy) {
			// TODO Auto-generated method stub
			
		}
	};
	
	@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		
		managerSensorow = (SensorManager) getSystemService(SENSOR_SERVICE);
		
		
		/* AKCELEROMETR >>>> */
		
		List<Sensor> listaSensorowAccel = managerSensorow.getSensorList(Sensor.TYPE_ACCELEROMETER);
		
		
		if (listaSensorowAccel.size() > 0) {
			
			sensorAkcelPresent = true;
			Sensor sesnorAccel = listaSensorowAccel.get(0);
						
		}
		else 
			sensorAkcelPresent = false;
		
		
		TextView dostepnoscAkcel = (TextView) findViewById(R.id.dostepnoscAkcelerometr);
		
		if(sensorAkcelPresent) {
			dostepnoscAkcel.setText("DOSTĘPNY");
						
		}
		else
			dostepnoscAkcel.setText("NIE DOSTĘPNY");
		
		managerSensorow.registerListener(mojSluchaczSensorowAkcel, 
				managerSensorow.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), 
				SensorManager.SENSOR_DELAY_NORMAL);
		
		
		/* <<<<  CZUJNIK OREINTACJI >>>> */
		
		List<Sensor> listaSensorowOrient = managerSensorow.getSensorList(Sensor.TYPE_ORIENTATION);
		Sensor sensorOrient = null;
		
		if (listaSensorowOrient.size() > 0) {
			
			sensorOrientPresent = true;
			sensorOrient = listaSensorowOrient.get(0);
						
		}
		else 
			sensorOrientPresent = false;
		
		
		TextView dostepnoscOrient = (TextView) findViewById(R.id.dostepnoscOrient);
		
		if(sensorOrientPresent) {
			dostepnoscOrient.setText("DOSTĘPNY");
						
		}
		else
			dostepnoscOrient.setText("NIE DOSTĘPNY");
		
		
		managerSensorow.registerListener(mojSluchaczSensorowOrient, 
				managerSensorow.getDefaultSensor(Sensor.TYPE_ORIENTATION),
				SensorManager.SENSOR_DELAY_NORMAL);
		
		/* <<<<  CZUJNIK TEMPERATURY >>>> */
		
		List<Sensor> listaSensorowTemp = managerSensorow.getSensorList(Sensor.TYPE_TEMPERATURE);
		
		Sensor sensorTemp = null;
		
		if (listaSensorowTemp.size() > 0) {
			sensorTempPresent = true;
			sensorTemp = listaSensorowTemp.get(0);
		}
		else
			sensorTempPresent = false;
		
		TextView dostepnoscTemp = (TextView) findViewById(R.id.dostepnoscTemp);
		
		if(sensorTempPresent) {
			dostepnoscTemp.setText("DOSTĘPNY");
		}
		else
			dostepnoscTemp.setText("NIE DOSTĘPNY");
		
		managerSensorow.registerListener(mojSluchaczSensorowTemp, 
				managerSensorow.getDefaultSensor(Sensor.TYPE_TEMPERATURE),
				SensorManager.SENSOR_DELAY_FASTEST);
		
		
		/* <<<<  CZUJNIK �WIAT�A >>>> */
		
List<Sensor> listaSensorowSwiatla = managerSensorow.getSensorList(Sensor.TYPE_LIGHT);
		
		Sensor sensorLight = null;
		
		if (listaSensorowSwiatla.size() > 0) {
			sensorLightPresent = true;
			sensorLight = listaSensorowSwiatla.get(0);
		}
		else
			sensorLightPresent = false;
		
		TextView dostepnoscSwiatlo = (TextView) findViewById(R.id.dostepnoscSwiatlo);
		
		if(sensorLightPresent) {
			dostepnoscSwiatlo.setText("DOSTĘPNY");
		}
		else
			dostepnoscSwiatlo.setText("NIE DOSTĘPNY");
		
		managerSensorow.registerListener(mojSluchaczSensorowSwiatlo, 
				managerSensorow.getDefaultSensor(Sensor.TYPE_LIGHT),
				SensorManager.SENSOR_DELAY_NORMAL);
		
		/* <<<<  CZUJNIK CI�NIENIA >>>> */
		
	List<Sensor> listaSensorowCisnienia = managerSensorow.getSensorList(Sensor.TYPE_PRESSURE);
	Sensor sensorCisnienie = null;
	if(listaSensorowCisnienia.size() > 0) {
		sensorCisnieniePresent = true;
		sensorCisnienie = listaSensorowCisnienia.get(0);
	}
	else
		sensorCisnieniePresent = false;
	
	TextView dostepnoscCisnienie = (TextView) findViewById(R.id.dostepnoscCisnienie);
	
	if (sensorCisnieniePresent) {
		dostepnoscCisnienie.setText("DOSTĘPNY");
	}
	else
		dostepnoscCisnienie.setText("NIE DOSTĘPNY");
	
	managerSensorow.registerListener(mojSluchaczSesnorowCisnienia, 
			managerSensorow.getDefaultSensor(Sensor.TYPE_PRESSURE), 
			SensorManager.SENSOR_DELAY_NORMAL);
	
	/* <<<<  CZUJNIK �YROSKOP >>>> */
	
	List<Sensor> listaSensorowZyroskop = managerSensorow.getSensorList(Sensor.TYPE_GYROSCOPE);
	Sensor sensorZyroskop = null;
	if(listaSensorowZyroskop.size() > 0) {
		sensorZyroskopPresent = true;
		sensorCisnienie = listaSensorowCisnienia.get(0);
	}
	else
		sensorCisnieniePresent = false;
	
	TextView dostepnoscZyroskop = (TextView) findViewById(R.id.dostepnoscZyroskop);
	
	if (sensorZyroskopPresent) {
		dostepnoscZyroskop.setText("DOSTĘPNY");
	}
	else
		dostepnoscZyroskop.setText("NIE DOSTĘPNY");
	
	managerSensorow.registerListener(mojSluchaczSensorowZyroskop, 
			managerSensorow.getDefaultSensor(Sensor.TYPE_GYROSCOPE), 
			SensorManager.SENSOR_DELAY_NORMAL);
	
	/* <<<<  CZUJNIK IGLA MAGNETYCZNA >>>> */
	
	List<Sensor> listaSensorowIgla = managerSensorow.getSensorList(Sensor.TYPE_MAGNETIC_FIELD);
	Sensor sensorIgla = null;
	if(listaSensorowIgla.size() > 0) {
		sensorIglaPresent = true;
		sensorIgla = listaSensorowIgla.get(0);
	}
	else
		sensorIglaPresent = false;
	
	TextView dostepnoscIgla = (TextView) findViewById(R.id.dostepnoscIgla);
	
	if (sensorIglaPresent) {
		dostepnoscIgla.setText("DOSTĘPNY");
	}
	else
		dostepnoscIgla.setText("NIE DOSTĘPNY");
	
	managerSensorow.registerListener(mojSluchaczSensorowIgla, 
			managerSensorow.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD), 
			SensorManager.SENSOR_DELAY_NORMAL);
	
	
	/* <<<<  ��CZNO�� GSM / WCDMA / LTE >>>> */
	
	TelephonyManager telManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
	
	GsmCellLocation gsmCellLoc = (GsmCellLocation) telManager.getCellLocation();
	
	int cellIdGSM = gsmCellLoc.getCid();
	TextView TextCellId = (TextView) findViewById(R.id.cellId);
	TextCellId.setText(cellIdGSM+"");
	
	int lacGSM = gsmCellLoc.getLac();
	TextView TextlacGsm = (TextView) findViewById(R.id.LAC);
	TextlacGsm.setText(lacGSM+"");
	
	
	String nazwaOperatora = telManager.getNetworkOperatorName();
	TextView TextnazwaOperatora = (TextView) findViewById(R.id.operatorName);
	TextnazwaOperatora.setText(nazwaOperatora);
	
	int typSieci = telManager.getNetworkType();
	TextView TextTypSieci = (TextView) findViewById(R.id.networkType);
	TextTypSieci.setText(typSieci+"");
	
	int typTelefonu = telManager.getPhoneType();
	
	
	class MyPhoneStateListener extends PhoneStateListener
    {
      /* Get the Signal strength from the provider, each tiome there is an update */
      @Override
      public void onSignalStrengthsChanged(SignalStrength signalStrength)
      {
         super.onSignalStrengthsChanged(signalStrength);
         //Toast.makeText(getApplicationContext(), "Go to Firstdroid!!! GSM Cinr = "
         //   + String.valueOf(signalStrength.getGsmSignalStrength()), Toast.LENGTH_SHORT).show();
         
         TextView silaSyg = (TextView)findViewById(R.id.silaSygnaluGSM);
         double silaGsmAsu = signalStrength.getCdmaDbm();
         double silaGsmDbm = (2*silaGsmAsu)-113;
         
        
         silaSyg.setText(silaGsmDbm+" [dBm] / "+silaGsmAsu+ " [asu]");
      }
    }
      
      MyPhoneStateListener MyListener = new MyPhoneStateListener();
      telManager.listen(MyListener, PhoneStateListener.LISTEN_SIGNAL_STRENGTHS);
	
     
      /* <<<<  KARTA SIM >>>> */
     
	

	String simSN = telManager.getSimSerialNumber();
  	
  	
  	String simOperatorNazwa = telManager.getSimOperatorName();
  	
  	
  	String simOperator = telManager.getSimOperator();
      
      /* <<<<  DANE URZADZENIA >>>> */
  	
  	String idUrzadzenia = telManager.getDeviceId();
      
      /* <<<<  WIFI >>>> */
      
      /* <<<<  BLUETOUCH >>>> */
  	
  	BluetoothManager bManager = (BluetoothManager) getSystemService(BLUETOOTH_SERVICE);
    BluetoothAdapter bAdapter = bManager.getAdapter();
    
    String bAdress = bAdapter.getAddress();
    String bNazwa = bAdapter.getName();
    
    Set<BluetoothDevice> bondedDevice = bAdapter.getBondedDevices();
    
    
    TextView textBluetoothAdress = (TextView)findViewById(R.id.textBluetoothAdress);
    TextView textBluetoothNazwa = (TextView)findViewById(R.id.textBluetoothNazwa);
    TextView textBluetoothStan = (TextView)findViewById(R.id.textBluetoothStan);
    TextView textBluetoothPair = (TextView)findViewById(R.id.textBluetoothPair);
    TextView textBluetoothConected = (TextView)findViewById(R.id.textBluetoothConnected);
    
    textBluetoothAdress.setText(bAdress);
    textBluetoothNazwa.setText(bNazwa);
    
    if (bAdapter.isEnabled()==true) 
    { 
    	textBluetoothStan.setText("WŁĄCZONY");
    } 
    else
    	textBluetoothStan.setText("WYŁĄCZONY");
    //TextView textBluetoothPair
      /* <<<<  BATERIA >>>> */
  	
  	
  	
      
      /* <<<<  GPS >>>> */

   
	
	
	}



	

	
	
	
	
}
