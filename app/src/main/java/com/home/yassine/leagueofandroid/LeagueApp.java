package com.home.yassine.leagueofandroid;

import android.app.Application;

import com.home.yassine.leagueofandroid.DI.AndroidModule;
import com.home.yassine.leagueofandroid.DI.ApplicationComponent;
import com.home.yassine.leagueofandroid.DI.DaggerApplicationComponent;

/**
 * Created by Yassine on 25/12/2016.
 */

public class LeagueApp extends Application {

    private static ApplicationComponent component;

    public static ApplicationComponent getComponent() { return component; }

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerApplicationComponent.builder().androidModule(new AndroidModule(this)).build();
    }
}
