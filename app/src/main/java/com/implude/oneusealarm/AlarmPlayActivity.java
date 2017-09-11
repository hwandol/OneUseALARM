package com.implude.oneusealarm;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AlarmPlayActivity extends AppCompatActivity {


    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_play);


        int mode = getIntent().getExtras().getInt("Mode");
        Button stopBtn = (Button)findViewById(R.id.stopAlmBtn);

        TextView nowTime = (TextView) findViewById(R.id.nowTime);
        TextView nowDay = (TextView)findViewById(R.id.nowDate);


        long now = System.currentTimeMillis();
        Date date = new Date(now);
        SimpleDateFormat time = new SimpleDateFormat("HH:mm");
        SimpleDateFormat day = new SimpleDateFormat("MM.dd");
        String sTime =time.format(date);
        String sDay = day.format(date);
        nowTime.setText(sTime);
        nowDay.setText(sDay);


        stopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


}
