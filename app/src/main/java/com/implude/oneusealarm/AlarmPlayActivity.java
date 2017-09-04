package com.implude.oneusealarm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AlarmPlayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_play);

        TextView nowHour = (TextView) findViewById(R.id.nowHour);
        TextView nowMin = (TextView) findViewById(R.id.nowMin);
        Button stopBtn = (Button)findViewById(R.id.stopAlmBtn);

        long now = System.currentTimeMillis();
        Date date = new Date(now);
        SimpleDateFormat hour = new SimpleDateFormat("hh");
        SimpleDateFormat min = new SimpleDateFormat("mm");
        String sHour =hour.format(date);
        String sMin =min.format(date);
        nowHour.setText(sHour);
        nowMin.setText(sMin);

        stopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
