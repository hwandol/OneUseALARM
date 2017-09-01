package com.implude.oneusealarm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    TimePicker timePicker;
    Button buttonVib, buttonSound, buttonAddAlarm;

    int hour=-1, minute=-1;
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

        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int i, int i1) {
                hour = timePicker.getHour();
                minute = timePicker.getMinute();
            }
        });

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

            }
        });
    }
}
