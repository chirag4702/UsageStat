package com.example.usagestat

import android.annotation.SuppressLint
import android.app.AppOpsManager
import android.app.usage.UsageStats
import android.app.usage.UsageStatsManager
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Process
import android.provider.Settings
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: PackageAdapter

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = PackageAdapter()
        recyclerView.adapter = adapter

        // Check if permission to access usage stats is granted
        if (!hasUsageStatsPermission(this)) {
            requestUsageStatsPermission()
        }

        showUsageStats()

        adapter.setItemClickListener { packageName ->
            // Handle the click event, you can navigate to a new activity or perform other actions
            //Toast.makeText(this, "Clicked on $packageName", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, PackageDetailsActivity::class.java)
            intent.putExtra("PACKAGE_NAME", packageName)
            startActivity(intent)
        }

    }

    @SuppressLint("SuspiciousIndentation")
    @RequiresApi(Build.VERSION_CODES.Q)
    private fun showUsageStats() {
        val usageStatsManager: UsageStatsManager = getSystemService(Context.USAGE_STATS_SERVICE) as UsageStatsManager
        val rn = System.currentTimeMillis()

        val queryUsageStats: List<UsageStats> = usageStatsManager.queryUsageStats(
            UsageStatsManager.INTERVAL_BEST,
            rn - 24 * 60 * 60 * 1000,
            rn
        )

        val packageNames = mutableListOf<String>()

        for (entry in queryUsageStats.indices) {
            packageNames.add(queryUsageStats[entry].packageName)
            Log.d("MainActivity", queryUsageStats[entry].packageName)
        }

        adapter.setData(packageNames)
    }

    private fun hasUsageStatsPermission(context: Context): Boolean {
        val appOps = context.getSystemService(Context.APP_OPS_SERVICE) as AppOpsManager
        val mode = appOps.checkOpNoThrow(
            AppOpsManager.OPSTR_GET_USAGE_STATS,
            Process.myUid(),
            context.packageName
        )
        return mode == AppOpsManager.MODE_ALLOWED
    }

    private fun requestUsageStatsPermission() {
        val intent = Intent(Settings.ACTION_USAGE_ACCESS_SETTINGS)
        ActivityCompat.startActivityForResult(
            this,
            intent,
            0,
            null
        )
    }
}
