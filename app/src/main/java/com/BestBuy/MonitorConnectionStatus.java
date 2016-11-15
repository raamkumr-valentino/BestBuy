package com.BestBuy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by RaamKumr on 7/21/2016.
 */
public class MonitorConnectionStatus extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        boolean isConnected=NetworkUtils.getConnectivityStatusString(context);
                if(!(isConnected))
                {
                    Toast.makeText(context,"Check Your Network Connection",Toast.LENGTH_LONG).show();
                }
    }
}
