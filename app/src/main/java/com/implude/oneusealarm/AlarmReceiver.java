package com.implude.oneusealarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent mServiceintent = new Intent(context,AlarmSoundService.class);
        context.startService(mServiceintent);

    }
}
