package com.bodysim.xrayprank.cam2025.spalsh;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.animation.DecelerateInterpolator;

import com.onesignal.Continue;
import com.onesignal.OneSignal;
import com.onesignal.debug.LogLevel;
import com.bodysim.xrayprank.cam2025.databinding.ActivitySplashBinding;
import com.bodysim.xrayprank.cam2025.myAds.AdsPreference;


public class A1_SplashActivity extends BaseActivity {

    ActivitySplashBinding binding;
    private boolean IntroChecked = false;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        showNativeAds = false;
        showInterstitialAds = true;
        super.onCreate(savedInstanceState);
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        ObjectAnimator animation = ObjectAnimator.ofInt(binding.progressBar, "progress", 0, 100);
        animation.setDuration(3000); // 2 seconds
        animation.setInterpolator(new DecelerateInterpolator());
        animation.start();

        SharedPreferences prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        prefs.edit().putBoolean("spin_dialog_shown", false).apply();

        sharedPreferences = getSharedPreferences("FfPref", MODE_PRIVATE);
        IntroChecked = sharedPreferences.getBoolean("IntroChecked", false);

        // Enable verbose logging for debugging (remove in production)
        OneSignal.getDebug().setLogLevel(LogLevel.VERBOSE);

        // ✅ Initialize OneSignal first
        String oneSignalAppId = AdsPreference.getOneSignalAppId();
        if (!oneSignalAppId.isEmpty()) {
            OneSignal.initWithContext(this, oneSignalAppId);

            // ✅ Only call getNotifications AFTER initWithContext
            OneSignal.getNotifications().requestPermission(false, Continue.none());
        }

        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            if (IntroChecked) {

                startActivity(new Intent(A1_SplashActivity.this, HomeActivity.class));
                finish();
            } else {

                startActivity(new Intent(A1_SplashActivity.this, CountryActivity.class));
                finish();
            }
        }, 3500);
    }
}
