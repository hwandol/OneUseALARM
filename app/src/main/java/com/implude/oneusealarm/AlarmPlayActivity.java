package com.implude.oneusealarm;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AlarmPlayActivity extends AppCompatActivity {
    private void setClock(){
        TextView nowTime = (TextView) findViewById(R.id.nowTime);
        TextView nowDay = (TextView)findViewById(R.id.nowDate);


        SimpleDateFormat time = new SimpleDateFormat("HH:mm");
        SimpleDateFormat day = new SimpleDateFormat("MM.dd");
        long now = System.currentTimeMillis();
        Date date = new Date(now);
        String sTime =time.format(date);
        String sDay = day.format(date);
        nowTime.setText(sTime);
        nowDay.setText(sDay);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_play);
        Button stopBtn = (Button)findViewById(R.id.stopAlmBtn);

        setClock();


        stopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }



}
