package com.implude.oneusealarm;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AlarmPlayActivity extends AppCompatActivity {
    public static final int MODE_SOUND=1, MODE_VIB=2;


    MediaPlayer mediaPlayer;
    TextView nowTime;
    TextView nowDay;
    long now;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_play);
        final Vibrator vibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);

        int mode = getIntent().getExtras().getInt("Mode");

        if(mode == MODE_SOUND){
            Toast.makeText(getApplicationContext(),"소리알람이 울립니다",Toast.LENGTH_LONG).show();
            mediaPlayer = MediaPlayer.create(this, R.raw.apple_ring);
            mediaPlayer.setLooping(true);
            mediaPlayer.start();

        }else if(mode == MODE_VIB){
            Toast.makeText(getApplicationContext(),"진동알람이 울립니다.",Toast.LENGTH_LONG).show();
            vibrator.vibrate(new long[]{100,1000,100,500,100,500,100,1000},0);
        }else{
            Toast.makeText(getApplicationContext(),"오류로 인해 소리/진동이 설정되지 않았습니다.",Toast.LENGTH_LONG).show();
        }



        Button stopBtn = (Button)findViewById(R.id.stopAlmBtn);

        nowTime = (TextView) findViewById(R.id.nowTime);
        nowDay = (TextView)findViewById(R.id.nowDate);


        now = System.currentTimeMillis();
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
                mediaPlayer.stop();
                final Vibrator vibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.cancel();
                finish();
            }
        });
    }


}

