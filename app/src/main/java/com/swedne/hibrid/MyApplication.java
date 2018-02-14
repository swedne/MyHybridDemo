package com.swedne.hibrid;

import android.app.Application;

/**
 * Created by Administrator on 2018/1/12.
 */

public class MyApplication extends Application {
    public static MyApplication context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }

    public static MyApplication getInstace() {
        return context;
    }
}
