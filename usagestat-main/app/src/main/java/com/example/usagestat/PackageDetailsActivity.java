package com.example.usagestat;

import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.usagestat.R;

// PackageDetailsActivity.java
public class PackageDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package_details);

        Intent intent = getIntent();
        if (intent != null) {
            String packageName = intent.getStringExtra("PACKAGE_NAME");
            // Now you have the package name, you can use it to query more details and display them in a RecyclerView
            // Perform your additional queries and UI setup here
        }
    }
}
