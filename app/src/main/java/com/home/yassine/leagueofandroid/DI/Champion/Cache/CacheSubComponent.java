package com.home.yassine.leagueofandroid.DI.Champion.Cache;

import com.home.yassine.leagueofandroid.fragments.CacheFragment;
import com.home.yassine.leagueofandroid.core.champion.cache.Cache;
import com.home.yassine.leagueofandroid.core.champion.cache.CacheModule;

import dagger.Subcomponent;

/**
 * Created by Yassine on 03/01/2017.
 */

@Cache
@Subcomponent(modules = {AppCacheModule.class})
public interface CacheSubComponent {

    void inject(CacheFragment view);
}