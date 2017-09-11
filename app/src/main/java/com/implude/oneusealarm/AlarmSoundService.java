package com.implude.oneusealarm;

import android.app.AlarmManager;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;


public class AlarmSoundService extends Service {
    public AlarmSoundService(){
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //Intent mintent = new Intent(getApplicationContext(), AlarmPlayActivity.class);
        //startActivity(intent);

        return START_NOT_STICKY;
    }

    /*@Override
    public int onStartCommand(Intent intent, int flags, int startId){
        Toast.makeText(this,"알람이 울리고 있습니다",Toast.LENGTH_LONG).show();
        return START_NOT_STICKY;

    }*/



    
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

}
