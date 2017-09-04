package com.implude.oneusealarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent mServiceintent = new Intent(context, AlarmSoundService.class);
        mServiceintent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startService(mServiceintent);

        Toast.makeText(context, "asdf",Toast.LENGTH_SHORT).show();
    }
}
