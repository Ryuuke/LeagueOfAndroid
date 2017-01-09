package com.home.yassine.leagueofandroid.DI;

import android.content.Context;

import com.home.yassine.leagueofandroid.utils.AppConstants;
import com.home.yassine.leagueofandroid.utils.AppSchedulerProvider;
import com.home.yassine.leagueofandroid.core.utils.SchedulerProvider;
import com.home.yassine.leagueofandroid.utils.Utils;

import java.io.File;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.HttpUrl;

/**
 * Created by Yassine on 03/01/2017.
 */

@Module
public class LoLAndroidModule {

    @Provides
    @Singleton
    @Named("isDebug")
    boolean provideIsDebug() {
        return false;
    }

    @Provides
    @Singleton
    @Named("networkTimeout")
    int provideNetworkTimeoutInSeconds() {
        return AppConstants.NETWORK_CONNECTION_TIMEOUT_SEC;
    }

    @Provides
    @Singleton
    HttpUrl provideEndpoint() {
        return HttpUrl.parse(AppConstants.BASE_URL);
    }

    @Provides
    @Singleton
    SchedulerProvider provideAppScheduler() {
        return new AppSchedulerProvider();
    }

    @Provides
    @Singleton
    @Named("cacheSize")
    long provideCacheSize() {
        return AppConstants.CACHE_SIZE_BYTES;
    }

    @Provides
    @Singleton
    @Named("cacheMaxAge")
    int provideCacheMaxAgeMinutes() {
        return AppConstants.CACHE_MAX_AGE_MIN;
    }

    @Provides
    @Singleton
    @Named("cacheMaxStale")
    int provideCacheMaxStaleDays() {
        return AppConstants.CACHE_MAX_STALE_DAY;
    }

    @Provides
    @Singleton
    @Named("listSize")
    int provideListSize() {
        return AppConstants.CHAMPION_LIST_MAX_SIZE;
    }

    @Provides
    @Singleton
    @Named("cacheDir")
    File provideCacheDir(Context context) {
        return context.getCacheDir();
    }

    @Provides
    @Named("isConnect")
    boolean provideIsConnect(Context context) {
       return Utils.isConnected(context);
    }
}
