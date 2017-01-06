package com.home.yassine.leagueofandroid.DI.champion.Cache;

import com.home.yassine.leagueofandroid.fragments.CacheFragment;
import com.home.yassine.leagueofandroid.core.champion.cache.Cache;

import dagger.Subcomponent;

/**
 * Created by Yassine on 03/01/2017.
 */

@Cache
@Subcomponent(modules = {AppCacheModule.class})
public interface CacheSubComponent {

    void inject(CacheFragment view);
}