//package com.yash.appslist;
//
//import android.app.AppOpsManager;
//import android.content.Context;
//import android.content.Intent;
//import android.provider.Settings;
//
//class AppUsagePermissions {
//
//    static boolean hasUsageAccess(final Context context) {
//        final AppOpsManager appOps = (AppOpsManager) context.getSystemService(Context.APP_OPS_SERVICE);
//        if (appOps == null) return false;
//        int mode = appOps.checkOpNoThrow(AppOpsManager.OPSTR_GET_USAGE_STATS,
//                android.os.Process.myUid(), context.getPackageName());
//        return mode == AppOpsManager.MODE_ALLOWED;
//    }
//
//    static void requestAppUsageAccessPermission(Context context) {
//        Intent intent = new Intent(Settings.ACTION_USAGE_ACCESS_SETTINGS);
//        context.startActivity(intent);
//    }
//
//}
