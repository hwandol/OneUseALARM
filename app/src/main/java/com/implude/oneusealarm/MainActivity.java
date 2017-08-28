package com.implude.oneusealarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity {
    int hour,min;
    EditText setHour,setMin;
    int requestCode = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setHour = (EditText) findViewById(R.id.setHour);
        setMin = (EditText) findViewById(R.id.setMin);
        Button setAlarm = (Button) findViewById(R.id.setAlarm);

        setAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hour = Integer.parseInt(setHour.getText().toString());
                min = Integer.parseInt(setMin.getText().toString());
                Calendar mCal = Calendar.getInstance();
                mCal.set(Calendar.HOUR_OF_DAY,hour);
                mCal.set(Calendar.MINUTE,min);
                mCal.set(Calendar.SECOND,1);

                Intent mAlarmIntent = new Intent("com.implude.oneusealarm.ALARM_START");
                final PendingIntent mPedingIntent = PendingIntent.getBroadcast(getApplicationContext(),requestCode,mAlarmIntent,PendingIntent.FLAG_UPDATE_CURRENT);
                AlarmManager mAlarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
                mAlarmManager.set(AlarmManager.RTC_WAKEUP,mCal.getTimeInMillis(),mPedingIntent);
                Toast.makeText(getApplicationContext(),hour+"시 "+min+"분에 알람이 울립니다",Toast.LENGTH_SHORT).show();
            }
        });


    }

}