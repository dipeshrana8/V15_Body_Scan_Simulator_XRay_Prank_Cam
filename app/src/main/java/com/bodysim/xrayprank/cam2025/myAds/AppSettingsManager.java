package com.bodysim.xrayprank.cam2025.myAds;

public class AppSettingsManager {
    private static AppSettingsManager instance;
    private AppSettings appSettings;

    private AppSettingsManager() {

    }

    public static synchronized AppSettingsManager getInstance() {
        if (instance == null) {
            instance = new AppSettingsManager();
        }
        return instance;
    }

    public AppSettings getAppSettings() {
        return appSettings;
    }

    public void setAppSettings(AppSettings settings) {
        this.appSettings = settings;
    }
}
