package com.yash.appslist;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class PackageChangeReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction() == Intent.ACTION_PACKAGE_REMOVED) {
            Log.d("UNINSTALLED", "Some package removed");
            Toast.makeText(context, R.string.toast_removed, Toast.LENGTH_SHORT).show();
        } else if (intent.getAction() == Intent.ACTION_PACKAGE_ADDED) {
            Log.d("INSTALLED", "Some package added");
            Toast.makeText(context, R.string.toast_added, Toast.LENGTH_SHORT).show();
        }
    }
}
