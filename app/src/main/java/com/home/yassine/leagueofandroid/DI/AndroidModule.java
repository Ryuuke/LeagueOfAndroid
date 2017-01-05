package com.home.yassine.leagueofandroid.DI;

import android.content.Context;
import android.content.res.Resources;

import com.home.yassine.leagueofandroid.LeagueApp;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Yassine on 25/12/2016.
 */
@Module
public class AndroidModule {

    private LeagueApp application;

    public AndroidModule(LeagueApp application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Context providesContext() { return application.getApplicationContext(); }

    @Provides
    @Singleton
    public Resources providesResources() { return application.getResources(); }
}
