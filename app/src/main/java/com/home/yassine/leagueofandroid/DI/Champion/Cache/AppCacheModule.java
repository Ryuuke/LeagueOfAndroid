package com.home.yassine.leagueofandroid.DI.Champion.Cache;

import android.content.Context;

import com.home.yassine.leagueofandroid.core.champion.cache.Cache;
import com.home.yassine.leagueofandroid.core.champion.cache.CacheModule;
import com.home.yassine.leagueofandroid.core.champion.cache.CacheView;
import com.home.yassine.leagueofandroid.fragments.CacheFragment;

import java.security.InvalidParameterException;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Yassine on 05/01/2017.
 */

@Module
public class AppCacheModule extends CacheModule {

    CacheFragment.CacheListener listener;

    public AppCacheModule(CacheView view, Context context) {
        super(view);

        listener = (CacheFragment.CacheListener) context;

        if (listener == null)
            throw new InvalidParameterException("Context must implement CacheListener interface");
    }

    @Provides
    @Cache
    public CacheFragment.CacheListener provideCacheListener() {
        return listener;
    }
}
