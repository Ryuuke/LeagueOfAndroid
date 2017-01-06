package com.home.yassine.leagueofandroid.DI;

import com.home.yassine.leagueofandroid.DI.champion.Cache.AppCacheModule;
import com.home.yassine.leagueofandroid.DI.database.DatabaseModule;
import com.home.yassine.leagueofandroid.activites.MainActivity;
import com.home.yassine.leagueofandroid.DI.champion.Cache.CacheSubComponent;
import com.home.yassine.leagueofandroid.DI.champion.Search.AppSearchModule;
import com.home.yassine.leagueofandroid.DI.champion.Search.SearchSubComponent;
import com.home.yassine.leagueofandroid.core.client.ApiModule;
import com.home.yassine.leagueofandroid.core.client.ClientModule;

import javax.inject.Singleton;
import dagger.Component;

/**
 * Created by Yassine on 25/12/2016.
 */

@Singleton
@Component(modules = {
        AndroidModule.class,
        LoLAndroidModule.class,
        ClientModule.class,
        ApiModule.class,
        DatabaseModule.class
})
public interface ApplicationComponent {

    void inject(MainActivity module);

    CacheSubComponent plus(AppCacheModule cacheModule);
    SearchSubComponent plus(AppSearchModule searchModule);
}