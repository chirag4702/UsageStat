package com.example.usagestat;

import android.annotation.SuppressLint;
import android.app.AppOpsManager;
import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.provider.Settings;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PackageAdapter adapter;

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new PackageAdapter();
        recyclerView.setAdapter(adapter);

        // Check if permission to access usage stats is granted
        if (!hasUsageStatsPermission(this)) {
            requestUsageStatsPermission();
        }

        showUsageStats();

        adapter.setItemClickListener(packageName -> {
            // Handle the click event, you can navigate to a new activity or perform other actions
            //Toast.makeText(this, "Clicked on " + packageName, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, PackageDetailsActivity.class);
            intent.putExtra("PACKAGE_NAME", packageName);
            startActivity(intent);
            return null;
        });
    }

    @SuppressLint("SuspiciousIndentation")
    @RequiresApi(api = Build.VERSION_CODES.Q)
    private void showUsageStats() {
        UsageStatsManager usageStatsManager = (UsageStatsManager) getSystemService(Context.USAGE_STATS_SERVICE);
        long currentTime = System.currentTimeMillis();

        List<UsageStats> queryUsageStats = usageStatsManager.queryUsageStats(
                UsageStatsManager.INTERVAL_BEST,
                currentTime - 24 * 60 * 60 * 1000,
                currentTime
        );

        List<String> packageNames = new ArrayList<>();

        for (UsageStats stats : queryUsageStats) {
            packageNames.add(stats.getPackageName());
            Log.d("ListActivity", stats.getPackageName());
        }

        adapter.setData(packageNames);
    }

    private boolean hasUsageStatsPermission(Context context) {
        AppOpsManager appOps = (AppOpsManager) context.getSystemService(Context.APP_OPS_SERVICE);
        int mode = appOps.checkOpNoThrow(
                AppOpsManager.OPSTR_GET_USAGE_STATS,
                Process.myUid(),
                context.getPackageName()
        );
        return mode == AppOpsManager.MODE_ALLOWED;
    }

    private void requestUsageStatsPermission() {
        Intent intent = new Intent(Settings.ACTION_USAGE_ACCESS_SETTINGS);
        ActivityCompat.startActivityForResult(
                this,
                intent,
                0,
                null
        );
    }
}
