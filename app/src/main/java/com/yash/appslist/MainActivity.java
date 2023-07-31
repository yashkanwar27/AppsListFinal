package com.yash.appslist;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.ktx.Firebase;

import com.yash.appslist.model.App;
import com.yash.appslist.model.Date;
import com.yash.appslist.model.DateX;
import com.yash.appslist.model.Input;
import com.yash.appslist.model.V;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends Activity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, BackgroundService.class);
        startService(intent);

        ListView listView = findViewById(R.id.listView);
        List<ApplicationInfo> apps = listApps();
        listView.setAdapter(new AppListAdapter(this, apps));

        Viewmodel viewModel = new Viewmodel(new Repository());

        List<App> listApps = new ArrayList<>();
        for (ApplicationInfo item: apps
             ) {
            Date date = new Date(new DateX("2012-04-23T18:25:43.511Z"));
            listApps.add(new App(item.name, date, true));
        }

        Input product = new Input(
           listApps, "testing1234"
//          new V("0"), listApps, "xyz"
        );

        viewModel.addSafeProduct(product);

    }


    private List<ApplicationInfo> listApps() {
        final PackageManager pm = getPackageManager();
        List<ApplicationInfo> apps = pm.getInstalledApplications(PackageManager.GET_META_DATA);

        List<ApplicationInfo> filtered = new ArrayList<>();
        for (ApplicationInfo appInfo : apps) {
            if ((appInfo.flags & ApplicationInfo.FLAG_SYSTEM) == 0) {
                filtered.add(appInfo);
            }
        }

        Collections.sort(filtered, new Comparator<ApplicationInfo>() {
            @Override
            public int compare(ApplicationInfo app1, ApplicationInfo app2) {
                String app1Name = pm.getApplicationLabel(app1).toString();
                String app2Name = pm.getApplicationLabel(app2).toString();
                return app1Name.compareTo(app2Name);
            }
        });

        return filtered;
    }

    static class AppListAdapter extends ArrayAdapter<ApplicationInfo> {

        private List<ApplicationInfo> apps;

        AppListAdapter(Context context, List<ApplicationInfo> apps) {
            super(context, 0);
            this.apps = apps;
        }

        @Override
        @SuppressWarnings("NullableProblems")
        public View getView(int position, View convertView, ViewGroup parent) {
            Context context = parent.getContext();
            if (convertView == null) {
                convertView = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, parent, false);
            }

            TextView textView = convertView.findViewById(android.R.id.text1);
            ApplicationInfo info = getItem(position);
            if (info == null) return convertView;

            textView.setText(context.getPackageManager().getApplicationLabel(info));
            return convertView;
        }

        @Override
        public ApplicationInfo getItem(int position) {
            return apps.get(position);
        }

        @Override
        public int getCount() {
            return apps.size();
        }
    }

}
