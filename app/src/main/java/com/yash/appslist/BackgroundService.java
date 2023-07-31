package com.yash.appslist;
import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.IBinder;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;

public class BackgroundService extends Service {

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        startForeground(1, createNotification());
        registerPackageChangeReceiver();
        return START_STICKY;
    }

    @TargetApi(Build.VERSION_CODES.O)
    private Notification createNotification() {
        String channelId = "background_service_channel";
        String channelName = "Background Service";
        String notificationText = "Background service is running.";

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(channel);
        }

        return new Notification.Builder(this, channelId)
                .setContentTitle(channelName)
                .setContentText(notificationText)
                .setSmallIcon(R.mipmap.ic_launcher)
                .build();
    }

    private void registerPackageChangeReceiver() {
        PackageChangeReceiver packageChangeReceiver = new PackageChangeReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_PACKAGE_ADDED);
        intentFilter.addAction(Intent.ACTION_PACKAGE_REMOVED);
        intentFilter.addDataScheme("package");
        registerReceiver(packageChangeReceiver, intentFilter);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


//    public class FirebaseDataPush {
//        public static void main(String[] args) {
//            // Initialize Firebase with your project's credentials
//            FirebaseDatabase database = FirebaseDatabase.getInstance();
//
//            // Get a reference to the "my_data" node in your Firebase database
//            DatabaseReference myDataRef = database.getReference("app_data");
//
//            // Create an instance of your model class
//            packageActivity dataModel = new packageActivity("mob_1", 26-07-23,"installed", "uninstalled");
//
//            // Push the data to Firebase
//            myDataRef.push().setValue(dataModel);
//
//            System.out.println("Data pushed successfully!");
//        }
//    }
}




