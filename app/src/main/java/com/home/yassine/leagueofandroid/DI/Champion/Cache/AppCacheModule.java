package com.home.yassine.leagueofandroid.DI.champion.Cache;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;

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

    private CacheFragment.CacheListener listener;
    private Context context;

    public AppCacheModule(CacheView view, Context context) {
        super(view);

        this.context = context;
        listener = (CacheFragment.CacheListener) context;

        if (listener == null)
            throw new InvalidParameterException("Context must implement CacheListener interface");
    }

    @Provides
    @Cache
    public CacheFragment.CacheListener provideCacheListener() {
        return listener;
    }

    @Provides
    @Cache
    public LinearLayoutManager provideLinearLayoutManager() {
        return new LinearLayoutManager(this.context);
    }
}
