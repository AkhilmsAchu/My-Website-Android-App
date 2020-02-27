package com.example.mywebsite;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {
    WebView wv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wv=(WebView) findViewById(R.id.webview);
        wv.setInitialScale(1);
        wv.setBackgroundColor(0);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.getSettings().setLoadWithOverviewMode(true);
        wv.getSettings().setUseWideViewPort(true);
        wv.loadUrl("http://akhilmsachu.me");
        styleRecentTasksEntry(this);
    }
    public static void styleRecentTasksEntry(Activity activity) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            return;
        }
        Resources resources = activity.getResources();
        String label = "My Website";
        Bitmap icon = ((BitmapDrawable) activity.getApplicationInfo().loadIcon(activity.getPackageManager())).getBitmap();
        activity.setTaskDescription(new ActivityManager.TaskDescription(label,icon));
    }

}
