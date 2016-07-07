package com.example.analizator;


import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

public class Bateryjka  extends Activity {
	
	protected void onCreate(Bundle sevedInstanceState) {
		super.onCreate(sevedInstanceState);
		setContentView(R.layout.activity_bateryjka);
		this.registerReceiver(this.batteryInfoReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
		}
		
	    private BroadcastReceiver batteryInfoReceiver = new BroadcastReceiver() {
			@Override
			public void onReceive(Context context, Intent intent) {
				
				
				TextView txt_poziom_baterii = (TextView) findViewById(R.id.textView3);
				
				int  level= intent.getIntExtra(BatteryManager.EXTRA_LEVEL,0);
				ImageView bateryjka = (ImageView) findViewById(R.id.imageView1);
				ImageView strzalka = (ImageView) findViewById(R.id.imageView3);
				txt_poziom_baterii.setText(level + " %");

				RotateAnimation animacja_rotacja_lewo = new RotateAnimation(0.0f, -360.0f, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF, 0.5f);
				animacja_rotacja_lewo.setInterpolator(new LinearInterpolator());
				animacja_rotacja_lewo.setRepeatCount(Animation.INFINITE);
				animacja_rotacja_lewo.setRepeatMode(Animation.REVERSE);
				animacja_rotacja_lewo.setDuration(2000);

				RotateAnimation animacja_rotacja_prawo = new RotateAnimation(0.0f, 360.0f, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF, 0.5f);
				animacja_rotacja_prawo.setInterpolator(new LinearInterpolator());
				animacja_rotacja_prawo.setRepeatCount(Animation.INFINITE);
				animacja_rotacja_prawo.setRepeatMode(Animation.REVERSE);
				animacja_rotacja_prawo.setDuration(2000);


				//bateryjka.startAnimation(animacja_rotacja_lewo);
				//strzalka.startAnimation(animacja_rotacja_prawo);

				Animation hyperspaceJumpAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.hyperspace_jump);
				Animation fade_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
				Animation fade_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_out);
				Animation move = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move);
				Animation slide_up = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_up);
				Animation sequential_anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.sequential_anim);
				Animation together_animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.together_animation);

				bateryjka.startAnimation(sequential_anim);



				/*if (level >=90)
					{			
					bateryjka.setImageResource(R.drawable.bateryjka_70_druga_wersja);
							}
				else if (level<90 && level>=18)
				
					bateryjka.setImageResource(R.drawable.bateryjka_70_druga_wersja);
				
				else 
					
					bateryjka.setImageResource(R.drawable.bateryjka_70_druga_wersja);
	 
				*/
				
				/*switch (level) {
				case 1:		bateryjka.setImageResource(R.drawable.beteryjka_5); break;
				case 2:		bateryjka.setImageResource(R.drawable.beteryjka_5); break;
				case 3:		bateryjka.setImageResource(R.drawable.beteryjka_5); break;
				case 4:		bateryjka.setImageResource(R.drawable.beteryjka_5); break;
				case 5:		bateryjka.setImageResource(R.drawable.beteryjka_5); break;
				case 6:		bateryjka.setImageResource(R.drawable.beteryjka_18); break;
				case 7:		bateryjka.setImageResource(R.drawable.beteryjka_18); break;
				case 8:		bateryjka.setImageResource(R.drawable.beteryjka_18); break;
				case 9:		bateryjka.setImageResource(R.drawable.beteryjka_18); break;
				case 10:	bateryjka.setImageResource(R.drawable.beteryjka_18); break;
				case 11:	bateryjka.setImageResource(R.drawable.beteryjka_18); break;
				case 12:	bateryjka.setImageResource(R.drawable.beteryjka_18); break;
				case 13:	bateryjka.setImageResource(R.drawable.beteryjka_18); break;
				case 14:	bateryjka.setImageResource(R.drawable.beteryjka_18); break;
				case 15:	bateryjka.setImageResource(R.drawable.beteryjka_18); break;
				case 16:	bateryjka.setImageResource(R.drawable.beteryjka_18); break;
				case 17:	bateryjka.setImageResource(R.drawable.beteryjka_18); break;
				case 18:	bateryjka.setImageResource(R.drawable.beteryjka_18); break;
				case 19:	bateryjka.setImageResource(R.drawable.bateryjka_70_druga_wersja); break;
				case 20:	bateryjka.setImageResource(R.drawable.bateryjka_70_druga_wersja); break;
				case 21:	bateryjka.setImageResource(R.drawable.bateryjka_70_druga_wersja); break;
				case 22:	bateryjka.setImageResource(R.drawable.bateryjka_70_druga_wersja); break;
				case 23:	bateryjka.setImageResource(R.drawable.bateryjka_70_druga_wersja); break;
				case 24:	bateryjka.setImageResource(R.drawable.bateryjka_70_druga_wersja); break;
				case 25:	bateryjka.setImageResource(R.drawable.bateryjka_70_druga_wersja); break;
				case 26:	bateryjka.setImageResource(R.drawable.bateryjka_70_druga_wersja); break;
				case 27:	bateryjka.setImageResource(R.drawable.bateryjka_70_druga_wersja); break;
				case 28:	bateryjka.setImageResource(R.drawable.bateryjka_70_druga_wersja); break;
				case 29:	bateryjka.setImageResource(R.drawable.bateryjka_70_druga_wersja); break;
				case 30:	bateryjka.setImageResource(R.drawable.bateryjka_70_druga_wersja); break;
				case 31:	bateryjka.setImageResource(R.drawable.bateryjka_70_druga_wersja); break;
				case 32:	bateryjka.setImageResource(R.drawable.bateryjka_70_druga_wersja); break;
				case 33:	bateryjka.setImageResource(R.drawable.bateryjka_70_druga_wersja); break;
				case 34:	bateryjka.setImageResource(R.drawable.bateryjka_70_druga_wersja); break;
				case 35:	bateryjka.setImageResource(R.drawable.bateryjka_70_druga_wersja); break;
				case 36:	bateryjka.setImageResource(R.drawable.bateryjka_70_druga_wersja); break;
				case 37:	bateryjka.setImageResource(R.drawable.bateryjka_70_druga_wersja); break;
				case 38:	bateryjka.setImageResource(R.drawable.bateryjka_70_druga_wersja); break;
				case 39:	bateryjka.setImageResource(R.drawable.bateryjka_70_druga_wersja); break;
				case 40:	bateryjka.setImageResource(R.drawable.bateryjka_70_druga_wersja); break;
				case 41:	bateryjka.setImageResource(R.drawable.bateryjka_70_druga_wersja); break;
				case 42:	bateryjka.setImageResource(R.drawable.bateryjka_70_druga_wersja); break;
				case 43:	bateryjka.setImageResource(R.drawable.bateryjka_70_druga_wersja); break;
				case 44:	bateryjka.setImageResource(R.drawable.bateryjka_70_druga_wersja); break;
				case 45:	bateryjka.setImageResource(R.drawable.bateryjka_70_druga_wersja); break;
				case 46:	bateryjka.setImageResource(R.drawable.bateryjka_70_druga_wersja); break;
				case 47:	bateryjka.setImageResource(R.drawable.bateryjka_70_druga_wersja); break;
				case 48:	bateryjka.setImageResource(R.drawable.bateryjka_70_druga_wersja); break;
				case 49:	bateryjka.setImageResource(R.drawable.bateryjka_70_druga_wersja); break;
				case 50:	bateryjka.setImageResource(R.drawable.bateryjka_70_druga_wersja); break;
				case 51:	bateryjka.setImageResource(R.drawable.bateryjka_70_druga_wersja); break;
				case 52:	bateryjka.setImageResource(R.drawable.bateryjka_70_druga_wersja); break;
				case 53:	bateryjka.setImageResource(R.drawable.bateryjka_70_druga_wersja); break;
				case 54:	bateryjka.setImageResource(R.drawable.bateryjka_70_druga_wersja); break;
				case 55:	bateryjka.setImageResource(R.drawable.bateryjka_70_druga_wersja); break;
				case 56:	bateryjka.setImageResource(R.drawable.bateryjka_70_druga_wersja); break;
				case 57:	bateryjka.setImageResource(R.drawable.bateryjka_70_druga_wersja); break;
				case 58:	bateryjka.setImageResource(R.drawable.bateryjka_70_druga_wersja); break;
				case 59:	bateryjka.setImageResource(R.drawable.bateryjka_70_druga_wersja); break;
				case 60:	bateryjka.setImageResource(R.drawable.bateryjka_70_druga_wersja); break;
				case 61:	bateryjka.setImageResource(R.drawable.bateryjka_70_druga_wersja); break;
				case 62:	bateryjka.setImageResource(R.drawable.bateryjka_70_druga_wersja); break;
				case 63:	bateryjka.setImageResource(R.drawable.bateryjka_70_druga_wersja); break;
				case 64:	bateryjka.setImageResource(R.drawable.bateryjka_70_druga_wersja); break;
				case 65:	bateryjka.setImageResource(R.drawable.bateryjka_70_druga_wersja); break;
				case 66:	bateryjka.setImageResource(R.drawable.bateryjka_70_druga_wersja); break;
				case 67:	bateryjka.setImageResource(R.drawable.bateryjka_70_druga_wersja); break;
				case 68:	bateryjka.setImageResource(R.drawable.bateryjka_70_druga_wersja); break;
				case 69:	bateryjka.setImageResource(R.drawable.bateryjka_70_druga_wersja); break;
				case 70:	bateryjka.setImageResource(R.drawable.bateryjka_70_druga_wersja); break;
				case 71:	bateryjka.setImageResource(R.drawable.bateryjka_70_druga_wersja); break;
				case 72:	bateryjka.setImageResource(R.drawable.bateryjka_70_druga_wersja); break;
				case 73:	bateryjka.setImageResource(R.drawable.bateryjka_70_druga_wersja); break;
				case 74:	bateryjka.setImageResource(R.drawable.bateryjka_70_druga_wersja); break;
				case 75:	bateryjka.setImageResource(R.drawable.bateryjka_70_druga_wersja); break;
				case 76:	bateryjka.setImageResource(R.drawable.bateryjka_70_druga_wersja); break;
				case 77:	bateryjka.setImageResource(R.drawable.bateryjka_70_druga_wersja); break;
				case 78:	bateryjka.setImageResource(R.drawable.bateryjka_70_druga_wersja); break;
				case 79:	bateryjka.setImageResource(R.drawable.bateryjka_70_druga_wersja); break;
				case 80:	bateryjka.setImageResource(R.drawable.bateryjka_70_druga_wersja); break;
				case 81:	bateryjka.setImageResource(R.drawable.bateryjka_70_druga_wersja); break;
				case 82:	bateryjka.setImageResource(R.drawable.bateryjka_70_druga_wersja); break;
				case 83:	bateryjka.setImageResource(R.drawable.bateryjka_70_druga_wersja); break;
				case 84:	bateryjka.setImageResource(R.drawable.bateryjka_70_druga_wersja); break;
				case 85:	bateryjka.setImageResource(R.drawable.bateryjka_70_druga_wersja); break;
				case 86:	bateryjka.setImageResource(R.drawable.bateryjka_70_druga_wersja); break;
				case 87:	bateryjka.setImageResource(R.drawable.bateryjka_70_druga_wersja); break;
				case 88:	bateryjka.setImageResource(R.drawable.bateryjka_70_druga_wersja); break;
				case 89:	bateryjka.setImageResource(R.drawable.bateryjka_70_druga_wersja); break;
				case 90:	bateryjka.setImageResource(R.drawable.beteryjka_90); break;
				case 91:	bateryjka.setImageResource(R.drawable.beteryjka_90); break;
				case 92:	bateryjka.setImageResource(R.drawable.beteryjka_90); break;
				case 93:	bateryjka.setImageResource(R.drawable.beteryjka_90); break;
				case 94:	bateryjka.setImageResource(R.drawable.beteryjka_90); break;
				case 95:	bateryjka.setImageResource(R.drawable.beteryjka_90); break;
				case 96:	bateryjka.setImageResource(R.drawable.beteryjka_90); break;
				case 97:	bateryjka.setImageResource(R.drawable.beteryjka_90); break;
				case 98:	bateryjka.setImageResource(R.drawable.beteryjka_90); break;
				case 99:	bateryjka.setImageResource(R.drawable.beteryjka_90); break;
				case 100:	bateryjka.setImageResource(R.drawable.beteryjka_90); break;

					
				} */
			}
		};

}
