package com.implude.oneusealarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TimePicker timePicker;
    Button buttonVib, buttonSound, buttonAddAlarm;

    int which=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timePicker = (TimePicker)findViewById(R.id.timePicker);
        buttonVib = (Button)findViewById(R.id.VibButton);
        buttonSound = (Button)findViewById(R.id.SoundButton);
        buttonAddAlarm = (Button)findViewById(R.id.AddAlarmButton);

        buttonSound.setBackgroundResource(R.drawable.sound_clicked);

        buttonVib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(which==1) {
                    buttonVib.setBackgroundResource(R.drawable.vib_clicked);
                    buttonSound.setBackgroundResource(R.drawable.sound);

                    which=2;
                }
            }
        });

        buttonSound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(which==2) {
                    buttonVib.setBackgroundResource(R.drawable.vib);
                    buttonSound.setBackgroundResource(R.drawable.sound_clicked);

                    which=1;
                }
            }
        });

        buttonAddAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int hour = timePicker.getHour();
                int minute = timePicker.getMinute();

                Calendar cal = Calendar.getInstance();
                cal.set(Calendar.HOUR_OF_DAY, hour);
                cal.set(Calendar.MINUTE, minute);
                cal.set(Calendar.SECOND, 1);

                Intent alarmIntent = new Intent("com.implude.oneusealarm.ALARM_START");

                PendingIntent pendingIntent =
                        PendingIntent.getBroadcast(
                                getApplicationContext(),
                                123,
                                alarmIntent,
                                PendingIntent.FLAG_UPDATE_CURRENT
                        );

                AlarmManager alarmManager = (AlarmManager)
                        getSystemService(Context.ALARM_SERVICE);

                alarmManager.set(
                        AlarmManager.RTC_WAKEUP,
                        cal.getTimeInMillis(),
                        pendingIntent
                );

                Toast.makeText(getApplicationContext(), ""+hour+"시 "+minute+"분 알람 설정됨", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
