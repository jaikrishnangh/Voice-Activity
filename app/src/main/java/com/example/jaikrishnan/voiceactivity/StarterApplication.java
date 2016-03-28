package com.example.jaikrishnan.voiceactivity;

import android.app.Application;

import com.onesignal.OneSignal;

/**
 * Created by JAI KRISHNAN on 10-02-2016.
 */
public class StarterApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        OneSignal.startInit(this).init();
    }
}
